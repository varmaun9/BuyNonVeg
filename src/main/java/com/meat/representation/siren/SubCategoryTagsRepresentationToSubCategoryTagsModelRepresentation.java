/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubCategoryTagsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("subCategoryTagsRepresentationToSubCategoryTagsModelRepresentation")
public class SubCategoryTagsRepresentationToSubCategoryTagsModelRepresentation extends
PropertyCopyingConverter<SubCategoryTagsRepresentation, SubCategoryTagsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryTagsModel convert(final SubCategoryTagsRepresentation source) {

        SubCategoryTagsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryTagsModel> factory) {
        super.setFactory(factory);
    }

}
