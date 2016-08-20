/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBranchTaxModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Varma
 *
 */
@Component("sellerBranchTaxRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranchTax", uri = "/sellerBranchTaxes/{id}")
@Representation(SellerBranchTaxModel.class)
public class SellerBranchTaxRepresentation extends BaseResource {
    private String id;
    private String taxId;
    private String amountDescription;
    private String taxName;
    private String taxType;
    private String taxValue;
    private String sellerBranchId;
    private String sellerBranchTaxStatus;
    private String createdDate;
    private String amountTypeId;
    @Siren4JSubEntity
    private List<SellerItemTaxRepresentation> sellerItemTaxRep = new ArrayList<SellerItemTaxRepresentation>(0);

    public String getAmountTypeId() {
        return amountTypeId;
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

    public String getSellerBranchTaxStatus() {
        return sellerBranchTaxStatus;
    }

    public List<SellerItemTaxRepresentation> getSellerItemTaxRep() {
        return sellerItemTaxRep;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public String getTaxType() {
        return taxType;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setAmountTypeId(final String amountTypeId) {
        this.amountTypeId = amountTypeId;
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

    public void setSellerBranchTaxStatus(final String sellerBranchTaxStatus) {
        this.sellerBranchTaxStatus = sellerBranchTaxStatus;
    }

    public void setSellerItemTaxRep(final List<SellerItemTaxRepresentation> sellerItemTaxRep) {
        this.sellerItemTaxRep = sellerItemTaxRep;
    }

    public void setTaxId(final String taxId) {
        this.taxId = taxId;
    }

    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    public void setTaxType(final String taxType) {
        this.taxType = taxType;
    }

    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

    /**
     * @return the amountDescription
     */
    public String getAmountDescription() {
        return amountDescription;
    }

    /**
     * @param amountDescription the amountDescription to set
     */
    public void setAmountDescription(String amountDescription) {
        this.amountDescription = amountDescription;
    }

}
