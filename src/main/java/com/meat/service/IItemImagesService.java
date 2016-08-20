/**
 *
 */
package com.meat.service;

import com.meat.domain.ItemImages;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IItemImagesService {
    ItemImages create(ItemImages itemImages);

    void deleteItemImages(String itemImagesId);

    List<ItemImages> getAll();

    ItemImages getItemImages(String itemImagesId);

    /**
     * @param itemId
     * @return
     */
    List<ItemImages> getItemImagesByItem(String itemId);

    ItemImages updateItemImages(ItemImages itemImages);

}
