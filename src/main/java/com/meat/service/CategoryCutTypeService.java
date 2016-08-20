/**
 *
 */
package com.meat.service;

import com.meat.dao.CategoryCutTypeRepository;
import com.meat.domain.CategoryCutType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class CategoryCutTypeService implements ICategoryCutTypeService {

    @Autowired
    private CategoryCutTypeRepository categoryCutTypeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCutTypeService#create(com.meat.domain.CategoryCutType)
     */
    @Override
    public CategoryCutType create(final CategoryCutType categoryCutType) {
        // TODO Auto-generated method stub
        return categoryCutTypeRepository.save(categoryCutType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCutTypeService#deleteCategoryCutType(java.lang.String)
     */
    @Override
    public void deleteCategoryCutType(final String categoryCutTypeId) {
        // TODO Auto-generated method stub
        CategoryCutType categoryCutType = new CategoryCutType();
        categoryCutType.setId(categoryCutTypeId);
        categoryCutTypeRepository.delete(categoryCutType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCutTypeService#getAll()
     */
    @Override
    public List<CategoryCutType> getAll() {
        // TODO Auto-generated method stub
        return (List<CategoryCutType>) categoryCutTypeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCutTypeService#getCategoryCutType(java.lang.String)
     */
    @Override
    public CategoryCutType getCategoryCutType(final String categoryCutTypeId) {
        // TODO Auto-generated method stub
        return categoryCutTypeRepository.findOne(categoryCutTypeId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryCutTypeService#updateCategoryCutType(com.meat.domain.CategoryCutType)
     */
    @Override
    public CategoryCutType updateCategoryCutType(final CategoryCutType categoryCutType) {
        // TODO Auto-generated method stub
        return categoryCutTypeRepository.save(categoryCutType);
    }

}
