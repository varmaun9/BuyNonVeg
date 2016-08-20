/**
 *
 */
package com.meat.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "seller_user", catalog = "meat_app")
public class SellerUser extends AbstractDomain implements java.io.Serializable {

    private String userName;
    private String userEmail;
    private String userPhoneNo;
    private String userStatus;
    private Users users;
    private SellerBranch sellerBranch;
    private String emailStatus;
    private String gender;
    private String password;
    private Date createdDate;
    private String authenticateStatus;
    private String sellerUserType;
    private String userRoleType;

    public SellerUser() {

    }

    public SellerUser(final String id, final String userName, final String userEmail, final String gender, final String password,
            final String authenticateStatus, final String emailStatus, final String sellerUserType, final String userPhoneNo,
            final String userStatus, final Users users, final String userRoleType, final Date createdDate,
            final SellerBranch sellerBranch) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNo = userPhoneNo;
        this.userStatus = userStatus;
        this.password = password;
        this.userRoleType = userRoleType;
        this.authenticateStatus = authenticateStatus;
        this.emailStatus = emailStatus;
        this.createdDate = createdDate;
        this.sellerUserType = sellerUserType;
        this.gender = gender;
        this.users = users;
        this.sellerBranch = sellerBranch;
    }

    @Column(name = "authenticate_status")
    public String getAuthenticateStatus() {
        return authenticateStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "email_status")
    public String getEmailStatus() {
        return emailStatus;
    }

    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_branch_id", nullable = false)
    public SellerBranch getSellerBranch() {
        return sellerBranch;
    }

    @Column(name = "seller_user_type")
    public String getSellerUserType() {
        return sellerUserType;
    }

    @Column(name = "user_email", length = 100)
    public String getUserEmail() {
        return userEmail;
    }

    @Column(name = "user_name", length = 100)
    public String getUserName() {
        return userName;
    }

    @Column(name = "user_phone_no", length = 45)
    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    /**
     * @return the userRoleType
     */
    @Column(name = "user_role_type")
    public String getUserRoleType() {
        return userRoleType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    public Users getUsers() {
        return users;
    }

    @Column(name = "user_status", length = 45)
    public String getUserStatus() {
        return userStatus;
    }

    public void setAuthenticateStatus(final String authenticateStatus) {
        this.authenticateStatus = authenticateStatus;
    }

    public void setCreatedDate(final Date createdDate) {
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

    public void setSellerBranch(final SellerBranch sellerBranch) {
        this.sellerBranch = sellerBranch;
    }

    public void setSellerUserType(final String sellerUserType) {
        this.sellerUserType = sellerUserType;
    }

    public void setUserEmail(final String userEmail) {
        this.userEmail = userEmail;
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

    public void setUsers(final Users users) {
        this.users = users;
    }

    public void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }
}
