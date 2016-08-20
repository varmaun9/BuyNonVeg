package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.*;

/**
 * UserWishList generated by hbm2java
 */
@Entity
@Table(name = "user_wish_list", catalog = "meat_app")
public class UserWishList extends AbstractDomain implements java.io.Serializable {

    private Item item;
    private Users users;
    private Date createdDate;
    private String description;

    public UserWishList() {
    }

    public UserWishList(final String id, final Item item, final Users users, final Date createdDate) {
        this.id = id;
        this.item = item;
        this.users = users;
        this.createdDate = createdDate;
    }

    public UserWishList(final String id, final Item item, final Users users, final Date createdDate, final String description) {
        this.id = id;
        this.item = item;
        this.users = users;
        this.createdDate = createdDate;
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "description", length = 45)
    public String getDescription() {
        return description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    public Item getItem() {
        return item;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = false)
    public Users getUsers() {
        return users;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setUsers(final Users users) {
        this.users = users;
    }

}