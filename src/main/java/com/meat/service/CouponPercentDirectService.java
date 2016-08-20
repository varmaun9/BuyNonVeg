/**
 *
 */
package com.meat.service;

import com.meat.dao.CouponPercentDirectRepository;
import com.meat.domain.CouponPercentDirect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class CouponPercentDirectService implements ICouponPercentDirectService {
    @Autowired
    private CouponPercentDirectRepository couponPercentDirectRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponPercentDirectService#create(com.meat.domain.CouponPercentDirect)
     */
    @Override
    public CouponPercentDirect create(final CouponPercentDirect couponPercentDirect) {
        // TODO Auto-generated method stub
        return couponPercentDirectRepository.save(couponPercentDirect);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponPercentDirectService#deleteCouponPercentDirect(java.lang.String)
     */
    @Override
    public void deleteCouponPercentDirect(final String couponPercentDirectId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponPercentDirectService#getAll()
     */
    @Override
    public List<CouponPercentDirect> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponPercentDirectService#getCouponPercentDirect(java.lang.String)
     */
    @Override
    public CouponPercentDirect getCouponPercentDirect(final String couponPercentDirectId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICouponPercentDirectService#updateCouponPercentDirect(com.meat.domain.CouponPercentDirect)
     */
    @Override
    public CouponPercentDirect updateCouponPercentDirect(final CouponPercentDirect couponPercentDirect) {
        // TODO Auto-generated method stub
        return couponPercentDirectRepository.save(couponPercentDirect);
    }

}
