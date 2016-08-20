/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CouponBuyXGetY;
import com.meat.model.CouponBuyXGetYModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("couponBuyXGetYModelToCouponBuyXGetYConverter")
public class CouponBuyXGetYModelToCouponBuyXGetYConverter implements Converter<CouponBuyXGetYModel, CouponBuyXGetY> {
    @Autowired
    private ObjectFactory<CouponBuyXGetY> couponBuyXGetYFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponBuyXGetY convert(final CouponBuyXGetYModel source) {
        CouponBuyXGetY couponBuyXGetY = couponBuyXGetYFactory.getObject();
        BeanUtils.copyProperties(source, couponBuyXGetY);

        return couponBuyXGetY;
    }

    @Autowired
    public void setCouponBuyXGetYFactory(final ObjectFactory<CouponBuyXGetY> couponBuyXGetYFactory) {
        this.couponBuyXGetYFactory = couponBuyXGetYFactory;
    }

}
