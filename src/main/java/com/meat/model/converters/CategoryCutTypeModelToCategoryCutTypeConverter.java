/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryCutType;
import com.meat.model.CategoryCutTypeModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeModelToCategoryCutTypeConverter")
public class CategoryCutTypeModelToCategoryCutTypeConverter implements Converter<CategoryCutTypeModel, CategoryCutType> {
    @Autowired
    private ObjectFactory<CategoryCutType> categoryCutTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryCutType convert(final CategoryCutTypeModel source) {
        CategoryCutType categoryCutType = categoryCutTypeFactory.getObject();
        BeanUtils.copyProperties(source, categoryCutType);

        return categoryCutType;
    }

    @Autowired
    public void setCategoryCutTypeFactory(final ObjectFactory<CategoryCutType> categoryCutTypeFactory) {
        this.categoryCutTypeFactory = categoryCutTypeFactory;
    }
}
