/**
 *
 */
package com.meat.service;

import com.meat.domain.*;

import java.util.List;
import java.util.Set;

/**
 * @author arthvedi1
 *
 */
public interface IItemService {

    /**
     * @param item
     * @param itemAttribute
     * @return
     */

    /**
     * @param item
     * @param itemAttribute
     * @return
     */
    Item addItemAttributes(Item item, List<ItemAttributes> itemAttribute);

    Item addItemImages(Item item, List<ItemImages> itemImages);

    /**
     * @param item
     * @param itemTagses
     * @return
     */
    Item addItemTags(Item item, List<ItemTags> itemTagses);

    /**
     * @param item
     * @param sellerItems
     * @return
     */
    Item addSellerItems(Item item, Set<SellerItem> sellerItems);

    /**
     * @param item
     * @param itemImage
     * @return
     */

    Item create(Item item);

    void deleteItem(String itemId);

    List<Item> getAll();

    /**
     * @param categoryId
     * @param zoneId
     * @param page
     * @param pageSize
     * @return
     */

    List<Item> getCategoriesItemPagesByThemeleaf(String categoryId, String zoneId);

    /**
     * @param cat
     * @param zoneId
     * @param subCategoryId
     * @param tagId
     * @param attributesId
     * @param attributeValue
     * @param sp
     * @param ep
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<Item> getCategoryItemPriceFilterThymeleafPageAll(String[] cat, String zoneId, String[] subCategoryId, String[] tagId,
            String[] attributesId, String[] attributeValue, String sp, String ep, int page, int pageSize, String sort, String type);

    /**
     * @return
     */

    Item getItem(String itemId);

    /**
     * @param categoryId
     * @return
     */
    List<Item> getItemByCategoryId(String categoryId);

    /**
     * @param categoryId
     * @return
     */
    List<Item> getItemByCategoryItemOnly(String categoryId);

    /**
     * @param subCategoryId
     * @return
     */
    List<Item> getItemBySubCategoryId(String subCategoryId);

    /**
     * @param itemId
     * @return
     */
    Item getItemByThymeleafWithSellerItem(String itemId);

    /**
     * @param zoneId
     * @param categoryId
     * @return
     */
    List<Item> getItemByZoneAndCategory(String zoneId, String categoryId);

    /**
     * @return
     */
    List<Item> getItemOnly();

    /**
     * @param categoryId
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<Item> getItemsByThymeleafCategory(String categoryId, int page, int pageSize, String sort, String type);

    /**
     * @param categoryId
     * @param zoneId
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<Item> getItemsByThymeleafCategoryZone(String categoryId, String zoneId, int page, int pageSize, String sort, String type);

    /**
     * @param cat
     * @param subCategoryId
     * @param tagId
     * @param attributesId
     * @param attributeValue
     * @param sp
     * @param ep
     * @param page
     * @param pageSize
     * @param sort
     * @param type
     * @return
     */
    List<Item> getItemsByThymeleafPageAllCategory(String[] cat, String[] subCategoryId, String[] tagId, String[] attributesId,
            String[] attributeValue, String sp, String ep, int page, int pageSize, String sort, String type);

    /**
     * @param itemId
     * @return
     */
    List<Item> getItemWithOutSellerItem(String itemId);

    /**
     * @param itemId
     * @return
     */
    List<Item> getItemWithSellerItem(String itemId);

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param zoneId
     * @param searchTerm
     * @param itemsCount
     * @return
     */
    List<Item> getSearchItemsByZoneOnly(String zoneId, String searchTerm, int itemsCount);

    /**
     * @param searchTerm
     * @return
     */
    List<Item> getSearchItemsOnly(String searchTerm);

    /**
     * @param searchTerm
     * @param itemsCount
     * @return
     */
    List<Item> getSearchItemsOnly(String searchTerm, int itemsCount);

    /**
     * @param id
     * @param zoneId
     * @param p
     * @param pz
     * @return
     */
    List<Item> getSubCatRelativeRelativeItemsPage(String id, String zoneId, int p, int pz);

    Item updateItem(Item item);

    /**
     * @param item
     * @param itemImage
     * @return
     */

}
