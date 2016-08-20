/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UserWishListContext;
import com.meat.model.UserWishListModel;
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
 * @author arthvedi
 *
 */

@RestController
@RequestMapping(value = "/userWishList", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UserWishListController {
    private IBusinessDelegate<UserWishListModel, UserWishListContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserWishListContext> userWishListContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserWishListModel> create(@RequestBody final UserWishListModel userWishListModel) {
        businessDelegate.create(userWishListModel);
        return new ResponseEntity<UserWishListModel>(userWishListModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserWishListModel> edit(@PathVariable(value = "id") final String userWishListId,
            @RequestBody final UserWishListModel userWishListModel) {
        UserWishListContext userWishListContext = new UserWishListContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(userWishListId), userWishListModel);
        return new ResponseEntity<UserWishListModel>(userWishListModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUserWishList() {
        UserWishListContext userWishListContext = userWishListContextFactory.getObject();
        userWishListContext.setAll("all");
        Collection<UserWishListModel> UserWishListModel = businessDelegate.getCollection(userWishListContext);
        IModelWrapper<Collection<UserWishListModel>> models = new CollectionModelWrapper<UserWishListModel>(UserWishListModel.class,
                UserWishListModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserWishListModel> getUserWishList(@PathVariable(value = "id") final String userWishListId) {
        UserWishListContext userWishListContext = userWishListContextFactory.getObject();
        UserWishListModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(userWishListId), userWishListContext);
        return new ResponseEntity<UserWishListModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "userWishListBusinessDelegate")
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
    public void setUserWishListObjectFactory(final ObjectFactory<UserWishListContext> userWishListContextFactory) {
        this.userWishListContextFactory = userWishListContextFactory;
    }

}
