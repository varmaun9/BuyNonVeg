package com.meat.model.converters;

import com.meat.domain.SellerBranchAddress;
import com.meat.model.SellerBranchAddressModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerBranchAddressToSellerBranchAddressModelConverter")
public class SellerBranchAddressToSellerBranchAddressModelConverter implements Converter<SellerBranchAddress, SellerBranchAddressModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerBranchAddressToSellerBranchAddressModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchAddressModel> sellerBranchAddressModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchAddressModel convert(final SellerBranchAddress source) {
        // TODO Auto-generated method stub
        SellerBranchAddressModel sellerBranchAddressModel = sellerBranchAddressModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchAddressModel);
        if (source.getAddress() != null) {
            sellerBranchAddressModel.setLine1(source.getAddress().getLine1());
            sellerBranchAddressModel.setArea(source.getAddress().getArea());
            sellerBranchAddressModel.setType(source.getAddress().getType());
            sellerBranchAddressModel.setCity(source.getAddress().getCity());
            sellerBranchAddressModel.setContactPerson(source.getAddress().getContactPerson());
            sellerBranchAddressModel.setCountry(source.getAddress().getCountry());
            sellerBranchAddressModel.setDefaultStatus(source.getAddress().getDefaultStatus());
            sellerBranchAddressModel.setDistrict(source.getAddress().getDistrict());
            sellerBranchAddressModel.setMobileNo(source.getAddress().getMobileNo());
            sellerBranchAddressModel.setState(source.getAddress().getState());
            sellerBranchAddressModel.setZipcode(source.getAddress().getZipcode());
            sellerBranchAddressModel.setTown(source.getAddress().getTown());
        }
        if (source.getSellerBranch() != null) {
            sellerBranchAddressModel.setSellerBranchId(source.getSellerBranch().getId());
        }
        if (source.getAddress() != null) {
            sellerBranchAddressModel.setAddressId(source.getAddress().getId());
        }
        return sellerBranchAddressModel;

    }

    @Autowired
    public void setSellerBranchAddressFactory(final ObjectFactory<SellerBranchAddressModel> sellerBranchAddressModelFactory) {
        this.sellerBranchAddressModelFactory = sellerBranchAddressModelFactory;
    }

}
