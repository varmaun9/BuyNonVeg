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
@Component("categoryImagesRepresentationToCategoryImagesModelConverter")
public class CategoryImagesRepresentationToCategoryImagesModelConverter extends
PropertyCopyingConverter<CategoryImagesRepresentation, CategoryImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryImagesModel convert(final CategoryImagesRepresentation source) {

        CategoryImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryImagesModel> factory) {
        super.setFactory(factory);
    }
}
