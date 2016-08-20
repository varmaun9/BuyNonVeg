/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryImages;
import com.meat.model.SubCategoryImagesModel;
import com.meat.service.ISubCategoryImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
public class SubCategoryImagesBusinessDelegate implements
        IBusinessDelegate<SubCategoryImagesModel, SubCategoryImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubCategoryImagesService subCategoryImagesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryImagesModel create(final SubCategoryImagesModel model) {
        SubCategoryImages subCategoryImages = new SubCategoryImages();
        subCategoryImages.setImageName(model.getImageName());
        subCategoryImages.setImageType(model.getImageType());
        subCategoryImages.setImageLocation(model.getImageLocation());
        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryImages.setSubCategory(subCategory);
        subCategoryImages = subCategoryImagesService.create(subCategoryImages);
        model.setId(subCategoryImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubCategoryImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryImagesModel edit(final IKeyBuilder<String> keyBuilder, final SubCategoryImagesModel model) {
        SubCategoryImages subCategoryImages = subCategoryImagesService.getSubCategoryImages(keyBuilder.build().toString());
        subCategoryImages.setImageName(model.getImageName());
        subCategoryImages.setImageType(model.getImageType());
        subCategoryImages.setImageLocation(model.getImageLocation());
        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        subCategoryImages.setSubCategory(subCategory);
        subCategoryImages = subCategoryImagesService.updateSubCategoryImages(subCategoryImages);
        model.setId(subCategoryImages.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SubCategoryImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final SubCategoryImagesContext context) {
        SubCategoryImages subCategoryImages = subCategoryImagesService.getSubCategoryImages(keyBuilder.build().toString());
        SubCategoryImagesModel subCategoryImagesModel = conversionService.convert(subCategoryImages, SubCategoryImagesModel.class);

        return subCategoryImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SubCategoryImagesModel> getCollection(final SubCategoryImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
