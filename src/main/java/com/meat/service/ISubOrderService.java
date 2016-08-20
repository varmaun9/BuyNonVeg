/**
 *
 */
package com.meat.service;

import com.meat.domain.SubOrder;

import java.util.List;
import java.util.Map;

/**
 * @author arthvedi1
 *
 */
public interface ISubOrderService {

    SubOrder create(SubOrder subOrder);

    void deleteSubOrder(String subOrderId);

    List<SubOrder> getAll();

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param branchId
     * @param i
     * @param string
     * @return
     */
    Map<String, String> getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(String branchId, int i, String periodType,
            String paymentMode);

    SubOrder getSubOrder(String subOrderId);

    /**
     * @param billedStatus
     * @return
     */
    List<SubOrder> getSubOrderByBilledStatus(String billedStatus);

    /**
     * @param branchId
     * @param date
     * @param status
     * @return sub Orders
     */
    List<SubOrder> getSubOrderByBranchStatusDate(String branchId, String date, String status);

    /**
     * @param orderId
     * @param status
     * @return
     */
    List<SubOrder> getSubOrderByOrderAndStatus(String orderId, String status);

    /**
     * @param sellerBranchId
     * @return
     */
    List<SubOrder> getSubOrderBySellerBranchId(String sellerBranchId);

    /**
     * @param branchId
     * @param string
     * @param string2
     * @param string3
     * @return
     */
    Map<String, String> getSubOrdersByStatusBillingPaymentMode(String branchId, String subOrderStatus, String billingStatus,
            String paymentMode);

    /**
     * @param branchId
     * @param string
     * @return
     */
    String getSubOrdersCountBranchByMinsBeforeStatus(String branchId, String string);

    /**
     * @param branchId
     * @param string
     * @param date1
     * @return
     */
    String getSubOrdersCountByBranchStatusDate(String branchId, String status, String date1);

    /**
     * @param branchId
     * @param string
     * @param string2
     * @return
     */
    String getSubOrderUnBilledAmountByBranchBilledStatus(String branchId, String status, String billedStatus);

    SubOrder updateSubOrder(SubOrder subOrder);

}
