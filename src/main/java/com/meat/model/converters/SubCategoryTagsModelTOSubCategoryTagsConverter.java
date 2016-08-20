package com.meat.model.converters;

import com.meat.domain.SubCategoryTags;
import com.meat.model.SubCategoryTagsModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("subCategoryTagsModelTOSubCategoryTagsConverter")
public class SubCategoryTagsModelTOSubCategoryTagsConverter implements Converter<SubCategoryTagsModel, SubCategoryTags> {
    @Autowired
    private ObjectFactory<SubCategoryTags> subCategoryTagsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryTags convert(final SubCategoryTagsModel source) {
        SubCategoryTags subCategoryTags = subCategoryTagsFactory.getObject();
        BeanUtils.copyProperties(source, subCategoryTags);

        return subCategoryTags;
    }

    @Autowired
    public void setSubCategoryTagsFactory(final ObjectFactory<SubCategoryTags> subCategoryTagsFactory) {
        this.subCategoryTagsFactory = subCategoryTagsFactory;
    }

}
