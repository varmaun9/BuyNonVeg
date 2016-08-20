/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ZoneAreaContext;
import com.meat.model.ZoneAreaModel;
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
 * @author varma
 *
 */
@RestController
@RequestMapping(value = "/zoneArea", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ZoneAreaController {
    private IBusinessDelegate<ZoneAreaModel, ZoneAreaContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ZoneAreaContext> zoneAreaContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneAreaModel> create(@RequestBody final ZoneAreaModel zoneAreaModel) {
        businessDelegate.create(zoneAreaModel);
        return new ResponseEntity<ZoneAreaModel>(zoneAreaModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ZoneAreaModel> edit(@PathVariable(value = "id") final String zoneAreaId,
            @RequestBody final ZoneAreaModel zoneAreaModel) {
        ZoneAreaContext zoneAreaContext = new ZoneAreaContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(zoneAreaId), zoneAreaModel);
        return new ResponseEntity<ZoneAreaModel>(zoneAreaModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZoneAreas() {
        ZoneAreaContext zoneAreaContext = zoneAreaContextFactory.getObject();
        zoneAreaContext.setAll("all");
        Collection<ZoneAreaModel> zoneAreaModel = businessDelegate.getCollection(zoneAreaContext);
        IModelWrapper<Collection<ZoneAreaModel>> models = new CollectionModelWrapper<ZoneAreaModel>(ZoneAreaModel.class, zoneAreaModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneAreaModel> getZoneArea(@PathVariable(value = "id") final String zoneAreaId) {
        ZoneAreaContext zoneAreaContext = zoneAreaContextFactory.getObject();
        ZoneAreaModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(zoneAreaId), zoneAreaContext);
        return new ResponseEntity<ZoneAreaModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "zoneAreaBusinessDelegate")
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
    public void setZoneAreaObjectFactory(final ObjectFactory<ZoneAreaContext> zoneAreaContextFactory) {
        this.zoneAreaContextFactory = zoneAreaContextFactory;
    }
}
