/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Coupon;
import com.meat.domain.CouponBuyXGetY;
import com.meat.domain.CouponPercentDirect;
import com.meat.model.CouponModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("couponModelToCouponConverter")
public class CouponModelToCouponConverter implements Converter<CouponModel, Coupon> {
    @Autowired
    private ObjectFactory<Coupon> couponFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Coupon convert(final CouponModel source) {
        Coupon coupon = couponFactory.getObject();
        BeanUtils.copyProperties(source, coupon);

        if (CollectionUtils.isNotEmpty(source.getCouponBuyXGetYsModels())) {
            List<CouponBuyXGetY> converted = (List<CouponBuyXGetY>) conversionService.convert(source.getCouponBuyXGetYsModels(),
                    TypeDescriptor.forObject(source.getCouponBuyXGetYsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponBuyXGetY.class));
            coupon.getCouponBuyXGetYs().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCouponPercentDirectsModels())) {
            List<CouponPercentDirect> converted = (List<CouponPercentDirect>) conversionService.convert(
                    source.getCouponPercentDirectsModels(), TypeDescriptor.forObject(source.getCouponPercentDirectsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponPercentDirect.class));
            coupon.getCouponPercentDirects().addAll(converted);
        }
        return coupon;
    }

    @Autowired
    public void setCouponFactory(final ObjectFactory<Coupon> couponFactory) {
        this.couponFactory = couponFactory;
    }

}
