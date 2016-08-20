/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CriteriaModel;
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
@Component("criteriaRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "criteria", uri = "/criteriaes/{id}")
@Representation(CriteriaModel.class)
public class CriteriaRepresentation extends BaseResource {
    private String id;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String criteriaName;
    private String orderOfPlace;
    private String description;
    private String createdDate;
    private String status;
    @Siren4JSubEntity
    private List<CategoryCriteriaRepresentation> categoryCriteriasRep = new ArrayList<CategoryCriteriaRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemCriteriaRepresentation> sellerItemCriteriasRep = new ArrayList<SellerItemCriteriaRepresentation>(0);

    /**
     * @return the categoryCriteriasRep
     */
    public List<CategoryCriteriaRepresentation> getCategoryCriteriasRep() {
        return categoryCriteriasRep;
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the orderOfPlace
     */
    public String getOrderOfPlace() {
        return orderOfPlace;
    }

    /**
     * @return the sellerItemCriteriasRep
     */
    public List<SellerItemCriteriaRepresentation> getSellerItemCriteriasRep() {
        return sellerItemCriteriasRep;
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
     * @param categoryCriteriasRep
     *            the categoryCriteriasRep to set
     */
    public void setCategoryCriteriasRep(final List<CategoryCriteriaRepresentation> categoryCriteriasRep) {
        this.categoryCriteriasRep = categoryCriteriasRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param orderOfPlace
     *            the orderOfPlace to set
     */
    public void setOrderOfPlace(final String orderOfPlace) {
        this.orderOfPlace = orderOfPlace;
    }

    /**
     * @param sellerItemCriteriasRep
     *            the sellerItemCriteriasRep to set
     */
    public void setSellerItemCriteriasRep(final List<SellerItemCriteriaRepresentation> sellerItemCriteriasRep) {
        this.sellerItemCriteriasRep = sellerItemCriteriasRep;
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
