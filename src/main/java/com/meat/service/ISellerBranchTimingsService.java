/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBranchTimings;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface ISellerBranchTimingsService {

    SellerBranchTimings create(SellerBranchTimings sellerBranchTimings);

    void deleteSellerBranchTimings(String sellerBranchTimingsId);

    List<SellerBranchTimings> getAll();

    SellerBranchTimings getSellerBranchTimings(String sellerBranchTimingsId);

    /**
     * @param sellerBranchId
     * @return
     */
    List<SellerBranchTimings> getSellerBranchTimingsBySellerBranch(String sellerBranchId);

    SellerBranchTimings updateSellerBranchTimings(SellerBranchTimings sellerBranchTimings);

}
