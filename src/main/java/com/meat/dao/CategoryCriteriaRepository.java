/**
 *
 */
package com.meat.dao;

import com.meat.domain.CategoryCriteria;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi1
 *
 */
public interface CategoryCriteriaRepository extends PagingAndSortingRepository<CategoryCriteria, Serializable> {

}
