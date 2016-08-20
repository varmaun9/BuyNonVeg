/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBranchTimingsModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBranchTimingsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranchTimings", uri = "/sellerBranchTimingses/{id}")
@Representation(SellerBranchTimingsModel.class)
public class SellerBranchTimingsRepresentation extends BaseResource {
    private String id;
    private String timingsId;
    private String timingName;
    private String sellerBranchId;
    private String sellerBranchName;
    private String sellerId;
    private String sellerName;
    private String duplicateStatus;
    private String status;
    private String createdDate;
    private String startTime;
    private String endTime;
    @Siren4JSubEntity
    private List<SellerTimingsConfigRepresentation> sellerTimingsConfigRep = new ArrayList<SellerTimingsConfigRepresentation>(0);

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    public String getEndTime() {
        return endTime;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getSellerBranchName() {
        return sellerBranchName;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    /**
     * @return the sellerTimingsConfigRep
     */
    public List<SellerTimingsConfigRepresentation> getSellerTimingsConfigRep() {
        return sellerTimingsConfigRep;
    }

    public String getStartTime() {
        return startTime;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

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
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setSellerBranchName(final String sellerBranchName) {
        this.sellerBranchName = sellerBranchName;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    /**
     * @param sellerTimingsConfigRep
     *            the sellerTimingsConfigRep to set
     */
    public void setSellerTimingsConfigRep(final List<SellerTimingsConfigRepresentation> sellerTimingsConfigRep) {
        this.sellerTimingsConfigRep = sellerTimingsConfigRep;
    }

    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

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
     * @return the duplicateStatus
     */
    public String getDuplicateStatus() {
        return duplicateStatus;
    }

    /**
     * @param duplicateStatus the duplicateStatus to set
     */
    public void setDuplicateStatus(String duplicateStatus) {
        this.duplicateStatus = duplicateStatus;
    }

}
