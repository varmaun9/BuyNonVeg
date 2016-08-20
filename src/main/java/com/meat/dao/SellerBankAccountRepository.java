/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBankAccount;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SellerBankAccountRepository extends PagingAndSortingRepository<SellerBankAccount, Serializable> {

}
