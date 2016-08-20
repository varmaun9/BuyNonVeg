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
 * @author arthvedi
 *
 */
@Component("sellerModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String sellerName;
    private String description;
    private String createdDate;
    private String status;
    private String sellerCode;
    private String sellerCount;
    private String sellerType;
    private List<SellerBranchModel> sellerBranchModels = new ArrayList<SellerBranchModel>(0);
    private List<SellerImagesModel> sellerImagesModels = new ArrayList<SellerImagesModel>(0);
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
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

    public List<SellerBranchModel> getSellerBranchModels() {
        return sellerBranchModels;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public String getSellerCount() {
        return sellerCount;
    }

    public List<SellerImagesModel> getSellerImagesModels() {
        return sellerImagesModels;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerType() {
        return sellerType;
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

    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
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

    public void setSellerBranchModels(final List<SellerBranchModel> sellerBranchModels) {
        this.sellerBranchModels = sellerBranchModels;
    }

    public void setSellerCode(final String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public void setSellerCount(final String sellerCount) {
        this.sellerCount = sellerCount;
    }

    public void setSellerImagesModels(final List<SellerImagesModel> sellerImagesModels) {
        this.sellerImagesModels = sellerImagesModels;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public void setSellerType(final String sellerType) {
        this.sellerType = sellerType;
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

    public void setStatus(final String status) {
        this.status = status;
    }

}
