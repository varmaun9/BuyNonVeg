package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("couponPercentDirectModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CouponPercentDirectModel extends AbstractModel {

    private String couponId;
    private String discountPercent;
    private String discountAmount;

    public String getCouponId() {
        return couponId;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public void setCouponId(final String couponId) {
        this.couponId = couponId;
    }

    public void setDiscountAmount(final String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscountPercent(final String discountPercent) {
        this.discountPercent = discountPercent;
    }

}
