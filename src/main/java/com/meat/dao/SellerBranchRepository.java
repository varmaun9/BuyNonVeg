/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBranch;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerBranchRepository extends PagingAndSortingRepository<SellerBranch, Serializable> {

    /**
     * @param sellerId
     * @return
     */
    @Query("select distinct sb from SellerBranch sb join sb.seller s where s.id=?1")
    List<SellerBranch> findSellerBranchBySeller(String sellerId);

    /**
     * @param sellerItemId
     * @return
     */
    @Query("SELECT sb from SellerBranch sb join sb.sellerItems si where si.id=?1")
    SellerBranch findSellerBranchBySellerItem(String sellerItemId);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct sb from SellerBranch sb join sb.sellerItems si join si.item i join i.subCategory sc join sc.category c where c.id=?1")
    List<SellerBranch> findSellerBranchByThymeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct sb from SellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join sb.sellerItems si join si.item i join i.subCategory sc join sc.category c where c.id=?1 and z.id=?2 and sb.branchStatus='Active'")
    List<SellerBranch> findSellerBranchByThymeleafCategoryZone(String categoryId, String zoneId);

    /**
     * @param userId
     * @return
     */
    @Query("SELECT sb FROM SellerBranch sb JOIN sb.sellerUser su JOIN su.users u WHERE u.id=?1")
    SellerBranch findSellerBranchByUserId(String userId);

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("select distinct sb from SellerBranch sb where sb.id=?1")
    List<SellerBranch> findSellerBranchOnlyBySellerBranch(String sellerBranchId);

    /**
     * @param id
     * @return
     */
    @Query("select distinct sb from SellerBranch sb join sb.sellerItems si join si.item i join i.subCategory sc where sb.branchStatus='ACTIVE' and sc.id=?1")
    List<SellerBranch> getSellerBranchCountBySubCategory(String id);

    /**
     * @param id
     * @return
     */

    /**
     * @param sellerBranchId
     * @return
     */

}
