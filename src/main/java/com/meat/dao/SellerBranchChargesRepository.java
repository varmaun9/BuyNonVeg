/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBranchCharges;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerBranchChargesRepository extends PagingAndSortingRepository<SellerBranchCharges, Serializable> {

    /**
     * @param id
     * @return
     */
    @Query("SELECT SUM(sbc.chargesAmount) FROM SellerBranchCharges sbc WHERE sbc.sellerBranch.id = ?1 AND sbc.status = 'ACTIVE'")
    BigDecimal findTotalChargesBySeller(String id);

}
