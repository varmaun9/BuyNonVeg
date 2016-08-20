package com.meat.dao;

import com.meat.domain.CutType;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CutTypeRepository extends PagingAndSortingRepository<CutType, Serializable> {

    /**
     * @param categoryId
     * @return
     */
    @Query("SELECT DISTINCT ct FROM CutType ct JOIN ct.categoryCutTypes cct WHERE cct.category.id=?1")
    List<CutType> findByCategory(String categoryId);

    /**
     * @param itemId
     * @return
     */
    @Query("SELECT DISTINCT ct FROM CutType ct JOIN ct.categoryCutTypes cct JOIN cct.category c JOIN c.subCategories sc JOIN sc.items i WHERE i.id=?1")
    List<CutType> findByItem(String itemId);

    /**
     * @param sellerItemId
     * @return
     */
    @Query("SELECT DISTINCT ct FROM CutType ct JOIN ct.categoryCutTypes cct JOIN cct.category c JOIN c.subCategories sc JOIN sc.items i JOIN i.sellerItems si WHERE si.id=?1")
    List<CutType> findBySellerItemId(String sellerItemId);

}
