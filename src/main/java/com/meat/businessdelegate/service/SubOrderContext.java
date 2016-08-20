/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("subOrderContext")
public class SubOrderContext implements IBusinessDelegateContext {

    private String all;

    private String sellerBranchId;
    private String date;
    private String subOrdersByBranchDate;
    private String subOrderBranchDateStatus;
    private String status;

    public String getAll() {
        return all;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the subOrderBranchDateStatus
     */
    public String getSubOrderBranchDateStatus() {
        return subOrderBranchDateStatus;
    }

    /**
     * @return the subOrdersByBranchDate
     */
    public String getSubOrdersByBranchDate() {
        return subOrdersByBranchDate;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param subOrderBranchDateStatus
     *            the subOrderBranchDateStatus to set
     */
    public void setSubOrderBranchDateStatus(final String subOrderBranchDateStatus) {
        this.subOrderBranchDateStatus = subOrderBranchDateStatus;
    }

    /**
     * @param subOrdersByBranchDate
     *            the subOrdersByBranchDate to set
     */
    public void setSubOrdersByBranchDate(final String subOrdersByBranchDate) {
        this.subOrdersByBranchDate = subOrdersByBranchDate;
    }

}
