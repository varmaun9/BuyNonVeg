/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerItemTaxModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemTaxRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerItemTax", uri = "/sellerItemTaxes/{id}")
@Representation(SellerItemTaxModel.class)
public class SellerItemTaxRepresentation extends BaseResource {
    private String id;
    private String sellerItemId;
    private String sellerBranchTaxId;
    private String sellerItemTaxStatus;
    private String sellerItemTaxValue;
    //private String sellerBranchTax_1;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
    }

    /* public String getSellerBranchTax_1() {
         return sellerBranchTax_1;
     }*/

    public String getSellerBranchTaxId() {
        return sellerBranchTaxId;
    }

    public String getSellerItemId() {
        return sellerItemId;
    }

    public String getSellerItemTaxStatus() {
        return sellerItemTaxStatus;
    }

    public String getSellerItemTaxValue() {
        return sellerItemTaxValue;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(final String id) {
        this.id = id;
    }

    /* public void setSellerBranchTax_1(final String sellerBranchTax_1) {
         this.sellerBranchTax_1 = sellerBranchTax_1;
     }*/

    public void setSellerBranchTaxId(final String sellerBranchTaxId) {
        this.sellerBranchTaxId = sellerBranchTaxId;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    public void setSellerItemTaxStatus(final String sellerItemTaxStatus) {
        this.sellerItemTaxStatus = sellerItemTaxStatus;
    }

    public void setSellerItemTaxValue(final String sellerItemTaxValue) {
        this.sellerItemTaxValue = sellerItemTaxValue;
    }

}
