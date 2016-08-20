package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OrderItemStatusCodesContext;
import com.meat.model.OrderItemStatusCodesModel;
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
@RequestMapping(value = "/orderItemStatusCodes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OrderItemStatusCodesController {
    private IBusinessDelegate<OrderItemStatusCodesModel, OrderItemStatusCodesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OrderItemStatusCodesContext> orderItemStatusCodesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderItemStatusCodesModel> create(@RequestBody final OrderItemStatusCodesModel orderItemStatusCodesModel) {
        businessDelegate.create(orderItemStatusCodesModel);
        return new ResponseEntity<OrderItemStatusCodesModel>(orderItemStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrderItemStatusCodesModel> edit(@PathVariable(value = "id") final String orderItemStatusCodesId,
            @RequestBody final OrderItemStatusCodesModel orderItemStatusCodesModel) {
        OrderItemStatusCodesContext orderItemStatusCodesContext = new OrderItemStatusCodesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(orderItemStatusCodesId), orderItemStatusCodesModel);
        return new ResponseEntity<OrderItemStatusCodesModel>(orderItemStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/All", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllMailStatusCodes() {
        OrderItemStatusCodesContext orderItemStatusCodesContext = orderItemStatusCodesContextFactory.getObject();
        orderItemStatusCodesContext.setAll("all");
        Collection<OrderItemStatusCodesModel> orderItemStatusCodesModel = businessDelegate.getCollection(orderItemStatusCodesContext);
        IModelWrapper<Collection<OrderItemStatusCodesModel>> models = new CollectionModelWrapper<OrderItemStatusCodesModel>(
                OrderItemStatusCodesModel.class, orderItemStatusCodesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderItemStatusCodesModel> getMailStatusCodes(@PathVariable(value = "id") final String orderItemStatusCodesId) {
        OrderItemStatusCodesContext orderItemStatusCodesContext = orderItemStatusCodesContextFactory.getObject();
        OrderItemStatusCodesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(orderItemStatusCodesId),
                orderItemStatusCodesContext);
        return new ResponseEntity<OrderItemStatusCodesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "orderItemStatusCodesBusinessDelegate")
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
    public void setMailStatusCodesObjectFactory(final ObjectFactory<OrderItemStatusCodesContext> orderItemStatusCodesContextFactory) {
        this.orderItemStatusCodesContextFactory = orderItemStatusCodesContextFactory;
    }

}
