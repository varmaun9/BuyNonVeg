/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.TaxModel;
import com.meat.util.Representation;

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
@Component("taxRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "tax", uri = "/taxes/{id}")
@Representation(TaxModel.class)
public class TaxRepresentation extends BaseResource {

    private String id;
    private String taxName;
    private String taxType;
    private String taxStatus;
    private Date createdDate;

    @Siren4JSubEntity
    private List<SellerBranchTaxRepresentation> sellerBranchTaxRep = new ArrayList<SellerBranchTaxRepresentation>(0);

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
    }

    public List<SellerBranchTaxRepresentation> getSellerBranchTaxRep() {
        return sellerBranchTaxRep;
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

    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerBranchTaxRep(final List<SellerBranchTaxRepresentation> sellerBranchTaxRep) {
        this.sellerBranchTaxRep = sellerBranchTaxRep;
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
