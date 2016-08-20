/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserAddress;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface UserAddressRepository extends PagingAndSortingRepository<UserAddress, Serializable> {

}
