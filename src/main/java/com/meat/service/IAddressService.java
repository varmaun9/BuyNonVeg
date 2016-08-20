/**
 *
 */
package com.meat.service;

import com.meat.domain.Address;

import java.util.List;

/**
 * @author Administrator
 *
 */
public interface IAddressService {

    Address create(Address address);

    void deleteAddress(String addressId);

    Address getAddress(String addressId);

    List<Address> getAll();

    /**
     * @param id
     * @return
     */
    List<Address> getAllAddressByUser(String id);

    List<Address> getCity(String city);

    Address updateAddress(Address address);

}
