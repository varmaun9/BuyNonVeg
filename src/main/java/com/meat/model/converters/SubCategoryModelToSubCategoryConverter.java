package com.meat.model.converters;

import com.meat.domain.Item;
import com.meat.domain.SubCategory;
import com.meat.domain.SubCategoryAttributes;
import com.meat.domain.SubCategoryTags;
import com.meat.model.SubCategoryModel;
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

@Component("subCategoryModelToSubCategoryConverter")
public class SubCategoryModelToSubCategoryConverter implements Converter<SubCategoryModel, SubCategory> {
    @Autowired
    private ObjectFactory<SubCategory> subCategoryFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategory convert(final SubCategoryModel source) {
        SubCategory subCategory = subCategoryFactory.getObject();
        BeanUtils.copyProperties(source, subCategory);

        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagModels())) {
            List<SubCategoryTags> converted = (List<SubCategoryTags>) conversionService.convert(source.getSubCategoryTagModels(),
                    TypeDescriptor.forObject(source.getSubCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTags.class));
            subCategory.getSubCategoryTagses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemModels())) {
            List<Item> converted = (List<Item>) conversionService.convert(source.getItemModels(),
                    TypeDescriptor.forObject(source.getItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Item.class));
            subCategory.getItems().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributeModels())) {
            List<SubCategoryAttributes> converted = (List<SubCategoryAttributes>) conversionService.convert(
                    source.getSubCategoryAttributeModels(), TypeDescriptor.forObject(source.getSubCategoryAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributes.class));
            subCategory.getSubCategoryAttributeses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagModels())) {
            List<SubCategoryTags> converted = (List<SubCategoryTags>) conversionService.convert(source.getSubCategoryTagModels(),
                    TypeDescriptor.forObject(source.getSubCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTags.class));
            subCategory.getSubCategoryTagses().addAll(converted);
        }

        return subCategory;
    }

    @Autowired
    public void setSubCategoryFactory(final ObjectFactory<SubCategory> subCategoryFactory) {
        this.subCategoryFactory = subCategoryFactory;
    }

}
