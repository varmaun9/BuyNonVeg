package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("sellerContext")
public class SellerContext implements IBusinessDelegateContext {

    private String all;
    private String sellerOnly;
    private String sellerId;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return
     */
    public String getSellerOnly() {
        // TODO Auto-generated method stub
        return sellerOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param string
     */
    public void setSellerOnly(final String sellerOnly) {
        this.sellerOnly = sellerOnly;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

}
