/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ZoneCityContext;
import com.meat.model.ZoneCityModel;
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
@RequestMapping(value = "/zoneCity", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ZoneCityController {
    private IBusinessDelegate<ZoneCityModel, ZoneCityContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ZoneCityContext> zoneCityContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneCityModel> create(@RequestBody final ZoneCityModel zoneCityModel) {
        businessDelegate.create(zoneCityModel);
        return new ResponseEntity<ZoneCityModel>(zoneCityModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ZoneCityModel> edit(@PathVariable(value = "id") final String zoneCityId,
            @RequestBody final ZoneCityModel zoneCityModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(zoneCityId), zoneCityModel);
        return new ResponseEntity<ZoneCityModel>(zoneCityModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/zoneCityZoneOnly/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZoneCityZoneOnly() {
        ZoneCityContext zoneCityContext = zoneCityContextFactory.getObject();
        zoneCityContext.setAll("all");
        zoneCityContext.setZoneCityZoneOnly("ZoneCityZoneOnly");
        Collection<ZoneCityModel> zoneCityModel = businessDelegate.getCollection(zoneCityContext);
        IModelWrapper<Collection<ZoneCityModel>> models = new CollectionModelWrapper<ZoneCityModel>(ZoneCityModel.class, zoneCityModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZones() {
        ZoneCityContext zoneCityContext = zoneCityContextFactory.getObject();
        zoneCityContext.setAll("all");
        Collection<ZoneCityModel> zoneCityModel = businessDelegate.getCollection(zoneCityContext);
        IModelWrapper<Collection<ZoneCityModel>> models = new CollectionModelWrapper<ZoneCityModel>(ZoneCityModel.class, zoneCityModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ZoneCityModel> getZoneCity(@PathVariable(value = "id") final String zoneCityId) {
        ZoneCityContext zoneCityContext = zoneCityContextFactory.getObject();
        ZoneCityModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(zoneCityId), zoneCityContext);
        return new ResponseEntity<ZoneCityModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "zoneCityBusinessDelegate")
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
    public void setZoneCityObjectFactory(final ObjectFactory<ZoneCityContext> zoneCityContextFactory) {
        this.zoneCityContextFactory = zoneCityContextFactory;
    }

}
