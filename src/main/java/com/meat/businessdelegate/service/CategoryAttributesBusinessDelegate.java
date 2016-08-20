/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Attributes;
import com.meat.domain.Category;
import com.meat.domain.CategoryAttributes;
import com.meat.model.CategoryAttributesModel;
import com.meat.service.IAttributesService;
import com.meat.service.ICategoryAttributesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Varma
 *
 */
@Service
public class CategoryAttributesBusinessDelegate
        implements IBusinessDelegate<CategoryAttributesModel, CategoryAttributesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICategoryAttributesService categoryAttributesService;
    @Autowired
    private IAttributesService attributesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryAttributesModel create(final CategoryAttributesModel model) {
        CategoryAttributes categoryAttributes = new CategoryAttributes();
        categoryAttributes.setId(model.getId());
        Attributes attributes = attributesService.getAttributes(model.getAttributesId());
        attributes.setId(attributes.getId());
        categoryAttributes.setAttributes(attributes);
        categoryAttributes.setStatus(model.getStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryAttributes.setCategory(category);
        categoryAttributes.setAttributeValue(attributes.getAttributeName());
        categoryAttributes = categoryAttributesService.create(categoryAttributes);
        model.setId(categoryAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryAttributesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryAttributesModel edit(final IKeyBuilder<String> keyBuilder, final CategoryAttributesModel model) {
        CategoryAttributes categoryAttributes = categoryAttributesService.getCategoryAttributes(keyBuilder.build().toString());
        categoryAttributes.setId(model.getId());
        Attributes attributes = new Attributes();
        attributes.setId(model.getAttributesId());
        categoryAttributes.setAttributes(attributes);
        categoryAttributes.setStatus(model.getStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryAttributes.setCategory(category);
        categoryAttributes.setAttributeValue(model.getAttributeValue());
        categoryAttributes = categoryAttributesService.create(categoryAttributes);
        model.setId(categoryAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryAttributesModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryAttributesContext context) {
        CategoryAttributes categoryAttributes = categoryAttributesService.getCategoryAttributes(keyBuilder.build().toString());
        CategoryAttributesModel categoryAttributesModel = conversionService.convert(categoryAttributes, CategoryAttributesModel.class);
        return categoryAttributesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryAttributesModel> getCollection(final CategoryAttributesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
