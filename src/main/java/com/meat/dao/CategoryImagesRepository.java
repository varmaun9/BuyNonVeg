/**
 *
 */
package com.meat.dao;

import com.meat.domain.CategoryImages;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface CategoryImagesRepository extends PagingAndSortingRepository<CategoryImages, Serializable> {

}
