/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryAttributesModel;
import com.meat.model.ItemAttributesModel;
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
@Component("categoryAttributesRepresentationToCategoryAttributesModelConverter")
public class CategoryAttributesRepresentationToCategoryAttributesModelConverter
        extends PropertyCopyingConverter<CategoryAttributesRepresentation, CategoryAttributesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryAttributesModel convert(final CategoryAttributesRepresentation source) {

        CategoryAttributesModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getItemAttributeRep())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributeRep(),
                    TypeDescriptor.forObject(source.getItemAttributeRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            target.getItemAttributeModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryAttributesModel> factory) {
        super.setFactory(factory);
    }

}
