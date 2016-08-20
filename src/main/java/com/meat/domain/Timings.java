package com.meat.domain;

// Generated Jan 11, 2016 12:46:59 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Timings generated by hbm2java
 */
@Entity
@Table(name = "timings", catalog = "meat_app")
public class Timings extends AbstractDomain implements java.io.Serializable {

    private String timingName;
    private String startTime;
    private String endTime;
    private String status;
    private String description;
    private String statusFlag;
    private Set<SellerBranchTimings> sellerBranchTimingses = new HashSet<SellerBranchTimings>(0);
    private Set<SubOrder> subOrders = new HashSet<SubOrder>(0);

    public Timings() {
    }

    public Timings(final String id, final String timingName, final String startTime, final String endTime, final String status) {
        this.id = id;
        this.timingName = timingName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Timings(final String id, final String timingName, final String startTime, final String endTime, final String status,
            final String description, final String statusFlag, final Set<SubOrder> subOrders,
            final Set<SellerBranchTimings> sellerBranchTimingses) {
        this.id = id;
        this.timingName = timingName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.description = description;
        this.statusFlag = statusFlag;
        this.subOrders = subOrders;
        this.sellerBranchTimingses = sellerBranchTimingses;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return description;
    }

    @Column(name = "end_time", nullable = false, length = 45)
    public String getEndTime() {
        return endTime;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "timings")
    public Set<SellerBranchTimings> getSellerBranchTimingses() {
        return sellerBranchTimingses;
    }

    @Column(name = "start_time", nullable = false, length = 45)
    public String getStartTime() {
        return startTime;
    }

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    @Column(name = "status_flag", length = 45)
    public String getStatusFlag() {
        return statusFlag;
    }

    /**
     * @return the subOrders
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "timings")
    public Set<SubOrder> getSubOrders() {
        return subOrders;
    }

    @Column(name = "timing_name", nullable = false, length = 45)
    public String getTimingName() {
        return timingName;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setEndTime(final String endTime) {
        this.endTime = endTime;
    }

    public void setSellerBranchTimingses(final Set<SellerBranchTimings> sellerBranchTimingses) {
        this.sellerBranchTimingses = sellerBranchTimingses;
    }

    public void setStartTime(final String startTime) {
        this.startTime = startTime;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setStatusFlag(final String statusFlag) {
        this.statusFlag = statusFlag;
    }

    /**
     * @param subOrders
     *            the subOrders to set
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "timings")
    public void setSubOrders(final Set<SubOrder> subOrders) {
        this.subOrders = subOrders;
    }

    public void setTimingName(final String timingName) {
        this.timingName = timingName;
    }

}