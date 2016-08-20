/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryTagsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("categoryTagsModelToCategoryTagsRepresentationConverter.java")
public class CategoryTagsModelToCategoryTagsRepresentationConverter extends
PropertyCopyingConverter<CategoryTagsModel, CategoryTagsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryTagsRepresentation convert(final CategoryTagsModel source) {

        CategoryTagsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryTagsRepresentation> factory) {
        super.setFactory(factory);
    }
}
