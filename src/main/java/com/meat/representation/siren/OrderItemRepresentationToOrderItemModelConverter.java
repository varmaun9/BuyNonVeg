/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OrderItemModel;
import com.meat.model.OrderItemStatusCodesModel;
import com.meat.model.ShipmentItemsModel;
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
@Component("orderItemRepresentationToOrderItemModelConverter")
public class OrderItemRepresentationToOrderItemModelConverter extends PropertyCopyingConverter<OrderItemRepresentation, OrderItemModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItemModel convert(final OrderItemRepresentation source) {

        OrderItemModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getOrderItemStatusCodesesRep())) {
            List<OrderItemStatusCodesModel> converted = (List<OrderItemStatusCodesModel>) conversionService.convert(
                    source.getOrderItemStatusCodesesRep(), TypeDescriptor.forObject(source.getOrderItemStatusCodesesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemStatusCodesModel.class));
            target.getOrderItemStatusCodesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentItemsesRep())) {
            List<ShipmentItemsModel> converted = (List<ShipmentItemsModel>) conversionService.convert(source.getShipmentItemsesRep(),
                    TypeDescriptor.forObject(source.getShipmentItemsesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItemsModel.class));
            target.getShipmentItemsesModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderItemModel> factory) {
        super.setFactory(factory);
    }

}
