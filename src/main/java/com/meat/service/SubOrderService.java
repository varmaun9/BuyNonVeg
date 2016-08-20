/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderItemRepository;
import com.meat.dao.SubOrderRepository;
import com.meat.domain.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi1
 *
 */

@Component
public class SubOrderService implements ISubOrderService {

    @Autowired
    private SubOrderRepository subOrderRepository;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ISubOrderStatusCodeService subOrderStatusCodeService;
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private ISubOrderTaxesService subOrderTaxesService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#create(com.meat.domain.SubOrder)
     */
    @Override
    @Transactional
    public SubOrder create(final SubOrder subOrder) {
        SubOrder sOrder = new SubOrder();
        sOrder = subOrderRepository.save(subOrder);

        if (sOrder.getId() != null) {

            Set<OrderItem> orderItem = new HashSet<OrderItem>();
            for (OrderItem oi : sOrder.getOrderItems()) {
                OrderItem orderItm = oi;
                orderItm.setSubOrder(sOrder);

                orderItm = orderItemService.create(orderItm);
                orderItem.add(orderItm);
            }
            subOrder.setOrderItems(orderItem);
        }
        Set<SubOrderTaxes> subOrderTaxes = new HashSet<SubOrderTaxes>();
        if (sOrder.getId() != null) {
            for (SubOrderTaxes sot : sOrder.getSubOrderTaxes()) {
                SubOrderTaxes subOrderTax = sot;
                subOrderTax.setSubOrder(sOrder);

                subOrderTax = subOrderTaxesService.create(sot);
                subOrderTaxes.add(subOrderTax);
            }
            subOrder.setSubOrderTaxes(subOrderTaxes);
        }
        if (sOrder.getId() != null) {
            Set<SubOrderStatusCode> subOrderStatusCodes = new HashSet<SubOrderStatusCode>();
            //  for (SubOrderStatusCode subOrderSC : sOrder.getSubOrderStatusCodes()) {
            SubOrderStatusCode soSc = new SubOrderStatusCode();
            soSc.setSubOrder(sOrder);
            soSc.setSubOrderStatusDate(new Date());
            soSc.setSubOrderStatusName("PLACED");
            soSc.setSubOrderStatusDescription("SubOrderPlaced Status");
            subOrderStatusCodes.add(soSc);
            soSc = subOrderStatusCodeService.create(soSc);
            //}
            subOrder.setSubOrderStatusCodes(subOrderStatusCodes);
        }
        return sOrder;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#deleteSubOrder(java.lang.String)
     */
    @Override
    public void deleteSubOrder(final String subOrderId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getAll()
     */
    @Override
    public List<SubOrder> getAll() {
        List<SubOrder> subOrders = new ArrayList<SubOrder>();
        subOrders = (List<SubOrder>) subOrderRepository.findAll();
        return subOrders;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return (int) subOrderRepository.count();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getPreviousSubOrdersCountAmountByBranch(java.lang.String, int, java.lang.String)
     */
    @Override
    public Map<String, String> getPreviousSubOrdersCountAmountByBranchPaymentModePerPeriod(final String branchId, final int i,
            String period, final String paymentMode) {
        Map<String, String> lastPeriodOrdersCountAmount = new HashMap<String, String>(0);
        // DATE_SUB(NOW(), INTERVAL 5 MINUTE)
        period = "DATE_SUB(NOW(),INTERVAL " + i + " " + period + ")";
        List<Object[]> resultList = new ArrayList<Object[]>(0);
        if (paymentMode.equals("ALL")) {
            resultList = subOrderRepository.getAllPeriodSalesReportByBranch(branchId, period);
        }
        else {

            /* resultList = subOrderRepository.get7DaysPeriodSalesReportByBranch(branchId, paymentMode);*/
            resultList = subOrderRepository.findSubOrdersByBranchBilledStatusSubOrderStatusPaymentMode(branchId, paymentMode, "UNBILLED");

            // resultList = subOrderRepository.get30DaysPeriodSalesReportByBranch(branchId, paymentMode);

        }
        for (Object[] result : resultList) {
            if (result[1] != null) {
                lastPeriodOrdersCountAmount.put(result[0].toString(), result[1].toString());
            }
            else {
                lastPeriodOrdersCountAmount.put(result[0].toString(), "0.0");
            }
        }
        return lastPeriodOrdersCountAmount;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrder(java.lang.String)
     */
    @Override
    public SubOrder getSubOrder(final String subOrderId) {
        // TODO Auto-generated method stub
        return subOrderRepository.findOne(subOrderId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrderByBilledStatus(java.lang.String)
     */
    @Override
    public List<SubOrder> getSubOrderByBilledStatus(final String billedStatus) {
        // TODO Auto-generated method stub
        return subOrderRepository.findAll(billedStatus);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrderByBranchStatusDate(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public List<SubOrder> getSubOrderByBranchStatusDate(final String branchId, final String date, final String status) {
        // TODO Auto-generated method stub
        List<SubOrder> subOrders = new ArrayList<SubOrder>(0);
        if (!status.equals("ALL")) {
            subOrders = subOrderRepository.findSubOrdersByBranchDateStatus(branchId, date, status);
        }
        else {
            subOrders = subOrderRepository.findSubOrdersByBranchDate(branchId, date);
        }
        return subOrders;
    }

    /**
     * @param id
     * @param string
     * @return
     */
    @Override
    public List<SubOrder> getSubOrderByOrderAndStatus(final String orderId, final String status) {
        // TODO Auto-generated method stub
        List<SubOrder> so = subOrderRepository.findSubOrdersByOrderAndStatus(orderId, status);
        return so;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrderBySellerBranchId(java.lang.String)
     */
    @Override
    public List<SubOrder> getSubOrderBySellerBranchId(final String sellerBranchId) {
        // TODO Auto-generated method stub
        return subOrderRepository.findSubOrderBySellerBranchId(sellerBranchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrdersByStatusBillingPaymentMode(java.lang.String, java.lang.String, java.lang.String,
     *      java.lang.String)
     */
    @Override
    public Map<String, String> getSubOrdersByStatusBillingPaymentMode(final String branchId, final String subOrderStatus,
            final String billingStatus, final String paymentMode) {
        // TODO Auto-generated method stub
        Map<String, String> subOrders = new HashMap<String, String>();
        List<Object[]> resultList = subOrderRepository.findSubOrdersByBranchBilledSubOrderStatusPaymentMode(branchId, subOrderStatus,
                billingStatus, paymentMode);

        for (Object[] result : resultList) {
            if (result[1] != null) {
                subOrders.put(result[0].toString(), result[1].toString());
            }
            else {
                subOrders.put(result[0].toString(), "0.0");
            }
        }

        return subOrders;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrdersCountBranchByMinsBeforeStatus(java.lang.String, java.lang.String)
     */
    @Override
    public String getSubOrdersCountBranchByMinsBeforeStatus(final String branchId, final String status) {
        // TODO Auto-generated method stub
        return subOrderRepository.findSubOrderCountByBranchMinsBeforeStatus(branchId, status);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrdersCountByBranchStatusDate(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getSubOrdersCountByBranchStatusDate(final String branchId, final String status, final String date) {
        String count = "";
        if (date.equals("ALL")) {
            count = subOrderRepository.findSubOrderCountByBranchStatus(branchId, status);
        }
        else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // System.out.println(sdf.parse(date) + "###################");
            /*deliveryDate = sdf.format(date);
            System.out.println(deliveryDate + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");*/
            count = subOrderRepository.findSubOrderCountByBranchDeliveryDateStatus(branchId, status, date);
        }
        return count;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#getSubOrderUnBilledAmountByBranchBilledStatus(java.lang.String, java.lang.String,
     *      java.lang.String)
     */
    @Override
    public String getSubOrderUnBilledAmountByBranchBilledStatus(final String branchId, final String subOrderStatus,
            final String billedStatus) {
        if (subOrderStatus.equals("PLACEDORSHIPPEDORCONFIRMED")) {
            return subOrderRepository.findSubOrderAmountByBranchUnDeliveredStatus(branchId, billedStatus);
        }
        else {
            return subOrderRepository.findSubOrderAmountByBranchStatus(branchId, subOrderStatus, billedStatus);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderService#updateSubOrder(com.meat.domain.SubOrder)
     */
    @Override
    public SubOrder updateSubOrder(final SubOrder subOrder1) {

        SubOrder subOrder = subOrderRepository.save(subOrder1);
        if (subOrder.getSubOrderStatus() != null) {
            Orders os = ordersService.getOrder(subOrder.getOrders().getId());
            //checks whether all sub orders cancelled,
            //if so order status = cancelled
            //else order status = Partially confirmed
            if (subOrder.getSubOrderStatus().equals("CANCELLED")) {

                for (OrderItem oi : subOrder.getOrderItems()) {
                    oi.setOrderItemStatus("CANCELLED");
                    orderItemRepository.save(oi);
                }
                List<SubOrder> sos = getSubOrderByOrderAndStatus(subOrder.getOrders().getId(), "CANCELLED");
                if (sos != null) {

                    if (os.getSubOrders().size() == sos.size()) {
                        os.setStatus("CANCELLED");
                    }
                    else {
                        os.setStatus("PARTIALLYCONFIRMED");
                    }
                    os.setAmount(os.getAmount().subtract(subOrder.getSubOrderTotalPrice()));
                    ordersService.updateOrders(os);

                }
            }
            //checks whether all sub orders confirmed,
            //if so order status = confirmed
            //else order status = Partially confirmed
            if (subOrder.getSubOrderStatus().equals("CONFIRMED")) {

                List<SubOrder> sos = getSubOrderByOrderAndStatus(subOrder.getOrders().getId(), "CONFIRMED");
                if (sos != null) {

                    if (os.getSubOrders().size() == sos.size()) {
                        os.setStatus("CONFIRMED");
                    }
                    else {
                        os.setStatus("PARTIALLYCONFIRMED");
                    }
                    ordersService.updateOrders(os);

                }
            }
            if (subOrder.getSubOrderStatus().equals("PARTIALLYCONFIRMED")) {

                os.setStatus("PARTIALLYCONFIRMED");
                ordersService.updateOrders(os);
            }
            if (subOrder.getSubOrderStatus().equals("DELIVERED")) {
                List<SubOrder> sos = getSubOrderByOrderAndStatus(subOrder.getOrders().getId(), "DELIVERED");
                if (sos != null) {

                    if (os.getSubOrders().size() == sos.size()) {
                        os.setStatus("DELIVERED");
                    }
                    else {
                        os.setStatus("PARTIALLYDELIVERED");
                    }
                    ordersService.updateOrders(os);

                }
            }
            if (subOrder.equals("SHIPPED")) {

            }

        }

        return subOrder;
    }

}
