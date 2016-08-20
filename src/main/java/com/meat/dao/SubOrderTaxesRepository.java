/**
 *
 */
package com.meat.dao;

import com.meat.domain.SubOrderTaxes;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SubOrderTaxesRepository extends PagingAndSortingRepository<SubOrderTaxes, Serializable> {

}
