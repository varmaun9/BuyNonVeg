/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBranchAddress;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerBranchAddressService {

    SellerBranchAddress create(SellerBranchAddress sellerBranchAddress);

    void deleteSellerBranchAddress(String sellerBranchAddressId);

    List<SellerBranchAddress> getAll();

    SellerBranchAddress getSellerBranchAddress(String sellerBranchAddressId);

    /**
     * @param sellerBranchId
     * @return
     */
    List<SellerBranchAddress> getSellerBranchAddressBySellerBranch(String sellerBranchId);

    SellerBranchAddress updateSellerBranchAddress(SellerBranchAddress sellerBranchAddress);

}
