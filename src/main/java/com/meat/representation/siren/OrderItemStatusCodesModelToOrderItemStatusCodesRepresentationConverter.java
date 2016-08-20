package com.meat.representation.siren;

import com.meat.model.OrderItemStatusCodesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("orderItemStatusCodesModelToOrderItemStatusCodesRepresentationConverter")
public class OrderItemStatusCodesModelToOrderItemStatusCodesRepresentationConverter extends
        PropertyCopyingConverter<OrderItemStatusCodesModel, OrderItemStatusCodesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItemStatusCodesRepresentation convert(final OrderItemStatusCodesModel source) {

        OrderItemStatusCodesRepresentation target = super.convert(source);

        /* if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsModels())) {
             List<OrderDeliveryOptionsRepresentation> converted = (List<OrderDeliveryOptionsRepresentation>) conversionService.convert(
                     source.getOrderDeliveryOptionsModels(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsModels()),
                     CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsRepresentation.class));
             target.getOrderDeliveryOptionsesRep().addAll(converted);
         }

         if (CollectionUtils.isNotEmpty(source.getRestaurantBranchModels())) {
             List<RestaurantBranchRepresentation> converted = (List<RestaurantBranchRepresentation>) conversionService.convert(
                     source.getRestaurantBranchModels(), TypeDescriptor.forObject(source.getRestaurantBranchModels()),
                     CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RestaurantBranchRepresentation.class));
             target.getRestaurantBranchsRep().addAll(converted);
         }*/

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderItemStatusCodesRepresentation> factory) {
        super.setFactory(factory);
    }

}
