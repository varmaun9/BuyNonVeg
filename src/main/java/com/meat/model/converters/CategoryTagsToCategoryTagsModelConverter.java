/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryTags;
import com.meat.model.CategoryTagsModel;

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
@Component("categoryTagsToCategoryTagsModelConverter")
public class CategoryTagsToCategoryTagsModelConverter implements Converter<CategoryTags, CategoryTagsModel> {

    private static final Logger LOGGER = Logger.getLogger(CategoryTagsToCategoryTagsModelConverter.class);
    @Autowired
    private ObjectFactory<CategoryTagsModel> categoryTagsModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryTagsModel convert(final CategoryTags source) {
        // TODO Auto-generated method stub
        CategoryTagsModel categoryTagsModel = categoryTagsModelFactory.getObject();
        BeanUtils.copyProperties(source, categoryTagsModel);
        categoryTagsModel.setTagName(source.getTags().getTagName());
        categoryTagsModel.setCategoryId(source.getCategory().getId());
        categoryTagsModel.setTagsId(source.getTags().getId());
        categoryTagsModel.setTagTypeName(source.getTags().getTagType().getTagTypeName());
        return categoryTagsModel;

    }

    @Autowired
    public void setCategoryTagsFactory(final ObjectFactory<CategoryTagsModel> categoryTagsModelFactory) {
        this.categoryTagsModelFactory = categoryTagsModelFactory;
    }
}
