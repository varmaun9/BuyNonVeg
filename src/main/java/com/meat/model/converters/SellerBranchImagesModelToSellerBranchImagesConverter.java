package com.meat.model.converters;

import com.meat.domain.SellerBranchImages;
import com.meat.model.SellerBranchImagesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerBranchImagesModelToSellerBranchImagesConverter")
public class SellerBranchImagesModelToSellerBranchImagesConverter implements Converter<SellerBranchImagesModel, SellerBranchImages> {
    @Autowired
    private ObjectFactory<SellerBranchImages> sellerBranchImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchImages convert(final SellerBranchImagesModel source) {
        SellerBranchImages sellerBranchImages = sellerBranchImagesFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchImages);

        return sellerBranchImages;
    }

    @Autowired
    public void setSellerBranchImagesFactory(final ObjectFactory<SellerBranchImages> sellerBranchImagesFactory) {
        this.sellerBranchImagesFactory = sellerBranchImagesFactory;
    }

}
