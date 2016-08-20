/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchChargesRepository;
import com.meat.domain.SellerBranchCharges;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class SellerBranchChargesService implements ISellerBranchChargesService {

    @Autowired
    private SellerBranchChargesRepository sellerBranchChargesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#create(com.meat.domain.SellerBranchCharges)
     */
    @Override
    public SellerBranchCharges create(final SellerBranchCharges sellerBranchCharges) {
        // TODO Auto-generated method stub
        return sellerBranchChargesRepository.save(sellerBranchCharges);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#deleteSellerBranchCharges(java.lang.String)
     */
    @Override
    public void deleteSellerBranchCharges(final String sellerBranchChargesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#getAll()
     */
    @Override
    public List<SellerBranchCharges> getAll() {
        // TODO Auto-generated method stub
        return (List<SellerBranchCharges>) sellerBranchChargesRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#getSellerBranchCharges(java.lang.String)
     */
    @Override
    public SellerBranchCharges getSellerBranchCharges(final String sellerBranchChargesId) {
        // TODO Auto-generated method stub
        return sellerBranchChargesRepository.findOne(sellerBranchChargesId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#getSumOfSellerChargesBySellerBranch(java.lang.String)
     */
    @Override
    public BigDecimal getSumOfSellerChargesBySellerBranch(final String sellerBranchId) {
        // TODO Auto-generated method stub
        return sellerBranchChargesRepository.findTotalChargesBySeller(sellerBranchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchChargesService#updateSellerBranchCharges(com.meat.domain.SellerBranchCharges)
     */
    @Override
    public SellerBranchCharges updateSellerBranchCharges(final SellerBranchCharges sellerBranchCharges) {
        // TODO Auto-generated method stub
        return sellerBranchChargesRepository.save(sellerBranchCharges);
    }

}
