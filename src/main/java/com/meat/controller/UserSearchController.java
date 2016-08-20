/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UserSearchContext;
import com.meat.model.UserSearchModel;
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
@RequestMapping(value = "/userSearch", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UserSearchController {
    private IBusinessDelegate<UserSearchModel, UserSearchContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserSearchContext> userSearchContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserSearchModel> create(@RequestBody final UserSearchModel userSearchModel) {
        businessDelegate.create(userSearchModel);
        return new ResponseEntity<UserSearchModel>(userSearchModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserSearchModel> edit(@PathVariable(value = "id") final String userSearchId,
            @RequestBody final UserSearchModel userSearchModel) {
        UserSearchContext userSearchContext = new UserSearchContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(userSearchId), userSearchModel);
        return new ResponseEntity<UserSearchModel>(userSearchModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUserSearch() {
        UserSearchContext userSearchContext = userSearchContextFactory.getObject();
        userSearchContext.setAll("all");
        Collection<UserSearchModel> userSearchModel = businessDelegate.getCollection(userSearchContext);
        IModelWrapper<Collection<UserSearchModel>> models = new CollectionModelWrapper<UserSearchModel>(UserSearchModel.class,
                userSearchModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserSearchModel> getUserSearch(@PathVariable(value = "id") final String userSearchId) {
        UserSearchContext userSearchContext = userSearchContextFactory.getObject();
        UserSearchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(userSearchId), userSearchContext);
        return new ResponseEntity<UserSearchModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "userSearchBusinessDelegate")
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
    public void setUserSearchObjectFactory(final ObjectFactory<UserSearchContext> userSearchContextFactory) {
        this.userSearchContextFactory = userSearchContextFactory;
    }

}
