/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UsersModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("usersRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "user", uri = "/users/{id}")
@Representation(UsersModel.class)
public class UsersRepresentation extends BaseResource {
    private String id;
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
    private String userRoleType;
    private String emailStatus;
    private String userEmailIdStatus;
    private String userPhoneNoStatus;
    @Siren4JSubEntity
    private List<AddressRepresentation> addressRep = new ArrayList<AddressRepresentation>(0);
    @Siren4JSubEntity
    private List<UserSellerItemRatingRepresentation> userSellerItemRatingRep = new ArrayList<UserSellerItemRatingRepresentation>(0);
    @Siren4JSubEntity
    private List<UserItemRatingRepresentation> userItemRatingRep = new ArrayList<UserItemRatingRepresentation>(0);
    @Siren4JSubEntity
    private List<UserWishListRepresentation> userWishListRep = new ArrayList<UserWishListRepresentation>(0);
    @Siren4JSubEntity
    private List<UserImagesRepresentation> userImagesRep = new ArrayList<UserImagesRepresentation>(0);
    @Siren4JSubEntity
    private List<OrdersRepresentation> ordersRep = new ArrayList<OrdersRepresentation>(0);
    @Siren4JSubEntity
    private List<RolesRepresentation> roleRep = new ArrayList<RolesRepresentation>(0);

    /**
     * @return the addressRep
     */
    public List<AddressRepresentation> getAddressRep() {
        return addressRep;
    }

    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDob() {
        return dob;
    }

    public String getEmailId() {
        return emailId;
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

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    public List<OrdersRepresentation> getOrdersRep() {
        return ordersRep;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public List<RolesRepresentation> getRoleRep() {
        return roleRep;
    }

    public String getStatus() {
        return status;
    }

    public String getUserCode() {
        return userCode;
    }

    public String getUserCount() {
        return userCount;
    }

    /**
     * @return the userEmailIdStatus
     */
    public String getUserEmailIdStatus() {
        return userEmailIdStatus;
    }

    public List<UserImagesRepresentation> getUserImagesRep() {
        return userImagesRep;
    }

    public List<UserItemRatingRepresentation> getUserItemRatingRep() {
        return userItemRatingRep;
    }

    public String getUserName() {
        return userName;
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

    public List<UserSellerItemRatingRepresentation> getUserSellerItemRatingRep() {
        return userSellerItemRatingRep;
    }

    public String getUserType() {
        return userType;
    }

    public List<UserWishListRepresentation> getUserWishListRep() {
        return userWishListRep;
    }

    /**
     * @param addressRep
     *            the addressRep to set
     */
    public void setAddressRep(final List<AddressRepresentation> addressRep) {
        this.addressRep = addressRep;
    }

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

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDob(final String dob) {
        this.dob = dob;
    }

    public void setEmailId(final String emailId) {
        this.emailId = emailId;
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

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(final String newPassword) {
        this.newPassword = newPassword;
    }

    public void setOrdersRep(final List<OrdersRepresentation> ordersRep) {
        this.ordersRep = ordersRep;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setRoleRep(final List<RolesRepresentation> roleRep) {
        this.roleRep = roleRep;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserCode(final String userCode) {
        this.userCode = userCode;
    }

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

    public void setUserImagesRep(final List<UserImagesRepresentation> userImagesRep) {
        this.userImagesRep = userImagesRep;
    }

    public void setUserItemRatingRep(final List<UserItemRatingRepresentation> userItemRatingRep) {
        this.userItemRatingRep = userItemRatingRep;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
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

    public void setUserSellerItemRatingRep(final List<UserSellerItemRatingRepresentation> userSellerItemRatingRep) {
        this.userSellerItemRatingRep = userSellerItemRatingRep;
    }

    public void setUserType(final String userType) {
        this.userType = userType;
    }

    public void setUserWishListRep(final List<UserWishListRepresentation> userWishListRep) {
        this.userWishListRep = userWishListRep;
    }

}
