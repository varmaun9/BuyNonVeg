/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AttributesModel;
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
@Component("attributeModelToAttributeRepresentationConverter")
public class AttributesModelToAttributesRepresentationConverter extends PropertyCopyingConverter<AttributesModel, AttributesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AttributesRepresentation convert(final AttributesModel source) {

        AttributesRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesModels())) {
            List<CategoryAttributesRepresentation> converted = (List<CategoryAttributesRepresentation>) conversionService.convert(
                    source.getCategoryAttributesModels(), TypeDescriptor.forObject(source.getCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesRepresentation.class));
            target.getCategoryAttributesRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributesModels())) {
            List<SubCategoryAttributesRepresentation> converted = (List<SubCategoryAttributesRepresentation>) conversionService.convert(
                    source.getSubCategoryAttributesModels(), TypeDescriptor.forObject(source.getSubCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesRepresentation.class));
            target.getSubCategoryAttributesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemAttributesesModels())) {
            List<ItemAttributesRepresentation> converted = (List<ItemAttributesRepresentation>) conversionService.convert(
                    source.getItemAttributesesModels(), TypeDescriptor.forObject(source.getItemAttributesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesRepresentation.class));
            target.getItemAttributesesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AttributesRepresentation> factory) {
        super.setFactory(factory);
    }

}
