/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchAddressRepository;
import com.meat.domain.SellerBranchAddress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Varma
 *
 */
@Component
public class SellerBranchAddressService implements ISellerBranchAddressService {
    @Autowired
    private SellerBranchAddressRepository sellerBranchAddressRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#create(com.meat.domain.SellerBranchAddress)
     */
    @Override
    @Transactional
    public SellerBranchAddress create(final SellerBranchAddress sellerBranchAddress) {
        // TODO Auto-generated method stub
        return sellerBranchAddressRepository.save(sellerBranchAddress);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#deleteSellerBranchAddress(java.lang.String)
     */
    @Override
    public void deleteSellerBranchAddress(final String sellerBranchAddressId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#getAll()
     */
    @Override
    public List<SellerBranchAddress> getAll() {
        // TODO Auto-generated method stub
        return (List<SellerBranchAddress>) sellerBranchAddressRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#getSellerBranchAddress(java.lang.String)
     */
    @Override
    public SellerBranchAddress getSellerBranchAddress(final String sellerBranchAddressId) {
        // TODO Auto-generated method stub
        return sellerBranchAddressRepository.findOne(sellerBranchAddressId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#getSellerBranchAddressBySellerBranch(java.lang.String)
     */
    @Override
    public List<SellerBranchAddress> getSellerBranchAddressBySellerBranch(final String sellerBranchId) {
        // TODO Auto-generated method stub
        return sellerBranchAddressRepository.findSellerBranchAddressByBranchId(sellerBranchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchAddressService#updateSellerBranchAddress(com.meat.domain.SellerBranchAddress)
     */
    @Override
    public SellerBranchAddress updateSellerBranchAddress(final SellerBranchAddress sellerBranchAddress) {
        // TODO Auto-generated method stub
        return sellerBranchAddressRepository.save(sellerBranchAddress);
    }

}
