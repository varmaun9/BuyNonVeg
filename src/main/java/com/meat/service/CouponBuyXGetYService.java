/**
 *
 */
package com.meat.service;

import com.meat.dao.CouponBuyXGetYRepository;
import com.meat.domain.CouponBuyXGetY;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component
public class CouponBuyXGetYService implements ICouponBuyXGetYService {
    @Autowired
    private CouponBuyXGetYRepository couponBuyXGetYRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponBuyXGetYService#create(com.meat.domain.CouponBuyXGetY)
     */
    @Override
    public CouponBuyXGetY create(final CouponBuyXGetY couponBuyXGetY) {
        // TODO Auto-generated method stub
        return couponBuyXGetYRepository.save(couponBuyXGetY);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponBuyXGetYService#deleteCouponBuyXGetY(java.lang.String)
     */
    @Override
    public void deleteCouponBuyXGetY(final String couponBuyXGetYId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponBuyXGetYService#getAll()
     */
    @Override
    public List<CouponBuyXGetY> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponBuyXGetYService#getCouponBuyXGetY(java.lang.String)
     */
    @Override
    public CouponBuyXGetY getCouponBuyXGetY(final String couponBuyXGetYId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponBuyXGetYService#updateCouponBuyXGetY(com.meat.domain.CouponBuyXGetY)
     */
    @Override
    public CouponBuyXGetY updateCouponBuyXGetY(final CouponBuyXGetY couponBuyXGetY) {
        // TODO Auto-generated method stub
        return couponBuyXGetYRepository.save(couponBuyXGetY);
    }

}
