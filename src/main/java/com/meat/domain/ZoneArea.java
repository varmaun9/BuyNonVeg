package com.meat.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "zone_area", catalog = "meat_app")
public class ZoneArea extends AbstractDomain implements java.io.Serializable {

    private String area;
    private String status;
    private Date createdDate;
    private Zone zone;
    private String pincode;

    public ZoneArea() {
    }

    public ZoneArea(final String id, final String area, final String status, final Zone zone) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.zone = zone;
    }

    public ZoneArea(final String id, final String area, final Zone zone, final String status, final Date createdDate,
            final String pincode) {
        this.id = id;
        this.area = area;
        this.zone = zone;
        this.status = status;
        this.createdDate = createdDate;
        this.pincode = pincode;
    }

    @Column(name = "area", length = 100)
    public String getArea() {
        return area;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "pincode")
    public String getPincode() {
        return pincode;
    }

    @Column(name = "status", length = 45)
    public String getStatus() {
        return status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id", nullable = false)
    public Zone getZone() {
        return zone;
    }

    public void setArea(final String area) {
        this.area = area;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setPincode(final String pincode) {
        this.pincode = pincode;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZone(final Zone zone) {
        this.zone = zone;
    }

}
