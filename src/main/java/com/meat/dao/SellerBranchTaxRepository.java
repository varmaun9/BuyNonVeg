/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBranchTax;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerBranchTaxRepository extends PagingAndSortingRepository<SellerBranchTax, Serializable> {

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("SELECT sbt FROM SellerBranchTax sbt JOIN sbt.sellerBranch sb JOIN sbt.amountType at JOIN sbt.tax t WHERE sb.id=?1 AND at.amountDescription = ?2 AND t.taxType='TAX'")
    List<SellerBranchTax> findSellerBranchTaxesBySellerBranch(String sellerBranchId, String amountType);

    /**
     * @param id
     * @param amountType
     * @return
     */
    @Query("SELECT SUM(sbt.taxValue) FROM SellerBranchTax sbt JOIN sbt.sellerBranch sb JOIN sbt.amountType at JOIN sbt.tax t WHERE sb.id=?1 AND at.amountDescription = ?2 AND t.taxType='TAX'")
    Float findSumOfApplicableTaxTypeBySellerBranch(String id, String amountType);

    /**
     * @param sellerItemId
     * @return sum of all applicable taxes
     */
    @Query("SELECT SUM(sbt.taxValue) FROM SellerBranchTax sbt JOIN sbt.sellerBranch sb JOIN sb.sellerItems si JOIN sbt.amountType at JOIN sbt.tax t WHERE si.id=?1 AND at.amountDescription = ?2 AND t.taxType='TAX'")
    Float findSumOfApplicableTaxTypeBySellerItem(String sellerItemId, String amountType);

    /**
     * @param id
     * @param string
     * @return
     */
    @Query("select sbt from SellerBranchTax sbt join sbt.sellerBranch sb join sbt.tax t where t.taxType=?2 and sb.id=?1")
    List<SellerBranchTax> findTaxByBranchAndTaxType(String branchId, String taxType);

}
