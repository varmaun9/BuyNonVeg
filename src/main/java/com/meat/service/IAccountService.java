/**
 *
 */
package com.meat.service;

import com.meat.domain.Account;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IAccountService {

    Account create(Account account);

    void deleteAccount(String accountId);

    Account getAccount(String accountId);

    /**
     * @param id
     * @return
     */

    Account getAccountByBranch(String id);

    /**
     * @param string
     * @return
     */
    Account getAccountByEntityType(String string);

    List<Account> getAccountOnly();

    List<Account> getAll();

    Account updateAccount(Account account);

}
