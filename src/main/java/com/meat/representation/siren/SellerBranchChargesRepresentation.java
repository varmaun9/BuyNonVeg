/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBranchChargesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerBranchChargesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranchCharges", uri = "/sellerBranchChargeses/{id}")
@Representation(SellerBranchChargesModel.class)
public class SellerBranchChargesRepresentation extends BaseResource {

    private String id;
    private String sellerBranchId;
    private String chargesType;
    private String chargesAmount;
    private String amountTypeId;
    private String amountDescription;
    private String status;
    private String createdDate;

    public String getAmountDescription() {
        return amountDescription;
    }

    public String getAmountTypeId() {
        return amountTypeId;
    }

    public String getChargesAmount() {
        return chargesAmount;
    }

    public String getChargesType() {
        return chargesType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getStatus() {
        return status;
    }

    public void setAmountDescription(final String amountDescription) {
        this.amountDescription = amountDescription;
    }

    public void setAmountTypeId(final String amountTypeId) {
        this.amountTypeId = amountTypeId;
    }

    public void setChargesAmount(final String chargesAmount) {
        this.chargesAmount = chargesAmount;
    }

    public void setChargesType(final String chargesType) {
        this.chargesType = chargesType;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
