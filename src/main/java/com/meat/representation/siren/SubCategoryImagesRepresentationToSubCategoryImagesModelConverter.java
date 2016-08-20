/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubCategoryImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("subCategoryImagesRepresentationToSubCategoryImagesModelConverter")
public class SubCategoryImagesRepresentationToSubCategoryImagesModelConverter extends
PropertyCopyingConverter<SubCategoryImagesRepresentation, SubCategoryImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryImagesModel convert(final SubCategoryImagesRepresentation source) {

        SubCategoryImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryImagesModel> factory) {
        super.setFactory(factory);
    }

}
