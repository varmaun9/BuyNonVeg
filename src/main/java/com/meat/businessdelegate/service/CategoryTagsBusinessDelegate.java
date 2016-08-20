/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Category;
import com.meat.domain.CategoryTags;
import com.meat.domain.Tags;
import com.meat.model.CategoryTagsModel;
import com.meat.service.ICategoryTagsService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CategoryTagsBusinessDelegate implements IBusinessDelegate<CategoryTagsModel, CategoryTagsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICategoryTagsService categoryTagsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryTagsModel create(final CategoryTagsModel model) {
        CategoryTags categoryTags = new CategoryTags();
        categoryTags.setId(model.getId());
        categoryTags.setCategoryTagsStatus(model.getCategoryTagsStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryTags.setCategory(category);
        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        categoryTags.setTags(tags);
        categoryTags = categoryTagsService.create(categoryTags);
        model.setId(categoryTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryTagsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryTagsModel edit(final IKeyBuilder<String> keyBuilder, final CategoryTagsModel model) {
        CategoryTags categoryTags = categoryTagsService.getCategoryTags(keyBuilder.build().toString());
        categoryTags.setId(model.getId());
        categoryTags.setCategoryTagsStatus(model.getCategoryTagsStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryTags.setCategory(category);
        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        categoryTags.setTags(tags);
        categoryTags = categoryTagsService.updateCategoryTags(categoryTags);
        model.setId(categoryTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryTagsModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryTagsContext context) {
        CategoryTags categoryTags = categoryTagsService.getCategoryTags(keyBuilder.build().toString());
        CategoryTagsModel categoryTagsModel = conversionService.convert(categoryTags, CategoryTagsModel.class);
        return categoryTagsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryTagsModel> getCollection(final CategoryTagsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
