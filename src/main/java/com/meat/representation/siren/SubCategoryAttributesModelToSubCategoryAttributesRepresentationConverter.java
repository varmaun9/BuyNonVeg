/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubCategoryAttributesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("subCategoryAttributesModelToSubCategoryAttributesRepresentationConverter")
public class SubCategoryAttributesModelToSubCategoryAttributesRepresentationConverter extends
        PropertyCopyingConverter<SubCategoryAttributesModel, SubCategoryAttributesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryAttributesRepresentation convert(final SubCategoryAttributesModel source) {

        SubCategoryAttributesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryAttributesRepresentation> factory) {
        super.setFactory(factory);
    }
}