/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerUser;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerUserRepository extends PagingAndSortingRepository<SellerUser, Serializable> {

    /**
     * @param emailId
     * @return
     */
    @Query("SELECT su FROM SellerUser su where su.userEmail=?1")
    SellerUser findByEmailId(String emailId);

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("select distinct su from SellerUser su where su.sellerBranch.id=?1")
    List<SellerUser> findSellerBranchAllUsers(String sellerBranchId);

    /**
     * @param sellerBranchId
     * @param string
     * @return
     */
    @Query("select su FROM SellerUser su JOIN su.sellerBranch sb WHERE su.userRoleType = ?2 AND sb.id=?1")
    List<SellerUser> findSellerUsersByRoleBranch(String sellerBranchId, String string);

}
