package com.meat.model.converters;

import com.meat.domain.Attributes;
import com.meat.model.AttributesModel;
import com.meat.model.CategoryAttributesModel;
import com.meat.model.ItemAttributesModel;
import com.meat.model.SubCategoryAttributesModel;
import com.meat.util.CollectionTypeDescriptor;

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

@Component("AttributesToAttributesModelConverter")
public class AttributesToAttributesModelConverter implements Converter<Attributes, AttributesModel> {

    private static final Logger LOGGER = Logger.getLogger(AttributesToAttributesModelConverter.class);
    @Autowired
    private ObjectFactory<AttributesModel> attributesModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public AttributesModel convert(final Attributes source) {
        AttributesModel attributesModel = attributesModelFactory.getObject();
        BeanUtils.copyProperties(source, attributesModel);
        attributesModel.setSeoId(source.getSeo().getId());
        attributesModel.setSeoTitle(source.getSeo().getSeoTitle());
        attributesModel.setSeoKeywords(source.getSeo().getSeoKeywords());
        attributesModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());

        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributeses())) {
            List<SubCategoryAttributesModel> converted = (List<SubCategoryAttributesModel>) conversionService.convert(
                    source.getSubCategoryAttributeses(), TypeDescriptor.forObject(source.getSubCategoryAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesModel.class));
            attributesModel.getSubCategoryAttributesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributeses())) {
            List<CategoryAttributesModel> converted = (List<CategoryAttributesModel>) conversionService.convert(
                    source.getCategoryAttributeses(), TypeDescriptor.forObject(source.getCategoryAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesModel.class));
            attributesModel.getCategoryAttributesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemAttributeses())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributeses(),
                    TypeDescriptor.forObject(source.getItemAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            attributesModel.getItemAttributesesModels().addAll(converted);
        }
        return attributesModel;

    }

    @Autowired
    public void setAttributesFactory(final ObjectFactory<AttributesModel> attributesModelFactory) {
        this.attributesModelFactory = attributesModelFactory;
    }

}
