package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OrderStatusCodesContext;
import com.meat.model.OrderStatusCodesModel;
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
@RequestMapping(value = "/orderStatusCodes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OrderStatusCodesController {

    private IBusinessDelegate<OrderStatusCodesModel, OrderStatusCodesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OrderStatusCodesContext> orderStatusCodesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderStatusCodesModel> create(@RequestBody final OrderStatusCodesModel orderStatusCodesModel) {
        businessDelegate.create(orderStatusCodesModel);
        return new ResponseEntity<OrderStatusCodesModel>(orderStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrderStatusCodesModel> edit(@PathVariable(value = "id") final String orderStatusCodesId,
            @RequestBody final OrderStatusCodesModel OrderStatusCodesModel) {

        OrderStatusCodesContext orderStatusCodesContext = new OrderStatusCodesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(orderStatusCodesId), OrderStatusCodesModel);
        return new ResponseEntity<OrderStatusCodesModel>(OrderStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOrderStatusCodes() {
        OrderStatusCodesContext orderStatusCodesContext = orderStatusCodesContextFactory.getObject();
        orderStatusCodesContext.setAll("all");
        Collection<OrderStatusCodesModel> orderStatusCodesModel = businessDelegate.getCollection(orderStatusCodesContext);
        IModelWrapper<Collection<OrderStatusCodesModel>> models = new CollectionModelWrapper<OrderStatusCodesModel>(
                OrderStatusCodesModel.class, orderStatusCodesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderStatusCodesModel> getOrderStatusCodes(@PathVariable(value = "id") final String orderStatusCodesId) {
        OrderStatusCodesContext orderStatusCodesContext = orderStatusCodesContextFactory.getObject();
        OrderStatusCodesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(orderStatusCodesId),
                orderStatusCodesContext);
        return new ResponseEntity<OrderStatusCodesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "orderStatusCodesBusinessDelegate")
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
    public void setOrderStatusCodesObjectFactory(final ObjectFactory<OrderStatusCodesContext> orderStatusCodesContextFactory) {
        this.orderStatusCodesContextFactory = orderStatusCodesContextFactory;
    }

}
