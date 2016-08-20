/**
 *
 */
package com.meat.dao;

import com.meat.domain.SubCategory;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SubCategoryRepository extends PagingAndSortingRepository<SubCategory, Serializable> {

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct sc from SubCategory sc where sc.category.id=?1")
    List<SubCategory> findAllSubCategoryByCategory(String categoryId);

    /**
     * @return
     */
    @Query("select distinct sc from SubCategory sc where sc.status='ACTIVE'")
    List<SubCategory> findByAll();

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct sc from SubCategory sc join sc.category c where c.id=?1 and sc.status='ACTIVE'")
    List<SubCategory> findItemSubCategoryThymeleafByCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct sc from SubCategory sc join sc.category c join sc.items i join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id=?1 and z.id=?2 and sc.status='ACTIVE'")
    List<SubCategory> findItemSubCategoryThymeleafByCategoryZone(String categoryId, String zoneId);

    /**
     * @param sellerId
     * @return
     */
    @Query("select distinct sc from SubCategory sc where sc.category.id=?1")
    List<SubCategory> findSubCategoryByCategory(String categoryId);

    /**
     * @param sellerId
     * @return
     */
    @Query("select distinct sc from SubCategory sc join sc.items i join i.sellerItems si join si.sellerBranch sb join sb.seller s where s.id=?1")
    List<SubCategory> findSubCategoryBySeller(String sellerId);

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("select distinct sc from SubCategory sc join sc.items i join i.sellerItems si join si.sellerBranch sb where sb.id=?1")
    List<SubCategory> findSubCategoryBySellerBranch(String sellerBranchId);

    /**
     * @return
     */
    @Query("select MAX(subCategoryCount) from SubCategory sc")
    Integer getMaxCode();

    /**
     * @param searchTerm
     * @return
     */
    @Query("select distinct sc from SubCategory sc join sc.items i join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where sc.status='ACTIVE' and LOWER(sc.subCategoryName) like LOWER(CONCAT('%',?2,'%')) and z.id=?1")
    List<SubCategory> splitSearchTermAndRemoveIgnoredCharactersDCCN(String zoneId, String searchTerm);

    /**
     * @param searchTerm
     * @return
     */
    @Query("select distinct sc from SubCategory sc where sc.status='ACTIVE' and LOWER(sc.subCategoryName) like LOWER(CONCAT('%',?1,'%'))")
    List<SubCategory> splitSearchTermAndRemoveIgnoredCharactersDCCNWithOutZone(String searchTerm);

}
