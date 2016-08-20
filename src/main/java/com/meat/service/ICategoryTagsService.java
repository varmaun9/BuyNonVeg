/**
 *
 */
package com.meat.service;

import com.meat.domain.CategoryTags;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICategoryTagsService {

    CategoryTags create(CategoryTags categoryTags);

    void deleteCategoryTags(String categoryTagsId);

    List<CategoryTags> getAll();

    CategoryTags getCategoryTags(String categoryTagsId);

    CategoryTags updateCategoryTags(CategoryTags categoryTags);

}
