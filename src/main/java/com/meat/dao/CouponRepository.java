/**
 *
 */
package com.meat.dao;

import com.meat.domain.Coupon;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi1
 *
 */
public interface CouponRepository extends PagingAndSortingRepository<Coupon, Serializable> {

}
