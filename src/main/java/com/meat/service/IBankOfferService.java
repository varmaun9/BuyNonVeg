/**
 *
 */
package com.meat.service;

import com.meat.domain.BankOffer;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IBankOfferService {

    BankOffer create(BankOffer bankOffer);

    void deleteBankOffer(String bankOfferId);

    List<BankOffer> getAll();

    BankOffer getBankOffer(String bankOfferId);

    List<BankOffer> getBankOfferOnly();

    BankOffer updateAccount(BankOffer bankOffer);

}
