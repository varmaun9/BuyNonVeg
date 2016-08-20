package com.meat.representation.siren;

import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("orderDeliveryOptionsModelToOrderDeliveryOptionsRepresentationConverter")
public class OrderDeliveryOptionsModelToOrderDeliveryOptionsRepresentationConverter extends
        PropertyCopyingConverter<OrderDeliveryOptionsModel, OrderDeliveryOptionsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderDeliveryOptionsRepresentation convert(final OrderDeliveryOptionsModel source) {

        OrderDeliveryOptionsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderDeliveryOptionsRepresentation> factory) {
        super.setFactory(factory);
    }

}
