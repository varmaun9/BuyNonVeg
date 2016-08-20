/**
 *
 */
package com.meat.service;

import com.meat.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author arthvedi1
 *
 */
public interface ISellerItemService {
    /**
     * @param sellerItem
     * @param sllrItemCriteria
     * @return
     */
    SellerItem addSellerItemCriteria(SellerItem sellerItem, List<SellerItemCriteria> sllrItemCriteria);

    /**
     * @param sellerItem
     * @param sllrItemImages
     * @return
     */
    SellerItem addSellerItemImages(SellerItem sellerItem, List<SellerItemImages> sllrItemImages);

    /**
     * @param sellerItem
     * @param sllrItemPieceTypes
     * @return
     */
    SellerItem addSellerItemPieceTypes(SellerItem sellerItem, List<SellerItemPieceType> sllrItemPieceTypes);

    /**
     * @param sellerItem
     * @param slrItemTax
     * @return
     */
    SellerItem addSellerItemTax(SellerItem sellerItem, List<SellerItemTax> slrItemTax);

    SellerItem create(SellerItem sellerItem);

    void deleteSellerItem(String sellerItemId);

    List<SellerItem> getAll();

    /**
     * @param categoryId
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<SellerItem> getItemSellerItemByThymeleafCategory(String categoryId, int page, int pageSize, String sort, String type);

    /**
     * @param categoryId
     * @param zoneId
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<SellerItem> getItemSellerItemByThymeleafCategoryZone(String categoryId, String zoneId, int page, int pageSize, String sort,
            String type);

    /**
     * @param sellerId
     * @param zoneId
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<SellerItem> getItemSellerItemByThymeleafSellerZone(String sellerId, String zoneId, int page, int pageSize, String sort,
            String type);

    /**
     * @param categoryId
     * @return
     */
    BigDecimal getMaxSellerItemPagesByThemeleafCategory(String categoryId);

    /**
     * @param zoneId
     * @param categoryId
     * @return
     */
    BigDecimal getMaxSellerItemPagesByThemeleafCategoryZone(String zoneId, String categoryId);

    /**
     * @param categoryId
     * @return
     */
    BigDecimal getMinSellerItemPagesByThemeleafCategory(String categoryId);

    /**
     * @param zoneId
     * @param categoryId
     * @return
     */
    BigDecimal getMinSellerItemPagesByThemeleafCategoryZone(String zoneId, String categoryId);

    /**
     * @return
     */
    List<SellerItem> getSellerBranchItemOnly(String sellerBranchId);

    /**
     * @param itemId
     * @return
     */
    // List<SellerItem> getSellerItemByThymeleafItem(String itemId);

    SellerItem getSellerItem(String sellerItemId);

    /**
     * @param sellerItemId
     * @return
     */
    SellerItem getSellerItemAfterOfferApplied(String sellerItemId);

    /**
     * @param itemId
     * @param zoneId
     * @return
     */
    List<SellerItem> getSellerItemByThymeleafItem(String itemId);

    /**
     * @param itemId
     * @param zoneId
     * @return
     */
    List<SellerItem> getSellerItemByThymeleafItemZone(String itemId, String zoneId);

    /**
     * @return
     */
    List<SellerItem> getSellerItemOnly();

    /**
     * @param sellerBranchId
     * @return
     */
    List<SellerItem> getSellerItemOnly(String sellerBranchId);

    /**
     * @param branchId
     * @return
     */
    List<SellerItem> getSellerItemsBySellerBranch(String branchId);

    /**
     * @param id
     * @return
     */
    Set<SellerItem> getSellerItemsByThymeleafItem(String id);

    /**
     * @param branchId
     * @param string
     * @return
     */
    String getSellerItemsCountBySellerBranchStatus(String branchId, String status);

    /**
     * @param sellerItems
     * @return
     */
    List<SellerItem> getSellerItemWithOffer(List<SellerItem> sellerItems);

    /**
     * @param id
     * @return
     */
    Map<SellerItem, List<Offer>> getSellerItemWithOffersShortInfo(String sellerItemId);

    SellerItem updateSellerItem(SellerItem sellerItem);

}
