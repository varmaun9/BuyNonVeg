package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "meat_app")
public class Category extends AbstractDomain implements java.io.Serializable {

    private Seo seo;
    private String categoryName;
    private String description;
    private Date createdDate;
    private String sellingTag;
    private String status;
    private String categoryCode;
    private long categoryCount;
    private Integer countFlag;
    private Set<CategoryAttributes> categoryAttributeses = new HashSet<CategoryAttributes>(0);
    private Set<SubCategory> subCategories = new HashSet<SubCategory>(0);
    private Set<CategoryCriteria> categoryCriterias = new HashSet<CategoryCriteria>(0);
    private Set<CategoryTags> categoryTagses = new HashSet<CategoryTags>(0);
    private Set<CategoryImages> categoryImageses = new HashSet<CategoryImages>(0);
    private Set<CategoryCutType> categoryCutTypes = new HashSet<CategoryCutType>(0);

    public Category() {
    }

    public Category(final String id, final Seo seo, final String categoryName, final Date createdDate, final String status,
            final String categoryCode, final Integer countFlag, final long categoryCount) {
        this.id = id;
        this.seo = seo;
        this.categoryName = categoryName;
        this.createdDate = createdDate;
        this.status = status;
        this.countFlag = countFlag;
        this.categoryCode = categoryCode;
        this.categoryCount = categoryCount;
    }

    public Category(final String id, final Seo seo, final String categoryName, final String description, final Date createdDate,
            final String sellingTag, final String status, final Integer countFlag, final String categoryCode, final long categoryCount,
            final Set<CategoryAttributes> categoryAttributeses, final Set<SubCategory> subCategories,
            final Set<CategoryCriteria> categoryCriterias, final Set<CategoryTags> categoryTagses,
            final Set<CategoryImages> categoryImageses, final Set<CategoryCutType> categoryCutTypes) {
        this.id = id;
        this.seo = seo;
        this.categoryName = categoryName;
        this.description = description;
        this.createdDate = createdDate;
        this.sellingTag = sellingTag;
        this.status = status;
        this.countFlag = countFlag;
        this.categoryCode = categoryCode;
        this.categoryCount = categoryCount;
        this.categoryAttributeses = categoryAttributeses;
        this.subCategories = subCategories;
        this.categoryCutTypes = categoryCutTypes;
        this.categoryCriterias = categoryCriterias;
        this.categoryTagses = categoryTagses;
        this.categoryImageses = categoryImageses;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    public Set<CategoryAttributes> getCategoryAttributeses() {
        return categoryAttributeses;
    }

    @Column(name = "category_code", nullable = false, length = 45)
    public String getCategoryCode() {
        return categoryCode;
    }

    @Column(name = "category_count", nullable = false)
    public long getCategoryCount() {
        return categoryCount;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<CategoryCriteria> getCategoryCriterias() {
        return categoryCriterias;
    }

    /**
     * @return the cutTypes
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<CategoryCutType> getCategoryCutTypes() {
        return categoryCutTypes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<CategoryImages> getCategoryImageses() {
        return categoryImageses;
    }

    @Column(name = "category_name", nullable = false, length = 45)
    public String getCategoryName() {
        return categoryName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<CategoryTags> getCategoryTagses() {
        return categoryTagses;
    }

    @Column(name = "count_flag")
    public Integer getCountFlag() {
        return countFlag;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    @Column(name = "selling_tag")
    public String getSellingTag() {
        return sellingTag;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seo_id", nullable = false)
    public Seo getSeo() {
        return seo;
    }

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setCategoryAttributeses(final Set<CategoryAttributes> categoryAttributeses) {
        this.categoryAttributeses = categoryAttributeses;
    }

    public void setCategoryCode(final String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryCount(final long categoryCount) {
        this.categoryCount = categoryCount;
    }

    public void setCategoryCriterias(final Set<CategoryCriteria> categoryCriterias) {
        this.categoryCriterias = categoryCriterias;
    }

    /**
     * @param cutTypes
     *            the cutTypes to set
     */
    public void setCategoryCutTypes(final Set<CategoryCutType> categoryCutTypes) {
        this.categoryCutTypes = categoryCutTypes;
    }

    public void setCategoryImageses(final Set<CategoryImages> categoryImageses) {
        this.categoryImageses = categoryImageses;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryTagses(final Set<CategoryTags> categoryTagses) {
        this.categoryTagses = categoryTagses;
    }

    public void setCountFlag(final Integer countFlag) {
        this.countFlag = countFlag;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setSellingTag(final String sellingTag) {
        this.sellingTag = sellingTag;
    }

    public void setSeo(final Seo seo) {
        this.seo = seo;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setSubCategories(final Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

}
