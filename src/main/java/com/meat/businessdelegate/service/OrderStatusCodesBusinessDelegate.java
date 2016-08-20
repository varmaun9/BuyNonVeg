/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.OrderStatusCodes;
import com.meat.domain.Orders;
import com.meat.model.OrderStatusCodesModel;
import com.meat.service.IOrderStatusCodesService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class OrderStatusCodesBusinessDelegate implements
        IBusinessDelegate<OrderStatusCodesModel, OrderStatusCodesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOrderStatusCodesService orderStatusCodesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderStatusCodesModel create(final OrderStatusCodesModel model) {
        OrderStatusCodes orderStatusCodes = new OrderStatusCodes();
        orderStatusCodes.setOrderStatusCode(model.getOrderStatusCode());
        orderStatusCodes.setOrderStatusDescription(model.getOrderStatusDescription());
        orderStatusCodes.setOrderStatusDate(new Date());
        Orders orders = new Orders();
        orders.setId(model.getOrderId());
        orderStatusCodes.setOrders(orders);
        orderStatusCodes = orderStatusCodesService.create(orderStatusCodes);
        model.setId(orderStatusCodes.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OrderStatusCodesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderStatusCodesModel edit(final IKeyBuilder<String> keyBuilder, final OrderStatusCodesModel model) {
        OrderStatusCodes orderStatusCodes = orderStatusCodesService.getOrderStatusCodes(keyBuilder.build().toString());
        orderStatusCodes.setOrderStatusCode(model.getOrderStatusCode());
        orderStatusCodes.setOrderStatusDescription(model.getOrderStatusDescription());
        orderStatusCodes.setOrderStatusDate(new Date());
        Orders orders = new Orders();
        orders.setId(model.getOrderId());
        orderStatusCodes.setOrders(orders);
        orderStatusCodes = orderStatusCodesService.updateOrderStatusCodes(orderStatusCodes);
        model.setId(orderStatusCodes.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OrderStatusCodesModel getByKey(final IKeyBuilder<String> keyBuilder, final OrderStatusCodesContext context) {
        OrderStatusCodes orderStatusCodes = orderStatusCodesService.getOrderStatusCodes(keyBuilder.build().toString());
        OrderStatusCodesModel orderStatusCodesModel = conversionService.convert(orderStatusCodes, OrderStatusCodesModel.class);
        return orderStatusCodesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OrderStatusCodesModel> getCollection(final OrderStatusCodesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
