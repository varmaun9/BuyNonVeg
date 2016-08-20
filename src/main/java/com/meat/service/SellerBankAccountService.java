/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBankAccountRepository;
import com.meat.domain.SellerBankAccount;

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
public class SellerBankAccountService implements ISellerBankAccountService {

    @Autowired
    private SellerBankAccountRepository sellerBankAccountRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#create(com.meat.domain.SellerBankAccount)
     */
    @Override
    public SellerBankAccount create(final SellerBankAccount sellerBankAccount) {

        return sellerBankAccountRepository.save(sellerBankAccount);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#deleteSellerBankAccount(java.lang.String)
     */
    @Override
    public void deleteSellerBankAccount(final String sellerBankAccountId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#getAll()
     */

    @Override
    @Transactional
    public List<SellerBankAccount> getAll() {
        List<SellerBankAccount> sellerBankAccount = new ArrayList<SellerBankAccount>();
        sellerBankAccount = (List<SellerBankAccount>) sellerBankAccountRepository.findAll();
        return sellerBankAccount;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#getCity(java.lang.String)
     */

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#getSellerBankAccount(java.lang.String)
     */

    @Override
    public SellerBankAccount getSellerBankAccount(final String sellerBankAccountId) {
        SellerBankAccount sellerBankAccount = new SellerBankAccount();
        sellerBankAccount = sellerBankAccountRepository.findOne(sellerBankAccountId);
        return sellerBankAccount;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#getSellerBankAccountOnly()
     */

    @Override
    public List<SellerBankAccount> getSellerBankAccountOnly() {
        List<SellerBankAccount> sellerBankAccount = new ArrayList<SellerBankAccount>();
        sellerBankAccount = (List<SellerBankAccount>) sellerBankAccountRepository.findAll();
        List<SellerBankAccount> sellerBankAccounts = new ArrayList<SellerBankAccount>();
        for (SellerBankAccount s : sellerBankAccount) {
            SellerBankAccount sba = new SellerBankAccount();
            sba.setId(s.getId());
            sba.setSellerBranch(s.getSellerBranch());
            sba.setAccountNo(s.getAccountNo());
            sba.setIfscCode(s.getIfscCode());
            sba.setBranchDetails(s.getBranchDetails());
            sba.setName(s.getName());
            sellerBankAccounts.add(sba);
        }
        return sellerBankAccounts;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBankAccountService#updateSellerBankAccount(com.meat.domain.SellerBankAccount)
     */
    @Override
    public SellerBankAccount updateSellerBankAccount(final SellerBankAccount sellerBankAccount) {
        // TODO Auto-generated method stub
        return sellerBankAccountRepository.save(sellerBankAccount);
    }

}
