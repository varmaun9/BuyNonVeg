/**
 *
 */
package com.meat.dao;

import com.meat.domain.ItemImages;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface ItemImagesRepository extends PagingAndSortingRepository<ItemImages, Serializable> {

    /**
     * @param itemId
     * @return
     */
    @Query("SELECT DISTINCT itImgs from ItemImages itImgs where itImgs.item.id=?1")
    List<ItemImages> findItemImagesByItem(String itemId);

}
