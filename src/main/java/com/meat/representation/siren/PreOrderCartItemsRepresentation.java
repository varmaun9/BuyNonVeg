/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.PreOrderCartItemsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("preOrderCartItemsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "preOrderCartItems", uri = "/preOrderCartItemses/{id}")
@Representation(PreOrderCartItemsModel.class)
public class PreOrderCartItemsRepresentation extends BaseResource {
    private String id;
    private String usersId;
    private String sellerItemId;
    private String timingsId;
    private String quantity;
    private String offersId;
    private String price;
    private String units;
    private String deliveryDate;
    private String status;
    private String cutType;
    /* private String availableTime;*/
    private String deliveryTime;
    private String preOrderCartItemsCode;
    private String preOrderCartItemsCount;
    private String createdDate;
    private String statusFlag;
    private String modifiedDate;
    private String cartPrice;
    private String timingName;
    private Integer countFlag;
    private String itemTax;
    private String itemDiscount;

    /**
     * @return the cartPrice
     */
    public String getCartPrice() {
        return cartPrice;
    }

    /**
     * @return the countFlag
     */
    public Integer getCountFlag() {
        return countFlag;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the deliveryDate
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * @return the deliveryTime
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the itemDiscount
     */
    public String getItemDiscount() {
        return itemDiscount;
    }

    /**
     * @return the itemTax
     */
    public String getItemTax() {
        return itemTax;
    }

    /**
     * @return the modifiedDate
     */
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @return the offersId
     */
    public String getOffersId() {
        return offersId;
    }

    /**
     * @return the availableTime
     */
    /*  public String getAvailableTime() {
          return availableTime;
      }*/

    /**
     * @return the code
     */
    public String getpreOrderCartItemsCode() {
        return preOrderCartItemsCode;
    }

    /**
     * @return the preOrderCartItemsCode
     */
    public String getPreOrderCartItemsCode() {
        return preOrderCartItemsCode;
    }

    /**
     * @return the preOrderCartItemsCount
     */
    public String getPreOrderCartItemsCount() {
        return preOrderCartItemsCount;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @return the sellerItemId
     */
    public String getSellerItemId() {
        return sellerItemId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the statusFlag
     */
    public String getStatusFlag() {
        return statusFlag;
    }

    /**
     * @return the timingName
     */
    public String getTimingName() {
        return timingName;
    }

    /**
     * @return the timingsId
     */
    public String getTimingsId() {
        return timingsId;
    }

    /**
     * @return the units
     */
    public String getUnits() {
        return units;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    /**
     * @param availableTime
     *            the availableTime to set
     */
    /* public void setAvailableTime(final String availableTime) {
         this.availableTime = availableTime;
     }
     */
    /**
     * @param cartPrice
     *            the cartPrice to set
     */
    public void setCartPrice(final String cartPrice) {
        this.cartPrice = cartPrice;
    }

    /**
     * @param countFlag
     *            the countFlag to set
     */
    public void setCountFlag(final Integer countFlag) {
        this.countFlag = countFlag;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param deliveryDate
     *            the deliveryDate to set
     */
    public void setDeliveryDate(final String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * @param deliveryTime
     *            the deliveryTime to set
     */
    public void setDeliveryTime(final String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemDiscount
     *            the itemDiscount to set
     */
    public void setItemDiscount(final String itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    /**
     * @param itemTax
     *            the itemTax to set
     */
    public void setItemTax(final String itemTax) {
        this.itemTax = itemTax;
    }

    /**
     * @param modifiedDate
     *            the modifiedDate to set
     */
    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @param offersId
     *            the offersId to set
     */
    public void setOffersId(final String offersId) {
        this.offersId = offersId;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setpreOrderCartItemsCode(final String preOrderCartItemsCode) {
        this.preOrderCartItemsCode = preOrderCartItemsCode;
    }

    /**
     * @param preOrderCartItemsCode
     *            the preOrderCartItemsCode to set
     */
    public void setPreOrderCartItemsCode(final String preOrderCartItemsCode) {
        this.preOrderCartItemsCode = preOrderCartItemsCode;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setpreOrderCartItemsCount(final String preOrderCartItemsCount) {
        this.preOrderCartItemsCount = preOrderCartItemsCount;
    }

    /**
     * @param preOrderCartItemsCount
     *            the preOrderCartItemsCount to set
     */
    public void setPreOrderCartItemsCount(final String preOrderCartItemsCount) {
        this.preOrderCartItemsCount = preOrderCartItemsCount;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(final String price) {
        this.price = price;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    /**
     * @param sellerItemId
     *            the sellerItemId to set
     */
    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param statusFlag
     *            the statusFlag to set
     */
    public void setStatusFlag(final String statusFlag) {
        this.statusFlag = statusFlag;
    }

    /**
     * @param timingName
     *            the timingName to set
     */
    public void setTimingName(final String timingName) {
        this.timingName = timingName;
    }

    /**
     * @param timingsId
     *            the timingsId to set
     */
    public void setTimingsId(final String timingsId) {
        this.timingsId = timingsId;
    }

    /**
     * @param units
     *            the units to set
     */
    public void setUnits(final String units) {
        this.units = units;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

    /**
     * @return the cutType
     */
    public String getCutType() {
        return cutType;
    }

    /**
     * @param cutType the cutType to set
     */
    public void setCutType(String cutType) {
        this.cutType = cutType;
    }

}
