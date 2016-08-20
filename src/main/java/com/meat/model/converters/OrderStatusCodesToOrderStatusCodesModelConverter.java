/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderStatusCodes;
import com.meat.model.OrderStatusCodesModel;

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
@Component("orderStatusCodesToOrderStatusCodesModelConverter")
public class OrderStatusCodesToOrderStatusCodesModelConverter implements Converter<OrderStatusCodes, OrderStatusCodesModel> {

    @Autowired
    private ObjectFactory<OrderStatusCodesModel> orderStatusCodesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(OrderStatusCodesToOrderStatusCodesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OrderStatusCodesModel convert(final OrderStatusCodes source) {
        // TODO Auto-generated method stub
        OrderStatusCodesModel orderStatusCodesModel = orderStatusCodesModelFactory.getObject();

        BeanUtils.copyProperties(source, orderStatusCodesModel);

        return orderStatusCodesModel;

    }

    @Autowired
    public void setOrderStatusCodesFactory(final ObjectFactory<OrderStatusCodesModel> orderStatusCodesModelFactory) {
        this.orderStatusCodesModelFactory = orderStatusCodesModelFactory;
    }

}
