/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CouponPercentDirect;
import com.meat.model.CouponPercentDirectModel;

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
@Component("couponPercentDirectModelToCouponPercentDirectConverter")
public class CouponPercentDirectModelToCouponPercentDirectConverter implements Converter<CouponPercentDirectModel, CouponPercentDirect> {
    @Autowired
    private ObjectFactory<CouponPercentDirect> couponPercentDirectFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponPercentDirect convert(final CouponPercentDirectModel source) {
        CouponPercentDirect couponPercentDirect = couponPercentDirectFactory.getObject();
        BeanUtils.copyProperties(source, couponPercentDirect);

        return couponPercentDirect;
    }

    @Autowired
    public void setCouponPercentDirectFactory(final ObjectFactory<CouponPercentDirect> couponPercentDirectFactory) {
        this.couponPercentDirectFactory = couponPercentDirectFactory;
    }

}
