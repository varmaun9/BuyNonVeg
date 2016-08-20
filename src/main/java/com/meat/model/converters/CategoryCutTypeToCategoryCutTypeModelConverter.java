/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryCutType;
import com.meat.model.CategoryCutTypeModel;

import org.apache.log4j.Logger;
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
@Component("categoryCutTypeToCategoryCutTypeModelConverter")
public class CategoryCutTypeToCategoryCutTypeModelConverter implements Converter<CategoryCutType, CategoryCutTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(CategoryCutTypeToCategoryCutTypeModelConverter.class);
    @Autowired
    private ObjectFactory<CategoryCutTypeModel> categoryCutTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryCutTypeModel convert(final CategoryCutType source) {
        // TODO Auto-generated method stub
        CategoryCutTypeModel categoryCutTypeModel = categoryCutTypeModelFactory.getObject();
        BeanUtils.copyProperties(source, categoryCutTypeModel);
        categoryCutTypeModel.setCategoryId(source.getCategory().getId());
        categoryCutTypeModel.setCutTypeId(source.getCutType().getId());
        categoryCutTypeModel.setCutTypeName(source.getCutType().getCutTypeName());

        return categoryCutTypeModel;

    }

    @Autowired
    public void setCategoryCutTypeFactory(final ObjectFactory<CategoryCutTypeModel> categoryCutTypeModelFactory) {
        this.categoryCutTypeModelFactory = categoryCutTypeModelFactory;
    }
}
