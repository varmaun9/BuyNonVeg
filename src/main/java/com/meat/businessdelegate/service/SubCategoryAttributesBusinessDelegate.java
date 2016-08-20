/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Attributes;
import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryAttributes;
import com.meat.model.SubCategoryAttributesModel;
import com.meat.service.ISubCategoryAttributesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */

@Service
public class SubCategoryAttributesBusinessDelegate implements
        IBusinessDelegate<SubCategoryAttributesModel, SubCategoryAttributesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubCategoryAttributesService subCategoryAttributesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryAttributesModel create(final SubCategoryAttributesModel model) {
        SubCategoryAttributes subCategoryAttributes = new SubCategoryAttributes();
        subCategoryAttributes.setId(model.getId());
        subCategoryAttributes.setAttributeValue(model.getAttributeValue());
        subCategoryAttributes.setStatus(model.getStatus());
        Attributes attributes = new Attributes();
        attributes.setId(model.getAttributesId());
        subCategoryAttributes.setAttributes(attributes);

        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryAttributes.setSubCategory(subCategory);
        subCategoryAttributes = subCategoryAttributesService.create(subCategoryAttributes);
        model.setId(subCategoryAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubCategoryAttributesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryAttributesModel edit(final IKeyBuilder<String> keyBuilder, final SubCategoryAttributesModel model) {
        SubCategoryAttributes subCategoryAttributes = subCategoryAttributesService.getSubCategoryAttributes(keyBuilder.build().toString());
        subCategoryAttributes.setId(model.getId());
        subCategoryAttributes.setAttributeValue(model.getAttributeValue());
        subCategoryAttributes.setStatus(model.getStatus());

        Attributes attributes = new Attributes();
        attributes.setId(model.getAttributesId());
        subCategoryAttributes.setAttributes(attributes);

        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryAttributes.setSubCategory(subCategory);
        subCategoryAttributes = subCategoryAttributesService.updateSubCategoryAttributes(subCategoryAttributes);
        model.setId(subCategoryAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SubCategoryAttributesModel getByKey(final IKeyBuilder<String> keyBuilder, final SubCategoryAttributesContext context) {
        SubCategoryAttributes subCategoryAttributes = subCategoryAttributesService.getSubCategoryAttributes(keyBuilder.build().toString());
        SubCategoryAttributesModel subCategoryAttributesModel = conversionService.convert(subCategoryAttributes,
                SubCategoryAttributesModel.class);
        return subCategoryAttributesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SubCategoryAttributesModel> getCollection(final SubCategoryAttributesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
