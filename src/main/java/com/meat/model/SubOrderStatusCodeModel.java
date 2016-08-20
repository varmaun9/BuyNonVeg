/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderStatusCodeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubOrderStatusCodeModel extends AbstractModel {

    private String subOrderId;
    private String subOrderStatusName;
    private String subOrderStatusDate;
    private String subOrderStatusDescription;

    public String getSubOrderId() {
        return subOrderId;
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

    public void setSubOrderId(final String subOrderId) {
        this.subOrderId = subOrderId;
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
