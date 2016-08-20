/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Category;
import com.meat.domain.CategoryImages;
import com.meat.model.CategoryImagesModel;
import com.meat.service.ICategoryImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class CategoryImagesBusinessDelegate implements
        IBusinessDelegate<CategoryImagesModel, CategoryImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ICategoryImagesService categoryImagesService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryImagesModel create(final CategoryImagesModel model) {
        CategoryImages categoryImages = new CategoryImages();
        categoryImages.setId(model.getId());
        categoryImages.setImageName(model.getImageName());
        categoryImages.setImageLocation(model.getImageLocation());
        categoryImages.setImageType(model.getImageType());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryImages.setCategory(category);
        categoryImages = categoryImagesService.create(categoryImages);
        model.setId(categoryImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryImagesModel edit(final IKeyBuilder<String> keyBuilder, final CategoryImagesModel model) {
        // TODO Auto-generated method stub
        CategoryImages categoryImages = categoryImagesService.getCategoryImages(keyBuilder.build().toString());
        categoryImages.setId(model.getId());
        categoryImages.setImageName(model.getImageName());
        categoryImages.setImageLocation(model.getImageLocation());
        categoryImages.setImageType(model.getImageType());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryImages.setCategory(category);
        categoryImages = categoryImagesService.updateCategoryImages(categoryImages);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryImagesContext context) {
        CategoryImages categoryImages = categoryImagesService.getCategoryImages(keyBuilder.build().toString());
        CategoryImagesModel categoryImagesModel = conversionService.convert(categoryImages, CategoryImagesModel.class);
        return categoryImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryImagesModel> getCollection(final CategoryImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
