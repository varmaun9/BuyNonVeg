/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CategoryCriteria;
import com.meat.model.CategoryCriteriaModel;

import org.apache.log4j.Logger;
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
@Component("categoryCriteriaToCategoryCriteriaModelConverter")
public class CategoryCriteriaToCategoryCriteriaModelConverter implements Converter<CategoryCriteria, CategoryCriteriaModel> {

    private static final Logger LOGGER = Logger.getLogger(CategoryCriteriaToCategoryCriteriaModelConverter.class);
    @Autowired
    private ObjectFactory<CategoryCriteriaModel> categoryCriteriaModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CategoryCriteriaModel convert(final CategoryCriteria source) {
        // TODO Auto-generated method stub
        CategoryCriteriaModel categoryCriteriaModel = categoryCriteriaModelFactory.getObject();
        BeanUtils.copyProperties(source, categoryCriteriaModel);

        if (source.getCriteria() != null) {
            categoryCriteriaModel.setCriteriaId(source.getCriteria().getId());
            categoryCriteriaModel.setCriteriaName(source.getCriteria().getCriteriaName());
        }
        if (source.getCategory() != null) {
            categoryCriteriaModel.setCategoryId(source.getCategory().getId());
            categoryCriteriaModel.setCategoryName(source.getCategory().getCategoryName());
        }
        return categoryCriteriaModel;

    }

    @Autowired
    public void setCategoryCriteriaFactory(final ObjectFactory<CategoryCriteriaModel> categoryCriteriaModelFactory) {
        this.categoryCriteriaModelFactory = categoryCriteriaModelFactory;
    }
}
