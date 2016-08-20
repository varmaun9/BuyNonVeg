/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OrderStatusCodesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("orderStatusCodesRepresentationToOrderStatusCodesModelConverter")
public class OrderStatusCodesRepresentationToOrderStatusCodesModelConverter extends
PropertyCopyingConverter<OrderStatusCodesRepresentation, OrderStatusCodesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderStatusCodesModel convert(final OrderStatusCodesRepresentation source) {

        OrderStatusCodesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OrderStatusCodesModel> factory) {
        super.setFactory(factory);
    }

}
