/**
 *
 */
package com.meat.controller;

/**
 * @author arthvedi1
 *
 */

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OrderDeliveryOptionsContext;
import com.meat.model.OrderDeliveryOptionsModel;
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

@RestController
@RequestMapping(value = "/orderDeliveryOptions", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OrderDeliveryOptionsController {

    private IBusinessDelegate<OrderDeliveryOptionsModel, OrderDeliveryOptionsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OrderDeliveryOptionsContext> orderDeliveryOptionsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderDeliveryOptionsModel> create(@RequestBody final OrderDeliveryOptionsModel orderDeliveryOptionsModel) {
        businessDelegate.create(orderDeliveryOptionsModel);
        return new ResponseEntity<OrderDeliveryOptionsModel>(orderDeliveryOptionsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrderDeliveryOptionsModel> edit(@PathVariable(value = "id") final String orderDeliveryOptionsId,
            @RequestBody final OrderDeliveryOptionsModel orderDeliveryOptionsModel) {

        OrderDeliveryOptionsContext orderDeliveryOptionsContext = new OrderDeliveryOptionsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(orderDeliveryOptionsId), orderDeliveryOptionsModel);
        return new ResponseEntity<OrderDeliveryOptionsModel>(orderDeliveryOptionsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOrderDeliveryOptions() {
        OrderDeliveryOptionsContext orderDeliveryOptionsContext = orderDeliveryOptionsContextFactory.getObject();
        orderDeliveryOptionsContext.setAll("all");
        Collection<OrderDeliveryOptionsModel> orderDeliveryOptionsModel = businessDelegate.getCollection(orderDeliveryOptionsContext);
        IModelWrapper<Collection<OrderDeliveryOptionsModel>> models = new CollectionModelWrapper<OrderDeliveryOptionsModel>(
                OrderDeliveryOptionsModel.class, orderDeliveryOptionsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderDeliveryOptionsModel> getOrderDeliveryOptions(
            @PathVariable(value = "id") final String orderDeliveryOptionsId) {
        OrderDeliveryOptionsContext orderDeliveryOptionsContext = orderDeliveryOptionsContextFactory.getObject();
        OrderDeliveryOptionsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(orderDeliveryOptionsId),
                orderDeliveryOptionsContext);
        return new ResponseEntity<OrderDeliveryOptionsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "orderDeliveryOptionsBusinessDelegate")
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
    public void setOrderDeliveryOptionsObjectFactory(final ObjectFactory<OrderDeliveryOptionsContext> orderDeliveryOptionsContextFactory) {
        this.orderDeliveryOptionsContextFactory = orderDeliveryOptionsContextFactory;
    }

}
