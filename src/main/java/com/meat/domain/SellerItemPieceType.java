/**
 *
 */
package com.meat.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "seller_item_piece_type", catalog = "meat_app")
public class SellerItemPieceType extends AbstractDomain implements java.io.Serializable {

    private SellerItem sellerItem;
    private PieceType pieceType;
    private String status;
    private Date createdDate;
    private Integer pieceCount;
    private String description;
    private Integer minQuantity;

    public SellerItemPieceType() {

    }

    public SellerItemPieceType(final String id, final PieceType pieceType, final SellerItem sellerItem, final String status,
            final Date createdDate) {
        this.id = id;
        this.status = status;
        this.createdDate = createdDate;
        this.pieceType = pieceType;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * @return the minQuantity
     */
    @Column(name = "min_quantity")
    public Integer getMinQuantity() {
        return minQuantity;
    }

    /**
     * @return the pieceCount
     */
    @Column(name = "piece_count")
    public Integer getPieceCount() {
        return pieceCount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piece_type_id")
    public PieceType getPieceType() {
        return pieceType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_item_id")
    public SellerItem getSellerItem() {
        return sellerItem;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param minQuantity
     *            the minQuantity to set
     */
    public void setMinQuantity(final Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    /**
     * @param pieceCount
     *            the pieceCount to set
     */
    public void setPieceCount(final Integer pieceCount) {
        this.pieceCount = pieceCount;
    }

    public void setPieceType(final PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public void setSellerItem(final SellerItem sellerItem) {
        this.sellerItem = sellerItem;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
