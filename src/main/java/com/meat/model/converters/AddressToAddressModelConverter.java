/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Address;
import com.meat.model.AddressModel;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("addressToAddressModelConverter")
public class AddressToAddressModelConverter implements Converter<Address, AddressModel> {

    private static final Logger LOGGER = Logger.getLogger(AddressToAddressModelConverter.class);
    @Autowired
    private ObjectFactory<AddressModel> addressModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public AddressModel convert(final Address source) {
        // TODO Auto-generated method stub
        AddressModel addressModel = addressModelFactory.getObject();

        BeanUtils.copyProperties(source, addressModel);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionses())) {
            List<OrderDeliveryOptionsModel> converted = (List<OrderDeliveryOptionsModel>) conversionService.convert(
                    source.getOrderDeliveryOptionses(), TypeDescriptor.forObject(source.getOrderDeliveryOptionses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsModel.class));
            addressModel.getOrderDeliveryOptionsModels().addAll(converted);
        }
        /*  if (CollectionUtils.isNotEmpty(source.getUsers())) {
            List<UsersModel> converted = (List<UsersModel>) conversionService.convert(source.getUsers(),
                    TypeDescriptor.forObject(source.getUsers()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersModel.class));
            addressModel.getUserModels().addAll(converted);
        }*/
        /* if (CollectionUtils.isNotEmpty(source.getSellerBranches())) {
            List<SellerBranchModel> converted = (List<SellerBranchModel>) conversionService.convert(source.getSellerBranches(),
                    TypeDescriptor.forObject(source.getSellerBranches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchModel.class));
            addressModel.getSellerBranchModels().addAll(converted);
        }*/
        return addressModel;

    }

    @Autowired
    public void setAddressFactory(final ObjectFactory<AddressModel> addressModelFactory) {
        this.addressModelFactory = addressModelFactory;
    }
}