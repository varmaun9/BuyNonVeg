/**
 *
 */
package com.meat.service;

import com.meat.dao.BankOfferRepository;
import com.meat.domain.BankOffer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class BankOfferService implements IBankOfferService {

    @Autowired
    private BankOfferRepository bankOfferRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#create(com.meat.domain.BankOffer)
     */
    @Override
    public BankOffer create(final BankOffer bankOffer) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#deleteBankOffer(java.lang.String)
     */
    @Override
    public void deleteBankOffer(final String bankOfferId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#getAll()
     */
    @Override
    public List<BankOffer> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#getBankOffer(java.lang.String)
     */
    @Override
    public BankOffer getBankOffer(final String bankOfferId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#getBankOfferOnly()
     */
    @Override
    public List<BankOffer> getBankOfferOnly() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IBankOfferService#updateAccount(com.meat.domain.BankOffer)
     */
    @Override
    public BankOffer updateAccount(final BankOffer bankOffer) {
        // TODO Auto-generated method stub
        return null;
    }

}
