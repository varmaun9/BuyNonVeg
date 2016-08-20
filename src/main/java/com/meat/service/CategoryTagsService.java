/**
 *
 */
package com.meat.service;

import com.meat.dao.CategoryTagsRepository;
import com.meat.domain.CategoryTags;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class CategoryTagsService implements ICategoryTagsService {
    @Autowired
    private CategoryTagsRepository categoryTagsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryTagsService#create(com.ruhungry.domain.CategoryTags)
     */
    @Override
    public CategoryTags create(final CategoryTags categoryTags) {
        // TODO Auto-generated method stub
        return categoryTagsRepository.save(categoryTags);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryTagsService#deleteCategoryTags(java.lang.String)
     */
    @Override
    public void deleteCategoryTags(final String categoryTagsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryTagsService#getAll()
     */
    @Override
    public List<CategoryTags> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryTagsService#getCategoryTags(java.lang.String)
     */
    @Override
    public CategoryTags getCategoryTags(final String categoryTagsId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryTagsService#updateCategoryTags(com.ruhungry.domain.CategoryTags)
     */
    @Override
    public CategoryTags updateCategoryTags(final CategoryTags categoryTags) {
        // TODO Auto-generated method stub
        return categoryTagsRepository.save(categoryTags);
    }

}
