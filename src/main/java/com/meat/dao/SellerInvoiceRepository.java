/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerInvoice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SellerInvoiceRepository extends PagingAndSortingRepository<SellerInvoice, Serializable> {

    /**
     * @param id
     * @return
     */
    @Query("select SUM(si.dueAmount) from SellerInvoice si join si.sellerBranch sb where si.paidStatus = ?2 and sb.id=?1")
    BigDecimal findBilledAmountBySellerBranchPaidStatus(String branchId, String paidStatus);

    /**
     * @param branchId
     * @return
     */
    @Query("SELECT si.amountToBePaid FROM SellerInvoice si JOIN si.sellerBranch sb WHERE sb.id = ?1 AND si.createdDate IN (SELECT MAX(sii.createdDate) FROM SellerInvoice sii WHERE sii.sellerBranch.id = ?1)")
    String findLastGeneratedSellerInvoiceAmountByBranch(String branchId);

    /**
     * @param branchId
     * @param Paid
     *            Status
     *
     * @return
     *
     */
    @Query("SELECT si FROM SellerInvoice si WHERE si.sellerBranch.id =?1 AND si.paidStatus = ?2")
    List<SellerInvoice> findSellerInvoiceBySellerBranchPaidStatus(String branchId, String paidStatus);

}
