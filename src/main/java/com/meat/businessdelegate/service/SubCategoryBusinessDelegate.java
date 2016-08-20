/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.*;
import com.meat.model.SubCategoryAttributesModel;
import com.meat.model.SubCategoryImagesModel;
import com.meat.model.SubCategoryModel;
import com.meat.model.SubCategoryTagsModel;
import com.meat.service.ISeoService;
import com.meat.service.ISubCategoryService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SubCategoryBusinessDelegate implements IBusinessDelegate<SubCategoryModel, SubCategoryContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubCategoryService subCategoryService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISeoService seoService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create (com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryModel create(final SubCategoryModel model) {
        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getId());
        subCategory.setSubCategoryName(model.getSubCategoryName());
        subCategory.setDescription(model.getDescription());
        subCategory.setStatus(model.getStatus());
        subCategory.setCreatedDate(new Date());
        subCategory.setSellingTag(model.getSellingTag());
        Integer i = subCategoryService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            subCategory.setSubCategoryCount(bi);
        }
        else {
            long bi = (i + 1);
            subCategory.setSubCategoryCount(bi);
        }
        Integer ca = i + 1;
        String m = DBSequences.SUBCATEGORY.getSequenceName();
        String mc = m.concat(ca.toString());
        subCategory.setSubCategoryCode(mc);

        Category cat = new Category();
        cat.setId(model.getCategoryId());
        subCategory.setCategory(cat);

        Seo seo = new Seo();
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        subCategory.setSeo(seo);
        subCategory = subCategoryService.create(subCategory);
        model.setId(subCategory.getId());
        if (subCategory.getSubCategoryName() != null) {
            if (subCategory.getSubCategoryName().equals("Duplicate")) {
                model.setSubCategoryNameStatus(model.getSubCategoryName() + " Already Exists!");
            }
        }
        if (subCategory.getId() != null) {
            if (model.getSubCategoryAttributeModels() != null) {
                List<SubCategoryAttributes> subCatAttributes = new ArrayList<SubCategoryAttributes>();
                for (SubCategoryAttributesModel subCatAttrModels : model.getSubCategoryAttributeModels()) {
                    SubCategoryAttributes subCategoryAttributes = new SubCategoryAttributes();
                    subCategoryAttributes.setId(subCatAttrModels.getId());
                    Attributes attr = new Attributes();
                    attr.setId(subCatAttrModels.getAttributesId());
                    subCategoryAttributes.setAttributes(attr);
                    subCategoryAttributes.setSubCategory(subCategory);
                    subCategoryAttributes.setAttributeValue(subCatAttrModels.getAttributeValue());
                    subCategoryAttributes.setStatus(subCatAttrModels.getStatus());
                    subCatAttributes.add(subCategoryAttributes);
                }
                subCategory = subCategoryService.addSubCategoryAttributes(subCategory, subCatAttributes);

            }
            if (model.getSubCategoryTagModels() != null) {
                List<SubCategoryTags> subCatTags = new ArrayList<SubCategoryTags>();
                for (SubCategoryTagsModel subCatTgModels : model.getSubCategoryTagModels()) {
                    SubCategoryTags subCategoryTags = new SubCategoryTags();
                    subCategoryTags.setId(subCatTgModels.getId());
                    Tags tag = new Tags();
                    tag.setId(subCatTgModels.getTagsId());
                    subCategoryTags.setTags(tag);
                    subCategoryTags.setSubCategory(subCategory);
                    subCategoryTags.setSubCategoryTagsStatus(subCatTgModels.getSubCategoryTagsStatus());
                    subCatTags.add(subCategoryTags);
                }
                subCategory = subCategoryService.addSubCategoryTags(subCategory, subCatTags);
            }
            if (model.getSubCategoryImageModels() != null) {
                List<SubCategoryImages> subCategoryImages = new ArrayList<SubCategoryImages>();
                for (SubCategoryImagesModel subCategoryImagesModel : model.getSubCategoryImageModels()) {
                    SubCategoryImages subImages = new SubCategoryImages();
                    subImages.setId(subCategoryImagesModel.getId());
                    subImages.setSubCategory(subCategory);
                    subImages.setImageName(subCategoryImagesModel.getImageName());
                    subImages.setImageType(subCategoryImagesModel.getImageType());
                    subImages.setImageLocation(subCategoryImagesModel.getImageLocation());
                    subCategoryImages.add(subImages);
                }
                subCategory = subCategoryService.addSubCategoryImages(subCategory, subCategoryImages);
            }

        }

        /*model.setId(subCategory.getId());*/
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete (com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubCategoryContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit (com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SubCategoryModel edit(final IKeyBuilder<String> keyBuilder, final SubCategoryModel model) {
        SubCategory subCategory = subCategoryService.getSubCategory(keyBuilder.build().toString());

        subCategory.setId(model.getId());
        if (model.getSubCategoryName() != null) {
            subCategory.setSubCategoryName(model.getSubCategoryName());
        }
        subCategory.setDescription(model.getDescription());
        if (model.getStatus() != null) {

            subCategory.setStatus(model.getStatus());
        }
        subCategory.setSellingTag(model.getSellingTag());
        if (model.getCategoryId() != null) {
            Category cat = new Category();
            cat.setId(model.getCategoryId());
            subCategory.setCategory(cat);
        }
        if (model.getSeoId() != null) {
            Seo seo = seoService.getSeo(subCategory.getSeo().getId());
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            subCategory.setSeo(seo);
        }

        if (subCategory.getId() != null) {
            if (model.getSubCategoryAttributeModels() != null) {
                List<SubCategoryAttributes> subCatAttributes = new ArrayList<SubCategoryAttributes>();
                for (SubCategoryAttributesModel subCatAttrModels : model.getSubCategoryAttributeModels()) {
                    SubCategoryAttributes subCategoryAttributes = new SubCategoryAttributes();
                    Attributes attr = new Attributes();
                    attr.setId(subCatAttrModels.getAttributesId());
                    subCategoryAttributes.setAttributes(attr);
                    SubCategory subCategory1 = new SubCategory();
                    subCategory1.setId(subCatAttrModels.getSubCategoryId());
                    subCategoryAttributes.setSubCategory(subCategory1);
                    subCategoryAttributes.setAttributeValue(subCatAttrModels.getAttributeValue());
                    subCategoryAttributes.setStatus(subCatAttrModels.getStatus());
                    subCatAttributes.add(subCategoryAttributes);
                }
                subCategory = subCategoryService.addSubCategoryAttributes(subCategory, subCatAttributes);

            }
            if (model.getSubCategoryTagModels() != null) {
                List<SubCategoryTags> subCatTags = new ArrayList<SubCategoryTags>();
                for (SubCategoryTagsModel subCatTgModels : model.getSubCategoryTagModels()) {
                    SubCategoryTags subCategoryTags = new SubCategoryTags();
                    subCategoryTags.setId(subCatTgModels.getId());
                    Tags tag = new Tags();
                    tag.setId(subCatTgModels.getTagsId());
                    subCategoryTags.setTags(tag);
                    /* SubCategory subCategory2 = new SubCategory();
                    subCategory2.setId(subCatTgModels.getSubCategoryId());*/
                    subCategoryTags.setSubCategory(subCategory);
                    subCategoryTags.setSubCategoryTagsStatus(subCatTgModels.getSubCategoryTagsStatus());
                    subCatTags.add(subCategoryTags);
                }
                subCategory = subCategoryService.addSubCategoryTags(subCategory, subCatTags);
            }
        }
        subCategory = subCategoryService.updateSubCategory(subCategory);
        model.setId(subCategory.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey (com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public SubCategoryModel getByKey(final IKeyBuilder<String> keyBuilder, final SubCategoryContext context) {
        SubCategory subCategory = subCategoryService.getSubCategory

        (keyBuilder.build().toString());
        SubCategoryModel SubCategoryModel = conversionService.convert(subCategory,

                SubCategoryModel.class);

        return SubCategoryModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection
     *      (com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public Collection<SubCategoryModel> getCollection(final SubCategoryContext

    context) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        if (context.getCategoryId() != null) {
            subCategory = subCategoryService.getByCategoryId(context.getCategoryId());
        }
        if (context.getAll() != null) {
            subCategory = subCategoryService.getAll();
        }
        if (context.getCategoryId() != null && context.getAll() != null) {
            subCategory = subCategoryService.getAllSubCategoryByCategoryId(context.getCategoryId());
        }
        if (context.getSubCategoryOnly() != null) {
            subCategory = subCategoryService.getSubCategoryOnly();
        }
        if (context.getSubCategoryOnly() != null && context.getCategoryId() != null) {
            subCategory = subCategoryService.getSubCategoryByCategory(context.getCategoryId());
        }
        if (context.getSubCategoryOnly() != null && context.getSellerId() != null) {
            subCategory = subCategoryService.getSubCategoryBySeller(context.getSellerId());
        }
        if (context.getSubCategoryOnly() != null && context.getSellerBranchId() != null) {
            subCategory = subCategoryService.getSubCategoryBySellerBranch(context.getSellerBranchId());
        }
        List<SubCategoryModel> subCategoryModels = (List<SubCategoryModel>) conversionService.convert(subCategory,
                TypeDescriptor.forObject(subCategory), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf

        (SubCategoryModel.class)));

        return subCategoryModels;
    }

}
