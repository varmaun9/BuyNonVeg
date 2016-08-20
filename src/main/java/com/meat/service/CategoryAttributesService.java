/**
 *
 */
package com.meat.service;

import com.meat.dao.CategoryAttributesRepository;
import com.meat.domain.CategoryAttributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class CategoryAttributesService implements ICategoryAttributesService {

    @Autowired
    private CategoryAttributesRepository categoryAttributesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryAttributesService#create(com.nonveg.domain.CategoryAttributes)
     */
    @Override
    public CategoryAttributes create(final CategoryAttributes categoryAttributes) {
        // TODO Auto-generated method stub
        return categoryAttributesRepository.save(categoryAttributes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryAttributesService#deleteCategoryAttributes(java.lang.String)
     */
    @Override
    public void deleteCategoryAttributes(final String categoryAttributesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryAttributesService#getAll()
     */
    @Override
    public List<CategoryAttributes> getAll() {
        // TODO Auto-generated method stub
        return (List<CategoryAttributes>) categoryAttributesRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryAttributesService#getCategoryAttributes(java.lang.String)
     */
    @Override
    public CategoryAttributes getCategoryAttributes(final String categoryAttributesId) {
        // TODO Auto-generated method stub
        return categoryAttributesRepository.findOne(categoryAttributesId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryAttributesService#updateCategoryAttributes(com.nonveg.domain.CategoryAttributes)
     */
    @Override
    public CategoryAttributes updateCategoryAttributes(final CategoryAttributes categoryAttributes) {
        // TODO Auto-generated method stub
        return categoryAttributesRepository.save(categoryAttributes);
    }
}
