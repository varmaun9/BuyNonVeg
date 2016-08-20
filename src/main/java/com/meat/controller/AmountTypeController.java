/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.AmountTypeContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.domain.AmountType;
import com.meat.model.AmountTypeModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author varma
 *
 */
@RestController
@RequestMapping(value = "/amountType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class AmountTypeController {

    private static final Logger LOGGER = Logger.getLogger(AmountTypeController.class);

    private IBusinessDelegate<AmountTypeModel, AmountTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<AmountTypeContext> amountTypeObjectFactory;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<AmountTypeModel> createAmountType(@RequestBody final AmountTypeModel amountTypeModel) {
        AmountType amountType = new AmountType();
        businessDelegate.create(amountTypeModel);
        return new ResponseEntity<AmountTypeModel>(amountTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<AmountTypeModel> editAmountType(@PathVariable(value = "id") final String amountTypeId,
            @RequestBody final AmountTypeModel amountTypeModel) {
        AmountTypeContext amountTypeContext = amountTypeObjectFactory.getObject();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(amountTypeId), amountTypeModel);
        return new ResponseEntity<AmountTypeModel>(amountTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<AmountTypeModel> getAmountType(@PathVariable(value = "id") final String amountTypeId) {
        AmountTypeContext amountTypeContext = amountTypeObjectFactory.getObject();
        AmountTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(amountTypeId), amountTypeContext);
        return new ResponseEntity<AmountTypeModel>(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/amountTypeOnly", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getAmountTypesOnly() {
        AmountTypeContext amountTypeContext = amountTypeObjectFactory.getObject();
        amountTypeContext.setAmountTypeOnly("amountTypeOnly");

        Collection<AmountTypeModel> amountTypeModelCollection = businessDelegate.getCollection(amountTypeContext);
        IModelWrapper<Collection<AmountTypeModel>> models = new CollectionModelWrapper<AmountTypeModel>(AmountTypeModel.class,
                amountTypeModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getStates() {
        AmountTypeContext amountTypeContext = amountTypeObjectFactory.getObject();
        amountTypeContext.setAll("all");
        Collection<AmountTypeModel> amountTypeModelCollection = businessDelegate.getCollection(amountTypeContext);
        IModelWrapper<Collection<AmountTypeModel>> models = new CollectionModelWrapper<AmountTypeModel>(AmountTypeModel.class,
                amountTypeModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @Resource(name = "amountTypeBusinessDelegate")
    public void setAmountTypeBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setAmountTypeObjectFactory(final ObjectFactory<AmountTypeContext> amountTypeObjectFactory) {
        this.amountTypeObjectFactory = amountTypeObjectFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
