/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryTags;
import com.meat.model.CategoryTagsModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("categoryTagsModelToCategoryTagsConverter")
public class CategoryTagsModelToCategoryTagsConverter implements Converter<CategoryTagsModel, CategoryTags> {
    @Autowired
    private ObjectFactory<CategoryTags> categoryTagsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryTags convert(final CategoryTagsModel source) {
        CategoryTags categoryTags = categoryTagsFactory.getObject();
        BeanUtils.copyProperties(source, categoryTags);

        return categoryTags;
    }

    @Autowired
    public void setCategoryTagsFactoryFactory(final ObjectFactory<CategoryTags> categoryTagsFactory) {
        this.categoryTagsFactory = categoryTagsFactory;
    }

}
