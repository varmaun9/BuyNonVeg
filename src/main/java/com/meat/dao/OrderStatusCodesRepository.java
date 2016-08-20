/**
 *
 */
package com.meat.dao;

import com.meat.domain.OrderStatusCodes;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OrderStatusCodesRepository extends PagingAndSortingRepository<OrderStatusCodes, Serializable> {

}
