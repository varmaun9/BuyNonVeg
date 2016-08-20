package com.meat.model.converters;

import com.meat.domain.SellerBranchAddress;
import com.meat.model.SellerBranchAddressModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerBranchAddressModelToSellerBranchAddressConverter")
public class SellerBranchAddressModelToSellerBranchAddressConverter implements Converter<SellerBranchAddressModel, SellerBranchAddress> {
    @Autowired
    private ObjectFactory<SellerBranchAddress> sellerBranchAddressFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchAddress convert(final SellerBranchAddressModel source) {
        SellerBranchAddress sellerBranchAddress = sellerBranchAddressFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchAddress);

        return sellerBranchAddress;
    }

    @Autowired
    public void setSellerBranchAddressFactory(final ObjectFactory<SellerBranchAddress> sellerBranchAddressFactory) {
        this.sellerBranchAddressFactory = sellerBranchAddressFactory;
    }

}
