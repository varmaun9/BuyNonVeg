/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBranchTax;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerBranchTaxService {

    SellerBranchTax create(SellerBranchTax sellerBranchTax);

    void deleteSellerBranchTax(String sellerBranchTaxId);

    List<SellerBranchTax> getAll();

    /**
     * @param sellerBranchId
     * @param string
     * @return
     */
    List<SellerBranchTax> getApplicableTaxesBySellerBranch(String sellerBranchId, String amountType);

    /**
     * @param seller
     *            Item Id
     * @return
     */
    Float getApplicableTaxesTypeSumBySellerItem(String sellerItemId, String amountType);

    SellerBranchTax getSellerBranchTax(String sellerBranchTaxId);

    /**
     * @param id
     * @param string
     * @return
     */
    Float getSumOfApplicableTaxesBySellerBranch(String id, String string);

    SellerBranchTax updateSellerBranchTax(SellerBranchTax sellerBranchTax);

}
