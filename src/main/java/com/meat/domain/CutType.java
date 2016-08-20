/**
 *
 */
package com.meat.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "cut_type", catalog = "meat_app")
public class CutType extends AbstractDomain implements java.io.Serializable {

    private String cutTypeName;
    private String status;
    private String description;
    private Date createdDate;
    private Set<CategoryCutType> categoryCutTypes = new HashSet<CategoryCutType>(0);

    public CutType() {

    }

    public CutType(final String id, final String cutTypeName, final String status, final Set<CategoryCutType> categoryCutTypes,
            final String description, final Date createdDate) {
        this.id = id;
        this.cutTypeName = cutTypeName;
        this.status = status;
        this.description = description;
        this.createdDate = createdDate;
        this.categoryCutTypes = categoryCutTypes;
    }

    /**
     * @return the categoryCutTypes
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cutType")
    public Set<CategoryCutType> getCategoryCutTypes() {
        return categoryCutTypes;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "cut_type_name")
    public String getCutTypeName() {
        return cutTypeName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    /**
     * @param categoryCutTypes
     *            the categoryCutTypes to set
     */
    public void setCategoryCutTypes(final Set<CategoryCutType> categoryCutTypes) {
        this.categoryCutTypes = categoryCutTypes;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setCutTypeName(final String cutTypeName) {
        this.cutTypeName = cutTypeName;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
