/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserSellerItemRating;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface UserSellerItemRatingRepository extends PagingAndSortingRepository<UserSellerItemRating, Serializable> {

}
