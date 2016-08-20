/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubCategoryAttributes;
import com.meat.model.SubCategoryAttributesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("subCategoryAttributesToSubCategoryAttributesModelConverter")
public class SubCategoryAttributesToSubCategoryAttributesModelConverter implements
Converter<SubCategoryAttributes, SubCategoryAttributesModel> {

    @Autowired
    private ObjectFactory<SubCategoryAttributesModel> subCategoryAttributesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SubCategoryAttributesToSubCategoryAttributesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public SubCategoryAttributesModel convert(final SubCategoryAttributes source) {
        // TODO Auto-generated method stub
        SubCategoryAttributesModel subCategoryAttributesModel = subCategoryAttributesModelFactory.getObject();

        BeanUtils.copyProperties(source, subCategoryAttributesModel);
        subCategoryAttributesModel.setSubCategoryId(source.getSubCategory().getId());
        subCategoryAttributesModel.setAttributesId(source.getAttributes().getId());

        return subCategoryAttributesModel;

    }

    @Autowired
    public void setSubCategoryAttributesFactory(final ObjectFactory<SubCategoryAttributesModel> subCategoryAttributesModelFactory) {
        this.subCategoryAttributesModelFactory = subCategoryAttributesModelFactory;
    }
}
