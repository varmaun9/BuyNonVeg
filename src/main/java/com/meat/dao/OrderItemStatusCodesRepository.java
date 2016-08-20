/**
 *
 */
package com.meat.dao;

import com.meat.domain.OrderItemStatusCodes;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OrderItemStatusCodesRepository extends PagingAndSortingRepository<OrderItemStatusCodes, Serializable> {

}
