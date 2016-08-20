/**
 *
 */
package com.meat.dao;

import com.meat.domain.CategoryAttributes;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface CategoryAttributesRepository extends PagingAndSortingRepository<CategoryAttributes, Serializable> {

}
