/**
 *
 */
package com.meat.domain;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "sub_order_taxes", catalog = "meat_app")
public class SubOrderTaxes extends AbstractDomain implements java.io.Serializable {

    private String taxName;
    private String taxValue;
    private SubOrder subOrder;
    private String status;
    private String description;

    public SubOrderTaxes() {
    }

    public SubOrderTaxes(final String id, final String status, final String taxName, final String taxValue, final String description,
            final SubOrder subOrder) {
        this.id = id;
        this.subOrder = subOrder;
        this.taxName = taxName;
        this.taxValue = taxValue;
        this.status = status;
        this.description = description;

    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_order_id", nullable = false)
    public SubOrder getSubOrder() {
        return subOrder;
    }

    @Column(name = "tax_name")
    public String getTaxName() {
        return taxName;
    }

    @Column(name = "tax_value")
    public String getTaxValue() {
        return taxValue;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setSubOrder(final SubOrder subOrder) {
        this.subOrder = subOrder;
    }

    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

}
