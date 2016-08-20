package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("amountTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AmountTypeModel extends AbstractModel {
    private String amountTypeName;
    private String amountDescription;
    private List<CouponModel> couponsModels = new ArrayList<CouponModel>(0);
    private List<SellerBranchTaxModel> sellerBranchTaxesModels = new ArrayList<SellerBranchTaxModel>(0);

    public String getAmountDescription() {
        return amountDescription;
    }

    /**
     * @return the amountType
     */

    public String getAmountTypeName() {
        return amountTypeName;
    }

    public List<CouponModel> getCouponsModels() {
        return couponsModels;
    }

    public List<SellerBranchTaxModel> getSellerBranchTaxesModels() {
        return sellerBranchTaxesModels;
    }

    public void setAmountDescription(final String amountDescription) {
        this.amountDescription = amountDescription;
    }

    /**
     * @param amountType
     *            the amountType to set
     */

    public void setAmountTypeName(final String amountTypeName) {
        this.amountTypeName = amountTypeName;
    }

    public void setCouponsModels(final List<CouponModel> couponsModels) {
        this.couponsModels = couponsModels;
    }

    public void setSellerBranchTaxesModels(final List<SellerBranchTaxModel> sellerBranchTaxesModels) {
        this.sellerBranchTaxesModels = sellerBranchTaxesModels;
    }

}
