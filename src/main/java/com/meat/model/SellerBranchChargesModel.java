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
@Component("sellerBranchChargesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchChargesModel extends AbstractModel {

    private String sellerBranchId;
    private String chargesType;
    private String chargesAmount;
    private String amountTypeId;
    private String amountDescription;
    private String status;
    private String createdDate;

    /**
     * @return the amountDescription
     */
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

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getStatus() {
        return status;
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

    public void setChargesAmount(final String chargesAmount) {
        this.chargesAmount = chargesAmount;
    }

    public void setChargesType(final String chargesType) {
        this.chargesType = chargesType;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
