/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerItemTax;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface SellerItemTaxRepository extends PagingAndSortingRepository<SellerItemTax, Serializable> {

}
