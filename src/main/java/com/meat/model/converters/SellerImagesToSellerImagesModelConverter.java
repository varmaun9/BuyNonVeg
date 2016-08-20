package com.meat.model.converters;

import com.meat.domain.SellerImages;
import com.meat.model.SellerImagesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerImagesToSellerImagesModelConverter")
public class SellerImagesToSellerImagesModelConverter implements Converter<SellerImages, SellerImagesModel> {

    @Autowired
    private ObjectFactory<SellerImagesModel> sellerImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerImagesToSellerImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerImagesModel convert(final SellerImages source) {
        // TODO Auto-generated method stub
        SellerImagesModel sellerImagesModel = sellerImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerImagesModel);

        return sellerImagesModel;

    }

    @Autowired
    public void setSellerImagesFactory(final ObjectFactory<SellerImagesModel> sellerImagesModelFactory) {
        this.sellerImagesModelFactory = sellerImagesModelFactory;
    }

}
