/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.AmountType;
import com.meat.domain.Coupon;
import com.meat.model.CouponModel;
import com.meat.service.ICouponService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CouponBusinessDelegate implements IBusinessDelegate<CouponModel, CouponContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICouponService couponService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponModel create(final CouponModel model) {
        Coupon coupon = new Coupon();
        coupon.setId(model.getId());

        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());
        coupon.setAmountType(amountType);

        coupon.setCouponName(model.getCouponName());
        coupon.setDescription(model.getDescription());
        coupon.setStatus(model.getStatus());
        coupon.setCouponCode(model.getCouponCode());
        coupon.setPlacedByStatus(model.getPlacedByStatus());
        coupon.setCouponFromDate(new Date());
        coupon.setCouponToDate(new Date());
        coupon.setQuantity(Integer.parseInt(model.getQuantity()));

        String value = model.getInvoiceAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            coupon.setInvoiceAmount(b);
        }

        coupon.setBillType(model.getBillType());
        coupon.setCouponType(model.getCouponType());
        coupon.setCouponCount(Long.parseLong(model.getCouponCount()));
        coupon.setCreatedDate(new Date());
        coupon.setAmountTypeValue(Integer.parseInt(model.getAmountTypeValue()));
        coupon = couponService.create(coupon);

        model.setId(coupon.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CouponContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CouponModel edit(final IKeyBuilder<String> keyBuilder, final CouponModel model) {
        Coupon coupon = couponService.getCoupon(keyBuilder.build().toString());
        coupon.setId(model.getId());
        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());
        coupon.setAmountType(amountType);
        coupon.setCouponName(model.getCouponName());
        coupon.setDescription(model.getDescription());
        coupon.setStatus(model.getStatus());
        coupon.setCouponCode(model.getCouponCode());
        coupon.setPlacedByStatus(model.getPlacedByStatus());
        coupon.setCouponFromDate(new Date());
        coupon.setCouponToDate(new Date());
        coupon.setQuantity(Integer.parseInt(model.getQuantity()));

        String value = model.getInvoiceAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            coupon.setInvoiceAmount(b);
        }
        coupon.setBillType(model.getBillType());
        coupon.setCouponType(model.getCouponType());
        coupon.setCouponCount(Long.parseLong(model.getCouponCount()));
        coupon.setAmountTypeValue(Integer.parseInt(model.getAmountTypeValue()));
        coupon = couponService.updateCoupon(coupon);
        model.setId(coupon.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CouponModel getByKey(final IKeyBuilder<String> keyBuilder, final CouponContext context) {
        Coupon coupon = couponService.getCoupon(keyBuilder.build().toString());
        CouponModel couponModel = conversionService.convert(coupon, CouponModel.class);
        return couponModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CouponModel> getCollection(final CouponContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
