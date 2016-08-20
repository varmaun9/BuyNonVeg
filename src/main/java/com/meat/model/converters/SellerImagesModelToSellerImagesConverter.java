package com.meat.model.converters;

import com.meat.domain.SellerImages;
import com.meat.model.SellerImagesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerImagesModelToSellerImagesConverter")
public class SellerImagesModelToSellerImagesConverter implements Converter<SellerImagesModel, SellerImages> {
    @Autowired
    private ObjectFactory<SellerImages> sellerImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerImages convert(final SellerImagesModel source) {
        SellerImages sellerImages = sellerImagesFactory.getObject();
        BeanUtils.copyProperties(source, sellerImages);

        return sellerImages;
    }

    @Autowired
    public void setSellerImagesFactory(final ObjectFactory<SellerImages> sellerImagesFactory) {
        this.sellerImagesFactory = sellerImagesFactory;
    }
}
