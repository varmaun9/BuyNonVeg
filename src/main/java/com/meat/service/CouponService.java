/**
 *
 */
package com.meat.service;


import com.meat.dao.CouponRepository;
import com.meat.domain.Coupon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component
public class CouponService implements ICouponService {
    @Autowired
    private CouponRepository CouponRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponService#create(com.meat.domain.Coupon)
     */
    @Override
    public Coupon create(Coupon coupon) {
        // TODO Auto-generated method stub
        return CouponRepository.save(coupon);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponService#deleteCoupon(java.lang.String)
     */
    @Override
    public void deleteCoupon(String couponId) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponService#getAll()
     */
    @Override
    public List<Coupon> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponService#getCoupon(java.lang.String)
     */
    @Override
    public Coupon getCoupon(String couponId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponService#updateCoupon(com.meat.domain.Coupon)
     */
    @Override
    public Coupon updateCoupon(Coupon coupon) {
        // TODO Auto-generated method stub
        return CouponRepository.save(coupon);
    }

 

}
