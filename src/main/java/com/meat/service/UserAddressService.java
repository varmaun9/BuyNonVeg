package com.meat.service;

import com.meat.dao.UserAddressRepository;
import com.meat.domain.UserAddress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAddressService implements IUserAddressService {
    @Autowired
    private UserAddressRepository userAddressRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserAddressService#create(com.meat.domain.UserAddress)
     */
    @Override
    public UserAddress create(final UserAddress userAddress) {
        // TODO Auto-generated method stub
        return userAddressRepository.save(userAddress);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserAddressService#deleteUserAddress(java.lang.String)
     */
    @Override
    public void deleteUserAddress(final String userAddressId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserAddressService#getAll()
     */
    @Override
    public List<UserAddress> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserAddressService#getUserAddress(java.lang.String)
     */
    @Override
    public UserAddress getUserAddress(final String userAddressId) {
        // TODO Auto-generated method stub
        return userAddressRepository.findOne(userAddressId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserAddressService#updateUserAddress(com.meat.domain.UserAddress)
     */
    @Override
    public UserAddress updateUserAddress(final UserAddress userAddress) {
        // TODO Auto-generated method stub
        return userAddressRepository.save(userAddress);
    }

}
