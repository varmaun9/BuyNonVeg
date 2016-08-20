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
@Component("subCategoryAttributesRepresentationToSubCategoryAttributesModelConverter")
public class SubCategoryAttributesRepresentationToSubCategoryAttributesModelConverter extends
        PropertyCopyingConverter<SubCategoryAttributesRepresentation, SubCategoryAttributesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryAttributesModel convert(final SubCategoryAttributesRepresentation source) {

        SubCategoryAttributesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryAttributesModel> factory) {
        super.setFactory(factory);
    }
}
