/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBankAccountModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBankAccountModel extends AbstractModel {
    private String sellerBranchId;
    private String accountNo;
    private String ifscCode;
    private String branchDetails;
    private String name;
    private String accountType;
    private String panNumber;

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @return the branchDetails
     */
    public String getBranchDetails() {
        return branchDetails;
    }

    /**
     * @return the ifscCode
     */
    public String getIfscCode() {
        return ifscCode;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the panNumber
     */
    public String getPanNumber() {
        return panNumber;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @param accountNo
     *            the accountNo to set
     */
    public void setAccountNo(final String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @param accountType
     *            the accountType to set
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * @param branchDetails
     *            the branchDetails to set
     */
    public void setBranchDetails(final String branchDetails) {
        this.branchDetails = branchDetails;
    }

    /**
     * @param ifscCode
     *            the ifscCode to set
     */
    public void setIfscCode(final String ifscCode) {
        this.ifscCode = ifscCode;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param panNumber
     *            the panNumber to set
     */
    public void setPanNumber(final String panNumber) {
        this.panNumber = panNumber;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

}
