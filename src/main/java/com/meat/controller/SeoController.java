/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SeoContext;
import com.meat.model.SeoModel;
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
 * @author Administrator
 *
 */
@RestController
@RequestMapping(value = "/seo", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SeoController {

    private IBusinessDelegate<SeoModel, SeoContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SeoContext> seoContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SeoModel> create(@RequestBody final SeoModel seoModel) {
        businessDelegate.create(seoModel);
        return new ResponseEntity<SeoModel>(seoModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SeoModel> edit(@PathVariable(value = "id") final String seoId, @RequestBody final SeoModel seoModel) {

        SeoContext seoContext = new SeoContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(seoId), seoModel);
        return new ResponseEntity<SeoModel>(seoModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTags() {
        SeoContext seoContext = seoContextFactory.getObject();
        seoContext.setAll("all");
        // LOGGER.info("items are");
        Collection<SeoModel> seoModels = businessDelegate.getCollection(seoContext);
        IModelWrapper<Collection<SeoModel>> models = new CollectionModelWrapper<SeoModel>(SeoModel.class, seoModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SeoModel> getSeos(@PathVariable(value = "id") final String seoId) {
        SeoContext seoContext = seoContextFactory.getObject();
        SeoModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(seoId), seoContext);
        return new ResponseEntity<SeoModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "seoBusinessDelegate")
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
    public void setSeoObjectFactory(final ObjectFactory<SeoContext> seoContextFactory) {
        this.seoContextFactory = seoContextFactory;
    }

}
