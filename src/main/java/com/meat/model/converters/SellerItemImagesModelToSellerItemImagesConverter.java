package com.meat.model.converters;

import com.meat.domain.SellerItemImages;
import com.meat.model.SellerItemImagesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerItemImagesModelToSellerItemImagesConverter")
public class SellerItemImagesModelToSellerItemImagesConverter implements Converter<SellerItemImagesModel, SellerItemImages> {
    @Autowired
    private ObjectFactory<SellerItemImages> sellerItemImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemImages convert(final SellerItemImagesModel source) {
        SellerItemImages sellerItemImages = sellerItemImagesFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemImages);

        return sellerItemImages;
    }

    @Autowired
    public void setSellerItemImagesFactory(final ObjectFactory<SellerItemImages> sellerItemImagesFactory) {
        this.sellerItemImagesFactory = sellerItemImagesFactory;
    }

}
