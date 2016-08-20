/**
 *
 */
package com.meat.dao;

import com.meat.domain.CategoryTags;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface CategoryTagsRepository extends PagingAndSortingRepository<CategoryTags, Serializable> {

}
