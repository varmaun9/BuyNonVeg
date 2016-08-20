/**
 *
 */
package com.meat.service;

import com.meat.dao.AddressRepository;
import com.meat.domain.Address;
import com.meat.domain.Users;
import com.meat.security.CustomUserDetails;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public class AddressService implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#create(com.nonveg.domain.Address)
     */
    @Override

    public Address create(final Address address) {
        Address addrss = new Address();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        // TODO Auto-generated method stub
        if (userDetails.getUserType() != null) {
            if (userDetails.getUserType().equals("CUSTOMER")) {
                Users u = new Users();
                u.setId(userDetails.getId());
                Set<Users> urs = new HashSet<Users>(Arrays.asList(u));
                address.setUsers(urs);
            }
        }
        addrss = addressRepository.save(address);
        return addrss;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#deleteAddress(java.lang.String)
     */
    @Override
    public void deleteAddress(final String addressId) {
        Address address = new Address();
        address.setId(addressId);
        addressRepository.delete(address);

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#getAddress(java.lang.String)
     */
    @Override
    public Address getAddress(final String addressId) {
        // TODO Auto-generated method stub
        return addressRepository.findOne(addressId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#getAll()
     */
    @Override
    public List<Address> getAll() {
        List<Address> address = new ArrayList<Address>();
        address = (List<Address>) addressRepository.findAll();
        return address;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAddressService#getAllAddressByUser(java.lang.String)
     */
    @Override
    public List<Address> getAllAddressByUser(final String id) {
        // TODO Auto-generated method stub
        return addressRepository.findAddressByUser(id);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#getCity(java.lang.String)
     */
    @Override
    public List<Address> getCity(final String city) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAddressService#updateAddress(com.nonveg.domain.Address)
     */
    @Override
    public Address updateAddress(final Address address) {
        // TODO Auto-generated method stub
        return addressRepository.save(address);
    }

}
