/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchTaxRepository;
import com.meat.domain.SellerBranchTax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerBranchTaxService implements ISellerBranchTaxService {

    @Autowired
    private SellerBranchTaxRepository sellerBranchTaxRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#create(com.meat.domain.SellerBranchTax)
     */
    @Override
    public SellerBranchTax create(final SellerBranchTax sellerBranchTax) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.save(sellerBranchTax);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#deleteSellerBranchTax(java.lang.String)
     */
    @Override
    public void deleteSellerBranchTax(final String sellerBranchTaxId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#getAll()
     */
    @Override
    public List<SellerBranchTax> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#getApplicableTaxesBySellerBranch(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerBranchTax> getApplicableTaxesBySellerBranch(final String sellerBranchId, final String amountType) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.findSellerBranchTaxesBySellerBranch(sellerBranchId, amountType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#getApplicableTaxesSumBySellerItem(java.lang.String)
     */
    @Override
    public Float getApplicableTaxesTypeSumBySellerItem(final String sellerItemId, final String amountType) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.findSumOfApplicableTaxTypeBySellerItem(sellerItemId, amountType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#getSellerBranchTax(java.lang.String)
     */
    @Override
    public SellerBranchTax getSellerBranchTax(final String sellerBranchTaxId) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.findOne(sellerBranchTaxId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#getSumOfApplicableTaxesBySellerBranch(java.lang.String, java.lang.String)
     */
    @Override
    public Float getSumOfApplicableTaxesBySellerBranch(final String id, final String amountType) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.findSumOfApplicableTaxTypeBySellerBranch(id, amountType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTaxService#updateSellerBranchTax(com.meat.domain.SellerBranchTax)
     */
    @Override
    public SellerBranchTax updateSellerBranchTax(final SellerBranchTax sellerBranchTax) {
        // TODO Auto-generated method stub
        return sellerBranchTaxRepository.save(sellerBranchTax);
    }

}
