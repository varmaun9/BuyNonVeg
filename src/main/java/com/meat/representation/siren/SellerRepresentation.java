/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerModel;
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
@Component("sellerRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "seller", uri = "/sellers/{id}")
@Representation(SellerModel.class)
public class SellerRepresentation extends BaseResource {
    private String id;
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
    @Siren4JSubEntity
    private List<SellerBranchRepresentation> sellerBranchRep = new ArrayList<SellerBranchRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerImagesRepresentation> sellerImagesRep = new ArrayList<SellerImagesRepresentation>(0);

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public List<SellerBranchRepresentation> getSellerBranchRep() {
        return sellerBranchRep;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public String getSellerCount() {
        return sellerCount;
    }

    public List<SellerImagesRepresentation> getSellerImagesRep() {
        return sellerImagesRep;
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

    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerBranchRep(final List<SellerBranchRepresentation> sellerBranchRep) {
        this.sellerBranchRep = sellerBranchRep;
    }

    public void setSellerCode(final String sellerCode) {
        this.sellerCode = sellerCode;
    }

    public void setSellerCount(final String sellerCount) {
        this.sellerCount = sellerCount;
    }

    public void setSellerImagesRep(final List<SellerImagesRepresentation> sellerImagesRep) {
        this.sellerImagesRep = sellerImagesRep;
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