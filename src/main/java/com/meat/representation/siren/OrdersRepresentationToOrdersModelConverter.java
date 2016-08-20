/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("ordersRepresentationToOrdersModelConverter")
public class OrdersRepresentationToOrdersModelConverter extends PropertyCopyingConverter<OrdersRepresentation, OrdersModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrdersModel convert(final OrdersRepresentation source) {

        OrdersModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsRep())) {
            List<OrderDeliveryOptionsModel> converted = (List<OrderDeliveryOptionsModel>) conversionService.convert(
                    source.getOrderDeliveryOptionsRep(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsModel.class));
            target.getOrderDeliveryOptionsesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemRep())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItemRep(),
                    TypeDescriptor.forObject(source.getOrderItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            target.getOrderItemsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentRep())) {
            List<ShipmentModel> converted = (List<ShipmentModel>) conversionService.convert(source.getShipmentRep(),
                    TypeDescriptor.forObject(source.getShipmentRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentModel.class));
            target.getShipmentsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderStatusCodesRep())) {
            List<OrderStatusCodesModel> converted = (List<OrderStatusCodesModel>) conversionService.convert(source.getOrderStatusCodesRep(),
                    TypeDescriptor.forObject(source.getOrderStatusCodesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderStatusCodesModel.class));
            target.getOrderStatusCodesesModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrdersModel> factory) {
        super.setFactory(factory);
    }

}
