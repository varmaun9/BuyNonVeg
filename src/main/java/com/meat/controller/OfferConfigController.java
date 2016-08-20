/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OfferConfigContext;
import com.meat.model.OfferConfigModel;
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
@RequestMapping(value = "/offerConfig", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OfferConfigController {
    private IBusinessDelegate<OfferConfigModel, OfferConfigContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OfferConfigContext> offerConfigContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferConfigModel> create(@RequestBody final OfferConfigModel offerConfigModel) {
        businessDelegate.create(offerConfigModel);
        return new ResponseEntity<OfferConfigModel>(offerConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OfferConfigModel> edit(@PathVariable(value = "id") final String offerConfigId,
            @RequestBody final OfferConfigModel offerConfigModel) {
        OfferConfigContext offerConfigContext = new OfferConfigContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(offerConfigId), offerConfigModel);
        return new ResponseEntity<OfferConfigModel>(offerConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOfferConfiges() {
        OfferConfigContext offerConfigContext = offerConfigContextFactory.getObject();
        offerConfigContext.setAll("all");
        Collection<OfferConfigModel> offerConfigModel = businessDelegate.getCollection(offerConfigContext);
        IModelWrapper<Collection<OfferConfigModel>> models = new CollectionModelWrapper<OfferConfigModel>(OfferConfigModel.class,
                offerConfigModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OfferConfigModel> getOfferConfig(@PathVariable(value = "id") final String offerConfigId) {
        OfferConfigContext offerConfigContext = offerConfigContextFactory.getObject();
        OfferConfigModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(offerConfigId), offerConfigContext);
        return new ResponseEntity<OfferConfigModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "offerConfigBusinessDelegate")
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
    public void setOfferConfigObjectFactory(final ObjectFactory<OfferConfigContext> offerConfigContextFactory) {
        this.offerConfigContextFactory = offerConfigContextFactory;
    }

}
