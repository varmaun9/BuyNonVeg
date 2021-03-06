package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("criteriaModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CriteriaModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String criteriaName;
    private String orderOfPlace;
    private String description;
    private String createdDate;
    private String status;
    private List<CategoryCriteriaModel> categoryCriteriasModels = new ArrayList<CategoryCriteriaModel>(0);
    private List<SellerItemCriteriaModel> sellerItemCriteriasModels = new ArrayList<SellerItemCriteriaModel>(0);

    /**
     * @return the categoryCriteriasModels
     */
    public List<CategoryCriteriaModel> getCategoryCriteriasModels() {
        return categoryCriteriasModels;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the criteriaName
     */
    public String getCriteriaName() {
        return criteriaName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the orderOfPlace
     */
    public String getOrderOfPlace() {
        return orderOfPlace;
    }

    /**
     * @return the sellerItemCriteriasModels
     */
    public List<SellerItemCriteriaModel> getSellerItemCriteriasModels() {
        return sellerItemCriteriasModels;
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
     * @param categoryCriteriasModels
     *            the categoryCriteriasModels to set
     */
    public void setCategoryCriteriasModels(final List<CategoryCriteriaModel> categoryCriteriasModels) {
        this.categoryCriteriasModels = categoryCriteriasModels;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param criteriaName
     *            the criteriaName to set
     */
    public void setCriteriaName(final String criteriaName) {
        this.criteriaName = criteriaName;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param orderOfPlace
     *            the orderOfPlace to set
     */
    public void setOrderOfPlace(final String orderOfPlace) {
        this.orderOfPlace = orderOfPlace;
    }

    /**
     * @param sellerItemCriteriasModels
     *            the sellerItemCriteriasModels to set
     */
    public void setSellerItemCriteriasModels(final List<SellerItemCriteriaModel> sellerItemCriteriasModels) {
        this.sellerItemCriteriasModels = sellerItemCriteriasModels;
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

}
