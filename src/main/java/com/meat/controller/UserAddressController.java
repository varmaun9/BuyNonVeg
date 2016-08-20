/**
 *
 */
package com.meat.controller;

/**
 * @author arthvedi1
 *
 */
/**
 *
 */

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UserAddressContext;
import com.meat.model.UserAddressModel;
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
@RequestMapping(value = "/userAddress", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UserAddressController {
    private IBusinessDelegate<UserAddressModel, UserAddressContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UserAddressContext> userAddressContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserAddressModel> create(@RequestBody final UserAddressModel userAddressModel) {
        businessDelegate.create(userAddressModel);
        return new ResponseEntity<UserAddressModel>(userAddressModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserAddressModel> edit(@PathVariable(value = "id") final String userAddressId,
            @RequestBody final UserAddressModel userAddressModel) {
        UserAddressContext userAddressContext = new UserAddressContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(userAddressId), userAddressModel);
        return new ResponseEntity<UserAddressModel>(userAddressModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUserAddress() {
        UserAddressContext userAddressContext = userAddressContextFactory.getObject();
        userAddressContext.setAll("all");
        Collection<UserAddressModel> UserAddressModel = businessDelegate.getCollection(userAddressContext);
        IModelWrapper<Collection<UserAddressModel>> models = new CollectionModelWrapper<UserAddressModel>(UserAddressModel.class,
                UserAddressModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UserAddressModel> getUserAddress(@PathVariable(value = "id") final String userAddressId) {
        UserAddressContext userAddressContext = userAddressContextFactory.getObject();
        UserAddressModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(userAddressId), userAddressContext);
        return new ResponseEntity<UserAddressModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "userAddressBusinessDelegate")
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
    public void setUserAddressObjectFactory(final ObjectFactory<UserAddressContext> userAddressContextFactory) {
        this.userAddressContextFactory = userAddressContextFactory;
    }

}
