/**
 *
 */
package com.meat.dao;

import com.meat.domain.OfferConfig;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface OfferConfigRepository extends PagingAndSortingRepository<OfferConfig, Serializable> {

    /**
     * @param id
     * @param category
     * @param subCategory
     * @param seller
     * @param sellerBranch
     * @param itm
     * @return
     */
    @Query("select ofc from OfferConfig ofc join ofc.sellerItem si join si.item i join i.subCategory sc join sc.category c join si.sellerBranch sb join sb.seller s where si.id=?1 or c.id=?2 or sc.id=?3 or s.id=?4 or sb.id=?5 or i.id=?6 and ofc.status='ACTIVE'")
    Set<OfferConfig> findOfferConfigByItemListCategoryZone(String id, String category, String subCategory, String seller,
            String sellerBranch, String itm);

}
