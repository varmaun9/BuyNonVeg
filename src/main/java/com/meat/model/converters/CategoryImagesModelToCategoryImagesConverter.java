/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryImages;
import com.meat.model.CategoryImagesModel;

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
@Component("categoryImagesModelToCategoryImagesConverter")
public class CategoryImagesModelToCategoryImagesConverter implements Converter<CategoryImagesModel, CategoryImages> {
    @Autowired
    private ObjectFactory<CategoryImages> categoryImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryImages convert(final CategoryImagesModel source) {
        CategoryImages categoryImages = categoryImagesFactory.getObject();
        BeanUtils.copyProperties(source, categoryImages);

        return categoryImages;
    }

    @Autowired
    public void setCategoryImagesFactory(final ObjectFactory<CategoryImages> categoryImagesFactory) {
        this.categoryImagesFactory = categoryImagesFactory;
    }

}
