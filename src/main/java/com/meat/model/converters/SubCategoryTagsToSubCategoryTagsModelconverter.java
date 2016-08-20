/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubCategoryTags;
import com.meat.model.SubCategoryTagsModel;

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
@Component("subCategoryTagsToSubCategoryTagsModelconverter")
public class SubCategoryTagsToSubCategoryTagsModelconverter implements Converter<SubCategoryTags, SubCategoryTagsModel> {

    private static final Logger LOGGER = Logger.getLogger(SubCategoryTagsToSubCategoryTagsModelconverter.class);
    @Autowired
    private ObjectFactory<SubCategoryTagsModel> subCategoryTagsModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SubCategoryTagsModel convert(final SubCategoryTags source) {
        // TODO Auto-generated method stub
        SubCategoryTagsModel subCategoryTagsModel = subCategoryTagsModelFactory.getObject();

        BeanUtils.copyProperties(source, subCategoryTagsModel);
        subCategoryTagsModel.setSubCategoryId(source.getSubCategory().getId());
        if (source.getTags() != null) {
            subCategoryTagsModel.setTagsId(source.getTags().getId());
            subCategoryTagsModel.setTagName(source.getTags().getTagName());
            subCategoryTagsModel.setTagTypeName(source.getTags().getTagType().getTagTypeName());
        }
        return subCategoryTagsModel;

    }

    @Autowired
    public void setSubCategoryTagsFactory(final ObjectFactory<SubCategoryTagsModel> subCategoryTagsModelFactory) {
        this.subCategoryTagsModelFactory = subCategoryTagsModelFactory;
    }
}
