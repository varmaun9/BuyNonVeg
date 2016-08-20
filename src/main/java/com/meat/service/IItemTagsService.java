/**
 *
 */
package com.meat.service;

import com.meat.domain.ItemTags;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IItemTagsService {
    ItemTags create(ItemTags itemTags);

    void deleteItemTags(String itemTagsId);

    List<ItemTags> getAll();

    ItemTags getItemTags(String itemTagsId);

    ItemTags updateItemTags(ItemTags itemTags);

}
