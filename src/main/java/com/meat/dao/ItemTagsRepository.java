/**
 *
 */
package com.meat.dao;

import com.meat.domain.ItemTags;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface ItemTagsRepository extends PagingAndSortingRepository<ItemTags, Serializable> {

}
