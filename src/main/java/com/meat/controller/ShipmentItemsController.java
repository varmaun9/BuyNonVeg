/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ShipmentItemsContext;
import com.meat.model.ShipmentItemsModel;
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
@RequestMapping(value = "/shipmentItems", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ShipmentItemsController {
    private IBusinessDelegate<ShipmentItemsModel, ShipmentItemsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ShipmentItemsContext> shipmentItemsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ShipmentItemsModel> create(@RequestBody final ShipmentItemsModel shipmentItemsModel) {
        businessDelegate.create(shipmentItemsModel);
        return new ResponseEntity<ShipmentItemsModel>(shipmentItemsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ShipmentItemsModel> edit(@PathVariable(value = "id") final String shipmentItemsId,
            @RequestBody final ShipmentItemsModel shipmentItemsModel) {
        ShipmentItemsContext shipmentItemsContext = new ShipmentItemsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(shipmentItemsId), shipmentItemsModel);
        return new ResponseEntity<ShipmentItemsModel>(shipmentItemsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllShipmentItems() {
        ShipmentItemsContext shipmentItemsContext = shipmentItemsContextFactory.getObject();
        shipmentItemsContext.setAll("all");
        Collection<ShipmentItemsModel> shipmentItemsModel = businessDelegate.getCollection(shipmentItemsContext);
        IModelWrapper<Collection<ShipmentItemsModel>> models = new CollectionModelWrapper<ShipmentItemsModel>(ShipmentItemsModel.class,
                shipmentItemsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ShipmentItemsModel> getShipmentItems(@PathVariable(value = "id") final String shipmentItemsId) {
        ShipmentItemsContext shipmentItemsContext = shipmentItemsContextFactory.getObject();
        ShipmentItemsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(shipmentItemsId), shipmentItemsContext);
        return new ResponseEntity<ShipmentItemsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "shipmentItemsBusinessDelegate")
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
    public void setShipmentItemsObjectFactory(final ObjectFactory<ShipmentItemsContext> shipmentItemsContextFactory) {
        this.shipmentItemsContextFactory = shipmentItemsContextFactory;
    }

}
