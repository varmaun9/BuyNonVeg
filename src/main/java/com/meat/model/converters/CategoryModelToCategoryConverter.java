package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.CategoryModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("categoryModelToCategoryConverter")
public class CategoryModelToCategoryConverter implements Converter<CategoryModel, Category> {
    @Autowired
    private ObjectFactory<Category> categoryFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Category convert(final CategoryModel source) {
        Category category = categoryFactory.getObject();
        BeanUtils.copyProperties(source, category);
        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesModels())) {
            List<CategoryAttributes> converted = (List<CategoryAttributes>) conversionService.convert(source.getCategoryAttributesModels(),
                    TypeDescriptor.forObject(source.getCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributes.class));
            category.getCategoryAttributeses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryTagsModels())) {
            List<CategoryTags> converted = (List<CategoryTags>) conversionService.convert(source.getCategoryTagsModels(),
                    TypeDescriptor.forObject(source.getCategoryImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTags.class));
            category.getCategoryTagses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriaModels())) {
            List<CategoryCriteria> converted = (List<CategoryCriteria>) conversionService.convert(source.getCategoryCriteriaModels(),
                    TypeDescriptor.forObject(source.getCategoryCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteria.class));
            category.getCategoryCriterias().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoriesModels())) {
            List<SubCategory> converted = (List<SubCategory>) conversionService.convert(source.getSubCategoriesModels(),
                    TypeDescriptor.forObject(source.getSubCategoriesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategory.class));
            category.getSubCategories().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryImagesModels())) {
            List<CategoryImages> converted = (List<CategoryImages>) conversionService.convert(source.getCategoryImagesModels(),
                    TypeDescriptor.forObject(source.getCategoryImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryImages.class));
            category.getCategoryImageses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCutTypeModels())) {
            List<CategoryCutType> converted = (List<CategoryCutType>) conversionService.convert(source.getCategoryCutTypeModels(),
                    TypeDescriptor.forObject(source.getCategoryCutTypeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCutType.class));
            category.getCategoryCutTypes().addAll(converted);
        }
        return category;
    }

    @Autowired
    public void setCategoryFactory(final ObjectFactory<Category> categoryFactory) {
        this.categoryFactory = categoryFactory;
    }

}
