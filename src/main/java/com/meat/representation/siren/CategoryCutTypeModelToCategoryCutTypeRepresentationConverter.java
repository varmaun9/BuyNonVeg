/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryCutTypeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeModelToCategoryCutTypeRepresentationConverter.java")
public class CategoryCutTypeModelToCategoryCutTypeRepresentationConverter
        extends PropertyCopyingConverter<CategoryCutTypeModel, CategoryCutTypeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryCutTypeRepresentation convert(final CategoryCutTypeModel source) {

        CategoryCutTypeRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryCutTypeRepresentation> factory) {
        super.setFactory(factory);
    }
}
