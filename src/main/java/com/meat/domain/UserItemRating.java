package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.*;

/**
 * UserItemRating generated by hbm2java
 */
@Entity
@Table(name = "user_item_rating", catalog = "meat_app")
public class UserItemRating extends AbstractDomain implements java.io.Serializable {

    private Users users;
    private Item item;
    private int rating;
    private String itemRatingStatus;
    private String comments;
    private Date createdDate;

    public UserItemRating() {
    }

    public UserItemRating(final String id, final Users users, final Item item, final int rating, final String itemRatingStatus) {
        this.id = id;
        this.users = users;
        this.item = item;
        this.rating = rating;
        this.itemRatingStatus = itemRatingStatus;
    }

    public UserItemRating(final String id, final Users users, final Item item, final int rating, final String itemRatingStatus,
            final String comments, final Date createdDate) {
        this.id = id;
        this.users = users;
        this.item = item;
        this.rating = rating;
        this.itemRatingStatus = itemRatingStatus;
        this.comments = comments;
        this.createdDate = createdDate;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    public Item getItem() {
        return item;
    }

    @Column(name = "item_rating_status", nullable = false, length = 45)
    public String getItemRatingStatus() {
        return itemRatingStatus;
    }

    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public Users getUsers() {
        return users;
    }

    public void setComments(final String comments) {
        this.comments = comments;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setItemRatingStatus(final String itemRatingStatus) {
        this.itemRatingStatus = itemRatingStatus;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public void setUsers(final Users users) {
        this.users = users;
    }

}