/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerUserContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerUserContext implements IBusinessDelegateContext {

    private String all;
    private String sellerUserOnly;
    private String sellerUserRole;
    private String sellerBranchId;
    private String emailId;
    private String forgotPasswordStatus;
    private String sellerUserId;
    private String password;
    private String newPassword;
    private String changePassword;
    private String confirmPassword;

    public String getAll() {
        return all;
    }

    public String getChangePassword() {
        return changePassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
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

    public String getNewPassword() {
        return newPassword;
    }

    public String getPassword() {
        return password;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getSellerUserId() {
        return sellerUserId;
    }

    /**
     * @return
     */
    public String getSellerUserOnly() {
        // TODO Auto-generated method stub
        return sellerUserOnly;
    }

    /**
     * @return the sellerUserRole
     */
    public String getSellerUserRole() {
        return sellerUserRole;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setChangePassword(final String changePassword) {
        this.changePassword = changePassword;
    }

    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setSellerUserId(final String sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public void setSellerUserOnly(final String sellerUserOnly) {
        this.sellerUserOnly = sellerUserOnly;
    }

    /**
     * @param sellerUserRole
     *            the sellerUserRole to set
     */
    public void setSellerUserRole(final String sellerUserRole) {
        this.sellerUserRole = sellerUserRole;
    }

}
