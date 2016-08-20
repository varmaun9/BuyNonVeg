/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Coupon;
import com.meat.model.CouponBuyXGetYModel;
import com.meat.model.CouponModel;
import com.meat.model.CouponPercentDirectModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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
@Component("couponToCouponModelConverter")
public class CouponToCouponModelConverter implements Converter<Coupon, CouponModel> {

    @Autowired
    private ObjectFactory<CouponModel> couponModelFactory;
    private static final Logger LOGGER = Logger.getLogger(CouponToCouponModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CouponModel convert(final Coupon source) {
        // TODO Auto-generated method stub
        CouponModel couponModel = couponModelFactory.getObject();

        BeanUtils.copyProperties(source, couponModel);

        if (CollectionUtils.isNotEmpty(source.getCouponBuyXGetYs())) {
            List<CouponBuyXGetYModel> converted = (List<CouponBuyXGetYModel>) conversionService.convert(source.getCouponBuyXGetYs(),
                    TypeDescriptor.forObject(source.getCouponBuyXGetYs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponBuyXGetYModel.class));
            couponModel.getCouponBuyXGetYsModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCouponPercentDirects())) {
            List<CouponPercentDirectModel> converted = (List<CouponPercentDirectModel>) conversionService.convert(
                    source.getCouponPercentDirects(), TypeDescriptor.forObject(source.getCouponPercentDirects()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponPercentDirectModel.class));
            couponModel.getCouponPercentDirectsModels().addAll(converted);
        }
        return couponModel;

    }

    @Autowired
    public void setCouponFactory(final ObjectFactory<CouponModel> couponModelFactory) {
        this.couponModelFactory = couponModelFactory;
    }

}
