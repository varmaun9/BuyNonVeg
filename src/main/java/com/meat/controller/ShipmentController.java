/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ShipmentContext;
import com.meat.model.ShipmentModel;
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
@RequestMapping(value = "/shipment", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ShipmentController {
    private IBusinessDelegate<ShipmentModel, ShipmentContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ShipmentContext> shipmentContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ShipmentModel> create(@RequestBody final ShipmentModel shipmentModel) {
        businessDelegate.create(shipmentModel);
        return new ResponseEntity<ShipmentModel>(shipmentModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ShipmentModel> edit(@PathVariable(value = "id") final String shipmentId,
            @RequestBody final ShipmentModel shipmentModel) {
        ShipmentContext shipmentContext = new ShipmentContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(shipmentId), shipmentModel);
        return new ResponseEntity<ShipmentModel>(shipmentModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllShipment() {
        ShipmentContext shipmentContext = shipmentContextFactory.getObject();
        shipmentContext.setAll("all");
        Collection<ShipmentModel> shipmentModel = businessDelegate.getCollection(shipmentContext);
        IModelWrapper<Collection<ShipmentModel>> models = new CollectionModelWrapper<ShipmentModel>(ShipmentModel.class, shipmentModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ShipmentModel> getShipment(@PathVariable(value = "id") final String shipmentId) {
        ShipmentContext shipmentContext = shipmentContextFactory.getObject();
        ShipmentModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(shipmentId), shipmentContext);
        return new ResponseEntity<ShipmentModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "shipmentBusinessDelegate")
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
    public void setshipmentObjectFactory(final ObjectFactory<ShipmentContext> shipmentContextFactory) {
        this.shipmentContextFactory = shipmentContextFactory;
    }

}
