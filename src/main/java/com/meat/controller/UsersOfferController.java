/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UsersOfferContext;
import com.meat.model.UsersOfferModel;
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
 * @author arthvedi1
 *
 */

@RestController
@RequestMapping(value = "/usersOffer", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UsersOfferController {
    private IBusinessDelegate<UsersOfferModel, UsersOfferContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UsersOfferContext> usersOfferContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersOfferModel> create(@RequestBody final UsersOfferModel usersOfferModel) {
        businessDelegate.create(usersOfferModel);
        return new ResponseEntity<UsersOfferModel>(usersOfferModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsersOfferModel> edit(@PathVariable(value = "id") final String usersOfferId,
            @RequestBody final UsersOfferModel usersOfferModel) {
        UsersOfferContext usersOfferContext = new UsersOfferContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(usersOfferId), usersOfferModel);
        return new ResponseEntity<UsersOfferModel>(usersOfferModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUsersOfferes() {
        UsersOfferContext usersOfferContext = usersOfferContextFactory.getObject();
        usersOfferContext.setAll("all");
        Collection<UsersOfferModel> usersOfferModel = businessDelegate.getCollection(usersOfferContext);
        IModelWrapper<Collection<UsersOfferModel>> models = new CollectionModelWrapper<UsersOfferModel>(UsersOfferModel.class,
                usersOfferModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersOfferModel> getUsersOffer(@PathVariable(value = "id") final String usersOfferId) {
        UsersOfferContext usersOfferContext = usersOfferContextFactory.getObject();
        UsersOfferModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(usersOfferId), usersOfferContext);
        return new ResponseEntity<UsersOfferModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "usersOfferBusinessDelegate")
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
    public void setUsersOfferObjectFactory(final ObjectFactory<UsersOfferContext> usersOfferContextFactory) {
        this.usersOfferContextFactory = usersOfferContextFactory;
    }

}
