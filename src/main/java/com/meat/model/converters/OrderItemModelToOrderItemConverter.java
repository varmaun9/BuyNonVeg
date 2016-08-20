/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderItem;
import com.meat.domain.OrderItemStatusCodes;
import com.meat.domain.ShipmentItems;
import com.meat.model.OrderItemModel;
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

@Component("orderItemModelToOrderItemConverter")
public class OrderItemModelToOrderItemConverter implements Converter<OrderItemModel, OrderItem> {
    @Autowired
    private ObjectFactory<OrderItem> orderItemFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItem convert(final OrderItemModel source) {
        OrderItem orderItem = orderItemFactory.getObject();
        BeanUtils.copyProperties(source, orderItem);

        if (CollectionUtils.isNotEmpty(source.getOrderItemStatusCodesesModels())) {
            List<OrderItemStatusCodes> converted = (List<OrderItemStatusCodes>) conversionService.convert(
                    source.getOrderItemStatusCodesesModels(), TypeDescriptor.forObject(source.getOrderItemStatusCodesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemStatusCodes.class));
            orderItem.getOrderItemStatusCodeses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentItemsesModels())) {
            List<ShipmentItems> converted = (List<ShipmentItems>) conversionService.convert(source.getShipmentItemsesModels(),
                    TypeDescriptor.forObject(source.getShipmentItemsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItems.class));
            orderItem.getShipmentItemses().addAll(converted);
        }
        return orderItem;
    }

    @Autowired
    public void setOrderItemFactory(final ObjectFactory<OrderItem> orderItemFactory) {
        this.orderItemFactory = orderItemFactory;
    }

}
