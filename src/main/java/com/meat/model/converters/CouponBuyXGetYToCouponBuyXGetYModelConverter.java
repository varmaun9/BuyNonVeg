/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CouponBuyXGetY;
import com.meat.model.CouponBuyXGetYModel;

import org.apache.log4j.Logger;
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
@Component("couponBuyXGetYToCouponBuyXGetYModelConverter")
public class CouponBuyXGetYToCouponBuyXGetYModelConverter implements Converter<CouponBuyXGetY, CouponBuyXGetYModel> {

    @Autowired
    private ObjectFactory<CouponBuyXGetYModel> couponBuyXGetYModelFactory;
    private static final Logger LOGGER = Logger.getLogger(CouponBuyXGetYToCouponBuyXGetYModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CouponBuyXGetYModel convert(final CouponBuyXGetY source) {
        // TODO Auto-generated method stub
        CouponBuyXGetYModel couponBuyXGetYModel = couponBuyXGetYModelFactory.getObject();

        BeanUtils.copyProperties(source, couponBuyXGetYModel);

        return couponBuyXGetYModel;

    }

    @Autowired
    public void setCouponBuyXGetYFactory(final ObjectFactory<CouponBuyXGetYModel> couponBuyXGetYModelFactory) {
        this.couponBuyXGetYModelFactory = couponBuyXGetYModelFactory;
    }

}
