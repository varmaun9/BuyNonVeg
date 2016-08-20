/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.OrderItem;
import com.meat.domain.Orders;
import com.meat.domain.SellerItem;
import com.meat.domain.Timings;
import com.meat.model.OrderItemModel;
import com.meat.service.IOrderItemService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class OrderItemBusinessDelegate implements IBusinessDelegate<OrderItemModel, OrderItemContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderItemModel create(final OrderItemModel model) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(model.getId());
        orderItem.setQuantity(model.getQuantity());
        orderItem.setCutType(model.getCutType());
        /*String value = model.getPrice();
        if (value != null) {
            BigDecimal bigDecimal = new BigDecimal(value.replaceAll(",", " "));
              orderItem.setPrice(bigDecimal);
            orderItem.setPrice(orderItem.getPrice());
        }*/
        orderItem.setUnits(Float.parseFloat(model.getUnits()));
        orderItem.setDeliveryDate(new Date());
        orderItem.setTimingName(model.getTimingName());
        Timings timings = new Timings();
        timings.setId(model.getTimingsId());
        orderItem.setTimings(timings);
        orderItem.setDeliveryTime(model.getDeliveryTime());
        orderItem.setAvailableTime(model.getAvailableTime());
        Orders orders = new Orders();
        orders.setId(model.getOrdersId());
        orderItem.setOrders(orders);
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        orderItem.setSellerItem(sellerItem);
        orderItem.setOrderItemStatus(model.getOrderItemStatus());
        orderItem.setOrderItemCount(Long.parseLong(model.getOrderItemCount()));
        // orderItem.setOrderTimeCode(model.getOrderTimeCode());
        orderItem.setCreatedDate(new Date());
        orderItem = orderItemService.create(orderItem);
        model.setId(orderItem.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OrderItemContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public OrderItemModel edit(final IKeyBuilder<String> keyBuilder, final OrderItemModel model) {
        OrderItem orderItem = orderItemService.getOrderItem(keyBuilder.build().toString());
        /* String value = model.getPrice();*/
        /*if (value != null) {
            BigDecimal price = new BigDecimal(value.replaceAll(",", " "));
            orderItem.setPrice(price);
        }*/
        if (model.getQuantity() != null) {
            orderItem.setQuantity(model.getQuantity());
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dates = model.getDeliveryDate();
        if (dates != null && dates != "") {
            try {
                Date date1 = format.parse(dates);
                orderItem.setDeliveryDate(date1);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            orderItem.setDeliveryDate(new Date());
        }
        SellerItem sItem = new SellerItem();
        sItem.setId(model.getSellerItemId());
        orderItem.setSellerItem(/*rItem*/orderItem.getSellerItem());
        if (model.getUnits() != null) {
            orderItem.setUnits(Float.parseFloat(model.getUnits()));
        }
        orderItem.setOrderItemCode(orderItem.getOrderItemCode());
        // Orders order = new Orders();
        // order.setId(model.getOrderId());
        orderItem.setOrders(orderItem.getOrders());
        if (model.getAvailableTime() != null) {
            orderItem.setAvailableTime(model.getAvailableTime());
        }

        if (model.getDeliveryTime() != null) {
            orderItem.setDeliveryTime(model.getDeliveryTime());
        }
        if (model.getTimingsId() != null) {
            Timings tm = new Timings();
            tm.setId(model.getTimingsId());
            orderItem.setTimings(tm);
            orderItem.setTimingName(model.getTimingName());
        }

        orderItem.setOrderItemStatus(model.getOrderItemStatus());

        orderItem = orderItemService.updateOrderItem(orderItem);

        model.setId(orderItem.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OrderItemModel getByKey(final IKeyBuilder<String> keyBuilder, final OrderItemContext context) {
        OrderItem orderItem = orderItemService.getOrderItem(keyBuilder.build().toString());
        OrderItemModel orderItemModel = conversionService.convert(orderItem, OrderItemModel.class);
        return orderItemModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OrderItemModel> getCollection(final OrderItemContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
