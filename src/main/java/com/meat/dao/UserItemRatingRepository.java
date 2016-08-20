/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserItemRating;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface UserItemRatingRepository extends PagingAndSortingRepository<UserItemRating, Serializable> {

}
