/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Address;
import com.meat.model.AddressModel;
import com.meat.service.IAddressService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class AddressBusinessDelegate implements IBusinessDelegate<AddressModel, AddressContext, IKeyBuilder<String>, String> {

    @Autowired
    private IAddressService addressService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public AddressModel create(final AddressModel model) {
        Address address = new Address();
        address.setCity(model.getCity());
        address.setDistrict(model.getDistrict());
        address.setLine1(model.getLine1());
        address.setState(model.getState());
        address.setCountry(model.getCountry());
        address.setArea(model.getArea());
        address.setType(model.getType());
        address.setZipcode(model.getZipcode());
        address.setTown(model.getTown());
        address.setContactPerson(model.getContactPerson());
        address.setId(model.getId());
        if (model.getMobileNo() != null) {
            address.setMobileNo(model.getMobileNo());
        }
        address = addressService.create(address);
        model.setId(address.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final AddressContext context) {

        addressService.deleteAddress(keyBuilder.build().toString());

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public AddressModel edit(final IKeyBuilder<String> keyBuilder, final AddressModel model) {
        Address address = addressService.getAddress(keyBuilder.build().toString());
        address.setCity(model.getCity());
        address.setDistrict(model.getDistrict());
        address.setLine1(model.getLine1());
        address.setState(model.getState());
        address.setType(model.getType());
        address.setDistrict(model.getDistrict());
        address.setZipcode(model.getZipcode());
        address.setArea(model.getArea());
        address.setContactPerson(model.getContactPerson());
        address.setTown(model.getTown());
        address.setDefaultStatus(model.getDefaultStatus());
        address.setId(model.getId());

        address = addressService.updateAddress(address);
        model.setId(address.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public AddressModel getByKey(final IKeyBuilder<String> keyBuilder, final AddressContext context) {
        Address address = addressService.getAddress(keyBuilder.build().toString());
        AddressModel addressModel = conversionService.convert(address, AddressModel.class);

        return addressModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<AddressModel> getCollection(final AddressContext context) {
        List<Address> address = new ArrayList<Address>();

        if (context.getAll() != null) {
            address = addressService.getAll();
        }
        List<AddressModel> amountTypeModels = (List<AddressModel>) conversionService.convert(address, TypeDescriptor.forObject(address),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AddressModel.class)));
        return amountTypeModels;

    }

}
