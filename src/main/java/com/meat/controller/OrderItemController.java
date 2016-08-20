package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OrderItemContext;
import com.meat.model.OrderItemModel;
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
@RequestMapping(value = "/orderItem", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OrderItemController {

    private IBusinessDelegate<OrderItemModel, OrderItemContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OrderItemContext> orderItemContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderItemModel> create(@RequestBody final OrderItemModel orderItemModel) {
        businessDelegate.create(orderItemModel);
        return new ResponseEntity<OrderItemModel>(orderItemModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrderItemModel> edit(@PathVariable(value = "id") final String orderItemId,
            @RequestBody final OrderItemModel OrderItemModel) {

        OrderItemContext orderItemContext = new OrderItemContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(orderItemId), OrderItemModel);
        return new ResponseEntity<OrderItemModel>(OrderItemModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOrderItem() {
        OrderItemContext orderItemContext = orderItemContextFactory.getObject();
        orderItemContext.setAll("all");
        Collection<OrderItemModel> orderItemModel = businessDelegate.getCollection(orderItemContext);
        IModelWrapper<Collection<OrderItemModel>> models = new CollectionModelWrapper<OrderItemModel>(OrderItemModel.class, orderItemModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrderItemModel> getOrderItem(@PathVariable(value = "id") final String orderItemId) {
        OrderItemContext orderItemContext = orderItemContextFactory.getObject();
        OrderItemModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(orderItemId), orderItemContext);
        return new ResponseEntity<OrderItemModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "orderItemBusinessDelegate")
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
    public void setOrderItemObjectFactory(final ObjectFactory<OrderItemContext> orderItemContextFactory) {
        this.orderItemContextFactory = orderItemContextFactory;
    }

}
