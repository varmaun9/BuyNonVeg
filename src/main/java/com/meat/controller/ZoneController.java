/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ZoneContext;
import com.meat.model.ZoneModel;
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
@RequestMapping(value = "/zone", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ZoneController {
    private IBusinessDelegate<ZoneModel, ZoneContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ZoneContext> zoneContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneModel> create(@RequestBody final ZoneModel zoneModel) {
        businessDelegate.create(zoneModel);
        return new ResponseEntity<ZoneModel>(zoneModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ZoneModel> edit(@PathVariable(value = "id") final String zoneId, @RequestBody final ZoneModel zoneModel) {
        ZoneContext zoneContext = new ZoneContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(zoneId), zoneModel);
        return new ResponseEntity<ZoneModel>(zoneModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZones() {
        ZoneContext zoneContext = zoneContextFactory.getObject();
        zoneContext.setAll("all");
        Collection<ZoneModel> zoneModel = businessDelegate.getCollection(zoneContext);
        IModelWrapper<Collection<ZoneModel>> models = new CollectionModelWrapper<ZoneModel>(ZoneModel.class, zoneModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/zoneCity/{zoneCityId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZonesByZoneCity(@PathVariable(value = "zoneCityId") final String zoneCityId) {
        ZoneContext zoneContext = zoneContextFactory.getObject();
        zoneContext.setZoneCityId(zoneCityId);
        Collection<ZoneModel> zoneModel = businessDelegate.getCollection(zoneContext);
        IModelWrapper<Collection<ZoneModel>> models = new CollectionModelWrapper<ZoneModel>(ZoneModel.class, zoneModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneModel> getZone(@PathVariable(value = "id") final String zoneId) {
        ZoneContext zoneContext = zoneContextFactory.getObject();
        ZoneModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(zoneId), zoneContext);
        return new ResponseEntity<ZoneModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "zoneBusinessDelegate")
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
    public void setZoneObjectFactory(final ObjectFactory<ZoneContext> zoneContextFactory) {
        this.zoneContextFactory = zoneContextFactory;
    }

}
