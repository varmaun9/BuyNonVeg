package com.meat.model.converters;

import com.meat.domain.SubCategoryImages;
import com.meat.model.SubCategoryImagesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("subCategoryImagesModelToSubCategoryImagesConverter")
public class SubCategoryImagesModelToSubCategoryImagesConverter implements Converter<SubCategoryImagesModel, SubCategoryImages> {
    @Autowired
    private ObjectFactory<SubCategoryImages> subCategoryImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryImages convert(final SubCategoryImagesModel source) {
        SubCategoryImages subCategoryImages = subCategoryImagesFactory.getObject();
        BeanUtils.copyProperties(source, subCategoryImages);

        return subCategoryImages;
    }

    @Autowired
    public void setSubCategoryImagesFactory(final ObjectFactory<SubCategoryImages> subCategoryImagesFactory) {
        this.subCategoryImagesFactory = subCategoryImagesFactory;
    }

}
