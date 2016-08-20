/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBranchCharges;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author varma
 *
 */
public interface ISellerBranchChargesService {

    SellerBranchCharges create(SellerBranchCharges sellerBranchCharges);

    void deleteSellerBranchCharges(String sellerBranchChargesId);

    List<SellerBranchCharges> getAll();

    SellerBranchCharges getSellerBranchCharges(String sellerBranchChargesId);

    BigDecimal getSumOfSellerChargesBySellerBranch(String sellerBranchId);

    SellerBranchCharges updateSellerBranchCharges(SellerBranchCharges sellerBranchCharges);

}
