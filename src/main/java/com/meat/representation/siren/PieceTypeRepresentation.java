package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.PieceTypeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("pieceTypeRepresentation ")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "pieceType", uri = "/pieceTypes/{id}")
@Representation(PieceTypeModel.class)
public class PieceTypeRepresentation extends BaseResource {

    private String id;
    private String pieceName;
    private String status;
    private String pieceCount;
    private String minQuantity;
    private String description;

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
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

    public String getStatus() {
        return status;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
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

    public void setStatus(final String status) {
        this.status = status;
    }

}
