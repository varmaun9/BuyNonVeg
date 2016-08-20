package com.meat.model.converters;

import com.meat.domain.Attributes;
import com.meat.domain.CategoryAttributes;
import com.meat.domain.ItemAttributes;
import com.meat.domain.SubCategoryAttributes;
import com.meat.model.AttributesModel;
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

@Component("attributesModelToAttributesConverter")
public class AttributesModelToAttributesConverter implements Converter<AttributesModel, Attributes> {
    @Autowired
    private ObjectFactory<Attributes> attributesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Attributes convert(final AttributesModel source) {
        Attributes attributes = attributesFactory.getObject();
        BeanUtils.copyProperties(source, attributes);

        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributesModels())) {
            List<SubCategoryAttributes> converted = (List<SubCategoryAttributes>) conversionService.convert(
                    source.getSubCategoryAttributesModels(), TypeDescriptor.forObject(source.getSubCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributes.class));
            attributes.getSubCategoryAttributeses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesModels())) {
            List<CategoryAttributes> converted = (List<CategoryAttributes>) conversionService.convert(source.getCategoryAttributesModels(),
                    TypeDescriptor.forObject(source.getCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributes.class));
            attributes.getCategoryAttributeses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemAttributesesModels())) {
            List<ItemAttributes> converted = (List<ItemAttributes>) conversionService.convert(source.getItemAttributesesModels(),
                    TypeDescriptor.forObject(source.getItemAttributesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributes.class));
            attributes.getItemAttributeses().addAll(converted);
        }

        return attributes;
    }

    @Autowired
    public void setAttributesFactory(final ObjectFactory<Attributes> attributesFactory) {
        this.attributesFactory = attributesFactory;
    }

}
