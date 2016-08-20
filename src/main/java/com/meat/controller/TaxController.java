package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.TaxContext;
import com.meat.model.TaxModel;
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

@RestController
@RequestMapping(value = "/tax", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class TaxController {

    private IBusinessDelegate<TaxModel, TaxContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<TaxContext> taxContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TaxModel> create(@RequestBody final TaxModel taxModel) {
        businessDelegate.create(taxModel);
        return new ResponseEntity<TaxModel>(taxModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TaxModel> edit(@PathVariable(value = "id") final String taxId, @RequestBody final TaxModel taxModel) {
        TaxContext taxContext = new TaxContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(taxId), taxModel);
        return new ResponseEntity<TaxModel>(taxModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTax() {
        TaxContext taxContext = taxContextFactory.getObject();
        taxContext.setAll("all");
        // LOGGER.info("items are");
        Collection<TaxModel> taxModels = businessDelegate.getCollection(taxContext);
        IModelWrapper<Collection<TaxModel>> models = new CollectionModelWrapper<TaxModel>(TaxModel.class, taxModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TaxModel> getTax(@PathVariable(value = "id") final String taxId) {
        TaxContext taxContext = taxContextFactory.getObject();
        TaxModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(taxId), taxContext);
        return new ResponseEntity<TaxModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "taxBusinessDelegate")
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
    public void setTaxObjectFactory(final ObjectFactory<TaxContext> taxContextFactory) {
        this.taxContextFactory = taxContextFactory;
    }

}
