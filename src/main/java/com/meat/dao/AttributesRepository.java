/**
 *
 */
package com.meat.dao;

import com.meat.domain.Attributes;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface AttributesRepository extends PagingAndSortingRepository<Attributes, Serializable> {

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct a from Attributes a join a.itemAttributeses ita join ita.categoryAttributes ca join ca.category c join c.subCategories sc join sc.items i join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id=?1 and z.id=?2")
    List<Attributes> findItemAttributesByThymeleafCategoryZone(String categoryId, String zoneId);

}
