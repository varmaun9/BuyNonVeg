/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerItemModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Varma
 *
 */
@Component("sellerItemRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerItem", uri = "/sellerItems/{id}")
@Representation(SellerItemModel.class)
public class SellerItemRepresentation extends BaseResource {
    private String id;
    private String itemId;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String sellerItemName;
    private String sellerItemNameStatus;
    private String sellingTag;
    private String measurementUnit;
    private String quantity;
    private String specialTag;
    private String description;
    private String marketPrice;
    private String sellingPrice;
    //  private String ingredients;
    private String price;
    private String baseUnit;
    private String itemAvailableStatus;
    private String sellerBranchId;
    private String branchName;
    private String cutTypes;
    private String createdDate;
    private String itemExistsStatus;
    private String sellerStock;
    private String offerPrice;
    @Siren4JSubEntity
    private List<SellerItemImagesRepresentation> sellerItemImageRep = new ArrayList<SellerItemImagesRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemCriteriaRepresentation> sellerItemCriteriaRep = new ArrayList<SellerItemCriteriaRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemTaxRepresentation> sellerItemTaxRep = new ArrayList<SellerItemTaxRepresentation>(0);
    @Siren4JSubEntity
    private List<OrderItemRepresentation> orderItemRep = new ArrayList<OrderItemRepresentation>(0);
    @Siren4JSubEntity
    private List<UserSellerItemRatingRepresentation> userSellerItemRatingRep = new ArrayList<UserSellerItemRatingRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferConfigRepresentation> offerConfigRep = new ArrayList<OfferConfigRepresentation>(0);

    /**
     * @return the baseUnit
     */
    public String getBaseUnit() {
        return baseUnit;
    }

    /**
     * @return the branchName
     */
    public String getBranchName() {
        return branchName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the cutTypes
     */
    public String getCutTypes() {
        return cutTypes;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getItemAvailableStatus() {
        return itemAvailableStatus;
    }

    public String getItemId() {
        return itemId;
    }

    /**
     * @return the marketPrice
     */
    public String getMarketPrice() {
        return marketPrice;
    }

    /**
     * @return the measurementUnit
     */
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public List<OfferConfigRepresentation> getOfferConfigRep() {
        return offerConfigRep;
    }

    /**
     * @return the offerPrice
     */
    public String getOfferPrice() {
        return offerPrice;
    }

    public List<OrderItemRepresentation> getOrderItemRep() {
        return orderItemRep;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public List<SellerItemCriteriaRepresentation> getSellerItemCriteriaRep() {
        return sellerItemCriteriaRep;
    }

    public List<SellerItemImagesRepresentation> getSellerItemImageRep() {
        return sellerItemImageRep;
    }

    public String getSellerItemName() {
        return sellerItemName;
    }

    public String getSellerItemNameStatus() {
        return sellerItemNameStatus;
    }

    public List<SellerItemTaxRepresentation> getSellerItemTaxRep() {
        return sellerItemTaxRep;
    }

    public String getSellerStock() {
        return sellerStock;
    }

    /**
     * @return the sellingPrice
     */
    public String getSellingPrice() {
        return sellingPrice;
    }

    public String getSellingTag() {
        return sellingTag;
    }

    public String getSeoId() {
        return seoId;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public String getSpecialTag() {
        return specialTag;
    }

    public List<UserSellerItemRatingRepresentation> getUserSellerItemRatingRep() {
        return userSellerItemRatingRep;
    }

    /**
     * @param baseUnit
     *            the baseUnit to set
     */
    public void setBaseUnit(final String baseUnit) {
        this.baseUnit = baseUnit;
    }

    /**
     * @param branchName
     *            the branchName to set
     */
    public void setBranchName(final String branchName) {
        this.branchName = branchName;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param cutTypes
     *            the cutTypes to set
     */
    public void setCutTypes(final String cutTypes) {
        this.cutTypes = cutTypes;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemAvailableStatus(final String itemAvailableStatus) {
        this.itemAvailableStatus = itemAvailableStatus;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    /**
     * @param marketPrice
     *            the marketPrice to set
     */
    public void setMarketPrice(final String marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @param measurementUnit
     *            the measurementUnit to set
     */
    public void setMeasurementUnit(final String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public void setOfferConfigRep(final List<OfferConfigRepresentation> offerConfigRep) {
        this.offerConfigRep = offerConfigRep;
    }

    /**
     * @param offerPrice
     *            the offerPrice to set
     */
    public void setOfferPrice(final String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public void setOrderItemRep(final List<OrderItemRepresentation> orderItemRep) {
        this.orderItemRep = orderItemRep;
    }

    public void setPrice(final String price) {
        this.price = price;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setSellerItemCriteriaRep(final List<SellerItemCriteriaRepresentation> sellerItemCriteriaRep) {
        this.sellerItemCriteriaRep = sellerItemCriteriaRep;
    }

    public void setSellerItemImageRep(final List<SellerItemImagesRepresentation> sellerItemImageRep) {
        this.sellerItemImageRep = sellerItemImageRep;
    }

    public void setSellerItemName(final String sellerItemName) {
        this.sellerItemName = sellerItemName;
    }

    public void setSellerItemNameStatus(final String sellerItemNameStatus) {
        this.sellerItemNameStatus = sellerItemNameStatus;
    }

    public void setSellerItemTaxRep(final List<SellerItemTaxRepresentation> sellerItemTaxRep) {
        this.sellerItemTaxRep = sellerItemTaxRep;
    }

    public void setSellerStock(final String sellerStock) {
        this.sellerStock = sellerStock;
    }

    /**
     * @param sellingPrice
     *            the sellingPrice to set
     */
    public void setSellingPrice(final String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSellingTag(final String sellingTag) {
        this.sellingTag = sellingTag;
    }

    public void setSeoId(final String seoId) {
        this.seoId = seoId;
    }

    public void setSeoKeywords(final String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public void setSeoMetaDescription(final String seoMetaDescription) {
        this.seoMetaDescription = seoMetaDescription;
    }

    public void setSeoTitle(final String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public void setSpecialTag(final String specialTag) {
        this.specialTag = specialTag;
    }

    public void setUserSellerItemRatingRep(final List<UserSellerItemRatingRepresentation> userSellerItemRatingRep) {
        this.userSellerItemRatingRep = userSellerItemRatingRep;
    }

    /**
     * @return the itemExistsStatus
     */
    public String getItemExistsStatus() {
        return itemExistsStatus;
    }

    /**
     * @param itemExistsStatus the itemExistsStatus to set
     */
    public void setItemExistsStatus(String itemExistsStatus) {
        this.itemExistsStatus = itemExistsStatus;
    }

}
