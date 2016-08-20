/**
 *
 */
package com.meat.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author arthvedi1
 *
 */

@Entity
@Table(name = "zone_city", catalog = "meat_app")
public class ZoneCity extends AbstractDomain implements java.io.Serializable {

    private String cityName;
    private String status;
    private Set<Zone> zones = new HashSet<Zone>(0);

    public ZoneCity() {
    }

    public ZoneCity(final String id, final String cityName, final String status) {
        this.id = id;
        this.cityName = cityName;
        this.status = status;
    }

    public ZoneCity(final String id, final String cityName, final String status, final Set<Zone> zones) {
        this.id = id;
        this.cityName = cityName;
        this.status = status;
        this.zones = zones;
    }

    @Column(name = "city_name", nullable = false, length = 45)
    public String getCityName() {
        return cityName;
    }

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "zoneCity")
    @JsonManagedReference
    public Set<Zone> getZones() {
        return zones;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZones(final Set<Zone> zones) {
        this.zones = zones;
    }

}
