/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderDeliveryOptions;
import com.meat.model.OrderDeliveryOptionsModel;

import org.apache.log4j.Logger;
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

@Component("orderDeliveryOptionsToOrderDeliveryOptionsModelConverter")
public class OrderDeliveryOptionsToOrderDeliveryOptionsModelConverter implements Converter<OrderDeliveryOptions, OrderDeliveryOptionsModel> {

    @Autowired
    private ObjectFactory<OrderDeliveryOptionsModel> orderDeliveryOptionsModelFactory;
    private static final Logger LOGGER = Logger.getLogger(OrderDeliveryOptionsToOrderDeliveryOptionsModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OrderDeliveryOptionsModel convert(final OrderDeliveryOptions source) {
        // TODO Auto-generated method stub
        OrderDeliveryOptionsModel orderDeliveryOptionsModel = orderDeliveryOptionsModelFactory.getObject();

        BeanUtils.copyProperties(source, orderDeliveryOptionsModel);

        return orderDeliveryOptionsModel;

    }

    @Autowired
    public void setOrderDeliveryOptionsFactory(final ObjectFactory<OrderDeliveryOptionsModel> orderDeliveryOptionsModelFactory) {
        this.orderDeliveryOptionsModelFactory = orderDeliveryOptionsModelFactory;
    }

}
