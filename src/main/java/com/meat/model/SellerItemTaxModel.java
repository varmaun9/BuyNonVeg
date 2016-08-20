package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sellerItemTaxModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerItemTaxModel extends AbstractModel {

    private String sellerItemId;
    private String sellerBranchTaxId;
    private String sellerItemTaxStatus;
    private String sellerItemTaxValue;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getSellerBranchTaxId() {
        return sellerBranchTaxId;
    }

    public String getSellerItemId() {
        return sellerItemId;
    }

    public String getSellerItemTaxStatus() {
        return sellerItemTaxStatus;
    }

    public String getSellerItemTaxValue() {
        return sellerItemTaxValue;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setSellerBranchTaxId(final String sellerBranchTaxId) {
        this.sellerBranchTaxId = sellerBranchTaxId;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    public void setSellerItemTaxStatus(final String sellerItemTaxStatus) {
        this.sellerItemTaxStatus = sellerItemTaxStatus;
    }

    public void setSellerItemTaxValue(final String sellerItemTaxValue) {
        this.sellerItemTaxValue = sellerItemTaxValue;
    }

}
