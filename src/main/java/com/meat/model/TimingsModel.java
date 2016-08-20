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
@Component("timingsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TimingsModel extends AbstractModel {
    private String timingName;
    private String timingNameStatus;
    private String startTime;
    private String endTime;
    private String status;
    private String description;
    private String statusFlag;
    private List<SellerBranchTimingsModel> sellerBranchTimingsModels = new ArrayList<SellerBranchTimingsModel>(0);
    private List<SubOrderModel> subOrderModels = new ArrayList<SubOrderModel>(0);

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @return the sellerBranchTimingsModels
     */
    public List<SellerBranchTimingsModel> getSellerBranchTimingsModels() {
        return sellerBranchTimingsModels;
    }

    /**
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the statusFlag
     */
    public String getStatusFlag() {
        return statusFlag;
    }

    /**
     * @return the subOrderModels
     */
    public List<SubOrderModel> getSubOrderModels() {
        return subOrderModels;
    }

    /**
     * @return the timingName
     */
    public String getTimingName() {
        return timingName;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    /**
     * @param sellerBranchTimingsModels
     *            the sellerBranchTimingsModels to set
     */
    public void setSellerBranchTimingsModels(final List<SellerBranchTimingsModel> sellerBranchTimingsModels) {
        this.sellerBranchTimingsModels = sellerBranchTimingsModels;
    }

    /**
     * @param startTime
     *            the startTime to set
     */
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

    /**
     * @param statusFlag
     *            the statusFlag to set
     */
    public void setStatusFlag(final String statusFlag) {
        this.statusFlag = statusFlag;
    }

    /**
     * @param subOrderModels
     *            the subOrderModels to set
     */
    public void setSubOrderModels(final List<SubOrderModel> subOrderModels) {
        this.subOrderModels = subOrderModels;
    }

    /**
     * @param timingName
     *            the timingName to set
     */
    public void setTimingName(final String timingName) {
        this.timingName = timingName;
    }

    public String getTimingNameStatus() {
        return timingNameStatus;
    }

    public void setTimingNameStatus(String timingNameStatus) {
        this.timingNameStatus = timingNameStatus;
    }

}
