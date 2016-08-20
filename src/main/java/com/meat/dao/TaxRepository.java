/**
 *
 */
package com.meat.dao;

import com.meat.domain.Tax;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface TaxRepository extends PagingAndSortingRepository<Tax, Serializable> {

}
