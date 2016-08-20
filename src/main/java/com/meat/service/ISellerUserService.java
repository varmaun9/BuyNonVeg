/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerUser;

import java.util.List;

/**
 * @author varma
 *
 */
public interface ISellerUserService {
    boolean checkEmailExists(String email);

    SellerUser create(SellerUser sellerUser);

    void deleteSellerUser(String sellerUserId);

    /**
     * @param sellerUserId
     * @param confirmPassword
     * @param newPassword
     * @param password
     * @return
     */
    SellerUser findByChangePassword(String sellerUserId, String confirmPassword, String newPassword, String password);

    List<SellerUser> getAll();

    /**
     * @param sellerBranchId
     * @return
     */
    List<SellerUser> getSellerBranchAllUsers(String sellerBranchId);

    /**
     * @param sellerBranchId
     * @param sellerUserRole
     * @return
     */
    List<SellerUser> getSellerBranchUsersByUserRoles(String sellerBranchId, String sellerUserRole);

    SellerUser getSellerUser(String sellerUserId);

    /**
     * @param emailId
     * @return
     */
    SellerUser getSellerUserByEmail(String emailId);

    /**
     * @return
     */
    List<SellerUser> getSellerUserOnly();

    SellerUser updateSellerUser(SellerUser sellerUser);
}
