package com.meat.representation.siren;

import com.meat.model.SubCategoryTagsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("SubCategoryTagsModelToSubCategoryTagsRepresentationConverter")
public class SubCategoryTagsModelToSubCategoryTagsRepresentationConverter extends
PropertyCopyingConverter<SubCategoryTagsModel, SubCategoryTagsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryTagsRepresentation convert(final SubCategoryTagsModel source) {

        SubCategoryTagsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryTagsRepresentation> factory) {
        super.setFactory(factory);
    }
}
