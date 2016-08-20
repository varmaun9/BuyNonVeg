/**
 *
 */
package com.meat.service;

import com.meat.domain.CategoryImages;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICategoryImagesService {

    CategoryImages create(CategoryImages categoryImages);

    void deleteCategoryImages(String categoryImagesId);

    List<CategoryImages> getAll();

    CategoryImages getCategoryImages(String categoryImagesId);

    CategoryImages updateCategoryImages(CategoryImages categoryImages);

}
