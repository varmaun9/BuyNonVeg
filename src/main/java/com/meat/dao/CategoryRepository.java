/**
 *
 */
package com.meat.dao;

import com.meat.domain.Category;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Serializable> {

    @Query("select c from Category c where c.status='ACTIVE'")
    List<Category> findByAll();

    /* *//**
          * @param sellerItemId
          * @return
          *//*
           @Query("SELECT DISTINCT c FROM Category c JOIN c.subCategories sc JOIN sc.items i JOIN i.sellerItems si WHERE si.id=?1")
           Category findBySellerItem(String sellerItemId);
           */

    /**
     * @param sellerId
     * @return (
     */
    @Query("select distinct c from Category c join c.subCategories sc join sc.items it join it.sellerItems sit join sit.sellerBranch sb join sb.seller s where s.id=?1")
    List<Category> findCategoriesOnlyBySeller(String sellerId);

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("select distinct c from Category c join c.subCategories sc join sc.items i join i.sellerItems si join si.sellerBranch sb where sb.id=?1")
    List<Category> findCategoriesOnlyBySellerBranch(String sellerBranchId);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct c from Category c where c.id=?1")
    List<Category> findSubCategoriesAndCatAttributes(String categoryId);

    /**
     * @return
     */
    @Query("select MAX(categoryCount) from Category c")
    Integer getMaxCode();

}
