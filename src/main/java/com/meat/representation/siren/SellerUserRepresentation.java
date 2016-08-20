/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerUserModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerUserRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerUser", uri = "/sellerUsers/{id}")
@Representation(SellerUserModel.class)
public class SellerUserRepresentation extends BaseResource {
    private String id;
    private String userName;
    private String userEmail;
    private String userPhoneNo;
    private String sellerUserType;
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
    private String dob;
    private String emailStatus;
    private String userEmailIdStatus;
    private String sellerUserEmailExists;
    private String userRoleType;
    private String sellerUserPhoneNoExists;
    private String userPhoneNoStatus;
    private String status;

    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
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
     * @return the userPhoneNoStatus
     */
    public String getUserPhoneNoStatus() {
        return userPhoneNoStatus;
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

    /**
     * @param dob
     *            the dob to set
     */
    public void setDob(final String dob) {
        this.dob = dob;
    }

    public void setEmailStatus(final String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public void setId(final String id) {
        this.id = id;
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
     * @param userPhoneNoStatus
     *            the userPhoneNoStatus to set
     */
    public void setUserPhoneNoStatus(final String userPhoneNoStatus) {
        this.userPhoneNoStatus = userPhoneNoStatus;
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

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
