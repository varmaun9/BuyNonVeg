/**
 *
 */
package com.meat.dao;

import com.meat.domain.OrderDeliveryOptions;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OrderDeliveryOptionsRepository extends PagingAndSortingRepository<OrderDeliveryOptions, Serializable> {

}
