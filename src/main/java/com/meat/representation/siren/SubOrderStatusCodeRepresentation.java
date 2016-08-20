/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubOrderStatusCodeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderStatusCodeRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subOrderStatusCode", uri = "/subOrderStatusCodes/{id}")
@Representation(SubOrderStatusCodeModel.class)
public class SubOrderStatusCodeRepresentation extends BaseResource {
    private String id;
    private String subOrder;
    private String subOrderStatusName;
    private String subOrderStatusDate;
    private String subOrderStatusDescription;

    public String getId() {
        return id;
    }

    public String getSubOrder() {
        return subOrder;
    }

    /**
     * @return the subOrderStatusDate
     */
    public String getSubOrderStatusDate() {
        return subOrderStatusDate;
    }

    /**
     * @return the subOrderStatusDescription
     */
    public String getSubOrderStatusDescription() {
        return subOrderStatusDescription;
    }

    public String getSubOrderStatusName() {
        return subOrderStatusName;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSubOrder(final String subOrder) {
        this.subOrder = subOrder;
    }

    /**
     * @param subOrderStatusDate
     *            the subOrderStatusDate to set
     */
    public void setSubOrderStatusDate(final String subOrderStatusDate) {
        this.subOrderStatusDate = subOrderStatusDate;
    }

    /**
     * @param subOrderStatusDescription
     *            the subOrderStatusDescription to set
     */
    public void setSubOrderStatusDescription(final String subOrderStatusDescription) {
        this.subOrderStatusDescription = subOrderStatusDescription;
    }

    public void setSubOrderStatusName(final String subOrderStatusName) {
        this.subOrderStatusName = subOrderStatusName;
    }

}
