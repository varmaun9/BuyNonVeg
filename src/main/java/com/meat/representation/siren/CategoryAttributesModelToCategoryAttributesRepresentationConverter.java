/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryAttributesModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("categoryAttributesModelToCategoryAttributesRepresentationConverter")
public class CategoryAttributesModelToCategoryAttributesRepresentationConverter
        extends PropertyCopyingConverter<CategoryAttributesModel, CategoryAttributesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryAttributesRepresentation convert(final CategoryAttributesModel source) {

        CategoryAttributesRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getItemAttributeModels())) {
            List<ItemAttributesRepresentation> converted = (List<ItemAttributesRepresentation>) conversionService.convert(
                    source.getItemAttributeModels(), TypeDescriptor.forObject(source.getItemAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesRepresentation.class));
            target.getItemAttributeRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryAttributesRepresentation> factory) {
        super.setFactory(factory);
    }

}
