/**
 *
 */
package com.meat.dao;

import com.meat.domain.ItemAttributes;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Varma
 *
 */
public interface ItemAttributesRepository extends PagingAndSortingRepository<ItemAttributes, Serializable> {

    /**
     * @param id
     * @return
     */

    @Query("select distinct ita from ItemAttributes ita where ita.attributes.id = ?1 GROUP BY ita.attributeValue")
    List<ItemAttributes> findItemAttributesByAttributeId(String id);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct ita from ItemAttributes ita join ita.item i join i.subCategory sc join sc.category c where c.id=?1 and ita.searchableStatus='ACTIVE'")
    List<ItemAttributes> findItemAttributesByThymeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct ita from ItemAttributes ita join ita.item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id=?1 and z.id=?2 and ita.searchableStatus='ACTIVE'")
    List<ItemAttributes> findItemAttributesByThymeleafCategoryZone(String categoryId, String zoneId);

}
