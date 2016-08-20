/**
 *
 */
package com.meat.domain;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "category_cut_type", catalog = "meat_app")
public class CategoryCutType extends AbstractDomain implements java.io.Serializable {

    private Category category;
    private CutType cutType;
    private String status;
    private String description;

    public CategoryCutType() {

    }

    public CategoryCutType(final String id, final Category category, final CutType cutType, final String status, final String description) {
        this.id = id;
        this.category = category;
        this.cutType = cutType;
        this.status = status;
        this.description = description;
    }

    /**
     * @return the category
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    /**
     * @return the cutType
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cut_type_id", nullable = false)
    public CutType getCutType() {
        return cutType;
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
     * @param category
     *            the category to set
     */
    public void setCategory(final Category category) {
        this.category = category;
    }

    /**
     * @param cutType
     *            the cutType to set
     */
    public void setCutType(final CutType cutType) {
        this.cutType = cutType;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
