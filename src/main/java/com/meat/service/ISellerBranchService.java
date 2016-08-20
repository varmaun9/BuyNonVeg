/**
 *
 */
package com.meat.service;

import com.meat.domain.*;

import java.util.List;
import java.util.Set;

/**
 * @author arthvedi1
 *
 */
public interface ISellerBranchService {

    /**
     * @param sellerBranch
     * @param address
     * @return
     */
    // SellerBranch addAddress(SellerBranch sellerBranch, Set<Address> address);

    /* *//**
          * @param sellerBranch
          * @param sellerBranchAddresses
          * @return
          *//*
           SellerBranch addSellerBranchAddress(SellerBranch sellerBranch, Set<SellerBranchAddress> sellerBranchAddresses);
           */
    /**
     * @param sellerBranch
     * @param sbImages
     * @return
     */
    SellerBranch addSellerBranchImages(SellerBranch sellerBranch, List<SellerBranchImages> sbImages);

    /**
     * @param sellerBranch
     * @param sbt
     * @return
     */
    SellerBranch addSellerBranchTaxes(SellerBranch sellerBranch, Set<SellerBranchTax> sbt);

    /**
     * @param sellerBranch
     * @param sellerBranchTimings
     * @return
     */
    SellerBranch addSellerBranchTimings(SellerBranch sellerBranch, Set<SellerBranchTimings> sellerBranchTimings);

    /**
     * @param sellerBranch
     * @param sbz
     * @return
     */
    SellerBranch addSellerBranchZones(SellerBranch sellerBranch, Set<SellerBranchZone> sbz);

    /**
     * @param sellerBranch
     * @param sellerItems
     * @return
     */
    SellerBranch addSellerItems(SellerBranch sellerBranch, Set<SellerItem> sellerItems);

    SellerBranch create(SellerBranch sellerBranch);

    void deleteSellerBranch(String sellerBranchId);

    List<SellerBranch> getAll();

    /**
     * @param sellerItemId
     * @return
     */
    SellerBranch getBranchBySellerItem(String sellerItemId);

    SellerBranch getSellerBranch(String sellerBranchId);

    /**
     * @param sellerId
     * @return
     */

    /**
     * @param sellerId
     * @return
     */
    List<SellerBranch> getSellerBranchBySeller(String sellerId);

    /**
     * @param userId
     * @return
     */
    SellerBranch getSellerBranchByUserId(String userId);

    /**
     * @param categoryId
     * @return
     */
    List<SellerBranch> getSellerBranchesByThemeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    List<SellerBranch> getSellerBranchesByThemeleafCategoryZone(String categoryId, String zoneId);

    /**
     * @return
     */
    List<SellerBranch> getSellerBranchOnly();

    /**
     * @param sellerBranchId
     * @return
     */
    List<SellerBranch> getSellerBranchOnlyBySellerBranch(String sellerBranchId);

    SellerBranch updateSellerBranch(SellerBranch sellerBranch);

}
