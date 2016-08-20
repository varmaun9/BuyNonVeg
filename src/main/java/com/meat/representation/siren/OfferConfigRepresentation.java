/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OfferConfigModel;
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
@Component("offerConfigRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "offerConfig", uri = "/offerConfigs/{id}")
@Representation(OfferConfigModel.class)
public class OfferConfigRepresentation extends BaseResource {

    private String id;
    private String tagsId;
    private String sellerId;
    private String itemId;
    private String sellerItemId;
    private String offerId;
    private String categoryId;
    private String sellerBranchId;
    private String subCategoryId;
    private String bankOfferId;
    private String status;
    private String placedByStatus;
    private String offerAttributeName;
    private String offerAttributeValue;
    @Siren4JSubEntity
    private List<UsersOfferRepresentation> usersOfferRep = new ArrayList<UsersOfferRepresentation>(0);

    /**
     * @return the bankOfferId
     */
    public String getBankOfferId() {
        return bankOfferId;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @return the offerAttributeName
     */
    public String getOfferAttributeName() {
        return offerAttributeName;
    }

    /**
     * @return the offerAttributeValue
     */
    public String getOfferAttributeValue() {
        return offerAttributeValue;
    }

    /**
     * @return the offerId
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * @return the placedByStatus
     */
    public String getPlacedByStatus() {
        return placedByStatus;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the sellerId
     */
    public String getSellerId() {
        return sellerId;
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
     * @return the subCategoryId
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * @return the tagsId
     */
    public String getTagsId() {
        return tagsId;
    }

    /**
     * @return the usersOfferRep
     */
    public List<UsersOfferRepresentation> getUsersOfferRep() {
        return usersOfferRep;
    }

    /**
     * @param bankOfferId
     *            the bankOfferId to set
     */
    public void setBankOfferId(final String bankOfferId) {
        this.bankOfferId = bankOfferId;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemId
     *            the itemId to set
     */
    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    /**
     * @param offerAttributeName
     *            the offerAttributeName to set
     */
    public void setOfferAttributeName(final String offerAttributeName) {
        this.offerAttributeName = offerAttributeName;
    }

    /**
     * @param offerAttributeValue
     *            the offerAttributeValue to set
     */
    public void setOfferAttributeValue(final String offerAttributeValue) {
        this.offerAttributeValue = offerAttributeValue;
    }

    /**
     * @param offerId
     *            the offerId to set
     */
    public void setOfferId(final String offerId) {
        this.offerId = offerId;
    }

    /**
     * @param placedByStatus
     *            the placedByStatus to set
     */
    public void setPlacedByStatus(final String placedByStatus) {
        this.placedByStatus = placedByStatus;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param sellerId
     *            the sellerId to set
     */
    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
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
     * @param subCategoryId
     *            the subCategoryId to set
     */
    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    /**
     * @param tagsId
     *            the tagsId to set
     */
    public void setTagsId(final String tagsId) {
        this.tagsId = tagsId;
    }

    /**
     * @param usersOfferRep
     *            the usersOfferRep to set
     */
    public void setUsersOfferRep(final List<UsersOfferRepresentation> usersOfferRep) {
        this.usersOfferRep = usersOfferRep;
    }

}
