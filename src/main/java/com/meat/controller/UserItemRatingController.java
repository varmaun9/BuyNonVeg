/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UserItemRatingContext;
import com.meat.model.UserItemRatingModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dilli
 *
 */
@RestController
@RequestMapping(value = "/userItemRating", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UserItemRatingController {

    private IBusinessDelegate<UserItemRatingModel, UserItemRatingContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserItemRatingContext> userItemRatingContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserItemRatingModel> create(@RequestBody final UserItemRatingModel userItemRatingModel) {
        businessDelegate.create(userItemRatingModel);
        return new ResponseEntity<UserItemRatingModel>(userItemRatingModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserItemRatingModel> edit(@PathVariable(value = "id") final String userItemRatingId,
            @RequestBody final UserItemRatingModel userItemRatingModel) {
        UserItemRatingContext userItemRatingContext = new UserItemRatingContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(userItemRatingId), userItemRatingModel);
        return new ResponseEntity<UserItemRatingModel>(userItemRatingModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUserWishList() {
        UserItemRatingContext userItemRatingContext = userItemRatingContextFactory.getObject();
        userItemRatingContext.setAll("all");
        Collection<UserItemRatingModel> UserItemRatingModel = businessDelegate.getCollection(userItemRatingContext);
        IModelWrapper<Collection<UserItemRatingModel>> models = new CollectionModelWrapper<UserItemRatingModel>(UserItemRatingModel.class,
                UserItemRatingModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserItemRatingModel> getUserWishList(@PathVariable(value = "id") final String userItemRatingId) {
        UserItemRatingContext userItemRatingContext = userItemRatingContextFactory.getObject();
        UserItemRatingModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(userItemRatingId), userItemRatingContext);
        return new ResponseEntity<UserItemRatingModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "userItemRatingBusinessDelegate")
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
    public void setUserItemRatingObjectFactory(final ObjectFactory<UserItemRatingContext> userItemRatingContextFactory) {
        this.userItemRatingContextFactory = userItemRatingContextFactory;
    }
}
