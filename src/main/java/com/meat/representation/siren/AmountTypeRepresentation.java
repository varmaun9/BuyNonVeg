/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.AmountTypeModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("amountTypeRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "amountType", uri = "/amountTypes/{id}")
@Representation(AmountTypeModel.class)
public class AmountTypeRepresentation extends BaseResource {

    private String id;
    private String amountTypeName;
    private String amountDescription;
    @Siren4JSubEntity
    private List<CouponRepresentation> couponsRep = new ArrayList<CouponRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerBranchTaxRepresentation> sellerBranchTaxesRep = new ArrayList<SellerBranchTaxRepresentation>(0);

    /**
     * @return the amountDescription
     */
    public String getAmountDescription() {
        return amountDescription;
    }

    /**
     * @return the amountTypeName
     */
    public String getAmountTypeName() {
        return amountTypeName;
    }

    /**
     * @return the couponsRep
     */
    public List<CouponRepresentation> getCouponsRep() {
        return couponsRep;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the sellerBranchTaxesRep
     */
    public List<SellerBranchTaxRepresentation> getSellerBranchTaxesRep() {
        return sellerBranchTaxesRep;
    }

    /**
     * @param amountDescription
     *            the amountDescription to set
     */
    public void setAmountDescription(final String amountDescription) {
        this.amountDescription = amountDescription;
    }

    /**
     * @param amountTypeName
     *            the amountTypeName to set
     */
    public void setAmountTypeName(final String amountTypeName) {
        this.amountTypeName = amountTypeName;
    }

    /**
     * @param couponsRep
     *            the couponsRep to set
     */
    public void setCouponsRep(final List<CouponRepresentation> couponsRep) {
        this.couponsRep = couponsRep;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param sellerBranchTaxesRep
     *            the sellerBranchTaxesRep to set
     */
    public void setSellerBranchTaxesRep(final List<SellerBranchTaxRepresentation> sellerBranchTaxesRep) {
        this.sellerBranchTaxesRep = sellerBranchTaxesRep;
    }

}
