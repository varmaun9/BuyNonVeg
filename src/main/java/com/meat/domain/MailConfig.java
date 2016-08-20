package com.meat.domain;

// Generated Feb 23, 2016 5:30:35 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.*;

/**
 * MailConfig generated by hbm2java
 */
@Entity
@Table(name = "mail_config", catalog = "meat_app")
public class MailConfig extends AbstractDomain implements java.io.Serializable {

    private String mailAttributeName;
    private String mailAttributeValue;
    private String status;
    private Date createdDate;
    private Date modifiedDate;
    /*private SellerBranch sellerBranch;*/

    public MailConfig() {
    }

    public MailConfig(final String id, final String mailAttributeName, final String mailAttributeValue, final String status) {
        this.id = id;
        this.mailAttributeName = mailAttributeName;
        this.mailAttributeValue = mailAttributeValue;
        this.status = status;
    }

    public MailConfig(final String id, final String mailAttributeName, final String mailAttributeValue, final String status,
            final Date createdDate, final Date modifiedDate) {
        this.id = id;
        this.mailAttributeName = mailAttributeName;
        this.mailAttributeValue = mailAttributeValue;
        this.status = status;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "mail_attribute_name", nullable = false, length = 100)
    public String getMailAttributeName() {
        return mailAttributeName;
    }

    @Column(name = "mail_attribute_value", nullable = false, length = 100)
    public String getMailAttributeValue() {
        return mailAttributeValue;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date", length = 19)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /*
    *//**
       * @return the sellerBranch
       *//*
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "seller_branch_id", nullable = false)
        public SellerBranch getSellerBranch() {
         return sellerBranch;
        }*/

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setMailAttributeName(final String mailAttributeName) {
        this.mailAttributeName = mailAttributeName;
    }

    public void setMailAttributeValue(final String mailAttributeValue) {
        this.mailAttributeValue = mailAttributeValue;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /* *//**
          * @param sellerBranch
          *            the sellerBranch to set
          *//*
           public void setSellerBranch(final SellerBranch sellerBranch) {
            this.sellerBranch = sellerBranch;
           }*/

    public void setStatus(final String status) {
        this.status = status;
    }

}
