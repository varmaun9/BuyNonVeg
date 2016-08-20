/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderItemRepository;
import com.meat.dao.OrdersRepository;
import com.meat.dao.SubOrderRepository;
import com.meat.domain.OrderItem;
import com.meat.domain.Orders;
import com.meat.domain.SubOrder;
import com.meat.domain.SubOrderStatusCode;

import java.util.*;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Varma
 *
 */
@Component
public class OrdersService implements IOrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private SubOrderRepository subOrderRepository;
    @Autowired
    private ISubOrderStatusCodeService subOrderStatusCodeService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrdersService#addOrderItem(com.meat.domain.Orders, java.util.List)
     */
    @Override
    public Orders addOrderItem(final Orders orders, final List<OrderItem> orderItem) {
        Validate.notNull(orders, "orders must not be null");
        Set<OrderItem> addOrderItem = new HashSet<OrderItem>(orderItem);
        for (OrderItem odItem : orderItem) {
            OrderItem orderItem1 = new OrderItem();
            orderItem1.setSellerItem(odItem.getSellerItem());
            orderItem1.setOrders(odItem.getOrders());
            orderItem1.setQuantity(odItem.getQuantity());
            /* orderItem1.setPrice(odItem.getPrice());*/
            orderItem1.setUnits(odItem.getUnits());
            orderItem1.setDeliveryDate(new Date());
            orderItem1.setTimingName(odItem.getTimingName());
            orderItem1.setTimings(odItem.getTimings());
            orderItem1.setAvailableTime(odItem.getAvailableTime());
            orderItem1.setDeliveryTime(odItem.getDeliveryTime());
            orderItem1.setOrderItemStatus(odItem.getOrderItemStatus());
            orderItem1.setOrderItemCode(odItem.getOrderItemCode());
            orderItem1.setOrderItemCount(odItem.getOrderItemCount());
            orderItem1.setCreatedDate(new Date());
            orderItem1.setOrders(odItem.getOrders());
            orderItem1.setSubOrder(odItem.getSubOrder());
            addOrderItem.add(orderItem1);
            orderItem1 = orderItemRepository.save(orderItem1);
        }
        orders.setOrderItems(addOrderItem);
        return orders;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderService#create(com.meat.domain.Order)
     */
    @Override
    @Transactional
    public Orders create(final Orders orders) {
        Orders ordrs = ordersRepository.save(orders);
        if (ordrs.getId() != null) {
            if (orders.getSubOrders() != null) {
                Set<SubOrder> subOrders = new HashSet<SubOrder>();
                for (SubOrder sOrder : orders.getSubOrders()) {
                    SubOrder subOrder = sOrder;
                    subOrder.setOrders(ordrs);
                    subOrder.setUsers(sOrder.getUsers());
                    subOrders.add(subOrder);
                    subOrder = subOrderService.create(subOrder);
                }
                orders.setSubOrders(subOrders);
            }
        }
        return ordrs;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderService#deleteOrder(java.lang.String)
     */
    @Override
    public void deleteOrders(final String ordersId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderService#getAll()
     */
    @Override
    public List<Orders> getAll() {
        List<Orders> orders = new ArrayList<Orders>();
        orders = (List<Orders>) ordersRepository.findAll();
        return orders;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrdersService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return ordersRepository.getMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrdersService#getOrder(java.lang.String)
     */
    @Override
    public Orders getOrder(final String orderId) {
        Orders order = ordersRepository.findOne(orderId);
        Orders o = new Orders();
        o.setAmount(order.getAmount());
        o.setComments(order.getComments());
        o.setDiscount(order.getDiscount());
        o.setId(order.getId());
        o.setName(order.getName());
        o.setOrderCode(order.getOrderCode());
        o.setOrderCreatedDate(order.getOrderCreatedDate());
        o.setOrderCreatedTime(order.getOrderCreatedTime());
        o.setOrderDeliveryOptionses(order.getOrderDeliveryOptionses());
        o.setOrderDetails(order.getOrderDetails());
        //o.setOrderItems(order.set);
        o.setStatus(order.getStatus());
        o.setSubOrders(order.getSubOrders());
        o.setUsers(order.getUsers());

        return o;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderService#getOrder(java.lang.String)
     */
    @Override
    public Orders getOrders(final String ordersId) {
        Orders orders = new Orders();
        orders = ordersRepository.findOne(ordersId);
        return orders;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrdersService#getOrdersByThymeleafUser(java.lang.String)
     */
    @Override
    public List<Orders> getOrdersByThymeleafUser(final String userId) {
        // TODO Auto-generated method stub
        return ordersRepository.findOrdersByThymeleafUser(userId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderService#updateOrder(com.meat.domain.Order)
     */
    /**
     * {@inheritDoc}
     *
     * @see com.hungry.service.IOrderService#updateOrder(com.hungry.domain.Orders)
     */
    @Override
    public Orders updateOrders(final Orders orders) {
        // TODO Auto-generated method stub

        Orders os = ordersRepository.save(orders);
        if (os.getStatus().equals("CANCELLED")) {
            for (SubOrder so : os.getSubOrders()) {
                so.setSubOrderStatus("CANCELLED");
                SubOrder subOrder = subOrderRepository.save(so);
                if (subOrder.getId() != null) {

                    Set<SubOrderStatusCode> subOrderStatusCodes = new HashSet<SubOrderStatusCode>();
                    SubOrderStatusCode subosc = new SubOrderStatusCode();
                    subosc.setSubOrderStatusName(subOrder.getSubOrderStatus());
                    subosc.setSubOrderStatusDate(new Date());
                    subosc.setSubOrderStatusDescription(orders.getComments());
                    subosc.setSubOrder(subOrder);
                    subOrderStatusCodes.add(subosc);

                    subosc = subOrderStatusCodeService.create(subosc);
                    //sOrder.setSubOrderStatusCodes(subOrderStatusCodes);

                }
                for (OrderItem oi : so.getOrderItems()) {
                    oi.setOrderItemStatus("CANCELLED");
                    orderItemRepository.save(oi);
                }
            }
        }
        return os;
    }

}