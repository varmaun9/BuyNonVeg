/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerItemPieceTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerItemPieceTypeModel extends AbstractModel {

    private String sellerItemId;
    private String pieceTypeId;
    private String createdDate;
    private String pieceCount;
    private String pieceName;
    private String status;
    private String description;
    private String minQuantity;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getMinQuantity() {
        return minQuantity;
    }

    public String getPieceCount() {
        return pieceCount;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String getPieceTypeId() {
        return pieceTypeId;
    }

    public String getSellerItemId() {
        return sellerItemId;
    }

    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setMinQuantity(final String minQuantity) {
        this.minQuantity = minQuantity;
    }

    public void setPieceCount(final String pieceCount) {
        this.pieceCount = pieceCount;
    }

    public void setPieceName(final String pieceName) {
        this.pieceName = pieceName;
    }

    public void setPieceTypeId(final String pieceTypeId) {
        this.pieceTypeId = pieceTypeId;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
