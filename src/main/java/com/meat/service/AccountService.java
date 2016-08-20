/**
 *
 */
package com.meat.service;

import com.meat.dao.AccountRepository;
import com.meat.domain.Account;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#create(com.meat.domain.Account)
     */
    @Override
    public Account create(final Account account) {

        return accountRepository.save(account);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#deleteAccount(java.lang.String)
     */
    @Override
    public void deleteAccount(final String accountId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getAccount(java.lang.String)
     */

    @Override
    public Account getAccount(final String accountId) {
        Account account = new Account();
        account = accountRepository.findOne(accountId);
        return account;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getAccountByBranch(java.lang.String)
     */
    @Override
    public Account getAccountByBranch(final String id) {
        // TODO Auto-generated method stub
        return accountRepository.findAccountByBranch(id);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getAccountByEntityType(java.lang.String)
     */
    @Override
    public Account getAccountByEntityType(final String entityType) {
        // TODO Auto-generated method stub
        return accountRepository.findAccountByEntityType(entityType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getCity(java.lang.String)
     */

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getAccountOnly()
     */

    @Override
    public List<Account> getAccountOnly() {
        List<Account> account = new ArrayList<Account>();
        account = (List<Account>) accountRepository.findAll();
        List<Account> accounts = new ArrayList<Account>();
        for (Account a : account) {
            Account act = new Account();
            act.setId(a.getId());
            act.setSellerBranch(a.getSellerBranch());
            act.setEntityName(a.getEntityName());
            act.setEntityType(a.getEntityType());
            act.setAmount(a.getAmount());
            accounts.add(act);
        }
        return accounts;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#getAll()
     */

    @Override
    @Transactional
    public List<Account> getAll() {
        List<Account> account = new ArrayList<Account>();
        account = (List<Account>) accountRepository.findAll();
        return account;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAccountService#updateAccount(com.meat.domain.Account)
     */
    @Override
    public Account updateAccount(final Account account) {
        // TODO Auto-generated method stub
        return accountRepository.save(account);
    }

}
