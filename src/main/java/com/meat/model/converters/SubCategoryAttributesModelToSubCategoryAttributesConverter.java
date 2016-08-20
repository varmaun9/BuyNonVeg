/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubCategoryAttributes;
import com.meat.model.SubCategoryAttributesModel;

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
@Component("subCategoryAttributesModelToSubCategoryAttributesConverter")
public class SubCategoryAttributesModelToSubCategoryAttributesConverter implements
Converter<SubCategoryAttributesModel, SubCategoryAttributes> {
    @Autowired
    private ObjectFactory<SubCategoryAttributes> subCategoryAttributesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryAttributes convert(final SubCategoryAttributesModel source) {
        SubCategoryAttributes subCategoryAttributes = subCategoryAttributesFactory.getObject();
        BeanUtils.copyProperties(source, subCategoryAttributes);

        return subCategoryAttributes;
    }

    @Autowired
    public void setSubCategoryAttributesFactory(final ObjectFactory<SubCategoryAttributes> subCategoryAttributesFactory) {
        this.subCategoryAttributesFactory = subCategoryAttributesFactory;
    }

}
