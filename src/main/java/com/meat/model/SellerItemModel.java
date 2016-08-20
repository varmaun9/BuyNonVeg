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
 * @author Varma
 *
 */
@Component("sellerItemModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerItemModel extends AbstractModel {

    private String itemId;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String sellerItemName;
    private String sellingTag;
    private String quantity;
    private String specialTag;
    private String description;
    private String measurementUnit;
    private String marketPrice;
    private String sellingPrice;
    private String itemAvailableStatus;
    private String sellerBranchId;
    private String branchName;
    private String createdDate;
    private String sellerStock;
    private String baseUnit;
    private String offerPrice;
    private String pieceName;
    private String pieceCount;
    private String minQuantity;
    private String itemExistsStatus;
    private String cutTypes;
    private List<SellerItemPieceTypeModel> sellerItemPieceTypeModels = new ArrayList<SellerItemPieceTypeModel>(0);
    private List<SellerItemImagesModel> sellerItemImageModels = new ArrayList<SellerItemImagesModel>(0);
    private List<SellerItemCriteriaModel> sellerItemCriteriaModels = new ArrayList<SellerItemCriteriaModel>(0);
    private List<SellerItemTaxModel> sellerItemTaxModels = new ArrayList<SellerItemTaxModel>(0);
    private List<OrderItemModel> orderItemModels = new ArrayList<OrderItemModel>(0);
    private List<UserSellerItemRatingModel> userSellerItemRatingModels = new ArrayList<UserSellerItemRatingModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);
    private List<CouponBuyXGetYModel> couponBuyXGetYsForDiscountItemModel = new ArrayList<CouponBuyXGetYModel>(0);
    private List<CouponBuyXGetYModel> couponBuyXGetYsForPurchaseItemModel = new ArrayList<CouponBuyXGetYModel>(0);
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);

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

    /**
     * @return the couponBuyXGetYsForDiscountItemModel
     */
    public List<CouponBuyXGetYModel> getCouponBuyXGetYsForDiscountItemModel() {
        return couponBuyXGetYsForDiscountItemModel;
    }

    /**
     * @return the couponBuyXGetYsForPurchaseItemModel
     */
    public List<CouponBuyXGetYModel> getCouponBuyXGetYsForPurchaseItemModel() {
        return couponBuyXGetYsForPurchaseItemModel;
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

    public String getItemAvailableStatus() {
        return itemAvailableStatus;
    }

    public String getItemId() {
        return itemId;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    /**
     * @return the measurementUnit
     */
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public String getMinQuantity() {
        return minQuantity;
    }

    /**
     * @return the offerConfigModels
     */
    public List<OfferConfigModel> getOfferConfigModels() {
        return offerConfigModels;
    }

    /**
     * @return the offerExcludeConfigModels
     */
    public List<OfferExcludeConfigModel> getOfferExcludeConfigModels() {
        return offerExcludeConfigModels;
    }

    /**
     * @return the offerPrice
     */
    public String getOfferPrice() {
        return offerPrice;
    }

    public List<OrderItemModel> getOrderItemModels() {
        return orderItemModels;
    }

    public String getPieceCount() {
        return pieceCount;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public List<SellerItemCriteriaModel> getSellerItemCriteriaModels() {
        return sellerItemCriteriaModels;
    }

    public List<SellerItemImagesModel> getSellerItemImageModels() {
        return sellerItemImageModels;
    }

    public String getSellerItemName() {
        return sellerItemName;
    }

    /**
     * @return the sellerItemPieceTypeModels
     */
    public List<SellerItemPieceTypeModel> getSellerItemPieceTypeModels() {
        return sellerItemPieceTypeModels;
    }

    public List<SellerItemTaxModel> getSellerItemTaxModels() {
        return sellerItemTaxModels;
    }

    public String getSellerStock() {
        return sellerStock;
    }

    /**
     * @return the selingPrice
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

    public List<UserSellerItemRatingModel> getUserSellerItemRatingModels() {
        return userSellerItemRatingModels;
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

    /**
     * @param couponBuyXGetYsForDiscountItemModel
     *            the couponBuyXGetYsForDiscountItemModel to set
     */
    public void setCouponBuyXGetYsForDiscountItemModel(final List<CouponBuyXGetYModel> couponBuyXGetYsForDiscountItemModel) {
        this.couponBuyXGetYsForDiscountItemModel = couponBuyXGetYsForDiscountItemModel;
    }

    /**
     * @param couponBuyXGetYsForPurchaseItemModel
     *            the couponBuyXGetYsForPurchaseItemModel to set
     */
    public void setCouponBuyXGetYsForPurchaseItemModel(final List<CouponBuyXGetYModel> couponBuyXGetYsForPurchaseItemModel) {
        this.couponBuyXGetYsForPurchaseItemModel = couponBuyXGetYsForPurchaseItemModel;
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

    public void setItemAvailableStatus(final String itemAvailableStatus) {
        this.itemAvailableStatus = itemAvailableStatus;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

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

    public void setMinQuantity(final String minQuantity) {
        this.minQuantity = minQuantity;
    }

    /**
     * @param offerConfigModels
     *            the offerConfigModels to set
     */
    public void setOfferConfigModels(final List<OfferConfigModel> offerConfigModels) {
        this.offerConfigModels = offerConfigModels;
    }

    /**
     * @param offerExcludeConfigModels
     *            the offerExcludeConfigModels to set
     */
    public void setOfferExcludeConfigModels(final List<OfferExcludeConfigModel> offerExcludeConfigModels) {
        this.offerExcludeConfigModels = offerExcludeConfigModels;
    }

    /**
     * @param offerPrice
     *            the offerPrice to set
     */
    public void setOfferPrice(final String offerPrice) {
        this.offerPrice = offerPrice;
    }

    public void setOrderItemModels(final List<OrderItemModel> orderItemModels) {
        this.orderItemModels = orderItemModels;
    }

    public void setPieceCount(final String pieceCount) {
        this.pieceCount = pieceCount;
    }

    public void setPieceName(final String pieceName) {
        this.pieceName = pieceName;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setSellerItemCriteriaModels(final List<SellerItemCriteriaModel> sellerItemCriteriaModels) {
        this.sellerItemCriteriaModels = sellerItemCriteriaModels;
    }

    public void setSellerItemImageModels(final List<SellerItemImagesModel> sellerItemImageModels) {
        this.sellerItemImageModels = sellerItemImageModels;
    }

    public void setSellerItemName(final String sellerItemName) {
        this.sellerItemName = sellerItemName;
    }

    /**
     * @param sellerItemPieceTypeModels
     *            the sellerItemPieceTypeModels to set
     */
    public void setSellerItemPieceTypeModels(final List<SellerItemPieceTypeModel> sellerItemPieceTypeModels) {
        this.sellerItemPieceTypeModels = sellerItemPieceTypeModels;
    }

    public void setSellerItemTaxModels(final List<SellerItemTaxModel> sellerItemTaxModels) {
        this.sellerItemTaxModels = sellerItemTaxModels;
    }

    public void setSellerStock(final String sellerStock) {
        this.sellerStock = sellerStock;
    }

    /**
     * @param selingPrice
     *            the selingPrice to set
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

    public void setUserSellerItemRatingModels(final List<UserSellerItemRatingModel> userSellerItemRatingModels) {
        this.userSellerItemRatingModels = userSellerItemRatingModels;
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
