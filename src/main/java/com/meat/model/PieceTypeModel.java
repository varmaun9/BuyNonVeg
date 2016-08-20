/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("pieceTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PieceTypeModel extends AbstractModel {

    private String pieceName;
    private String status;
    private String pieceCount;
    private String minQuantity;
    private String description;
    private List<SellerItemPieceTypeModel> sellerItemPieceTypeModels = new ArrayList<SellerItemPieceTypeModel>(0);

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

    /**
     * @return the sellerItemPieceTypeModels
     */
    public List<SellerItemPieceTypeModel> getSellerItemPieceTypeModels() {
        return sellerItemPieceTypeModels;
    }

    public String getStatus() {
        return status;
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

    /**
     * @param sellerItemPieceTypeModels
     *            the sellerItemPieceTypeModels to set
     */
    public void setSellerItemPieceTypeModels(final List<SellerItemPieceTypeModel> sellerItemPieceTypeModels) {
        this.sellerItemPieceTypeModels = sellerItemPieceTypeModels;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
