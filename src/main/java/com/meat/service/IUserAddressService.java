package com.meat.service;

import com.meat.domain.UserAddress;

import java.util.List;

public interface IUserAddressService {

    UserAddress create(UserAddress userAddress);

    void deleteUserAddress(String userAddressId);

    List<UserAddress> getAll();

    UserAddress getUserAddress(String userAddressId);

    UserAddress updateUserAddress(UserAddress userAddress);

}
