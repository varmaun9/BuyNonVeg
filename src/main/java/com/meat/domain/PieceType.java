/**
 *
 */
package com.meat.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "piece_type", catalog = "meat_app")
public class PieceType extends AbstractDomain implements java.io.Serializable {

    private String pieceName;
    private String status;
    private Integer pieceCount;
    private Integer minQuantity;
    private String description;
    private Set<SellerItemPieceType> sellerItemPieceTypes = new HashSet<SellerItemPieceType>(0);

    public PieceType() {

    }

    public PieceType(final String id, final Integer pieceCount, final Integer minQuantity, final String pieceName, final String status,
            final String description) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.pieceName = pieceName;
        this.pieceCount = pieceCount;
        this.minQuantity = minQuantity;
    }

    public PieceType(final String id, final Integer pieceCount, final Integer minQuantity, final String pieceName, final String status,
            final String description, final Set<SellerItemPieceType> sellerItemPieceTypes) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.pieceName = pieceName;
        this.pieceCount = pieceCount;
        this.minQuantity = minQuantity;
        this.sellerItemPieceTypes = sellerItemPieceTypes;
    }

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

    @Column(name = "piece_name")
    public String getPieceName() {
        return pieceName;
    }

    /**
     * @return the sellerItemPieceTypes
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pieceType")
    public Set<SellerItemPieceType> getSellerItemPieceTypes() {
        return sellerItemPieceTypes;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

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

    public void setPieceName(final String pieceName) {
        this.pieceName = pieceName;
    }

    /**
     * @param sellerItemPieceTypes
     *            the sellerItemPieceTypes to set
     */
    public void setSellerItemPieceTypes(final Set<SellerItemPieceType> sellerItemPieceTypes) {
        this.sellerItemPieceTypes = sellerItemPieceTypes;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
