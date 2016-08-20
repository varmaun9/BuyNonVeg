/**
 *
 */
package com.meat.dao;

import com.meat.domain.CategoryCutType;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface CategoryCutTypeRepository extends PagingAndSortingRepository<CategoryCutType, Serializable> {

}
