/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Address;
import com.meat.domain.UserAddress;
import com.meat.domain.Users;
import com.meat.model.UserAddressModel;
import com.meat.service.IUserAddressService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class UserAddressBusinessDelegate implements IBusinessDelegate<UserAddressModel, UserAddressContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserAddressService userAddressService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public UserAddressModel create(final UserAddressModel model) {
        UserAddress userAddress = new UserAddress();
        Address address = new Address();
        address.setId(model.getAddressId());
        userAddress.setAddress(address);
        Users users = new Users();
        users.setId(model.getUserId());
        userAddress.setUsers(users);
        userAddress = userAddressService.create(userAddress);
        model.setId(userAddress.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserAddressContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public UserAddressModel edit(final IKeyBuilder<String> keyBuilder, final UserAddressModel model) {
        UserAddress userAddress = userAddressService.getUserAddress(keyBuilder.build().toString());
        Address address = new Address();
        address.setId(model.getAddressId());
        userAddress.setAddress(address);
        Users users = new Users();
        users.setId(model.getUserId());
        userAddress.setUsers(users);
        userAddress = userAddressService.updateUserAddress(userAddress);
        model.setId(userAddress.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserAddressModel getByKey(final IKeyBuilder<String> keyBuilder, final UserAddressContext context) {
        UserAddress userAddress = userAddressService.getUserAddress(keyBuilder.build().toString());
        UserAddressModel userAddressModel = conversionService.convert(userAddress, UserAddressModel.class);
        return userAddressModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserAddressModel> getCollection(final UserAddressContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
