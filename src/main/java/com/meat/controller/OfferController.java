/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OfferContext;
import com.meat.model.OfferModel;
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
@RequestMapping(value = "/offer", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OfferController {
    private IBusinessDelegate<OfferModel, OfferContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OfferContext> offerContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferModel> create(@RequestBody final OfferModel offerModel) {
        businessDelegate.create(offerModel);
        return new ResponseEntity<OfferModel>(offerModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OfferModel> edit(@PathVariable(value = "id") final String offerId, @RequestBody final OfferModel offerModel) {
        OfferContext offerContext = new OfferContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(offerId), offerModel);
        return new ResponseEntity<OfferModel>(offerModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOfferses() {
        OfferContext offerContext = offerContextFactory.getObject();
        offerContext.setAll("all");
        Collection<OfferModel> offerModel = businessDelegate.getCollection(offerContext);
        IModelWrapper<Collection<OfferModel>> models = new CollectionModelWrapper<OfferModel>(OfferModel.class, offerModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferModel> getOffer(@PathVariable(value = "id") final String offerId) {
        OfferContext offerContext = offerContextFactory.getObject();
        OfferModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(offerId), offerContext);
        return new ResponseEntity<OfferModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "offerBusinessDelegate")
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
    public void setOfferObjectFactory(final ObjectFactory<OfferContext> offerContextFactory) {
        this.offerContextFactory = offerContextFactory;
    }

}
