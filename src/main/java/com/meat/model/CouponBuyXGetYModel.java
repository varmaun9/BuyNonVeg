package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("couponBuyXGetYModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CouponBuyXGetYModel extends AbstractModel {

    private String couponId;
    private String buyX;
    private String getY;
    private String purchaseItemId;
    private String discountItemId;
    private String status;

    public String getBuyX() {
        return buyX;
    }

    public String getCouponId() {
        return couponId;
    }

    public String getDiscountItemId() {
        return discountItemId;
    }

    public String getGetY() {
        return getY;
    }

    public String getPurchaseItemId() {
        return purchaseItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setBuyX(final String buyX) {
        this.buyX = buyX;
    }

    public void setCouponId(final String couponId) {
        this.couponId = couponId;
    }

    public void setDiscountItemId(final String discountItemId) {
        this.discountItemId = discountItemId;
    }

    public void setGetY(final String getY) {
        this.getY = getY;
    }

    public void setPurchaseItemId(final String purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
