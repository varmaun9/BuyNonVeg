/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderStatusCodes;
import com.meat.model.OrderStatusCodesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("orderStatusCodesModelToOrderStatusCodesConverter")
public class OrderStatusCodesModelToOrderStatusCodesConverter implements Converter<OrderStatusCodesModel, OrderStatusCodes> {
    @Autowired
    private ObjectFactory<OrderStatusCodes> orderStatusCodesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderStatusCodes convert(final OrderStatusCodesModel source) {
        OrderStatusCodes orderStatusCodes = orderStatusCodesFactory.getObject();
        BeanUtils.copyProperties(source, orderStatusCodes);

        return orderStatusCodes;
    }

    @Autowired
    public void setOrderStatusCodesFactory(final ObjectFactory<OrderStatusCodes> orderStatusCodesFactory) {
        this.orderStatusCodesFactory = orderStatusCodesFactory;
    }

}
