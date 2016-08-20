/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserSearch;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface UserSearchRepository extends PagingAndSortingRepository<UserSearch, Serializable> {

}
