/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubOrderTaxesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("subOrderTaxesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subOrderTaxes", uri = "/subOrderTaxes/{id}")
@Representation(SubOrderTaxesModel.class)
public class SubOrderTaxesRepresentation extends BaseResource {

    private String id;
    private String taxName;
    private String taxValue;
    private String subOrderId;
    private String status;
    private String description;

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public String getTaxName() {
        return taxName;
    }

    public String getTaxValue() {
        return taxValue;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setSubOrderId(final String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

}
