/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Coupon;
import com.meat.domain.CouponBuyXGetY;
import com.meat.model.CouponBuyXGetYModel;
import com.meat.service.ICouponBuyXGetYService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CouponBuyXGetYBusinessDelegate implements
        IBusinessDelegate<CouponBuyXGetYModel, CouponBuyXGetYContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICouponBuyXGetYService couponBuyXGetYService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponBuyXGetYModel create(final CouponBuyXGetYModel model) {
        CouponBuyXGetY couponBuyXGetY = new CouponBuyXGetY();
        couponBuyXGetY.setId(model.getId());
        couponBuyXGetY.setBuyX(Integer.parseInt(model.getBuyX()));
        Coupon coupon = new Coupon();
        coupon.setId(model.getCouponId());
        couponBuyXGetY.setCoupon(coupon);
        couponBuyXGetY.setDiscountItemId(model.getDiscountItemId());
        couponBuyXGetY.setGetY(Integer.parseInt(model.getGetY()));
        couponBuyXGetY.setPurchaseItemId(model.getPurchaseItemId());
        couponBuyXGetY.setStatus(model.getStatus());
        couponBuyXGetY = couponBuyXGetYService.create(couponBuyXGetY);
        model.setId(couponBuyXGetY.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CouponBuyXGetYContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponBuyXGetYModel edit(final IKeyBuilder<String> keyBuilder, final CouponBuyXGetYModel model) {
        CouponBuyXGetY couponBuyXGetY = couponBuyXGetYService.getCouponBuyXGetY(keyBuilder.build().toString());
        couponBuyXGetY.setId(model.getId());
        couponBuyXGetY.setBuyX(Integer.parseInt(model.getBuyX()));
        Coupon coupon = new Coupon();
        coupon.setId(model.getCouponId());
        couponBuyXGetY.setCoupon(coupon);
        couponBuyXGetY.setDiscountItemId(model.getDiscountItemId());
        couponBuyXGetY.setGetY(Integer.parseInt(model.getGetY()));
        couponBuyXGetY.setPurchaseItemId(model.getPurchaseItemId());
        couponBuyXGetY.setStatus(model.getStatus());
        couponBuyXGetY = couponBuyXGetYService.updateCouponBuyXGetY(couponBuyXGetY);
        model.setId(couponBuyXGetY.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CouponBuyXGetYModel getByKey(final IKeyBuilder<String> keyBuilder, final CouponBuyXGetYContext context) {
        CouponBuyXGetY couponBuyXGetY = couponBuyXGetYService.getCouponBuyXGetY(keyBuilder.build().toString());
        CouponBuyXGetYModel couponBuyXGetYModel = conversionService.convert(couponBuyXGetY, CouponBuyXGetYModel.class);
        return couponBuyXGetYModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CouponBuyXGetYModel> getCollection(final CouponBuyXGetYContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
