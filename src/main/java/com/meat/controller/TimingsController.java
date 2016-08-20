/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.TimingsContext;
import com.meat.model.TimingsModel;
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
@RequestMapping(value = "/timings", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class TimingsController {
    private IBusinessDelegate<TimingsModel, TimingsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<TimingsContext> timingsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TimingsModel> create(@RequestBody final TimingsModel timingsModel) {
        businessDelegate.create(timingsModel);
        return new ResponseEntity<TimingsModel>(timingsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TimingsModel> edit(@PathVariable(value = "id") final String timingsId,
            @RequestBody final TimingsModel timingsModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(timingsId), timingsModel);
        return new ResponseEntity<TimingsModel>(timingsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTimingses() {
        TimingsContext timingsContext = timingsContextFactory.getObject();
        timingsContext.setAll("all");
        Collection<TimingsModel> timingsModel = businessDelegate.getCollection(timingsContext);
        IModelWrapper<Collection<TimingsModel>> models = new CollectionModelWrapper<TimingsModel>(TimingsModel.class, timingsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/timingsOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTimingsOnly() {
        TimingsContext timingsContext = timingsContextFactory.getObject();
        timingsContext.setAll("all");
        timingsContext.setTimingsOnly("TimingsOnly");
        Collection<TimingsModel> timingsModel = businessDelegate.getCollection(timingsContext);
        IModelWrapper<Collection<TimingsModel>> models = new CollectionModelWrapper<TimingsModel>(TimingsModel.class, timingsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TimingsModel> getTimings(@PathVariable(value = "id") final String timingsId) {
        TimingsContext timingsContext = timingsContextFactory.getObject();
        TimingsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(timingsId), timingsContext);
        return new ResponseEntity<TimingsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "timingsBusinessDelegate")
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
    public void setTimingsObjectFactory(final ObjectFactory<TimingsContext> timingsContextFactory) {
        this.timingsContextFactory = timingsContextFactory;
    }

}
