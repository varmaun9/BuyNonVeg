/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("usersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsersModel extends AbstractModel {

    private String userName;
    private String userType;
    private String emailId;
    private String phoneNo;
    private String dob;
    private String gender;
    private String password;
    private String confirmPassword;
    private String newPassword;
    private String status;
    private String userCode;
    private String authenticateStatus;
    private String userCount;
    private String createdDate;
    private String emailStatus;
    private String userEmailIdStatus;
    private String userPhoneNoStatus;
    private String userRoleType;
    private List<AddressModel> addresModels = new ArrayList<AddressModel>(0);
    private List<UserSellerItemRatingModel> userSellerItemRatingModels = new ArrayList<UserSellerItemRatingModel>(0);
    private List<SellerUserModel> sellerUserModel = new ArrayList<SellerUserModel>(0);

    private List<UserItemRatingModel> userItemRatingModels = new ArrayList<UserItemRatingModel>(0);

    private List<UserWishListModel> userWishListModels = new ArrayList<UserWishListModel>(0);

    private List<UserImagesModel> userImagesModels = new ArrayList<UserImagesModel>(0);
    private List<OrdersModel> orderModels = new ArrayList<OrdersModel>(0);
    private List<RolesModel> roleModels = new ArrayList<RolesModel>(0);

    /**
     * @return the addresModels
     */
    public List<AddressModel> getAddresModels() {
        return addresModels;
    }

    /**
     * @return the authenticateStatus
     */
    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @return the emailStatus
     */
    public String getEmailStatus() {
        return emailStatus;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @return the orderModels
     */
    public List<OrdersModel> getOrderModels() {
        return orderModels;
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
     * @return the roleModels
     */
    public List<RolesModel> getRoleModels() {
        return roleModels;
    }

    public List<SellerUserModel> getSellerUserModel() {
        return sellerUserModel;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @return the userCount
     */
    public String getUserCount() {
        return userCount;
    }

    /**
     * @return the userEmailIdStatus
     */
    public String getUserEmailIdStatus() {
        return userEmailIdStatus;
    }

    /**
     * @return the userImagesModels
     */
    public List<UserImagesModel> getUserImagesModels() {
        return userImagesModels;
    }

    /**
     * @return the userItemRatingModels
     */
    public List<UserItemRatingModel> getUserItemRatingModels() {
        return userItemRatingModels;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the userRoleType
     */
    public String getUserRoleType() {
        return userRoleType;
    }

    /**
     * @return the userSellerItemRatingModels
     */
    public List<UserSellerItemRatingModel> getUserSellerItemRatingModels() {
        return userSellerItemRatingModels;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @return the userWishListModels
     */
    public List<UserWishListModel> getUserWishListModels() {
        return userWishListModels;
    }

    /**
     * @param addresModels
     *            the addresModels to set
     */
    public void setAddresModels(final List<AddressModel> addresModels) {
        this.addresModels = addresModels;
    }

    /**
     * @param authenticateStatus
     *            the authenticateStatus to set
     */
    public void setAuthenticateStatus(final String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    /**
     * @param confirmPassword
     *            the confirmPassword to set
     */
    public void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
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

    /**
     * @param emailId
     *            the emailId to set
     */
    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @param emailStatus
     *            the emailStatus to set
     */
    public void setEmailStatus(final String emailStatus) {
        this.emailStatus = emailStatus;
    }

    /**
     * @param gender
     *            the gender to set
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @param orderModels
     *            the orderModels to set
     */
    public void setOrderModels(final List<OrdersModel> orderModels) {
        this.orderModels = orderModels;
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
     * @param roleModels
     *            the roleModels to set
     */
    public void setRoleModels(final List<RolesModel> roleModels) {
        this.roleModels = roleModels;
    }

    public void setSellerUserModel(final List<SellerUserModel> sellerUserModel) {
        this.sellerUserModel = sellerUserModel;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param userCode
     *            the userCode to set
     */
    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

    /**
     * @param userCount
     *            the userCount to set
     */
    public void setUserCount(final String userCount) {
        this.userCount = userCount;
    }

    /**
     * @param userEmailIdStatus
     *            the userEmailIdStatus to set
     */
    public void setUserEmailIdStatus(final String userEmailIdStatus) {
        this.userEmailIdStatus = userEmailIdStatus;
    }

    /**
     * @param userImagesModels
     *            the userImagesModels to set
     */
    public void setUserImagesModels(final List<UserImagesModel> userImagesModels) {
        this.userImagesModels = userImagesModels;
    }

    /**
     * @param userItemRatingModels
     *            the userItemRatingModels to set
     */
    public void setUserItemRatingModels(final List<UserItemRatingModel> userItemRatingModels) {
        this.userItemRatingModels = userItemRatingModels;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * @param userRoleType
     *            the userRoleType to set
     */
    public void setUserRoleType(final String userRoleType) {
        this.userRoleType = userRoleType;
    }

    /**
     * @param userSellerItemRatingModels
     *            the userSellerItemRatingModels to set
     */
    public void setUserSellerItemRatingModels(final List<UserSellerItemRatingModel> userSellerItemRatingModels) {
        this.userSellerItemRatingModels = userSellerItemRatingModels;
    }

    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType(final String userType) {
        this.userType = userType;
    }

    /**
     * @param userWishListModels
     *            the userWishListModels to set
     */
    public void setUserWishListModels(final List<UserWishListModel> userWishListModels) {
        this.userWishListModels = userWishListModels;
    }

    /**
     * @return the userPhoneNoStatus
     */
    public String getUserPhoneNoStatus() {
        return userPhoneNoStatus;
    }

    /**
     * @param userPhoneNoStatus the userPhoneNoStatus to set
     */
    public void setUserPhoneNoStatus(String userPhoneNoStatus) {
        this.userPhoneNoStatus = userPhoneNoStatus;
    }

}
