/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CouponPercentDirectModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("couponPercentDirectRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "couponPercentDirect", uri = "/couponPercentDirects/{id}")
@Representation(CouponPercentDirectModel.class)
public class CouponPercentDirectRepresentation extends BaseResource {
    private String id;
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

    public String getId() {
        return id;
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

    public void setId(final String id) {
        this.id = id;
    }

}
