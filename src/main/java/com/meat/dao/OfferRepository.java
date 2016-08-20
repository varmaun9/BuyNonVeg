/**
 *
 */
package com.meat.dao;

import com.meat.domain.Offer;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OfferRepository extends PagingAndSortingRepository<Offer, Serializable> {

    /**
     * @return
     */
    @Query("select MAX(o.offerCount) from Offer o")
    Integer findByMaxCode();

    /**
     * @param id
     * @param category
     * @param subCategory
     * @param seller
     * @param sellerBranch
     * @param itm
     * @return
     */
    // @Query("select o from Offer o join o.offerConfigs oc join oc.sellerItem si join si.item i join i.subCategory sc join sc.category c join si.sellerBranch sb join sb.seller s where (si.id=?1 or c.id=?2 or sc.id=?3 or s.id=?4 or sb.id=?5 or i.id=?6) and o.offerType='OFFER' and o.status = 'ACTIVE' and o.offerFromDate >= CURRENT_TIMESTAMP and o.offerToDate <= CURRENT_TIMESTAMP")
    @Query("SELECT o FROM Offer o LEFT JOIN o.offerConfigs oc LEFT JOIN oc.category c LEFT JOIN oc.sellerItem si LEFT JOIN oc.subCategory sc LEFT JOIN oc.sellerBranch sb LEFT JOIN oc.seller s LEFT JOIN oc.item i WHERE (si.id=?1) OR (i.id = ?2) OR (sc.id = ?3) OR (c.id=?4) OR (sb.id = ?5) OR (s.id = ?6) and o.offerType='OFFER' and o.status = 'ACTIVE' and o.offerFromDate >= CURRENT_TIMESTAMP and o.offerToDate <= CURRENT_TIMESTAMP")
    List<Offer> findOfferByItemListCategoryZone(String sellerItemId, String itemId, String subCategoryId, String categoryId,
            String sellerBranchId, String sellerId);

    /**
     * @param id
     * @return
     */
    @Query("SELECT o.id FROM Offer o LEFT JOIN o.offerConfigs oc LEFT JOIN oc.category c LEFT JOIN oc.sellerItem si LEFT JOIN oc.subCategory sc LEFT JOIN oc.sellerBranch sb LEFT JOIN oc.seller s LEFT JOIN oc.item i WHERE (si.id=?1) OR (i.id = ?2) OR (sc.id = ?3) OR (c.id=?4) OR (sb.id = ?5) OR (s.id = ?6) and o.offerType='OFFER' and o.status = 'ACTIVE' and o.offerFromDate >= CURRENT_TIMESTAMP and o.offerToDate <= CURRENT_TIMESTAMP")
    List<String> findOfferIdBySellerItemAlongwithParents(String sellerItemId, String itemId, String subCategoryId, String categoryId,
            String sellerBranchId, String sellerId);

}
