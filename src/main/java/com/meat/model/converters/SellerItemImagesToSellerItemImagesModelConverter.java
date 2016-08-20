package com.meat.model.converters;

import com.meat.domain.SellerItemImages;
import com.meat.model.SellerItemImagesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerItemImagesToSellerItemImagesModelConverter")
public class SellerItemImagesToSellerItemImagesModelConverter implements Converter<SellerItemImages, SellerItemImagesModel> {

    @Autowired
    private ObjectFactory<SellerItemImagesModel> sellerItemImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerItemImagesToSellerItemImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerItemImagesModel convert(final SellerItemImages source) {
        // TODO Auto-generated method stub
        SellerItemImagesModel sellerItemImagesModel = sellerItemImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerItemImagesModel);

        return sellerItemImagesModel;

    }

    @Autowired
    public void setSellerItemImagesFactory(final ObjectFactory<SellerItemImagesModel> sellerItemImagesModelFactory) {
        this.sellerItemImagesModelFactory = sellerItemImagesModelFactory;
    }

}
