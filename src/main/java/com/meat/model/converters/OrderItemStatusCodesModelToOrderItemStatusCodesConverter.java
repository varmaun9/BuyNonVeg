/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderItemStatusCodes;
import com.meat.model.OrderItemStatusCodesModel;

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
@Component("orderItemStatusCodesModelToOrderItemStatusCodesConverter")
public class OrderItemStatusCodesModelToOrderItemStatusCodesConverter implements Converter<OrderItemStatusCodesModel, OrderItemStatusCodes> {
    @Autowired
    private ObjectFactory<OrderItemStatusCodes> orderItemStatusCodesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderItemStatusCodes convert(final OrderItemStatusCodesModel source) {
        OrderItemStatusCodes orderItemStatusCodes = orderItemStatusCodesFactory.getObject();
        BeanUtils.copyProperties(source, orderItemStatusCodes);

        return orderItemStatusCodes;
    }

    @Autowired
    public void setOrderItemStatusCodesFactory(final ObjectFactory<OrderItemStatusCodes> orderItemStatusCodesFactory) {
        this.orderItemStatusCodesFactory = orderItemStatusCodesFactory;
    }

}
