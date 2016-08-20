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
@Component("categoryCutTypeRepresentationToCategoryCutTypeModelConverter")
public class CategoryCutTypeRepresentationToCategoryCutTypeModelConverter
        extends PropertyCopyingConverter<CategoryCutTypeRepresentation, CategoryCutTypeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryCutTypeModel convert(final CategoryCutTypeRepresentation source) {

        CategoryCutTypeModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryCutTypeModel> factory) {
        super.setFactory(factory);
    }
}
