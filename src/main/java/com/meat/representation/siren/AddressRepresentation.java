/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.AddressModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("addressRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "address", uri = "/addresses/{id}")
@Representation(AddressModel.class)
public class AddressRepresentation extends BaseResource {
    private String id;
    private String line1;
    private String area;
    private String town;
    private String city;
    private String district;
    private String state;
    private String country;
    private String zipcode;
    private String type;
    private String mobileNo;
    private String contactPerson;
    private String defaultStatus;
    @Siren4JSubEntity
    private List<SellerBranchAddressRepresentation> sellerBranchAddressRep = new ArrayList<SellerBranchAddressRepresentation>(0);
    @Siren4JSubEntity
    private List<UsersRepresentation> usersRep = new ArrayList<UsersRepresentation>(0);
    @Siren4JSubEntity
    private List<OrderDeliveryOptionsRepresentation> orderDeliveryOptionsRep = new ArrayList<OrderDeliveryOptionsRepresentation>(0);

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
     * @return the id
     */
    public String getId() {
        return id;
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
     * @return the orderDeliveryOptionsRep
     */
    public List<OrderDeliveryOptionsRepresentation> getOrderDeliveryOptionsRep() {
        return orderDeliveryOptionsRep;
    }

    public List<SellerBranchAddressRepresentation> getSellerBranchAddressRep() {
        return sellerBranchAddressRep;
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
     * @return the usersRep
     */
    public List<UsersRepresentation> getUsersRep() {
        return usersRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
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

    /**
     * @param orderDeliveryOptionsRep
     *            the orderDeliveryOptionsRep to set
     */
    public void setOrderDeliveryOptionsRep(final List<OrderDeliveryOptionsRepresentation> orderDeliveryOptionsRep) {
        this.orderDeliveryOptionsRep = orderDeliveryOptionsRep;
    }

    public void setSellerBranchAddressRep(final List<SellerBranchAddressRepresentation> sellerBranchAddressRep) {
        this.sellerBranchAddressRep = sellerBranchAddressRep;
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
     * @param usersRep
     *            the usersRep to set
     */
    public void setUsersRep(final List<UsersRepresentation> usersRep) {
        this.usersRep = usersRep;
    }

    /**
     * @param zipcode
     *            the zipcode to set
     */
    public void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
    }

}
