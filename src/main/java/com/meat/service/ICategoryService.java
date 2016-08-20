/**

 *
 */
package com.meat.service;

import com.meat.domain.*;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICategoryService {

    Category addCategoryAttributes(Category category, List<CategoryAttributes> catAttributes);

    /**
     * @param category
     * @param catCriteria
     * @return
     */
    Category addCategoryCriteria(Category category, List<CategoryCriteria> catCriteria);

    /**
     * @param category
     * @param catImages
     * @return
     */
    Category addCategoryImages(Category category, List<CategoryImages> catImages);

    /**
     * @param category
     * @param catTags
     * @return
     */
    Category addCategoryTags(Category category, List<CategoryTags> catTags);

    /**
     * @param category
     * @param categoryCutTypes
     * @return
     */
    Category addCutTypes(Category category, List<CategoryCutType> categoryCutTypes);

    /**
     * @param category
     * @param categoryOffers
     * @return
     */

    Category create(Category category);

    void deleteCategory(String categoryId);

    List<Category> getAll();

    /**
     * @param sellerId
     * @return
     */
    List<Category> getCategoriesOnlyBySeller(String sellerId);

    /**
     * @param sellerBranchId
     * @return
     */
    List<Category> getCategoriesOnlyBySellerBranch(String sellerBranchId);

    Category getCategory(String categoryId);

    List<Category> getCategoryOnly();

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param zoneId
     * @param searchTerm
     * @return
     */
    List<Category> getSearchItemCategoryByZoneOnly(String zoneId, String searchTerm);

    /**
     * @param searchTerm
     * @return
     */
    List<Category> getSearchItemCategoryOnly(String searchTerm);

    /**
     * @param categoryId
     * @return
     */
    List<Category> getSubCategoriesAndCatAttributes(String categoryId);

    Category updateCategory(Category category);

}
