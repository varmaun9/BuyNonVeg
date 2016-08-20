/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerBranchZone;

import java.util.List;

/**
 * @author Dilli
 *
 */
public interface ISellerBranchZoneService {
    SellerBranchZone create(SellerBranchZone sellerBranchZone);

    void deleteSellerBranchZone(String sellerBranchZoneId);

    /**
     * @return
     */
    List<SellerBranchZone> getAll();

    SellerBranchZone getSellerBranchZone(String sellerBranchZoneId);

    SellerBranchZone updateSellerBranchZone(SellerBranchZone sellerBranchZone);

}
