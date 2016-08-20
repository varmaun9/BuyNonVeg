/**
 *
 */
package com.meat.service;

import com.meat.domain.CategoryAttributes;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICategoryAttributesService {

    CategoryAttributes create(CategoryAttributes categoryAttributes);

    void deleteCategoryAttributes(String categoryAttributesId);

    List<CategoryAttributes> getAll();

    CategoryAttributes getCategoryAttributes(String categoryAttributesId);

    CategoryAttributes updateCategoryAttributes(CategoryAttributes categoryAttributes);

}
