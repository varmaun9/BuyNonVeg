/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerItemCriteria;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerItemCriteriaRepository extends PagingAndSortingRepository<SellerItemCriteria, Serializable> {

}
