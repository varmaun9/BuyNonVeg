package com.meat.representation.siren;

import com.meat.model.SubCategoryImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("subCategoryImagesModelToSubCategoryImagesRepresentationConverter")
public class SubCategoryImagesModelToSubCategoryImagesRepresentationConverter extends
PropertyCopyingConverter<SubCategoryImagesModel, SubCategoryImagesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryImagesRepresentation convert(final SubCategoryImagesModel source) {

        SubCategoryImagesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryImagesRepresentation> factory) {
        super.setFactory(factory);
    }
}
