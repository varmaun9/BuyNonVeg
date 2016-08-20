/**
 *
 */
package com.meat.service;

import com.meat.dao.CategoryImagesRepository;
import com.meat.domain.CategoryImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class CategoryImagesSerivce implements ICategoryImagesService {
    @Autowired
    private CategoryImagesRepository categoryImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryImagesService#create(com.nonveg.domain.CategoryImages)
     */
    @Override
    public CategoryImages create(final CategoryImages categoryImages) {
        // TODO Auto-generated method stub
        return categoryImagesRepository.save(categoryImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryImagesService#deleteCategoryImages(java.lang.String)
     */
    @Override
    public void deleteCategoryImages(final String categoryImagesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryImagesService#getAll()
     */
    @Override
    public List<CategoryImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryImagesService#getCategoryImages(java.lang.String)
     */
    @Override
    public CategoryImages getCategoryImages(final String categoryImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryImagesService#updateCategoryImages(com.nonveg.domain.CategoryImages)
     */
    @Override
    public CategoryImages updateCategoryImages(final CategoryImages categoryImages) {
        // TODO Auto-generated method stub
        return categoryImagesRepository.save(categoryImages);
    }

}
