/**
 *
 */
package com.meat.dao;

import com.meat.domain.Users;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface UsersRepository extends PagingAndSortingRepository<Users, Serializable> {

    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailId(String username);

    /**
     * @param e
     * @return
     */
    @Query("select u from Users u where u.emailId=?1")
    Users findByEmailIdAndPassword(String e);

    /**
     * @param username
     * @return
     */
    @Query("select distinct u from Users u where u.emailId=?1 and u.status='ACTIVE'")
    Users findByEmailIdStatus(String username);

    /**
     * @param phoneNo
     * @return
     */
    @Query("select u from Users u where u.phoneNo=?1")
    Users findByPhoneNo(String phoneNo);

    /**
     * @param sellerUserId
     * @return
     */
    @Query("select distinct u from Users u join u.sellerUser su where su.id=?1")
    Users findBySellerUser(String sellerUserId);

    /**
     * @param id
     * @return
     */
    @Query("select distinct u from Users u where u.id=?1")
    Users findByUserId(String id);

    /**
     * @param userType
     * @return
     */
    @Query("select u from Users u where u.userType=?1")
    List<Users> getByUserType(String userType);

    @Query("select MAX(userCount) from  Users u")
    Integer getMaxCode();
}
