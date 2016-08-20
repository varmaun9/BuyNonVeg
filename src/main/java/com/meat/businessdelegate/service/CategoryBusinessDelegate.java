/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.*;
import com.meat.model.*;
import com.meat.service.*;

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
public class CategoryBusinessDelegate implements IBusinessDelegate<CategoryModel, CategoryContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ICategoryTagsService categoryTagsService;
    @Autowired
    private ICategoryCriteriaService categoryCriteriaService;
    @Autowired
    private ICategoryAttributesService categoryAttributesService;
    @Autowired
    private ICategoryCutTypeService categoryCutTypeService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryModel create(final CategoryModel model) {

        Category category = new Category();
        category.setId(model.getId());
        category.setCategoryName(model.getCategoryName());
        category.setCreatedDate(new Date());
        category.setDescription(model.getDescription());
        category.setStatus(model.getStatus());
        category.setSellingTag(model.getSellingTag());
        Integer i = categoryService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            category.setCategoryCount(bi);
        }
        else {
            long bi = (i + 1);
            category.setCategoryCount(bi);
        }
        Integer ca = i + 1;
        String m = DBSequences.CATEGORY.getSequenceName();
        String mc = m.concat(ca.toString());
        category.setCategoryCode(mc);

        Seo seo = new Seo();
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        category.setSeo(seo);
        category = categoryService.create(category);

        if (category.getCategoryName() != null) {
            if (category.getCategoryName().equals("DUPLICATE")) {
                model.setCategoryNameStatus(model.getCategoryName() + " Already Exists!");
            }
        }

        if (category.getId() != null) {
            if (model.getCategoryTagsModels() != null) {
                List<CategoryTags> catTags = new ArrayList<CategoryTags>();
                for (CategoryTagsModel catTagModels : model.getCategoryTagsModels()) {
                    CategoryTags categoryTags = new CategoryTags();
                    Tags tags = new Tags();
                    tags.setId(catTagModels.getTagsId());
                    categoryTags.setTags(tags);
                    categoryTags.setCategory(category);
                    categoryTags.setCategoryTagsStatus(catTagModels.getCategoryTagsStatus());
                    //categoryTags.setId(catTagModels.getId());
                    catTags.add(categoryTags);
                    //categoryTags.setId(catTagModels.getId());
                }
                category = categoryService.addCategoryTags(category, catTags);
            }
            if (model.getCategoryCriteriaModels() != null) {
                List<CategoryCriteria> catCriteria = new ArrayList<CategoryCriteria>();
                for (CategoryCriteriaModel categoryCriteriaModels : model.getCategoryCriteriaModels()) {
                    CategoryCriteria categoryCriteria = new CategoryCriteria();
                    Criteria criteria = new Criteria();
                    criteria.setId(categoryCriteriaModels.getCriteriaId());
                    categoryCriteria.setCriteria(criteria);
                    categoryCriteria.setCategory(category);
                    categoryCriteria.setCriteriaValue(categoryCriteriaModels.getCriteriaValue());
                    categoryCriteria.setStatus(categoryCriteriaModels.getStatus());
                    catCriteria.add(categoryCriteria);
                }
                category = categoryService.addCategoryCriteria(category, catCriteria);
            }
            if (model.getCategoryAttributesModels() != null) {
                List<CategoryAttributes> catAttributes = new ArrayList<CategoryAttributes>();
                for (CategoryAttributesModel catAttributesModels : model.getCategoryAttributesModels()) {
                    CategoryAttributes categoryAttributes = new CategoryAttributes();
                    Attributes attributes = new Attributes();
                    attributes.setId(catAttributesModels.getAttributesId());
                    categoryAttributes.setAttributes(attributes);
                    categoryAttributes.setAttributeValue(catAttributesModels.getAttributeValue());
                    categoryAttributes.setStatus(catAttributesModels.getStatus());
                    categoryAttributes.setCategory(category);
                    catAttributes.add(categoryAttributes);
                }
                category = categoryService.addCategoryAttributes(category, catAttributes);
            }
            if (model.getCategoryImagesModels() != null) {
                List<CategoryImages> catImages = new ArrayList<CategoryImages>();
                for (CategoryImagesModel categoryImagesModels : model.getCategoryImagesModels()) {
                    CategoryImages categoryImages = new CategoryImages();
                    categoryImages.setId(categoryImagesModels.getId());
                    categoryImages.setCategory(category);
                    categoryImages.setImageName(categoryImagesModels.getImageName());
                    categoryImages.setImageType(categoryImagesModels.getImageType());
                    categoryImages.setImageLocation(categoryImagesModels.getImageLocation());
                    catImages.add(categoryImages);
                }
                category = categoryService.addCategoryImages(category, catImages);
            }
        }
        //category = categoryService.create(category);
        model.setId(category.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryModel edit(final IKeyBuilder<String> keyBuilder, final CategoryModel model) {
        Category category = categoryService.getCategory(keyBuilder.build().toString());

        category.setId(model.getId());
        if (model.getCategoryName() != null) {
            category.setCategoryName(model.getCategoryName());
        }
        category.setDescription(model.getDescription());
        if (model.getStatus() != null) {
            category.setStatus(model.getStatus());
        }
        category.setSellingTag(model.getSellingTag());

        if (model.getSeoId() != null) {
            Seo seo = seoService.getSeo(category.getSeo().getId());
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            category.setSeo(seo);
        }

        if (category.getId() != null) {
            List<CategoryTags> catTags = new ArrayList<CategoryTags>();
            if (model.getCategoryTagsModels() != null) {
                for (CategoryTagsModel catTagModels : model.getCategoryTagsModels()) {
                    CategoryTags categoryTags = new CategoryTags();
                    categoryTags.setId(catTagModels.getId());
                    Tags tags = new Tags();
                    tags.setId(catTagModels.getTagsId());
                    categoryTags.setTags(tags);
                    categoryTags.setCategory(category);
                    categoryTags.setId(catTagModels.getId());
                    categoryTags.setCategoryTagsStatus(catTagModels.getCategoryTagsStatus());
                    //  categoryTags = categoryTagsService.updateCategoryTags(categoryTags);
                    catTags.add(categoryTags);
                }
                category = categoryService.addCategoryTags(category, catTags);
            }

            List<CategoryCriteria> catCriteria = new ArrayList<CategoryCriteria>();
            if (model.getCategoryCriteriaModels() != null) {
                for (CategoryCriteriaModel categoryCriteriaModels : model.getCategoryCriteriaModels()) {
                    CategoryCriteria categoryCriteria = new CategoryCriteria();
                    Criteria criteria = new Criteria();
                    categoryCriteria.setId(categoryCriteriaModels.getId());
                    criteria.setId(categoryCriteriaModels.getCriteriaId());
                    categoryCriteria.setCriteria(criteria);
                    categoryCriteria.setCategory(category);
                    categoryCriteria.setStatus(categoryCriteriaModels.getStatus());
                    categoryCriteria.setCriteriaValue(categoryCriteriaModels.getCriteriaValue());
                    //categoryCriteria = categoryCriteriaService.updateCategoryCriteria(categoryCriteria);
                    catCriteria.add(categoryCriteria);
                }
                category = categoryService.addCategoryCriteria(category, catCriteria);

            }
            List<CategoryAttributes> catAttributes = new ArrayList<CategoryAttributes>();
            if (model.getCategoryAttributesModels() != null) {
                for (CategoryAttributesModel catAttributesModels : model.getCategoryAttributesModels()) {
                    CategoryAttributes categoryAttributes = new CategoryAttributes();
                    categoryAttributes.setId(catAttributesModels.getId());
                    Attributes attributes = new Attributes();
                    attributes.setId(catAttributesModels.getAttributesId());
                    categoryAttributes.setAttributes(attributes);
                    categoryAttributes.setAttributeValue(catAttributesModels.getAttributeValue());
                    categoryAttributes.setStatus(catAttributesModels.getStatus());
                    categoryAttributes.setCategory(category);
                    //  categoryAttributes = categoryAttributesService.updateCategoryAttributes(categoryAttributes);
                    catAttributes.add(categoryAttributes);
                }
                category = categoryService.addCategoryAttributes(category, catAttributes);
            }
            if (model.getCategoryImagesModels() != null) {
                List<CategoryImages> catImages = new ArrayList<CategoryImages>();
                for (CategoryImagesModel categoryImagesModels : model.getCategoryImagesModels()) {
                    CategoryImages categoryImages = new CategoryImages();
                    categoryImages.setCategory(category);
                    categoryImages.setImageName(categoryImagesModels.getImageName());
                    categoryImages.setImageType(categoryImagesModels.getImageType());
                    categoryImages.setImageLocation(categoryImagesModels.getImageLocation());
                    catImages.add(categoryImages);
                }
                category = categoryService.addCategoryImages(category, catImages);
            }
            if (model.getCategoryCutTypeModels() != null) {
                List<CategoryCutType> categoryCutTypes = new ArrayList<CategoryCutType>();
                for (CategoryCutTypeModel categoryCutTypeModel : model.getCategoryCutTypeModels()) {
                    if (categoryCutTypeModel.getCutTypeId() != null) {
                        CategoryCutType categoryCutType = new CategoryCutType();
                        CutType cutType = new CutType();
                        cutType.setId(categoryCutTypeModel.getCutTypeId());
                        categoryCutType.setCutType(cutType);
                        categoryCutType.setCategory(category);
                        categoryCutType.setDescription(categoryCutTypeModel.getDescription());
                        categoryCutType.setStatus("ACTIVE");
                        categoryCutTypes.add(categoryCutType);
                    }
                }
                category = categoryService.addCutTypes(category, categoryCutTypes);
            }
        }
        category = categoryService.updateCategory(category);
        model.setId(category.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryContext context) {
        Category category = categoryService.getCategory(keyBuilder.build().toString());
        CategoryModel categoryModel = conversionService.convert(category, CategoryModel.class);
        return categoryModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryModel> getCollection(final CategoryContext context) {
        List<Category> category = new ArrayList<Category>();

        if (context.getAll() != null) {
            category = categoryService.getAll();
        }
        if (context.getCategoryOnly() != null) {
            category = categoryService.getCategoryOnly();
        }
        if (context.getCategoryOnly() != null && context.getSellerId() != null) {
            category = categoryService.getCategoriesOnlyBySeller(context.getSellerId());
        }
        if (context.getCategoryOnly() != null && context.getSellerBranchId() != null) {
            category = categoryService.getCategoriesOnlyBySellerBranch(context.getSellerBranchId());
        }
        if (context.getCategoryOnly() != null && context.getCategoryId() != null) {
            category = categoryService.getSubCategoriesAndCatAttributes(context.getCategoryId());
        }
        List<CategoryModel> categModels = (List<CategoryModel>) conversionService.convert(category, TypeDescriptor.forObject(category),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryModel.class)));

        return categModels;
    }
}
