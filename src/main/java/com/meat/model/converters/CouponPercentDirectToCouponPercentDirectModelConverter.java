/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CouponPercentDirect;
import com.meat.model.CouponPercentDirectModel;

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
@Component("couponPercentDirectToCouponPercentDirectModelConvertor")
public class CouponPercentDirectToCouponPercentDirectModelConverter implements Converter<CouponPercentDirect, CouponPercentDirectModel> {

    @Autowired
    private ObjectFactory<CouponPercentDirectModel> couponPercentDirectModelFactory;
    private static final Logger LOGGER = Logger.getLogger(CouponPercentDirectToCouponPercentDirectModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CouponPercentDirectModel convert(final CouponPercentDirect source) {
        // TODO Auto-generated method stub
        CouponPercentDirectModel couponPercentDirectModel = couponPercentDirectModelFactory.getObject();

        BeanUtils.copyProperties(source, couponPercentDirectModel);

        return couponPercentDirectModel;

    }

    @Autowired
    public void setCouponPercentDirectFactory(final ObjectFactory<CouponPercentDirectModel> couponPercentDirectModelFactory) {
        this.couponPercentDirectModelFactory = couponPercentDirectModelFactory;
    }
}
