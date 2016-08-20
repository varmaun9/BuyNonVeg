package com.meat.model.converters;

import com.meat.domain.Category;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("categoryToCategoryModelConverter")
public class CategoryToCategoryModelConverter implements Converter<Category, CategoryModel> {

    private static final Logger LOGGER = Logger.getLogger(CategoryToCategoryModelConverter.class);
    @Autowired
    private ObjectFactory<CategoryModel> categoryModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryModel convert(final Category source) {
        // TODO Auto-generated method stub
        CategoryModel categoryModel = categoryModelFactory.getObject();
        BeanUtils.copyProperties(source, categoryModel);
        /*categoryModel.setSellingTag(Integer.toString(source.getSellingTag()));*/

        // categoryModel.setSeoId(source.getSeo().getId());
        if (source.getSeo() != null) {
            categoryModel.setSeoId(source.getSeo().getId());
            categoryModel.setSeoTitle(source.getSeo().getSeoTitle());
            categoryModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            categoryModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        /*categoryModel.setSellingTag(source.getSellingTag().toString());*/
        categoryModel.setCategoryCount(Long.toString(source.getCategoryCount()));

        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                categoryModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributeses())) {
            List<CategoryAttributesModel> converted = (List<CategoryAttributesModel>) conversionService.convert(
                    source.getCategoryAttributeses(), TypeDescriptor.forObject(source.getCategoryAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesModel.class));
            categoryModel.getCategoryAttributesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryTagses())) {
            List<CategoryTagsModel> converted = (List<CategoryTagsModel>) conversionService.convert(source.getCategoryTagses(),
                    TypeDescriptor.forObject(source.getCategoryTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsModel.class));
            categoryModel.getCategoryTagsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCriterias())) {
            List<CategoryCriteriaModel> converted = (List<CategoryCriteriaModel>) conversionService.convert(source.getCategoryCriterias(),
                    TypeDescriptor.forObject(source.getCategoryCriterias()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaModel.class));
            categoryModel.getCategoryCriteriaModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategories())) {
            List<SubCategoryModel> converted = (List<SubCategoryModel>) conversionService.convert(source.getSubCategories(),
                    TypeDescriptor.forObject(source.getSubCategories()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryModel.class));
            categoryModel.getSubCategoriesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryImageses())) {
            List<CategoryImagesModel> converted = (List<CategoryImagesModel>) conversionService.convert(source.getCategoryImageses(),
                    TypeDescriptor.forObject(source.getCategoryImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryImagesModel.class));
            categoryModel.getCategoryImagesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCutTypes())) {
            List<CategoryCutTypeModel> converted = (List<CategoryCutTypeModel>) conversionService.convert(source.getCategoryCutTypes(),
                    TypeDescriptor.forObject(source.getCategoryCutTypes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCutTypeModel.class));
            categoryModel.getCategoryCutTypeModels().addAll(converted);
        }
        return categoryModel;

    }

    @Autowired
    public void setCategoryFactory(final ObjectFactory<CategoryModel> categoryModelFactory) {
        this.categoryModelFactory = categoryModelFactory;
    }

}
