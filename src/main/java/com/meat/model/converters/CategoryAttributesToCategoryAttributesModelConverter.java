/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryAttributes;
import com.meat.model.CategoryAttributesModel;
import com.meat.model.ItemAttributesModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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
@Component("categoryAttributesToCategoryAttributesModelConverter")
public class CategoryAttributesToCategoryAttributesModelConverter implements Converter<CategoryAttributes, CategoryAttributesModel> {

    private static final Logger LOGGER = Logger.getLogger(CategoryAttributesToCategoryAttributesModelConverter.class);
    @Autowired
    private ObjectFactory<CategoryAttributesModel> categoryAttributesModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryAttributesModel convert(final CategoryAttributes source) {
        // TODO Auto-generated method stub
        CategoryAttributesModel categoryAttributesModel = categoryAttributesModelFactory.getObject();

        BeanUtils.copyProperties(source, categoryAttributesModel);
        categoryAttributesModel.setAttributeValue(source.getAttributeValue());

        if (source.getCategory() != null) {
            categoryAttributesModel.setCategoryId(source.getCategory().getId());
            categoryAttributesModel.setCategoryName(source.getCategory().getCategoryName());
        }
        if (source.getAttributes() != null) {
            categoryAttributesModel.setAttributesId(source.getAttributes().getId());
            categoryAttributesModel.setAttributeName(source.getAttributes().getAttributeName());

        }

        if (CollectionUtils.isNotEmpty(source.getItemAttributeses())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributeses(),
                    TypeDescriptor.forObject(source.getItemAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            categoryAttributesModel.getItemAttributeModels().addAll(converted);
        }
        return categoryAttributesModel;

    }

    @Autowired
    public void setCategoryAttributesFactory(final ObjectFactory<CategoryAttributesModel> categoryAttributesFactory) {
        categoryAttributesModelFactory = categoryAttributesFactory;
    }
}