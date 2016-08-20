/**
 *
 */
package com.meat.service;

import com.meat.domain.ItemAttributes;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IItemAttributesService {
    ItemAttributes create(ItemAttributes itemAttributes);

    void deleteItemAttributes(String itemAttributesId);

    List<ItemAttributes> getAll();

    ItemAttributes getItemAttributes(String itemAttributesId);

    /**
     * @param categoryId
     * @return
     */
    List<ItemAttributes> getItemAttributesByThymeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    List<ItemAttributes> getItemAttributesByThymeleafCategoryZone(String categoryId, String zoneId);

    ItemAttributes updateItemAttributes(ItemAttributes itemAttributes);

}
