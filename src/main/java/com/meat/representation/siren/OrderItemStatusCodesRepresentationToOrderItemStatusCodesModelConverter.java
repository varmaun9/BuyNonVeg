/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OrderItemStatusCodesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("orderItemStatusCodesRepresentationToOrderItemStatusCodesModelConverter")
public class OrderItemStatusCodesRepresentationToOrderItemStatusCodesModelConverter extends
PropertyCopyingConverter<OrderItemStatusCodesRepresentation, OrderItemStatusCodesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItemStatusCodesModel convert(final OrderItemStatusCodesRepresentation source) {

        OrderItemStatusCodesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderItemStatusCodesModel> factory) {
        super.setFactory(factory);
    }

}
