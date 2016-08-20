/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Address;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchAddress;
import com.meat.model.SellerBranchAddressModel;
import com.meat.service.IAddressService;
import com.meat.service.ISellerBranchAddressService;

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
public class SellerBranchAddressBusinessDelegate
        implements IBusinessDelegate<SellerBranchAddressModel, SellerBranchAddressContext, IKeyBuilder<String>, String> {
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ISellerBranchAddressService sellerBranchAddressService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchAddressModel create(final SellerBranchAddressModel model) {

        SellerBranchAddress sellerBranchAddress = new SellerBranchAddress();

        Address address = new Address();
        address.setId(model.getAddressId());
        sellerBranchAddress.setAddress(address);
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchAddress.setSellerBranch(sellerBranch);
        sellerBranchAddress = sellerBranchAddressService.create(sellerBranchAddress);
        model.setId(sellerBranchAddress.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchAddressContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchAddressModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchAddressModel model) {

        SellerBranchAddress sellerBranchAddress = sellerBranchAddressService.getSellerBranchAddress(keyBuilder.build().toString());
        Address address = new Address();
        if (model.getAddressId() != null) {
            address.setId(model.getAddressId());
            address.setArea(model.getArea());
            address.setCity(model.getCity());
            address.setCountry(model.getCountry());
            address.setDistrict(model.getDistrict());
            address.setLine1(model.getLine1());
            address.setState(model.getState());
            address.setZipcode(model.getZipcode());
            address.setType(model.getType());
            address.setTown(model.getTown());
            address = addressService.updateAddress(address);
        }
        sellerBranchAddress.setAddress(address);
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchAddress.setSellerBranch(sellerBranch);
        sellerBranchAddress.setStatus(model.getStatus());
        sellerBranchAddress = sellerBranchAddressService.updateSellerBranchAddress(sellerBranchAddress);
        model.setId(sellerBranchAddress.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchAddressModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchAddressContext context) {
        SellerBranchAddress sellerBranchAddress = sellerBranchAddressService.getSellerBranchAddress(keyBuilder.build().toString());
        SellerBranchAddressModel sellerBranchAddressModel = conversionService.convert(sellerBranchAddress, SellerBranchAddressModel.class);

        return sellerBranchAddressModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchAddressModel> getCollection(final SellerBranchAddressContext context) {
        List<SellerBranchAddress> sellerBranchAddress = new ArrayList<SellerBranchAddress>();

        if (context.getAll() != null) {
            sellerBranchAddress = sellerBranchAddressService.getAll();
        }
        if (context.getSellerBranchId() != null) {
            sellerBranchAddress = sellerBranchAddressService.getSellerBranchAddressBySellerBranch(context.getSellerBranchId());
        }

        List<SellerBranchAddressModel> sellerBranchAddressModels = (List<SellerBranchAddressModel>) conversionService.convert(
                sellerBranchAddress, TypeDescriptor.forObject(sellerBranchAddress),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchAddressModel.class)));
        return sellerBranchAddressModels;
    }

}
