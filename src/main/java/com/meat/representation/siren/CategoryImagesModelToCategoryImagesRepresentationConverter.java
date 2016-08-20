/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("categoryImagesModelToCategoryImagesRepresentationConverter")
public class CategoryImagesModelToCategoryImagesRepresentationConverter extends
PropertyCopyingConverter<CategoryImagesModel, CategoryImagesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryImagesRepresentation convert(final CategoryImagesModel source) {

        CategoryImagesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryImagesRepresentation> factory) {
        super.setFactory(factory);
    }
}
