/**
 *
 */
package com.meat.service;

import com.meat.domain.CategoryCutType;

import java.util.List;

/**
 * @author varma
 *
 */
public interface ICategoryCutTypeService {

    CategoryCutType create(CategoryCutType categoryCutType);

    void deleteCategoryCutType(String categoryCutTypeId);

    List<CategoryCutType> getAll();

    CategoryCutType getCategoryCutType(String categoryCutTypeId);

    CategoryCutType updateCategoryCutType(CategoryCutType categoryCutType);
}
