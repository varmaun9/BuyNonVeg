package com.meat.representation.siren;

import com.meat.model.OrderItemModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("orderItemModelToOrderItemRepresentationConverter")
public class OrderItemModelToOrderItemRepresentationConverter extends PropertyCopyingConverter<OrderItemModel, OrderItemRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItemRepresentation convert(final OrderItemModel source) {

        OrderItemRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getOrderItemStatusCodesesModels())) {
            List<OrderItemStatusCodesRepresentation> converted = (List<OrderItemStatusCodesRepresentation>) conversionService.convert(
                    source.getOrderItemStatusCodesesModels(), TypeDescriptor.forObject(source.getOrderItemStatusCodesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemStatusCodesRepresentation.class));
            target.getOrderItemStatusCodesesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentItemsesModels())) {
            List<ShipmentItemsRepresentation> converted = (List<ShipmentItemsRepresentation>) conversionService.convert(
                    source.getShipmentItemsesModels(), TypeDescriptor.forObject(source.getShipmentItemsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItemsRepresentation.class));
            target.getShipmentItemsesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderItemRepresentation> factory) {
        super.setFactory(factory);
    }

}
