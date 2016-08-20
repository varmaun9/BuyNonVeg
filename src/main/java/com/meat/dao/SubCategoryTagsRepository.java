/**
 *
 */
package com.meat.dao;

import com.meat.domain.SubCategoryTags;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface SubCategoryTagsRepository extends PagingAndSortingRepository<SubCategoryTags, Serializable> {

}
