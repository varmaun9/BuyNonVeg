/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("orderDeliveryOptionsRepresentationToOrderDeliveryOptionsModelConverter")
public class OrderDeliveryOptionsRepresentationToOrderDeliveryOptionsModelConverter extends
PropertyCopyingConverter<OrderDeliveryOptionsRepresentation, OrderDeliveryOptionsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderDeliveryOptionsModel convert(final OrderDeliveryOptionsRepresentation source) {

        OrderDeliveryOptionsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderDeliveryOptionsModel> factory) {
        super.setFactory(factory);
    }

}
