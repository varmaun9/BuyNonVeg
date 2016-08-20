/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("taxModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxModel extends AbstractModel {
    private String taxName;
    private String taxType;
    private String taxStatus;
    private Date createdDate;
    private List<SellerBranchTaxModel> sellerBranchTaxModels = new ArrayList<SellerBranchTaxModel>(0);

    public Date getCreatedDate() {
        return createdDate;
    }

    public List<SellerBranchTaxModel> getSellerBranchTaxModels() {
        return sellerBranchTaxModels;
    }

    public String getTaxName() {
        return taxName;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setSellerBranchTaxModels(final List<SellerBranchTaxModel> sellerBranchTaxModels) {
        this.sellerBranchTaxModels = sellerBranchTaxModels;
    }

    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    public void setTaxStatus(final String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public void setTaxType(final String taxType) {
        this.taxType = taxType;
    }

}