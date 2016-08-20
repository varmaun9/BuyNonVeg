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
@Component("sellerBranchAddressModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchAddressModel extends AbstractModel {
    private String line1;
    private String town;
    private String area;
    private String city;
    private String district;
    private String state;
    private String country;
    private String zipcode;
    private String type;
    private String mobileNo;
    private String defaultStatus;
    private String contactPerson;
    private String addressId;
    private String sellerBranchId;
    private String status;

    /**
     * @return the addressId
     */
    public String getAddressId() {
        return addressId;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getCountry() {
        return country;
    }

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public String getDistrict() {
        return district;
    }

    public String getLine1() {
        return line1;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getState() {
        return state;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    public String getTown() {
        return town;
    }

    public String getType() {
        return type;
    }

    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param addressId
     *            the addressId to set
     */
    public void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    public void setArea(final String area) {
        this.area = area;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public void setContactPerson(final String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public void setDefaultStatus(final String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public void setDistrict(final String district) {
        this.district = district;
    }

    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    public void setMobileNo(final String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setState(final String state) {
        this.state = state;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

}
