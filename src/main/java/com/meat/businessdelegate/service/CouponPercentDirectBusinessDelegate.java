/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Coupon;
import com.meat.domain.CouponPercentDirect;
import com.meat.model.CouponPercentDirectModel;
import com.meat.service.ICouponPercentDirectService;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CouponPercentDirectBusinessDelegate implements
IBusinessDelegate<CouponPercentDirectModel, CouponPercentDirectContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICouponPercentDirectService couponPercentDirectService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponPercentDirectModel create(final CouponPercentDirectModel model) {
        CouponPercentDirect couponPercentDirect = new CouponPercentDirect();
        couponPercentDirect.setId(model.getId());
        String value = model.getDiscountAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            couponPercentDirect.setDiscountAmount(b);
        }
        couponPercentDirect.setDiscountPercent(Integer.parseInt(model.getDiscountPercent()));
        Coupon coupon = new Coupon();
        coupon.setId(model.getCouponId());
        couponPercentDirect.setCoupon(coupon);
        couponPercentDirect = couponPercentDirectService.create(couponPercentDirect);
        model.setId(couponPercentDirect.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CouponPercentDirectContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponPercentDirectModel edit(final IKeyBuilder<String> keyBuilder, final CouponPercentDirectModel model) {
        CouponPercentDirect couponPercentDirect = couponPercentDirectService.getCouponPercentDirect(keyBuilder.build().toString());
        couponPercentDirect.setId(model.getId());
        String value = model.getDiscountAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            couponPercentDirect.setDiscountAmount(b);
        }
        couponPercentDirect.setDiscountPercent(Integer.parseInt(model.getDiscountPercent()));
        Coupon coupon = new Coupon();
        coupon.setId(model.getCouponId());
        couponPercentDirect.setCoupon(coupon);
        couponPercentDirect = couponPercentDirectService.create(couponPercentDirect);
        model.setId(couponPercentDirect.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CouponPercentDirectModel getByKey(final IKeyBuilder<String> keyBuilder, final CouponPercentDirectContext context) {
        CouponPercentDirect couponPercentDirect = couponPercentDirectService.getCouponPercentDirect(keyBuilder.build().toString());
        CouponPercentDirectModel couponPercentDirectModel = conversionService.convert(couponPercentDirect, CouponPercentDirectModel.class);
        return couponPercentDirectModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CouponPercentDirectModel> getCollection(final CouponPercentDirectContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
