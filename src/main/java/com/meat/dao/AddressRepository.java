/**
 *
 */
package com.meat.dao;

import com.meat.domain.Address;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Administrator
 *
 */
public interface AddressRepository extends PagingAndSortingRepository<Address, Serializable> {

    /**
     * @param id
     * @return
     */
    @Query("select DISTINCT a from Address a join a.users u where u.id=?1")
    List<Address> findAddressByUser(String id);

    /**
     * @param id
     * @return
     */
    /*  @Query("SELECT DISTINCT a FROM Address a JOIN a.orderDeliveryOptionses odp JOIN odp.orders o JOIN o.users u WHERE u.id=?1")
    List<Address> findAddressByUser(String id);*/

}
