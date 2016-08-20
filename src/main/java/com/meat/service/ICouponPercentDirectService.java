/**
 *
 */
package com.meat.service;

import com.meat.domain.CouponPercentDirect;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICouponPercentDirectService {
	
    CouponPercentDirect create(CouponPercentDirect couponPercentDirect);

    void deleteCouponPercentDirect(String couponPercentDirectId);

    List<CouponPercentDirect> getAll();

    CouponPercentDirect getCouponPercentDirect(String couponPercentDirectId);

    CouponPercentDirect updateCouponPercentDirect(CouponPercentDirect couponPercentDirect);
}
