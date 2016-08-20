/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryCriteriaModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("categoryCriteriaModelToCategoryCriteriaRepresentationConverter")
public class CategoryCriteriaModelToCategoryCriteriaRepresentationConverter extends
        PropertyCopyingConverter<CategoryCriteriaModel, CategoryCriteriaRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryCriteriaRepresentation convert(final CategoryCriteriaModel source) {

        CategoryCriteriaRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryCriteriaRepresentation> factory) {
        super.setFactory(factory);
    }
}
