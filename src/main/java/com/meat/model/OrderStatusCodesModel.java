package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderStatusCodesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderStatusCodesModel extends AbstractModel {

    private String orderId;
    private String orderStatusCode;
    private String orderStatusDescription;
    private String orderStatusDate;

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @return the orderStatusCode
     */
    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    /**
     * @return the orderStatusDate
     */
    public String getOrderStatusDate() {
        return orderStatusDate;
    }

    /**
     * @return the orderStatusDescription
     */
    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    /**
     * @param orderStatusCode
     *            the orderStatusCode to set
     */
    public void setOrderStatusCode(final String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    /**
     * @param orderStatusDate
     *            the orderStatusDate to set
     */
    public void setOrderStatusDate(final String orderStatusDate) {
        this.orderStatusDate = orderStatusDate;
    }

    /**
     * @param orderStatusDescription
     *            the orderStatusDescription to set
     */
    public void setOrderStatusDescription(final String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

}
