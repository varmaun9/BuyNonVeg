package com.meat.representation.siren;

import com.meat.model.OrdersModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("OrdersModelToOrdersRepresentationConverter")
public class OrdersModelToOrdersRepresentationConverter extends PropertyCopyingConverter<OrdersModel, OrdersRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrdersRepresentation convert(final OrdersModel source) {

        OrdersRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsesModels())) {
            List<OrderDeliveryOptionsRepresentation> converted = (List<OrderDeliveryOptionsRepresentation>) conversionService.convert(
                    source.getOrderDeliveryOptionsesModels(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsRepresentation.class));
            target.getOrderDeliveryOptionsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderItemsModels())) {
            List<OrderItemRepresentation> converted = (List<OrderItemRepresentation>) conversionService.convert(
                    source.getOrderItemsModels(), TypeDescriptor.forObject(source.getOrderItemsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemRepresentation.class));
            target.getOrderItemRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderStatusCodesesModels())) {
            List<OrderStatusCodesRepresentation> converted = (List<OrderStatusCodesRepresentation>) conversionService.convert(
                    source.getOrderStatusCodesesModels(), TypeDescriptor.forObject(source.getOrderStatusCodesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderStatusCodesRepresentation.class));
            target.getOrderStatusCodesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentsModels())) {
            List<ShipmentRepresentation> converted = (List<ShipmentRepresentation>) conversionService.convert(source.getShipmentsModels(),
                    TypeDescriptor.forObject(source.getShipmentsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentRepresentation.class));
            target.getShipmentRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrdersRepresentation> factory) {
        super.setFactory(factory);
    }

}
