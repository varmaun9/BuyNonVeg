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
 * @author venkat
 *
 */
@Component("addressModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AddressModel extends AbstractModel {

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
    private List<OrderDeliveryOptionsModel> orderDeliveryOptionsModels = new ArrayList<OrderDeliveryOptionsModel>(0);

    private List<UsersModel> userModels = new ArrayList<UsersModel>(0);
    private List<SellerBranchAddressModel> sellerBranchAddressModels = new ArrayList<SellerBranchAddressModel>(0);
    //  private List<SellerBranchModel> sellerBranchModels = new ArrayList<SellerBranchModel>(0);

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return the contactPerson
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return the defaultStatus
     */
    public String getDefaultStatus() {
        return defaultStatus;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @return the line1
     */
    public String getLine1() {
        return line1;
    }

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @return the orderDeliveryOptionsModels
     */
    public List<OrderDeliveryOptionsModel> getOrderDeliveryOptionsModels() {
        return orderDeliveryOptionsModels;
    }

    /* *//**
          * @return the sellerBranchModels
          *//*
           public List<SellerBranchModel> getSellerBranchModels() {
            return sellerBranchModels;
           }*/

    /**
     * @return the sellerBranchAddressModels
     */
    public List<SellerBranchAddressModel> getSellerBranchAddressModels() {
        return sellerBranchAddressModels;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the userModels
     */
    public List<UsersModel> getUserModels() {
        return userModels;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param area
     *            the area to set
     */
    public void setArea(final String area) {
        this.area = area;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }

    /**
     * @param contactPerson
     *            the contactPerson to set
     */
    public void setContactPerson(final String contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @param defaultStatus
     *            the defaultStatus to set
     */
    public void setDefaultStatus(final String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    /**
     * @param district
     *            the district to set
     */
    public void setDistrict(final String district) {
        this.district = district;
    }

    /**
     * @param line1
     *            the line1 to set
     */
    public void setLine1(final String line1) {
        this.line1 = line1;
    }

    /**
     * @param mobileNo
     *            the mobileNo to set
     */
    public void setMobileNo(final String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /* *//**
          * @param sellerBranchModels
          *            the sellerBranchModels to set
          *//*
           public void setSellerBranchModels(final List<SellerBranchModel> sellerBranchModels) {
            this.sellerBranchModels = sellerBranchModels;
           }*/

    /**
     * @param orderDeliveryOptionsModels
     *            the orderDeliveryOptionsModels to set
     */
    public void setOrderDeliveryOptionsModels(final List<OrderDeliveryOptionsModel> orderDeliveryOptionsModels) {
        this.orderDeliveryOptionsModels = orderDeliveryOptionsModels;
    }

    /**
     * @param sellerBranchAddressModels
     *            the sellerBranchAddressModels to set
     */
    public void setSellerBranchAddressModels(final List<SellerBranchAddressModel> sellerBranchAddressModels) {
        this.sellerBranchAddressModels = sellerBranchAddressModels;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState(final String state) {
        this.state = state;
    }

    /**
     * @param town
     *            the town to set
     */
    public void setTown(final String town) {
        this.town = town;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @param userModels
     *            the userModels to set
     */
    public void setUserModels(final List<UsersModel> userModels) {
        this.userModels = userModels;
    }

    /**
     * @param zipcode
     *            the zipcode to set
     */
    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

}