/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UserSellerItemRatingContext;
import com.meat.domain.Users;
import com.meat.model.UserSellerItemRatingModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi
 *
 */

@RestController
@RequestMapping(value = "/userSellerItemRating", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UserSellerItemRatingController {
    private IBusinessDelegate<UserSellerItemRatingModel, UserSellerItemRatingContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserSellerItemRatingContext> userSellerItemRatingContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserSellerItemRatingModel> create(@RequestBody final UserSellerItemRatingModel userSellerItemRatingModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getName().equals("anonymousUser")) {
            Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            userSellerItemRatingModel.setUserId(user.getId());
            businessDelegate.create(userSellerItemRatingModel);
        }
        return new ResponseEntity<UserSellerItemRatingModel>(userSellerItemRatingModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserSellerItemRatingModel> edit(@PathVariable(value = "id") final String userSellerItemRatingId,
            @RequestBody final UserSellerItemRatingModel userSellerItemRatingModel) {
        UserSellerItemRatingContext userSellerItemRatingContext = new UserSellerItemRatingContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(userSellerItemRatingId), userSellerItemRatingModel);
        return new ResponseEntity<UserSellerItemRatingModel>(userSellerItemRatingModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUserSellerItemRating() {
        UserSellerItemRatingContext userSellerItemRatingContext = userSellerItemRatingContextFactory.getObject();
        userSellerItemRatingContext.setAll("all");
        Collection<UserSellerItemRatingModel> userSellerItemRatingModel = businessDelegate.getCollection(userSellerItemRatingContext);
        IModelWrapper<Collection<UserSellerItemRatingModel>> userSellerItemRatingmodels = new CollectionModelWrapper<UserSellerItemRatingModel>(
                UserSellerItemRatingModel.class, userSellerItemRatingModel);
        return new ResponseEntity<IModelWrapper>(userSellerItemRatingmodels, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserSellerItemRatingModel> getUserSellerItemRating(
            @PathVariable(value = "id") final String userSellerItemRatingId) {
        UserSellerItemRatingContext userSellerItemRatingContext = userSellerItemRatingContextFactory.getObject();
        UserSellerItemRatingModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(userSellerItemRatingId),
                userSellerItemRatingContext);
        return new ResponseEntity<UserSellerItemRatingModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "userSellerItemRatingBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Autowired
    public void setUserSellerItemRatingObjectFactory(final ObjectFactory<UserSellerItemRatingContext> userSellerItemRatingContextFactory) {
        this.userSellerItemRatingContextFactory = userSellerItemRatingContextFactory;
    }

}
