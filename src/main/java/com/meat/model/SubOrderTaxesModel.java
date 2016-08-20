/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("subOrderTaxesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubOrderTaxesModel extends AbstractModel {

    private String taxName;
    private String taxValue;
    private String subOrderId;
    private String status;
    private String description;

    public String getDescription() {
        return description;
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
