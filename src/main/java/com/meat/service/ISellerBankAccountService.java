/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBankAccount;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface ISellerBankAccountService {

    SellerBankAccount create(SellerBankAccount sellerBankAccount);

    void deleteSellerBankAccount(String sellerBankAccountId);

    List<SellerBankAccount> getAll();

    // List<SellerBankAccount> getCity(String city);

    SellerBankAccount getSellerBankAccount(String sellerBankAccountId);

    /**
     * @return
     */
    List<SellerBankAccount> getSellerBankAccountOnly();

    SellerBankAccount updateSellerBankAccount(SellerBankAccount sellerBankAccount);

}