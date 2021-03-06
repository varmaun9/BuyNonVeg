package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import javax.persistence.*;

/**
 * CategoryTags generated by hbm2java
 */
@Entity
@Table(name = "category_tags", catalog = "meat_app")
public class CategoryTags extends AbstractDomain implements java.io.Serializable {

    private Tags tags;
    private Category category;
    private String categoryTagsStatus;

    public CategoryTags() {
    }

    public CategoryTags(final String id, final Tags tags, final Category category, final String categoryTagsStatus) {
        this.id = id;
        this.tags = tags;
        this.category = category;
        this.categoryTagsStatus = categoryTagsStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    @Column(name = "category_tags_status", nullable = false, length = 10)
    public String getCategoryTagsStatus() {
        return categoryTagsStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tags_id", nullable = false)
    public Tags getTags() {
        return tags;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public void setCategoryTagsStatus(final String categoryTagsStatus) {
        this.categoryTagsStatus = categoryTagsStatus;
    }

    public void setTags(final Tags tags) {
        this.tags = tags;
    }

}
