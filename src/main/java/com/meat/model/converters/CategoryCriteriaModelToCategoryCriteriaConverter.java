/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryCriteria;
import com.meat.model.CategoryCriteriaModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("categoryCriteriaModelToCategoryCriteriaConverter")
public class CategoryCriteriaModelToCategoryCriteriaConverter implements Converter<CategoryCriteriaModel, CategoryCriteria> {
    @Autowired
    private ObjectFactory<CategoryCriteria> categoryCriteriaFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryCriteria convert(final CategoryCriteriaModel source) {
        CategoryCriteria categoryCriteria = categoryCriteriaFactory.getObject();
        BeanUtils.copyProperties(source, categoryCriteria);

        return categoryCriteria;
    }

    @Autowired
    public void setCategoryCriteriaFactory(final ObjectFactory<CategoryCriteria> categoryCriteriaFactory) {
        this.categoryCriteriaFactory = categoryCriteriaFactory;
    }
}