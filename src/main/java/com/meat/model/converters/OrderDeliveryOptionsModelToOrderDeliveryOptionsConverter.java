/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderDeliveryOptions;
import com.meat.model.OrderDeliveryOptionsModel;

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
@Component("orderDeliveryOptionsModelToOrderDeliveryOptionsConverter")
public class OrderDeliveryOptionsModelToOrderDeliveryOptionsConverter implements Converter<OrderDeliveryOptionsModel, OrderDeliveryOptions> {
    @Autowired
    private ObjectFactory<OrderDeliveryOptions> orderDeliveryOptionsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OrderDeliveryOptions convert(final OrderDeliveryOptionsModel source) {
        OrderDeliveryOptions orderDeliveryOptions = orderDeliveryOptionsFactory.getObject();
        BeanUtils.copyProperties(source, orderDeliveryOptions);

        return orderDeliveryOptions;
    }

    @Autowired
    public void setOrderDeliveryOptionsFactory(final ObjectFactory<OrderDeliveryOptions> orderDeliveryOptionsFactory) {
        this.orderDeliveryOptionsFactory = orderDeliveryOptionsFactory;
    }

}
