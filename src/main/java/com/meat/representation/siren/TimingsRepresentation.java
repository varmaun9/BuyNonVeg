/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.TimingsModel;
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
@Component("timingsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "timings", uri = "/timingses/{id}")
@Representation(TimingsModel.class)
public class TimingsRepresentation extends BaseResource {
    private String id;
    private String timingName;
    private String timingNameStatus;
    private String startTime;
    private String endTime;
    private String status;
    private String description;
    private String statusFlag;
    @Siren4JSubEntity
    private List<SellerBranchTimingsRepresentation> sellerBranchTimingsRep = new ArrayList<SellerBranchTimingsRepresentation>(0);
    @Siren4JSubEntity
    private List<SubOrderRepresentation> subOrderRep = new ArrayList<SubOrderRepresentation>(0);

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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the sellerBranchTimingsRep
     */
    public List<SellerBranchTimingsRepresentation> getSellerBranchTimingsRep() {
        return sellerBranchTimingsRep;
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
     * @return the subOrderRep
     */
    public List<SubOrderRepresentation> getSubOrderRep() {
        return subOrderRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param sellerBranchTimingsRep
     *            the sellerBranchTimingsRep to set
     */
    public void setSellerBranchTimingsRep(final List<SellerBranchTimingsRepresentation> sellerBranchTimingsRep) {
        this.sellerBranchTimingsRep = sellerBranchTimingsRep;
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
     * @param subOrderRep
     *            the subOrderRep to set
     */
    public void setSubOrderRep(final List<SubOrderRepresentation> subOrderRep) {
        this.subOrderRep = subOrderRep;
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
