/**
 *
 */
package com.meat.dao;

import com.meat.domain.Account;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Serializable> {

    /**
     * @param id
     * @return
     */
    @Query("SELECT a FROM Account a JOIN a.sellerBranch sb WHERE sb.id =?1")
    Account findAccountByBranch(String id);

    /**
     * @param entityType
     * @return
     */
    @Query("SELECT a FROM Account a WHERE a.entityType = ?1")
    Account findAccountByEntityType(String entityType);

}
