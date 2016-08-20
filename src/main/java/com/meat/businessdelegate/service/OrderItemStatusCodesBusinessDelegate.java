/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.OrderItem;
import com.meat.domain.OrderItemStatusCodes;
import com.meat.model.OrderItemStatusCodesModel;
import com.meat.service.IOrderItemStatusCodesService;

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
public class OrderItemStatusCodesBusinessDelegate implements
        IBusinessDelegate<OrderItemStatusCodesModel, OrderItemStatusCodesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOrderItemStatusCodesService orderItemStatusCodesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderItemStatusCodesModel create(final OrderItemStatusCodesModel model) {
        OrderItemStatusCodes orderItemStatusCodes = new OrderItemStatusCodes();
        orderItemStatusCodes.setOrderItemStatusCode(model.getOrderItemStatusCode());
        orderItemStatusCodes.setOrderItemStatusDescription(model.getOrderItemStatusDescription());
        orderItemStatusCodes.setOrderItemStatusDate(new Date());
        OrderItem orderItem = new OrderItem();
        orderItem.setId(model.getOrderItemId());
        orderItemStatusCodes.setOrderItem(orderItem);
        orderItemStatusCodes = orderItemStatusCodesService.create(orderItemStatusCodes);
        model.setId(orderItemStatusCodes.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OrderItemStatusCodesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderItemStatusCodesModel edit(final IKeyBuilder<String> keyBuilder, final OrderItemStatusCodesModel model) {
        OrderItemStatusCodes orderItemStatusCodes = orderItemStatusCodesService.getOrderItemStatusCodes(keyBuilder.build().toString());
        orderItemStatusCodes.setOrderItemStatusDescription(model.getOrderItemStatusDate());
        orderItemStatusCodes.setOrderItemStatusDate(new Date());
        OrderItem orderItem = new OrderItem();
        orderItem.setId(model.getOrderItemId());
        orderItemStatusCodes.setOrderItem(orderItem);
        orderItemStatusCodes = orderItemStatusCodesService.updateOrderItemStatusCodes(orderItemStatusCodes);
        model.setId(orderItemStatusCodes.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OrderItemStatusCodesModel getByKey(final IKeyBuilder<String> keyBuilder, final OrderItemStatusCodesContext context) {
        OrderItemStatusCodes orderItemStatusCodes = orderItemStatusCodesService.getOrderItemStatusCodes(keyBuilder.build().toString());
        OrderItemStatusCodesModel orderItemStatusCodesModel = conversionService.convert(orderItemStatusCodes,
                OrderItemStatusCodesModel.class);
        return orderItemStatusCodesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OrderItemStatusCodesModel> getCollection(final OrderItemStatusCodesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
