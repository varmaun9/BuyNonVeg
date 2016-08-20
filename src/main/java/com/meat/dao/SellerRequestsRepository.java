/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerRequests;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SellerRequestsRepository extends PagingAndSortingRepository<SellerRequests, Serializable> {

}
