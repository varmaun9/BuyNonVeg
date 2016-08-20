package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.OrdersContext;
import com.meat.model.OrdersModel;
import com.meat.security.CustomUserDetails;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class OrdersController {

    private IBusinessDelegate<OrdersModel, OrdersContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<OrdersContext> ordersContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrdersModel> create(@RequestBody final OrdersModel ordersModel) {
        businessDelegate.create(ordersModel);
        return new ResponseEntity<OrdersModel>(ordersModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<OrdersModel> edit(@PathVariable(value = "id") final String ordersId, @RequestBody final OrdersModel ordersModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getPrincipal().equals("anonymousUser")) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
            ordersModel.setUsersId(userDetails.getId());
        }
        OrdersContext ordersContext = new OrdersContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(ordersId), ordersModel);
        return new ResponseEntity<OrdersModel>(ordersModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllOrders() {
        OrdersContext ordersContext = ordersContextFactory.getObject();
        ordersContext.setAll("all");
        Collection<OrdersModel> ordersModel = businessDelegate.getCollection(ordersContext);
        IModelWrapper<Collection<OrdersModel>> models = new CollectionModelWrapper<OrdersModel>(OrdersModel.class, ordersModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<OrdersModel> getOrders(@PathVariable(value = "id") final String ordersId) {
        OrdersContext ordersContext = ordersContextFactory.getObject();
        OrdersModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(ordersId), ordersContext);
        return new ResponseEntity<OrdersModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "ordersBusinessDelegate")
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
    public void setOrdersObjectFactory(final ObjectFactory<OrdersContext> ordersContextFactory) {
        this.ordersContextFactory = ordersContextFactory;
    }

}
