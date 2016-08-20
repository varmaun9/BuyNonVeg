/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryImages;
import com.meat.model.CategoryImagesModel;

import org.apache.log4j.Logger;
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
@Component("categoryImagesToCategoryimagesModelConvertor")
public class CategoryImageslToCategoryImagesModelConverter implements Converter<CategoryImages, CategoryImagesModel> {

    @Autowired
    private ObjectFactory<CategoryImagesModel> categoryImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(CategoryImageslToCategoryImagesModelConverter.class);

    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryImagesModel convert(final CategoryImages source) {
        // TODO Auto-generated method stub
        CategoryImagesModel categoryImagesModel = categoryImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, categoryImagesModel);

        return categoryImagesModel;

    }

    @Autowired
    public void setCategoryImagesModelFactory(final ObjectFactory<CategoryImagesModel> categoryImagesModelFactory) {
        this.categoryImagesModelFactory = categoryImagesModelFactory;
    }
}
