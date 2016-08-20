/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerItemRepository extends PagingAndSortingRepository<SellerItem, Serializable> {

    /**
     * @param id
     * @param id2
     * @return
     */
    @Query("SELECT si FROM SellerItem si WHERE si.item.id=?1 AND si.sellerBranch.id=?2")
    SellerItem findByItemSellerBranch(String itemId, String sellerBranchId);

    /**
     * @param categoryId
     * @param request
     * @return
     */
    @Query("select distinct si from SellerItem si join si.item i join i.subCategory sc join sc.category c where c.id=?1 and si.itemAvailableStatus='ACTIVE'")
    List<SellerItem> findItemSellerItemByThymeleafCategory(String categoryId, Pageable request);

    /**
     * @param categoryId
     * @param zoneId
     * @param request
     * @return
     */
    @Query("select distinct si from SellerItem si join si.item i join i.subCategory sc join sc.category c join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where si.itemAvailableStatus='ACTIVE' and c.id=?1 and z.id=?2")
    List<SellerItem> findItemSellerItemByThymeleafCategoryZone(String categoryId, String zoneId, Pageable request);

    /**
     * @param sellerId
     * @param zoneId
     * @param request
     * @return
     */
    @Query("select distinct si from SellerItem si join si.sellerBranch sb join sb.seller s join sb.sellerBranchZones sbz join sbz.zone z where si.itemAvailableStatus='ACTIVE' and  s.id=?1 and z.id=?2")
    List<SellerItem> findItemSellerItemByThymeleafSellerZone(String sellerId, String zoneId, Pageable request);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct MAX(si.sellingPrice) from SellerItem si join si.item i join i.subCategory sc join sc.category c where c.id=?1 and si.itemAvailableStatus='ACTIVE'")
    BigDecimal findMaxPriceSellerItemByThymeleafCategory(String categoryId);

    /**
     * @param zoneId
     * @param categoryId
     * @return
     */
    @Query("select distinct MAX(si.sellingPrice) from SellerItem si join si.item i join i.subCategory sc join sc.category c join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where si.itemAvailableStatus='ACTIVE' and c.id=?2 and z.id=?1")
    BigDecimal findMaxPriceSellerItemByThymeleafCategoryZone(String zoneId, String categoryId);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct MIN(si.sellingPrice) from SellerItem si join si.item i join i.subCategory sc join sc.category c where c.id=?1 and si.itemAvailableStatus='ACTIVE'")
    BigDecimal findMinPriceSellerItemByThymeleafCategory(String categoryId);

    /**
     * @param itemId
     * @return
     */

    //  List<SellerItem> findSellerItemByThymeleafItem(String itemId);

    /**
     * @param zoneId
     * @param categoryId
     * @return
     */
    @Query("select distinct MIN(si.sellingPrice) from SellerItem si join si.item i join i.subCategory sc join sc.category c join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where si.itemAvailableStatus='ACTIVE' and c.id=?2 and z.id=?1")
    BigDecimal findMinPriceSellerItemByThymeleafCategoryZone(String zoneId, String categoryId);

    /**
     * @param sellerBranchId
     * @return
     */

    @Query("select distinct si from SellerItem si join si.sellerBranch sb where sb.id=?1")
    List<SellerItem> findSellerBranchItemsOnly(String sellerBranchId);

    /**
     * @param id
     * @return
     */
    @Query("select distinct si from SellerItem si where si.item.id=?1")
    List<SellerItem> findSellerItemByItemMobileThymeleaf(String id);

    /**
     * @param id
     * @return
     */
    @Query("select distinct si from SellerItem si join si.item i where i.id=?1 order by si.sellingPrice ASC")
    Set<SellerItem> findSellerItemByItemThymeleaf(String id);

    /**
     * @param id
     * @return
     */
    @Query("select distinct si from SellerItem si join si.item i where si.itemAvailableStatus='ACTIVE' and i.id=?1")
    Set<SellerItem> findSellerItemBySearchItem(String id);

    /**
     * @param branchId
     * @return
     */
    @Query("select distinct si from SellerItem si where si.sellerBranch.id=?1")
    List<SellerItem> findSellerItemBySellerBranch(String branchId);

    /**
     * @param itemId
     * @param zoneId
     * @return
     */
    @Query("SELECT DISTINCT si FROM SellerItem si JOIN si.item i WHERE si.itemAvailableStatus='ACTIVE' AND i.id=?1 ORDER BY si.sellingPrice ASC")
    List<SellerItem> findSellerItemByThymeleafItem(String itemId);

    /**
     * @param itemId
     * @param zoneId
     * @return
     */
    @Query("select distinct si from SellerItem si join si.item i join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where si.itemAvailableStatus='ACTIVE' and i.id=?1 and z.id=?2 and sb.branchStatus = 'ACTIVE' order by si.sellingPrice ASC")
    List<SellerItem> findSellerItemByThymeleafItemZone(String itemId, String zoneId);

    /**
     * @param branchId
     * @param status
     * @return
     */
    @Query("SELECT COUNT(si) FROM SellerItem si JOIN si.sellerBranch sb WHERE sb.id=?1 AND si.itemAvailableStatus = ?2")
    String findSellerItemsCountBySellerBranchStatus(String branchId, String status);

}
