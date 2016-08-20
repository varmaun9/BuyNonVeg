/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryAttributes;
import com.meat.domain.ItemAttributes;
import com.meat.model.CategoryAttributesModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("categoryAttributesModelToCategoryAttributesConverter")
public class CategoryAttributesModelToCategoryAttributesConverter implements Converter<CategoryAttributesModel, CategoryAttributes> {
    @Autowired
    private ObjectFactory<CategoryAttributes> categoryAttributesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryAttributes convert(final CategoryAttributesModel source) {
        CategoryAttributes categoryAttributes = categoryAttributesFactory.getObject();
        BeanUtils.copyProperties(source, categoryAttributes);
        if (CollectionUtils.isNotEmpty(source.getItemAttributeModels())) {
            List<ItemAttributes> converted = (List<ItemAttributes>) conversionService.convert(source.getItemAttributeModels(),
                    TypeDescriptor.forObject(source.getItemAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributes.class));
            categoryAttributes.getItemAttributeses().addAll(converted);
        }
        return categoryAttributes;
    }

    @Autowired
    public void setCategoryAttributesFactory(final ObjectFactory<CategoryAttributes> categoryAttributesFactory) {
        this.categoryAttributesFactory = categoryAttributesFactory;
    }

}
