/**
 *
 */
package com.meat.dao;

import com.meat.domain.SubOrder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi1
 *
 */

public interface SubOrderRepository extends PagingAndSortingRepository<SubOrder, Serializable> {

    /**
     * @param billedStatus
     * @return
     */
    @Query("Select so from SubOrder so where so.billedStatus=?1 ")
    List<SubOrder> findAll(String billedStatus);

    /**
     * @param id
     * @return
     */
    @Query("SELECT SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.subOrderStatusCodes sosc JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.paymentMode = ?2")
    BigDecimal findBilledSubOrdersAmountByPaymentType(String branchId, String paymentType);

    /**
     * @param id
     * @return
     */
    @Query("SELECT SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.sellerBranch sb JOIN so.subOrderStatusCodes sosc WHERE sb.id=?1 AND sosc.subOrderStatusName='CANCELLED'")
    BigDecimal findCancelledSubOrdersAmountByBranch(String branchId);

    /**
     * @param id
     * @return
     */
    @Query("SELECT SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.sellerBranch sb JOIN so.subOrderStatusCodes sosc WHERE sb.id=?1 AND sosc.subOrderStatusName='DELIVERED'")
    BigDecimal findDeliverySubOrdersAmountByBranch(String branchId);

    /**
     * @param branchId
     * @param subOrderStatus
     * @param billedStatus
     * @return
     */
    @Query("select SUM(so.subOrderTotalPrice) from SubOrder so join so.sellerBranch sb where sb.id = ?1 and so.billedStatus =?3 and so.subOrderStatus=?2 ")
    String findSubOrderAmountByBranchStatus(String branchId, String subOrderStatus, String billedStatus);

    /**
     * @param branchId
     * @param billedStatus
     * @return
     */
    @Query("select SUM(so.subOrderTotalPrice) from SubOrder so join so.sellerBranch sb where sb.id = ?1 and so.billedStatus =?2 and (so.subOrderStatus!='DELIVERED' or so.subOrderStatus!='CANCELLED')")
    String findSubOrderAmountByBranchUnDeliveredStatus(String branchId, String billedStatus);

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("Select so from SubOrder so join so.sellerBranch sb where sb.id=?1")
    List<SubOrder> findSubOrderBySellerBranchId(String sellerBranchId);

    /**
     * @param branchId
     * @param status
     * @param date
     * @return
     */
    @Query("SELECT COUNT(so) FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.subOrderStatus = ?2 AND so.subOrderDeliveryDate=DATE(?3)")
    String findSubOrderCountByBranchDeliveryDateStatus(String branchId, String status, String date);

    /**
     * @param branchId
     * @param status
     * @return
     */
    @Query(value = "SELECT count(*) FROM sub_order WHERE seller_branch_id=?1 AND sub_order_status = ?2 AND created_date < DATE_SUB(NOW(), INTERVAL 5 MINUTE)", nativeQuery = true)
    String findSubOrderCountByBranchMinsBeforeStatus(String branchId, String status);

    /**
     * @param branchId
     * @param status
     * @return Sub
     */
    @Query("SELECT COUNT(so) FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.subOrderStatus=?2")
    String findSubOrderCountByBranchStatus(String branchId, String status);

    /**
     * @param branchId
     * @param paymentMode
     * @param string
     * @return
     */
    @Query("SELECT COUNT(so), SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.paymentMode = ?2 AND so.billedStatus=?3")
    List<Object[]> findSubOrdersByBranchBilledStatusSubOrderStatusPaymentMode(String branchId, String paymentMode, String billingStatus);

    /**
     * @param branchId
     * @param subOrderStatus
     * @param billingStatus
     * @param paymentMode
     * @return
     */
    @Query("SELECT COUNT(so),SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.subOrderStatus = ?2 AND so.billedStatus = ?3 AND so.paymentMode = ?4)")
    List<Object[]> findSubOrdersByBranchBilledSubOrderStatusPaymentMode(String branchId, String subOrderStatus, String billingStatus,
            String paymentMode);

    /**
     * @param branchId
     * @param date
     * @return
     */
    @Query("SELECT so FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.subOrderDeliveryDate=DATE(?2)")
    List<SubOrder> findSubOrdersByBranchDate(String branchId, String date);

    /**
     * @param branchId
     * @param date
     * @param status
     * @return
     */
    @Query("SELECT so FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id=?1 AND so.subOrderStatus=?3 AND so.subOrderDeliveryDate=DATE(?2)")
    List<SubOrder> findSubOrdersByBranchDateStatus(String branchId, String date, String status);

    @Query("select so from SubOrder so where so.orders.id=?1 AND so.subOrderStatus=?2")
    List<SubOrder> findSubOrdersByOrderAndStatus(String orderId, String status);

    /**
     * @return
     */
    @Query("select so from SubOrder so join so.sellerBranch sb join so.subOrderStatusCodes sosc where (sosc.subOrderStatusName='DELIVERED' or sosc.subOrderStatusName='CANCELLED') and so.billedStatus='UNBILLED'")
    List<SubOrder> findUnbilledSubOrders();

    /**
     * @return
     */
    @Query("select sb.id as sellerBranchId,SUM(so.subOrderSubTotalPrice) as totalAmount,SUM(so.subOrderTotalPrice) as grandTotalAmount,so.discount as discount, so.taxValue as taxValue, so.subOrderTotalCharges as sellerCharges,DATE(MIN(sosc.subOrderStatusDate)) as minDate, DATE(MAX(sosc.subOrderStatusDate)) as maxDate from SubOrder so join so.sellerBranch sb join so.subOrderStatusCodes sosc where (sosc.subOrderStatusName='DELIVERED' OR sosc.subOrderStatusName='CANCELLED') and so.billedStatus='UNBILLED'  GROUP BY sb.id")
    List<Object[]> findUnbilledSubOrdersTotalAmount();

    /**
     * @param branchId
     * @param paymentMode
     * @return
     */
    @Query(value = "SELECT COUNT(id) , SUM(sub_order_total_price) FROM sub_order WHERE seller_branch_id=?1  AND sub_order_delivery_date > DATE_SUB(NOW(),INTERVAL 7 DAY) AND payment_mode = ?2", nativeQuery = true)
    List<Object[]> get30DaysPeriodSalesReportByBranch(String branchId, String paymentMode);

    /**
     * @param branchId
     * @param paymentMode
     * @return
     */
    @Query(value = "SELECT COUNT(id) , SUM(sub_order_total_price) FROM sub_order WHERE seller_branch_id=?1  AND sub_order_delivery_date > DATE_SUB(NOW(),INTERVAL 7 DAY) AND payment_mode = ?2", nativeQuery = true)
    List<Object[]> get7DaysPeriodSalesReportByBranch(String branchId, String paymentMode);

    /**
     * @param branchId
     * @param period
     * @return
     */
    @Query(value = "SELECT COUNT(id) , SUM(sub_order_total_price) FROM sub_order WHERE seller_branch_id=?1  AND (sub_order_status='DELIVERED' OR sub_order_status = 'CANCELLED') AND sub_order_delivery_date > DATE_SUB(NOW(),INTERVAL 7 DAY) AND  payment_mode = ?2", nativeQuery = true)
    List<Object[]> getAllPeriodSalesReportByBranch(String branchId, String period);

    /**
     * @return
     */
    @Query("SELECT COUNT(so) FROM SubOrder so")
    Integer getCount();

    /**
     * @param branchId
     * @param period
     * @return
     */
    @Query(value = "SELECT COUNT(id) , SUM(sub_order_total_price) FROM sub_order WHERE seller_branch_id=?1  AND sub_order_delivery_date > ?2 AND payment_mode = ?3", nativeQuery = true)
    List<Object[]> getPeriodSalesReportByBranch(String branchId, String period, String paymentMode);

    @Query(value = "SELECT COUNT(id),SUM(sub_order_total_price) FROM sub_order WHERE seller_branch_id= ?1 AND (sub_order_status='DELIVERED' OR sub_order_status = 'CANCELLED') AND DATE(sub_order_delivery_date) BETWEEN DATE(NOW()) AND DATE(?3) AND  payment_mode = ?2", nativeQuery = true)
    /*    @Query("SELECT COUNT(so),SUM(so.subOrderTotalPrice) FROM SubOrder so JOIN so.sellerBranch sb WHERE sb.id = ?1 AND so.subOrderStatus='DELIVERED' AND so.paymentMode = ?2")*/
    List<Object[]> getSubOrderCount(String branchId, String paymentMode, String period);

}
