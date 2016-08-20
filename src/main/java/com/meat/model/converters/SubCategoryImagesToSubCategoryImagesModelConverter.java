/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubCategoryImages;
import com.meat.model.SubCategoryImagesModel;

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
@Component("SubCategoryImagesToSubCategoryImagesModelConverter")
public class SubCategoryImagesToSubCategoryImagesModelConverter implements Converter<SubCategoryImages, SubCategoryImagesModel> {

    @Autowired
    private ObjectFactory<SubCategoryImagesModel> subCategoryImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SubCategoryImagesToSubCategoryImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SubCategoryImagesModel convert(final SubCategoryImages source) {
        // TODO Auto-generated method stub
        SubCategoryImagesModel SubCategoryImagesModel = subCategoryImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, SubCategoryImagesModel);

        return SubCategoryImagesModel;

    }

    @Autowired
    public void setSubCategoryImagesFactory(final ObjectFactory<SubCategoryImagesModel> subCategoryImagesModelFactory) {
        this.subCategoryImagesModelFactory = subCategoryImagesModelFactory;
    }
}
