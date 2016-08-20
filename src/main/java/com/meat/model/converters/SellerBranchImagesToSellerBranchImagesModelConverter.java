package com.meat.model.converters;

import com.meat.domain.SellerBranchImages;
import com.meat.model.SellerBranchImagesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerBranchImagesToSellerBranchImagesModelConverter")
public class SellerBranchImagesToSellerBranchImagesModelConverter implements Converter<SellerBranchImages, SellerBranchImagesModel> {

    @Autowired
    private ObjectFactory<SellerBranchImagesModel> sellerBranchImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerBranchImagesToSellerBranchImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchImagesModel convert(final SellerBranchImages source) {
        // TODO Auto-generated method stub
        SellerBranchImagesModel sellerBranchImagesModel = sellerBranchImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerBranchImagesModel);

        return sellerBranchImagesModel;

    }

    @Autowired
    public void setSellerBranchImagesFactory(final ObjectFactory<SellerBranchImagesModel> sellerBranchImagesModelFactory) {
        this.sellerBranchImagesModelFactory = sellerBranchImagesModelFactory;
    }

}
