/**
 *
 */
package com.meat.dao;

import com.meat.domain.UsersOffer;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface UsersOfferRepository extends PagingAndSortingRepository<UsersOffer, Serializable> {

}
