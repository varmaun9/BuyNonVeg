/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerItemTaxRepository;
import com.meat.domain.SellerItemTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerItemTaxService implements ISellerItemTaxService {
    @Autowired
    private SellerItemTaxRepository sellerItemTaxRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemTaxService#create(com.meat.domain.SellerItemTax)
     */
    @Override
    public SellerItemTax create(final SellerItemTax sellerItemTax) {
        // TODO Auto-generated method stub
        return sellerItemTaxRepository.save(sellerItemTax);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemTaxService#deleteSellerItemTax(java.lang.String)
     */
    @Override
    public void deleteSellerItemTax(final String sellerItemTaxId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemTaxService#getAll()
     */
    @Override
    public List<SellerItemTax> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemTaxService#getSellerItemTaxId(java.lang.String)
     */
    @Override
    public SellerItemTax getSellerItemTax(final String sellerItemTaxId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemTaxService#updateSellerItemTax(com.meat.domain.SellerItemTax)
     */
    @Override
    public SellerItemTax updateSellerItemTax(final SellerItemTax sellerItemTax) {
        // TODO Auto-generated method stub
        return sellerItemTaxRepository.save(sellerItemTax);
    }

}
