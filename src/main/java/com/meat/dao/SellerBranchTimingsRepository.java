/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBranchTimings;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SellerBranchTimingsRepository extends PagingAndSortingRepository<SellerBranchTimings, Serializable> {

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("select sbt from SellerBranchTimings sbt where sbt.sellerBranch.id=?1")
    List<SellerBranchTimings> findSellerBranchTimingsBySellerBranch(String sellerBranchId);

    /**
     * @param sellerBranchId
     * @return
     */

}
