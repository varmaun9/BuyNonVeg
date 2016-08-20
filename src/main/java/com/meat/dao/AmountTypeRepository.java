/**
 *
 */
package com.meat.dao;

import com.meat.domain.AmountType;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Dilli
 *
 */

public interface AmountTypeRepository extends PagingAndSortingRepository<AmountType, Serializable> {

}
