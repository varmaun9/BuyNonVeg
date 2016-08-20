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
@Component("sellerBranchTaxModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchTaxModel extends AbstractModel {
    private String amountTypeId;
    private String amountDescription;
    private String taxId;
    private String taxName;
    private String taxType;
    private String taxValue;
    private String sellerBranchId;
    private String sellerBranchTaxStatus;
    private String createdDate;
    private List<SellerItemTaxModel> sellerItemTaxModels = new ArrayList<SellerItemTaxModel>(0);

    /**
     * @return the amountDescription
     */
    public String getAmountDescription() {
        return amountDescription;
    }

    public String getAmountTypeId() {
        return amountTypeId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getSellerBranchTaxStatus() {
        return sellerBranchTaxStatus;
    }

    public List<SellerItemTaxModel> getSellerItemTaxModels() {
        return sellerItemTaxModels;
    }

    public String getTaxId() {
        return taxId;
    }

    /**
     * @return the taxName
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * @return the taxType
     */
    public String getTaxType() {
        return taxType;
    }

    public String getTaxValue() {
        return taxValue;
    }

    /**
     * @param amountDescription
     *            the amountDescription to set
     */
    public void setAmountDescription(final String amountDescription) {
        this.amountDescription = amountDescription;
    }

    public void setAmountTypeId(final String amountTypeId) {
        this.amountTypeId = amountTypeId;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setSellerBranchTaxStatus(final String sellerBranchTaxStatus) {
        this.sellerBranchTaxStatus = sellerBranchTaxStatus;
    }

    public void setSellerItemTaxModels(final List<SellerItemTaxModel> sellerItemTaxModels) {
        this.sellerItemTaxModels = sellerItemTaxModels;
    }

    public void setTaxId(final String taxId) {
        this.taxId = taxId;
    }

    /**
     * @param taxName
     *            the taxName to set
     */
    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    /**
     * @param taxType
     *            the taxType to set
     */
    public void setTaxType(final String taxType) {
        this.taxType = taxType;
    }

    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

}
