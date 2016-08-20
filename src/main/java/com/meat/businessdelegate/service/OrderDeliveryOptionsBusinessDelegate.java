/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Address;
import com.meat.domain.OrderDeliveryOptions;
import com.meat.domain.Orders;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.service.IOrderDeliveryOptionsService;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class OrderDeliveryOptionsBusinessDelegate
        implements IBusinessDelegate<OrderDeliveryOptionsModel, OrderDeliveryOptionsContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOrderDeliveryOptionsService orderDeliveryOptionsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderDeliveryOptionsModel create(final OrderDeliveryOptionsModel model) {
        OrderDeliveryOptions orderDeliveryOptions = new OrderDeliveryOptions();
        String value = model.getShippingCost();
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.replaceAll(",", " "));
            orderDeliveryOptions.setShippingCost(bigDecimal);
            orderDeliveryOptions.setShippingCost(orderDeliveryOptions.getShippingCost());
        }
        Orders orders = new Orders();
        orders.setId(model.getOrdersId());
        orderDeliveryOptions.setOrders(orders);
        Address address = new Address();
        address.setId(model.getAddressId());
        orderDeliveryOptions.setAddress(address);
        //  orderDeliveryOptions.setShippingAddressId(model.getShippingAddressId());
        orderDeliveryOptions = orderDeliveryOptionsService.create(orderDeliveryOptions);
        model.setId(orderDeliveryOptions.getId());

        // TODO Auto-generated method stub
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OrderDeliveryOptionsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderDeliveryOptionsModel edit(final IKeyBuilder<String> keyBuilder, final OrderDeliveryOptionsModel model) {
        OrderDeliveryOptions orderDeliveryOptions = orderDeliveryOptionsService.getOrderDeliveryOptions(keyBuilder.build().toString());
        String value = model.getShippingCost();
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.replaceAll(",", " "));
            orderDeliveryOptions.setShippingCost(bigDecimal);
            orderDeliveryOptions.setShippingCost(orderDeliveryOptions.getShippingCost());
        }
        Orders orders = new Orders();
        orders.setId(model.getOrdersId());
        orderDeliveryOptions.setOrders(orders);
        Address address = new Address();
        address.setId(model.getAddressId());
        orderDeliveryOptions.setAddress(address);
        //  orderDeliveryOptions.setShippingAddressId(model.getShippingAddressId());
        orderDeliveryOptions = orderDeliveryOptionsService.updateOrderDeliveryOptions(orderDeliveryOptions);
        model.setId(orderDeliveryOptions.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OrderDeliveryOptionsModel getByKey(final IKeyBuilder<String> keyBuilder, final OrderDeliveryOptionsContext context) {
        OrderDeliveryOptions orderDeliveryOptions = orderDeliveryOptionsService.getOrderDeliveryOptions(keyBuilder.build().toString());
        OrderDeliveryOptionsModel orderDeliveryOptionsModel = conversionService.convert(orderDeliveryOptions,
                OrderDeliveryOptionsModel.class);
        return orderDeliveryOptionsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OrderDeliveryOptionsModel> getCollection(final OrderDeliveryOptionsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
