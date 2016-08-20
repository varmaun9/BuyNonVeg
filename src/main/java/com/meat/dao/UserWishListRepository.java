/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserWishList;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface UserWishListRepository extends PagingAndSortingRepository<UserWishList, Serializable> {

}
