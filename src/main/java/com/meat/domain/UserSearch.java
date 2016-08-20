package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.*;

/**
 * UserSearch generated by hbm2java
 */
@Entity
@Table(name = "user_search", catalog = "meat_app")
public class UserSearch extends AbstractDomain implements java.io.Serializable {

    private Users users;
    private Item item;
    private String userSearchItemStatus;
    private Date createdDate;

    public UserSearch() {
    }

    public UserSearch(final String id, final Users users, final Item item, final String userSearchItemStatus, final Date createdDate) {
        this.id = id;
        this.users = users;
        this.item = item;
        this.userSearchItemStatus = userSearchItemStatus;
        this.createdDate = createdDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "created_date", nullable = false, length = 10)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "item_id", nullable = false, length = 100)
    public Item getItem() {
        return item;
    }

    @Column(name = "users_id", nullable = false, length = 100)
    public Users getUsers() {
        return users;
    }

    @Column(name = "user_search_item_status", nullable = false, length = 45)
    public String getUserSearchItemStatus() {
        return userSearchItemStatus;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    public void setUsers(final Users users) {
        this.users = users;
    }

    public void setUserSearchItemStatus(final String userSearchItemStatus) {
        this.userSearchItemStatus = userSearchItemStatus;
    }

}