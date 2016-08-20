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
@Component("sellerBranchTimingsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchTimingsModel extends AbstractModel {
    private String timingsId;
    private String timingName;
    private String sellerBranchId;
    private String sellerBranchName;
    private String sellerId;
    private String sellerName;
    private String status;
    private String createdDate;
    private String startTime;
    private String endTime;
    private String timingsStatus;
    private List<SellerTimingsConfigModel> sellerTimingsConfigModels = new ArrayList<SellerTimingsConfigModel>(0);

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
     * @return the sellerBranchId
     */
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
     * @return the sellerTimingsConfigModels
     */
    public List<SellerTimingsConfigModel> getSellerTimingsConfigModels() {
        return sellerTimingsConfigModels;
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
     * @return the timingsStatus
     */
    public String getTimingsStatus() {
        return timingsStatus;
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
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
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
     * @param sellerTimingsConfigModels
     *            the sellerTimingsConfigModels to set
     */
    public void setSellerTimingsConfigModels(final List<SellerTimingsConfigModel> sellerTimingsConfigModels) {
        this.sellerTimingsConfigModels = sellerTimingsConfigModels;
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
     * @param timingsStatus
     *            the timingsStatus to set
     */
    public void setTimingsStatus(final String timingsStatus) {
        this.timingsStatus = timingsStatus;
    }

}
