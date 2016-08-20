/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerUserModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerUserModel extends AbstractModel {

    private String userName;
    private String userEmail;
    private String userPhoneNo;
    private String userStatus;
    private String usersId;
    private String sellerBranchId;
    private String sellerBranchName;
    private String sellerName;
    private String gender;
    private String password;
    private String confirmPassword;
    private String newPassword;
    private String authenticateStatus;
    private String createdDate;
    private String emailStatus;
    private String sellerUserType;
    private String userEmailIdStatus;
    private String userRoleType;
    private String sellerUserEmailExists;
    private String sellerUserPhoneNoExists;

    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the sellerBranchName
     */
    public String getSellerBranchName() {
        return sellerBranchName;
    }

    /**
     * @return the sellerName
     */
    public String getSellerName() {
        return sellerName;
    }

    public String getSellerUserEmailExists() {
        return sellerUserEmailExists;
    }

    /**
     * @return the sellerUserPhoneNoExists
     */
    public String getSellerUserPhoneNoExists() {
        return sellerUserPhoneNoExists;
    }

    public String getSellerUserType() {
        return sellerUserType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserEmailIdStatus() {
        return userEmailIdStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    /**
     * @return the userRoleType
     */
    public String getUserRoleType() {
        return userRoleType;
    }

    public String getUsersId() {
        return usersId;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setAuthenticateStatus(final String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setEmailStatus(final String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param sellerBranchName
     *            the sellerBranchName to set
     */
    public void setSellerBranchName(final String sellerBranchName) {
        this.sellerBranchName = sellerBranchName;
    }

    /**
     * @param sellerName
     *            the sellerName to set
     */
    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerUserEmailExists(final String sellerUserEmailExists) {
        this.sellerUserEmailExists = sellerUserEmailExists;
    }

    /**
     * @param sellerUserPhoneNoExists
     *            the sellerUserPhoneNoExists to set
     */
    public void setSellerUserPhoneNoExists(final String sellerUserPhoneNoExists) {
        this.sellerUserPhoneNoExists = sellerUserPhoneNoExists;
    }

    public void setSellerUserType(final String sellerUserType) {
        this.sellerUserType = sellerUserType;
    }

    public void setUserEmail(final String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserEmailIdStatus(final String userEmailIdStatus) {
        this.userEmailIdStatus = userEmailIdStatus;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public void setUserPhoneNo(final String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    /**
     * @param userRoleType
     *            the userRoleType to set
     */
    public void setUserRoleType(final String userRoleType) {
        this.userRoleType = userRoleType;
    }

    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

    public void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
