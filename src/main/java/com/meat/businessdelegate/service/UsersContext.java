package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component("usersContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsersContext implements IBusinessDelegateContext {

    private String all;
    private String usersOnly;
    private String userId;
    private String emailId;
    private String phoneNo;
    private String userRole;
    private String password;
    private String changePassword;
    private String newPassword;
    private String confirmPassword;
    private String sellerBranchId;
    private String forgotPasswordStatus;
    private String userType;
    private String onlyUsers;
    private String onlyActiveUsers;
    private String resetPasswordStatus;
    private String currentPassword;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return the changePassword
     */
    public String getChangePassword() {
        return changePassword;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the currentPassword
     */
    public String getCurrentPassword() {
        return currentPassword;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @return the forgotPasswordStatus
     */
    public String getForgotPasswordStatus() {
        return forgotPasswordStatus;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @return the onlyActiveUsers
     */
    public String getOnlyActiveUsers() {
        return onlyActiveUsers;
    }

    /**
     * @return the onlyUsers
     */
    public String getOnlyUsers() {
        return onlyUsers;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @return
     */
    public String getUsersOnly() {
        // TODO Auto-generated method stub
        return usersOnly;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param changePassword
     *            the changePassword to set
     */
    public void setChangePassword(final String changePassword) {
        this.changePassword = changePassword;
    }

    /**
     * @param confirmPassword
     *            the confirmPassword to set
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @param currentPassword
     *            the currentPassword to set
     */
    public void setCurrentPassword(final String currentPassword) {
        this.currentPassword = currentPassword;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @param forgotPasswordStatus
     *            the forgotPasswordStatus to set
     */
    public void setForgotPasswordStatus(final String forgotPasswordStatus) {
        this.forgotPasswordStatus = forgotPasswordStatus;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @param onlyActiveUsers
     *            the onlyActiveUsers to set
     */
    public void setOnlyActiveUsers(final String onlyActiveUsers) {
        this.onlyActiveUsers = onlyActiveUsers;
    }

    /**
     * @param onlyUsers
     *            the onlyUsers to set
     */
    public void setOnlyUsers(final String onlyUsers) {
        this.onlyUsers = onlyUsers;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param phoneNo
     *            the phoneNo to set
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @param userRole
     *            the userRole to set
     */
    public void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    /**
     * @param string
     */
    public void setUsersOnly(final String usersOnly) {
        this.usersOnly = usersOnly;
    }

    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType(final String userType) {
        this.userType = userType;
    }

    /**
     * @return the resetPasswordStatus
     */
    public String getResetPasswordStatus() {
        return resetPasswordStatus;
    }

    /**
     * @param resetPasswordStatus the resetPasswordStatus to set
     */
    public void setResetPasswordStatus(String resetPasswordStatus) {
        this.resetPasswordStatus = resetPasswordStatus;
    }

}
