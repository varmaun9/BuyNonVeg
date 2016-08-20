/**
 *
 */
package com.meat.dao;

import com.meat.domain.TagType;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface TagTypeRepository extends PagingAndSortingRepository<TagType, Serializable> {

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct tt from TagType tt join tt.tagses t join t.categoryTagses ct join ct.category c where c.id=?1")
    List<TagType> findItemTagTypesByThymeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct tt from TagType tt join tt.tagses t join t.categoryTagses ct join ct.category c join t.itemTagses it join it.item i join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id=?1 and z.id=?2")
    List<TagType> findItemTagTypesByThymeleafCategoryZone(String categoryId, String zoneId);

}
