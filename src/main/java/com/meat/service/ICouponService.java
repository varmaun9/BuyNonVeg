/**
 *
 */
package com.meat.service;

import com.meat.domain.Coupon;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICouponService {

    Coupon create(Coupon coupon);

    void deleteCoupon(String couponId);

    List<Coupon> getAll();

    Coupon getCoupon(String couponId);

    Coupon updateCoupon(Coupon coupon);

}
