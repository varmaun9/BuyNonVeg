/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ItemModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "item", uri = "/items/{id}")
@Representation(ItemModel.class)
public class ItemRepresentation extends BaseResource {
    private String id;
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
    @Siren4JSubEntity
    private List<UserItemRatingRepresentation> userItemRatingsRep = new ArrayList<UserItemRatingRepresentation>(0);

    @Siren4JSubEntity
    private List<ItemAttributesRepresentation> itemAttributesesRep = new ArrayList<ItemAttributesRepresentation>(0);

    @Siren4JSubEntity
    private List<UserWishListRepresentation> userWishListsRep = new ArrayList<UserWishListRepresentation>(0);

    @Siren4JSubEntity
    private List<ItemImagesRepresentation> itemImagesesRep = new ArrayList<ItemImagesRepresentation>(0);

    @Siren4JSubEntity
    private List<ItemTagsRepresentation> itemTagsesRep = new ArrayList<ItemTagsRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemRepresentation> sellerItemRep = new ArrayList<SellerItemRepresentation>(0);

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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the itemAttributesesRep
     */
    public List<ItemAttributesRepresentation> getItemAttributesesRep() {
        return itemAttributesesRep;
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
     * @return the itemImagesesRep
     */
    public List<ItemImagesRepresentation> getItemImagesesRep() {
        return itemImagesesRep;
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
     * @return the itemTagsesRep
     */
    public List<ItemTagsRepresentation> getItemTagsesRep() {
        return itemTagsesRep;
    }

    /**
     * @return the meatStatus
     */
    public String getMeatStatus() {
        return meatStatus;
    }

    /**
     * @return the sellerItemRep
     */
    public List<SellerItemRepresentation> getSellerItemRep() {
        return sellerItemRep;
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

    /**
     * @return the userSellerItemRatingsRep
     */
    public List<UserItemRatingRepresentation> getUserItemRatingsRep() {
        return userItemRatingsRep;
    }

    /**
     * @return the userWishListsRep
     */
    public List<UserWishListRepresentation> getUserWishListsRep() {
        return userWishListsRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemAttributesesRep
     *            the itemAttributesesRep to set
     */
    public void setItemAttributesesRep(final List<ItemAttributesRepresentation> itemAttributesesRep) {
        this.itemAttributesesRep = itemAttributesesRep;
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
     * @param itemImagesesRep
     *            the itemImagesesRep to set
     */
    public void setItemImagesesRep(final List<ItemImagesRepresentation> itemImagesesRep) {
        this.itemImagesesRep = itemImagesesRep;
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
     * @param itemTagsesRep
     *            the itemTagsesRep to set
     */
    public void setItemTagsesRep(final List<ItemTagsRepresentation> itemTagsesRep) {
        this.itemTagsesRep = itemTagsesRep;
    }

    /**
     * @param meatStatus
     *            the meatStatus to set
     */
    public void setMeatStatus(final String meatStatus) {
        this.meatStatus = meatStatus;
    }

    /**
     * @param sellerItemRep
     *            the sellerItemRep to set
     */
    public void setSellerItemRep(final List<SellerItemRepresentation> sellerItemRep) {
        this.sellerItemRep = sellerItemRep;
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

    /**
     * @param userSellerItemRatingsRep
     *            the userSellerItemRatingsRep to set
     */
    public void setUserItemRatingsRep(final List<UserItemRatingRepresentation> userSellerItemRatingsRep) {
        userItemRatingsRep = userItemRatingsRep;
    }

    /**
     * @param userWishListsRep
     *            the userWishListsRep to set
     */
    public void setUserWishListsRep(final List<UserWishListRepresentation> userWishListsRep) {
        this.userWishListsRep = userWishListsRep;
    }

}
