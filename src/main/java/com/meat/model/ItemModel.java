package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ItemModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoMetaDescription;
    private String seoKeywords;
    private String subCategoryId;
    private String subCategoryName;
    private String itemName;
    private String itemNameStatus;
    private String sellingTag;
    private String createdDate;
    private String meatStatus;
    private String description;
    private String status;
    private String itemCode;
    private String itemCount;
    private String categoryId;
    private String categoryName;
    private List<UserItemRatingModel> userItemRatingsModels = new ArrayList<UserItemRatingModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);
    private List<ItemAttributesModel> itemAttributesesModels = new ArrayList<ItemAttributesModel>(0);
    private List<UserWishListModel> userWishListsModels = new ArrayList<UserWishListModel>(0);
    private List<ItemImagesModel> itemImagesesModels = new ArrayList<ItemImagesModel>(0);
    private List<ItemTagsModel> itemTagsesModels = new ArrayList<ItemTagsModel>(0);
    private List<SellerItemModel> sellerItemModels = new ArrayList<SellerItemModel>(0);

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the itemAttributesesModels
     */
    public List<ItemAttributesModel> getItemAttributesesModels() {
        return itemAttributesesModels;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @return the itemCount
     */
    public String getItemCount() {
        return itemCount;
    }

    /**
     * @return the itemImagesesModels
     */
    public List<ItemImagesModel> getItemImagesesModels() {
        return itemImagesesModels;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    public String getItemNameStatus() {
        return itemNameStatus;
    }

    /**
     * @return the itemTagsesModels
     */
    public List<ItemTagsModel> getItemTagsesModels() {
        return itemTagsesModels;
    }

    /**
     * @return the meatStatus
     */
    public String getMeatStatus() {
        return meatStatus;
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
     * @return the sellerItemModels
     */
    public List<SellerItemModel> getSellerItemModels() {
        return sellerItemModels;
    }

    /**
     * @return the sellingTag
     */
    public String getSellingTag() {
        return sellingTag;
    }

    /**
     * @return the seoId
     */
    public String getSeoId() {
        return seoId;
    }

    /**
     * @return the seoKeywords
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * @return the seoMetaDescription
     */
    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    /**
     * @return the seoTitle
     */
    public String getSeoTitle() {
        return seoTitle;
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

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public List<UserItemRatingModel> getUserItemRatingsModels() {
        return userItemRatingsModels;
    }

    /**
     * @return the userWishListsModels
     */
    public List<UserWishListModel> getUserWishListsModels() {
        return userWishListsModels;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param itemAttributesesModels
     *            the itemAttributesesModels to set
     */
    public void setItemAttributesesModels(final List<ItemAttributesModel> itemAttributesesModels) {
        this.itemAttributesesModels = itemAttributesesModels;
    }

    /**
     * @param itemCode
     *            the itemCode to set
     */
    public void setItemCode(final String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @param itemCount
     *            the itemCount to set
     */
    public void setItemCount(final String itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * @param itemImagesesModels
     *            the itemImagesesModels to set
     */
    public void setItemImagesesModels(final List<ItemImagesModel> itemImagesesModels) {
        this.itemImagesesModels = itemImagesesModels;
    }

    /**
     * @param itemName
     *            the itemName to set
     */
    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    public void setItemNameStatus(final String itemNameStatus) {
        this.itemNameStatus = itemNameStatus;
    }

    /**
     * @param itemTagsesModels
     *            the itemTagsesModels to set
     */
    public void setItemTagsesModels(final List<ItemTagsModel> itemTagsesModels) {
        this.itemTagsesModels = itemTagsesModels;
    }

    /**
     * @param meatStatus
     *            the meatStatus to set
     */
    public void setMeatStatus(final String meatStatus) {
        this.meatStatus = meatStatus;
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
     * @param sellerItemModels
     *            the sellerItemModels to set
     */
    public void setSellerItemModels(final List<SellerItemModel> sellerItemModels) {
        this.sellerItemModels = sellerItemModels;
    }

    /**
     * @param sellingTag
     *            the sellingTag to set
     */
    public void setSellingTag(final String sellingTag) {
        this.sellingTag = sellingTag;
    }

    /**
     * @param seoId
     *            the seoId to set
     */
    public void setSeoId(final String seoId) {
        this.seoId = seoId;
    }

    /**
     * @param seoKeywords
     *            the seoKeywords to set
     */
    public void setSeoKeywords(final String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    /**
     * @param seoMetaDescription
     *            the seoMetaDescription to set
     */
    public void setSeoMetaDescription(final String seoMetaDescription) {
        this.seoMetaDescription = seoMetaDescription;
    }

    /**
     * @param seoTitle
     *            the seoTitle to set
     */
    public void setSeoTitle(final String seoTitle) {
        this.seoTitle = seoTitle;
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

    public void setSubCategoryName(final String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setUserItemRatingsModels(final List<UserItemRatingModel> userItemRatingsModels) {
        this.userItemRatingsModels = userItemRatingsModels;
    }

    /**
     * @param userWishListsModels
     *            the userWishListsModels to set
     */
    public void setUserWishListsModels(final List<UserWishListModel> userWishListsModels) {
        this.userWishListsModels = userWishListsModels;
    }

}
