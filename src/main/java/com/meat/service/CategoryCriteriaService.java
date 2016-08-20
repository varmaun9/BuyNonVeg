/**
 *
 */
package com.meat.service;

import com.meat.dao.CategoryCriteriaRepository;
import com.meat.domain.CategoryCriteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class CategoryCriteriaService implements ICategoryCriteriaService {
    @Autowired
    private CategoryCriteriaRepository categoryCriteriaRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCriteriaService#create(com.meat.domain.CategoryCriteria)
     */
    @Override
    public CategoryCriteria create(final CategoryCriteria categoryCriteria) {
        // TODO Auto-generated method stub
        return categoryCriteriaRepository.save(categoryCriteria);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCriteriaService#deleteCategoryCriteria(java.lang.String)
     */
    @Override
    public void deleteCategoryCriteria(final String categoryCriteriaId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCriteriaService#getAll()
     */
    @Override
    public List<CategoryCriteria> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCriteriaService#getCategoryCriteria(java.lang.String)
     */
    @Override
    public CategoryCriteria getCategoryCriteria(final String categoryCriteriaId) {
        // TODO Auto-generated method stub
        return categoryCriteriaRepository.findOne(categoryCriteriaId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCriteriaService#updateCategoryCriteria(com.meat.domain.CategoryCriteria)
     */
    @Override
    public CategoryCriteria updateCategoryCriteria(final CategoryCriteria categoryCriteria) {
        // TODO Auto-generated method stub
        return categoryCriteriaRepository.save(categoryCriteria);
    }

}
