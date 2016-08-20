package com.meat.service;

import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryAttributes;
import com.meat.domain.SubCategoryImages;
import com.meat.domain.SubCategoryTags;

import java.util.List;

public interface ISubCategoryService {

    /**
     * @param subCategory
     * @param subCatAttributes
     * @return
     */
    SubCategory addSubCategoryAttributes(SubCategory subCategory, List<SubCategoryAttributes> subCatAttributes);

    SubCategory addSubCategoryImages(SubCategory subCategory, List<SubCategoryImages> subCategoryImages);

    SubCategory addSubCategoryTags(SubCategory subCategory, List<SubCategoryTags> subCategoryTags);

    SubCategory create(SubCategory subCategory);

    void deleteSubCategory(String subCategoryId);

    List<SubCategory> getAll();

    /**
     * @param categoryId
     * @return
     */
    /*  List<SubCategory> getByCategoryId(Object categoryId);*/

    /**
     * @param categoryId
     * @return
     */
    List<SubCategory> getAllSubCategoryByCategoryId(String categoryId);

    /**
     * @param categoryId
     * @return
     */
    List<SubCategory> getByCategoryId(String categoryId);

    /**
     * @param categoryId
     * @return
     */
    List<SubCategory> getItemSubCategoriesByThymeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    List<SubCategory> getItemSubCategoriesByThymeleafCategoryZone(String categoryId, String zoneId);

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param zoneId
     * @param searchTerm
     * @return
     */
    List<SubCategory> getSearchItemSubCategoryByZoneOnly(String zoneId, String searchTerm);

    /**
     * @param searchTerm
     * @return
     */
    List<SubCategory> getSearchItemSubCategoryOnly(String searchTerm);

    SubCategory getSubCategory(String subCategoryId);

    /**
     * @param sellerId
     * @return
     */
    List<SubCategory> getSubCategoryByCategory(String sellerId);

    /**
     * @param sellerId
     * @return
     */
    List<SubCategory> getSubCategoryBySeller(String sellerId);

    /**
     * @param sellerBranchId
     * @return
     */
    List<SubCategory> getSubCategoryBySellerBranch(String sellerBranchId);

    /**
     * @return
     */
    List<SubCategory> getSubCategoryOnly();

    SubCategory updateSubCategory(SubCategory subCategory);

}
