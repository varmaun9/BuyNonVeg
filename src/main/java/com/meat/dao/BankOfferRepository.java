/**
 *
 */
package com.meat.dao;

import com.meat.domain.BankOffer;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface BankOfferRepository extends PagingAndSortingRepository<BankOffer, Serializable> {

}
