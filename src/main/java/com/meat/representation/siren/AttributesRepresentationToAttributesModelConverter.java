/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AttributesModel;
import com.meat.model.CategoryAttributesModel;
import com.meat.model.ItemAttributesModel;
import com.meat.model.SubCategoryAttributesModel;
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
@Component("attributesRepresentationToAttributesModelConverter")
public class AttributesRepresentationToAttributesModelConverter
        extends PropertyCopyingConverter<AttributesRepresentation, AttributesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AttributesModel convert(final AttributesRepresentation source) {
        AttributesModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesRep())) {
            List<CategoryAttributesModel> converted = (List<CategoryAttributesModel>) conversionService.convert(
                    source.getCategoryAttributesRep(), TypeDescriptor.forObject(source.getCategoryAttributesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesModel.class));
            target.getCategoryAttributesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributesRep())) {
            List<SubCategoryAttributesModel> converted = (List<SubCategoryAttributesModel>) conversionService.convert(
                    source.getSubCategoryAttributesRep(), TypeDescriptor.forObject(source.getSubCategoryAttributesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesModel.class));
            target.getSubCategoryAttributesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemAttributesesRep())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributesesRep(),
                    TypeDescriptor.forObject(source.getItemAttributesesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            target.getItemAttributesesModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AttributesModel> factory) {
        super.setFactory(factory);
    }

}
