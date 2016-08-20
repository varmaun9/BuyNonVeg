/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderItemStatusCodes;
import com.meat.model.OrderItemStatusCodesModel;

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
@Component("orderItemStatusCodesToOrderItemStatusCodesModelConverter")
public class OrderItemStatusCodesToOrderItemStatusCodesModelConverter implements Converter<OrderItemStatusCodes, OrderItemStatusCodesModel> {

    @Autowired
    private ObjectFactory<OrderItemStatusCodesModel> orderItemStatusCodesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(OrderItemStatusCodesToOrderItemStatusCodesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OrderItemStatusCodesModel convert(final OrderItemStatusCodes source) {
        // TODO Auto-generated method stub
        OrderItemStatusCodesModel orderItemStatusCodesModel = orderItemStatusCodesModelFactory.getObject();

        BeanUtils.copyProperties(source, orderItemStatusCodesModel);

        return orderItemStatusCodesModel;

    }

    @Autowired
    public void setOrderItemStatusCodesFactory(final ObjectFactory<OrderItemStatusCodesModel> orderItemStatusCodesModelFactory) {
        this.orderItemStatusCodesModelFactory = orderItemStatusCodesModelFactory;
    }
}
