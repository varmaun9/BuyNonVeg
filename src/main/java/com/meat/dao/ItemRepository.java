/**
 *
 */
package com.meat.dao;

import com.meat.domain.Item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi1
 *
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Serializable> {

    /**
     * @return
     */
    @Query("select distinct i from Item i where i.status='ACTIVE'")
    List<Item> findByAll();

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c  where c.id IN ?1 and i.status='ACTIVE'")
    List<Item> findCategoryFilterThymeleafPageRCPrice(List<String> category, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si where c.id IN ?1 and si.sellingPrice between (?2) and (?3) and i.status='ACTIVE'")
    List<Item> findCategoryFilterThymeleafPageRCPriceRange(List<String> category, BigDecimal spf, BigDecimal epf, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join i.itemAttributeses ita where c.id IN ?1 and ita.attributes.id IN ?2 and ita.attributeValue IN ?3 and si.sellingPrice between (?4) and (?5) and i.status='ACTIVE'")
    List<Item> findCategoryItemAttributesFilterThymeleafPageRCPriceByPriceRange(List<String> category, List<String> attributes,
            List<String> attributeValues, BigDecimal spf, BigDecimal epf, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join i.itemAttributeses ita where c.id IN ?1 and sc.id =?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4 and si.sellingPrice between (?5) and (?6) and i.status='ACTIVE'")
    List<Item> findCategorySubCategoryItemAttributesFilterThymeleafPageRCPriceRange(List<String> category, List<String> subCategory,
            List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf, PageRequest request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.sellerItems si join i.itemAttributeses ita where c.id IN ?1 and t.id=?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4 and si.sellingPrice between (?5) and (?6) and i.status='ACTIVE'")
    List<Item> findCategoryTagItemAttributesFilterThymeleafPageRCPriceRange(List<String> category, List<String> tag,
            List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf, PageRequest request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.sellerItems si join i.itemAttributeses ita where c.id IN ?1 and t.id=?2 and sc.id =?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5 and si.sellingPrice between (?6) and (?7) and i.status='ACTIVE'")
    List<Item> findCategoryTagItemAttributesSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, List<String> tag,
            List<String> subCategory, List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf,
            PageRequest request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.sellerItems si  where c.id IN ?1 and t.id=?2 and sc.id=?3 and si.sellingPrice between (?4) and (?5) and i.status='ACTIVE'")
    List<Item> findCategoryTagSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, List<String> tag, List<String> subCategory,
            BigDecimal spf, BigDecimal epf, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and ita.attributes.id IN ?2 and ita.attributeValue IN ?3")
    List<Item> findCategoryWithItemAttributesFilterThymeleafPageRCPrice(List<String> category, List<String> attributes,
            List<String> attributeValues, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t where i.status='ACTIVE' and c.id IN ?1  and t.id IN ?2 and sc.id=?3")
    List<Item> findCategoryWithSubCategoryAndTagFilterThymeleafPageRCPrice(List<String> category, List<String> tag,
            List<String> subCategory, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c where i.status='ACTIVE' and c.id IN ?1 and sc.id IN ?2")
    List<Item> findCategoryWithSubCategoryFilterThymeleafPageRCPrice(List<String> category, List<String> subCategory, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si where c.id IN ?1 and sc.id IN ?2 and si.sellingPrice between (?3) and (?4) and i.status='ACTIVE'")
    List<Item> findCategoryWithSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, List<String> subCategory, BigDecimal spf,
            BigDecimal epf, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and sc.id IN ?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4")
    List<Item> findCategoryWithSubCategoryItemAttributesFilterThymeleafPageRCPrice(List<String> category, List<String> subCategory,
            List<String> attributes, List<String> attributeValues, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1  and t.id IN ?2 and sc.id=?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5")
    List<Item> findCategoryWithSubCategoryTagITemAttributesFilterThymeleafPageRCPrice(List<String> category, List<String> tag,
            List<String> subCategory, List<String> attributes, List<String> attributeValues, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and t.id IN ?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4")
    List<Item> findCategoryWithTagAndItemAttributesFilterThymeleafPageRCPrice(List<String> category, List<String> tag,
            List<String> attributes, List<String> attributeValues, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t where i.status='ACTIVE' and c.id IN ?1  and t.id IN ?2")
    List<Item> findCategoryWithTagFilterThymeleafPageRCPrice(List<String> category, List<String> tag, Pageable request);

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join i.itemTagses it join it.tags t where c.id IN ?1 and t.id IN ?2 and si.sellingPrice between (?3) and (?4) and i.status='ACTIVE'")
    List<Item> findCategoryWithTagFilterThymeleafPageRCPriceRange(List<String> category, List<String> tag, BigDecimal spf, BigDecimal epf,
            Pageable request);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where z.id=?1 and c.id=?2 and i.status='ACTIVE'")
    List<Item> findItemByCategoryAndZoneThymeleaf(String zoneId, String categoryId);

    /**
     * @param categoryId
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc where sc.category.id=?1 and i.status='ACTIVE'")
    List<Item> findItemByCategoryId(String categoryId);

    /**
     * @param subCategoryId
     * @return
     */
    @Query("select distinct i from Item i where i.subCategory.id=?1 and i.status='ACTIVE'")
    List<Item> findItemBySubCategoryId(String subCategoryId);

    /**
     * @param categoryId
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.sellerItems si join i.subCategory sc join sc.category c where c.id=?1 and i.status='ACTIVE' order by si.sellingPrice ASC")
    List<Item> findItemByThymeleafCategory(String categoryId, Pageable request);

    /**
     * @param categoryId
     * @param zoneId
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id=?1 and z.id=?2 and i.status='ACTIVE' order by si.sellingPrice ASC")
    @OrderBy("itemName DESC")
    List<Item> findItemByThymeleafCategoryZone(String categoryId, String zoneId, Pageable request);

    /**
     * @param attributeValue
     * @param categoryId
     * @param zoneId
     * @return
     */
    @Query("select distinct COUNT(i) from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita where ita.attributeValue=?1 and c.id=?2 and z.id=?3")
    int findItemCountByThymeleafCategoryZoneAttributeValue(String attributeValue, String categoryId, String zoneId);

    /**
     * @param itemId
     * @return
     */
    @Query("select i from Item i where i.id=?1")
    List<Item> findItemWithOutSellerItem(String itemId);

    /**
     * @param category
     * @param zone
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id IN ?1 and z.id=?2 and i.status='ACTIVE'")
    @OrderBy("itemName DESC")
    List<Item> findZoneCategoryFilterThymeleafPageRCPrice(List<String> category, String zone, Pageable request);

    /**
     * @param category
     * @param zone
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id IN ?1 and z.id=?2 and si.sellingPrice between (?3) and (?4) and i.status='ACTIVE'")
    @OrderBy("itemName DESC")
    List<Item> findZoneCategoryFilterThymeleafPageRCPriceRange(List<String> category, String zone, BigDecimal spf, BigDecimal epf,
            Pageable request);

    /**
     * @param category
     * @param zone
     * @param itemAttributes
     * @param spf
     * @param epf
     * @param request
     * @return
     */

    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita where c.id IN ?1 and z.id=?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4 and si.sellingPrice between (?5) and (?6) and i.status='ACTIVE'")
    @OrderBy("itemName DESC")
    List<Item> findZoneCategoryItemAttributesFilterThymeleafPageRCPriceByPriceRange(List<String> category, String zone,
            List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf, Pageable request);

    /**
     * @param category
     * @param zone
     * @param subCategory
     * @param itemAttributes
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita where c.id IN ?1 and z.id=?2 and sc.id IN ?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5 and si.sellingPrice between (?6) and (?7) and i.status='ACTIVE'")
    @OrderBy("itemName DESC")
    List<Item> findZoneCategorySubCategoryItemAttributesFilterThymeleafPageRCPriceRange(List<String> category, String zone,
            List<String> subCategory, List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf,
            Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param itemAttributes
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemTagses it join it.tags t join i.itemAttributeses ita where c.id IN ?1 and z.id=?2 and t.id IN ?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5 and si.sellingPrice between (?6) and (?7) and i.status='ACTIVE'")
    List<Item> findZoneCategoryTagItemAttributesFilterThymeleafPageRCPriceRange(List<String> category, String zone, List<String> tag,
            List<String> attributes, List<String> attributeValues, BigDecimal spf, BigDecimal epf, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param subCategory
     * @param itemAttributes
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemTagses it join it.tags t join i.itemAttributeses ita where c.id IN ?1 and z.id IN ?2 and  t.id IN ?3 and sc.id IN ?4  and ita.attributes.id IN ?5 and ita.attributeValue IN ?6 and si.sellingPrice between (?7) and (?8) and i.status='ACTIVE'")
    List<Item> findZoneCategoryTagItemAttributesSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, String zone,
            List<String> tag, List<String> subCategory, List<String> attributes, List<String> attributeValues, BigDecimal spf,
            BigDecimal epf, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param subCategory
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id IN ?1 and z.id=?2 and t.id IN ?3 and sc.id IN ?4 and si.sellingPrice between (?5) and (?6) and i.status='ACTIVE'")
    List<Item> findZoneCategoryTagSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, String zone, List<String> tag,
            List<String> subCategory, BigDecimal spf, BigDecimal epf, Pageable request);

    /**
     * @param category
     * @param zone
     * @param itemAttributes
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and ita.attributes.id IN ?3 and ita.attributeValue IN ?4")
    List<Item> findZoneCategoryWithItemAttributesFilterThymeleafPageRCPrice(List<String> category, String zone, List<String> attributes,
            List<String> attributeValues, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param subCategory
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.itemTagses it join it.tags t join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and t.id IN ?3 and sc.id=?4")
    List<Item> findZoneCategoryWithSubCategoryAndTagFilterThymeleafPageRCPrice(List<String> category, String zone, List<String> tag,
            List<String> subCategory, Pageable request);

    /**
     * @param category
     * @param zone
     * @param subCategory
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where i.status='ACTIVE' and c.id IN ?1 and z.id = ?2 and sc.id IN ?3")
    List<Item> findZoneCategoryWithSubCategoryFilterThymeleafPageRCPrice(List<String> category, String zone, List<String> subCategory,
            Pageable request);

    /**
     * @param category
     * @param zone
     * @param subCategory
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where c.id IN ?1 and z.id = ?2 and sc.id IN ?3 and si.sellingPrice between (?4) and (?5) and i.status='ACTIVE'")
    List<Item> findZoneCategoryWithSubCategoryFilterThymeleafPageRCPriceRange(List<String> category, String zone, List<String> subCategory,
            BigDecimal spf, BigDecimal epf, Pageable request);

    /**
     * @param category
     * @param zone
     * @param subCategory
     * @param itemAttributes
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and sc.id IN ?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5")
    List<Item> findZoneCategoryWithSubCategoryItemAttributesFilterThymeleafPageRCPrice(List<String> category, String zone,
            List<String> subCategory, List<String> attributes, List<String> attributeValues, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param subCategory
     * @param itemAttributes
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemTagses it join it.tags t join i.itemAttributeses ita where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and t.id IN ?3 and sc.id IN ?4 and ita.attributes.id IN ?5 and ita.attributeValue IN ?6")
    List<Item> findZoneCategoryWithSubCategoryTagITemAttributesFilterThymeleafPageRCPrice(List<String> category, String zone,
            List<String> tag, List<String> subCategory, List<String> attributes, List<String> attributeValues, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param itemAttributes
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemAttributeses ita join i.itemTagses it join it.tags t where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and t.id IN ?3 and ita.attributes.id IN ?4 and ita.attributeValue IN ?5")
    List<Item> findZoneCategoryWithTagAndItemAttributesFilterThymeleafPageRCPrice(List<String> category, String zone, List<String> tag,
            List<String> attributes, List<String> attributeValues, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemTagses it join it.tags t where i.status='ACTIVE' and c.id IN ?1 and z.id=?2 and t.id IN ?3")
    List<Item> findZoneCategoryWithTagFilterThymeleafPageRCPrice(List<String> category, String zone, List<String> tag, Pageable request);

    /**
     * @param category
     * @param zone
     * @param tag
     * @param spf
     * @param epf
     * @param request
     * @return
     */
    @Query("select distinct i from Item i join i.subCategory sc join sc.category c join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z join i.itemTagses it join it.tags t where c.id IN ?1 and z.id=?2 and t.id IN ?3 and si.sellingPrice between (?4) and (?5) and i.status='ACTIVE'")
    List<Item> findZoneCategoryWithTagFilterThymeleafPageRCPriceRange(List<String> category, String zone, List<String> tag, BigDecimal spf,
            BigDecimal epf, Pageable request);

    /**
     * @param id
     * @return
     */
    @Query("select distinct COUNT(i) from Item i join i.subCategory sc where i.status='ACTIVE' and sc.id=?1")
    int getItemCountBySubCategory(String id);

    /*@Query("select i from Item i")
    List<Item> findAllItems();
     */
    /**
     * @return
     */
    @Query("select MAX(itemCount) from Item i")
    Integer getMaxCode();

    /**
     * @param subCategoryId
     * @param zoneId
     * @param request
     * @return
     */
    @Query("SELECT DISTINCT i FROM Item i JOIN i.subCategory sc JOIN i.sellerItems si JOIN si.sellerBranch sb JOIN sb.sellerBranchZones sbz JOIN sbz.zone z WHERE sc.id=?1 AND z.id=?2 AND i.status='ACTIVE'")
    List<Item> getSubCategoryItems(String subCategoryId, String zoneId, Pageable request);

    /**
     * @param zoneId
     * @param id
     * @return
     */

    @Query("select distinct COUNT(i) from Item i join i.subCategory sc join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join  sbz.zone z where i.status='ACTIVE' and z.id=?1 and sc.id=?2")
    int getZoneItemCountBySubCategory(String zoneId, String id);

    /**
     * @param zoneId
     * @param searchTerm
     * @return
     */
    //@Query("select distinct  ri from RestaurantItem ri join ri.item i join ri.restaurantBranch rb join rb.restaurantBranchZones rbz  where ri.itemAvailableStatus='Active' and LOWER(ri.restaurantItemName) like LOWER(CONCAT('%',?2, '%')) and rbz.zone.id IN(select z from Zone z join z.companyBranches cb join cb.users u where u.id=?1)")
    @Query("select distinct i from Item i join i.sellerItems si join si.sellerBranch sb join sb.sellerBranchZones sbz join sbz.zone z where i.status='ACTIVE' and LOWER(i.itemName) like LOWER(CONCAT('%',?2,'%')) and z.id=?1")
    List<Item> splitSearchTermAndRemoveIgnoredCharactersDCCNByZone(String zoneId, String searchTerm, Pageable page);

    /**
     * @param searchTerm
     * @return
     */
    @Query("select distinct i from Item i where i.status='ACTIVE' and LOWER(i.itemName) like LOWER(CONCAT('%',?1,'%'))")
    List<Item> splitSearchTermAndRemoveIgnoredCharactersDCCNWithOutZone(String searchTerm);

    /**
     * @param searchTermArray
     * @return
     */
    @Query("select distinct i from Item i where i.status='ACTIVE' and LOWER(i.itemName) like LOWER(CONCAT('%',?1,'%'))")
    List<Item> splitSearchTermAndRemoveIgnoredCharactersDCCNWithOutZone(String[] searchTermArray);

}
