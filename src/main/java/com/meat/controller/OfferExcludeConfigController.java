/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OfferExcludeConfigContext;
import com.meat.model.OfferExcludeConfigModel;
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
@RequestMapping(value = "/offerExcludeConfig", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OfferExcludeConfigController {
    private IBusinessDelegate<OfferExcludeConfigModel, OfferExcludeConfigContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OfferExcludeConfigContext> offerExcludeConfigContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferExcludeConfigModel> create(@RequestBody final OfferExcludeConfigModel offerExcludeConfigModel) {
        businessDelegate.create(offerExcludeConfigModel);
        return new ResponseEntity<OfferExcludeConfigModel>(offerExcludeConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OfferExcludeConfigModel> edit(@PathVariable(value = "id") final String offerExcludeConfigId,
            @RequestBody final OfferExcludeConfigModel offerExcludeConfigModel) {
        OfferExcludeConfigContext offerExcludeConfigContext = new OfferExcludeConfigContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(offerExcludeConfigId), offerExcludeConfigModel);
        return new ResponseEntity<OfferExcludeConfigModel>(offerExcludeConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOfferExcludeConfiges() {
        OfferExcludeConfigContext offerExcludeConfigContext = offerExcludeConfigContextFactory.getObject();
        offerExcludeConfigContext.setAll("all");
        Collection<OfferExcludeConfigModel> offerExcludeConfigModel = businessDelegate.getCollection(offerExcludeConfigContext);
        IModelWrapper<Collection<OfferExcludeConfigModel>> models = new CollectionModelWrapper<OfferExcludeConfigModel>(
                OfferExcludeConfigModel.class, offerExcludeConfigModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferExcludeConfigModel> getOfferExcludeConfig(@PathVariable(value = "id") final String offerExcludeConfigId) {
        OfferExcludeConfigContext offerExcludeConfigContext = offerExcludeConfigContextFactory.getObject();
        OfferExcludeConfigModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(offerExcludeConfigId),
                offerExcludeConfigContext);
        return new ResponseEntity<OfferExcludeConfigModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "offerExcludeConfigBusinessDelegate")
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
    public void setOfferExcludeConfigObjectFactory(final ObjectFactory<OfferExcludeConfigContext> offerExcludeConfigContextFactory) {
        this.offerExcludeConfigContextFactory = offerExcludeConfigContextFactory;
    }

}
