/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.AddressModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Class to convert address model domain to address
 *
 * @author venkyp
 *
 */
@Component("addressModelToAddressConverter")
public class AddressModelToAddressConverter implements Converter<AddressModel, Address> {
    @Autowired
    private ObjectFactory<Address> addressFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Address convert(final AddressModel source) {
        Address address = addressFactory.getObject();
        BeanUtils.copyProperties(source, address);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsModels())) {
            List<OrderDeliveryOptions> converted = (List<OrderDeliveryOptions>) conversionService.convert(
                    source.getOrderDeliveryOptionsModels(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptions.class));
            address.getOrderDeliveryOptionses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserModels())) {
            List<Users> converted = (List<Users>) conversionService.convert(source.getUserModels(),
                    TypeDescriptor.forObject(source.getUserModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserAddress.class));
            address.getUsers().addAll(converted);
        }
        /* if (CollectionUtils.isNotEmpty(source.getSellerBranchModels())) {
            List<SellerBranch> converted = (List<SellerBranch>) conversionService.convert(source.getSellerBranchModels(),
                    TypeDescriptor.forObject(source.getSellerBranchModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranch.class));
            address.getSellerBranches().addAll(converted);
        }*/
        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressModels())) {
            List<SellerBranchAddress> converted = (List<SellerBranchAddress>) conversionService.convert(
                    source.getSellerBranchAddressModels(), TypeDescriptor.forObject(source.getSellerBranchAddressModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranch.class));
            address.getSellerBranchAddresses().addAll(converted);
        }
        return address;
    }

    @Autowired
    public void setAddressFactory(final ObjectFactory<Address> addressFactory) {
        this.addressFactory = addressFactory;
    }

}
