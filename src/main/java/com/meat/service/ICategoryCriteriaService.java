/**
 *
 */
package com.meat.service;

import com.meat.domain.CategoryCriteria;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICategoryCriteriaService {

    CategoryCriteria create(CategoryCriteria categoryCriteria);

    void deleteCategoryCriteria(String categoryCriteriaId);

    List<CategoryCriteria> getAll();

    CategoryCriteria getCategoryCriteria(String categoryCriteriaId);

    CategoryCriteria updateCategoryCriteria(CategoryCriteria categoryCriteria);

}
