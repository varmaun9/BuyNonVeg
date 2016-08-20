/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBankAccountModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("SellerBankAccountRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "SellerBankAccount", uri = "/SellerBankAccounts/{id}")
@Representation(SellerBankAccountModel.class)
public class SellerBankAccountRepresentation extends BaseResource {
    private String id;
    private String sellerBranchId;
    private String accountNo;
    private String ifscCode;
    private String branchDetails;
    private String name;
    private String panNumber;
    private String accountType;

    /**
     * @return the accountNo
     */
    public String getAccountNo() {
        return accountNo;
    }

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
     * @return the id
     */
    public String getId() {
        return id;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
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
