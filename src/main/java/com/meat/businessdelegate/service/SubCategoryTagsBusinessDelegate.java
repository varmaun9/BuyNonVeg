/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryTags;
import com.meat.domain.Tags;
import com.meat.model.SubCategoryTagsModel;
import com.meat.service.ISubCategoryTagsService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
public class SubCategoryTagsBusinessDelegate implements
IBusinessDelegate<SubCategoryTagsModel, SubCategoryTagsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubCategoryTagsService subCategoryTagsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryTagsModel create(final SubCategoryTagsModel model) {
        // TODO Auto-generated method stub

        SubCategoryTags subCategoryTags = new SubCategoryTags();
        subCategoryTags.setId(model.getId());
        subCategoryTags.setSubCategoryTagsStatus(model.getSubCategoryTagsStatus());

        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryTags.setSubCategory(subCategory);

        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        subCategoryTags.setTags(tags);

        subCategoryTags = subCategoryTagsService.create(subCategoryTags);
        model.setId(subCategoryTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubCategoryTagsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryTagsModel edit(final IKeyBuilder<String> keyBuilder, final SubCategoryTagsModel model) {
        // TODO Auto-generated method stub

        SubCategoryTags subCategoryTags = subCategoryTagsService.getSubCategoryTags(keyBuilder.build().toString());
        subCategoryTags.setId(model.getId());
        subCategoryTags.setSubCategoryTagsStatus(model.getSubCategoryTagsStatus());

        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryTags.setSubCategory(subCategory);

        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        subCategoryTags.setTags(tags);

        subCategoryTags = subCategoryTagsService.updateSubCategoryTags(subCategoryTags);
        model.setId(subCategoryTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SubCategoryTagsModel getByKey(final IKeyBuilder<String> keyBuilder, final SubCategoryTagsContext context) {
        // TODO Auto-generated method stub
        SubCategoryTags subCategoryTags = subCategoryTagsService.getSubCategoryTags(keyBuilder.build().toString());
        SubCategoryTagsModel subCategoryTagsModel = conversionService.convert(subCategoryTags, SubCategoryTagsModel.class);

        return subCategoryTagsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SubCategoryTagsModel> getCollection(final SubCategoryTagsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
