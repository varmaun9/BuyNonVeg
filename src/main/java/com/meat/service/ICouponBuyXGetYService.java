/**
 *
 */
package com.meat.service;

import com.meat.domain.CouponBuyXGetY;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICouponBuyXGetYService {
    CouponBuyXGetY create(CouponBuyXGetY couponBuyXGetY);

    void deleteCouponBuyXGetY(String couponBuyXGetYId);

    List<CouponBuyXGetY> getAll();

    CouponBuyXGetY getCouponBuyXGetY(String couponBuyXGetYId);

    CouponBuyXGetY updateCouponBuyXGetY(CouponBuyXGetY couponBuyXGetY);
}
