/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.OrdersModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("ordersModelToOrdersConverter")
public class OrdersModelToOrdersConverter implements Converter<OrdersModel, Orders> {
    @Autowired
    private ObjectFactory<Orders> ordersFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Orders convert(final OrdersModel source) {
        Orders orders = ordersFactory.getObject();
        BeanUtils.copyProperties(source, orders);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsesModels())) {
            List<OrderDeliveryOptions> converted = (List<OrderDeliveryOptions>) conversionService.convert(
                    source.getOrderDeliveryOptionsesModels(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptions.class));
            orders.getOrderDeliveryOptionses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderItemsModels())) {
            List<OrderItem> converted = (List<OrderItem>) conversionService.convert(source.getOrderItemsModels(),
                    TypeDescriptor.forObject(source.getOrderItemsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItem.class));
            orders.getOrderItems().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderStatusCodesesModels())) {
            List<OrderStatusCodes> converted = (List<OrderStatusCodes>) conversionService.convert(source.getOrderStatusCodesesModels(),
                    TypeDescriptor.forObject(source.getOrderStatusCodesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderStatusCodes.class));
            orders.getOrderStatusCodeses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentsModels())) {
            List<Shipment> converted = (List<Shipment>) conversionService.convert(source.getShipmentsModels(),
                    TypeDescriptor.forObject(source.getShipmentsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Shipment.class));
            orders.getShipments().addAll(converted);
        }
        return orders;
    }

    @Autowired
    public void setOrdersFactory(final ObjectFactory<Orders> ordersFactory) {
        this.ordersFactory = ordersFactory;
    }

}
