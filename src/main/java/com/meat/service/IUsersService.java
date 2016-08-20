package com.meat.service;

import com.meat.domain.UserImages;
import com.meat.domain.Users;

import java.util.List;

public interface IUsersService {

    Users addUserImages(Users users, List<UserImages> userImag);

    /**
     * @param email
     * @return
     */
    boolean checkEmailExists(String email);

    Users create(Users users);

    void deleteUsers(String usersId);

    /**
     * @param emailId
     * @param password
     * @return
     */
    Users findByEmailIdAndPassword(String emailId, String password);

    /**
     * @param id
     * @return
     */
    Users findByUser(String id);

    List<Users> getAll();

    /**
     * @param userId
     * @param confirmPassword
     * @param newPassword
     * @param password
     * @return
     */
    Users getByChangePassword(String userId, String confirmPassword, String newPassword, String password);

    /**
     * @param userId
     * @param confirmPassword
     * @param newPassword
     * @return
     */
    Users getByResetPassword(String userId, String confirmPassword, String newPassword);

    /**
     * @param userType
     * @return
     */
    List<Users> getByUserType(String userType);

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param id
     * @return
     */
    Users getUserBySellerUser(String id);

    /**
     * @param user
     * @return
     */
    Users getUserResetPassword(Users user);

    Users getUsers(String usersId);

    /**
     * @param emailId
     * @return
     */
    Users getUsersByEmailId(String emailId);

    /**
     * @return
     */
    List<Users> getUsersOnly();

    Users updateUsers(Users users);

}
