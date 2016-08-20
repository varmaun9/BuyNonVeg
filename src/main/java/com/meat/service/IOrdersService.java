/**
 *
 */
package com.meat.service;

import com.meat.domain.OrderItem;
import com.meat.domain.Orders;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IOrdersService {

    /**
     * @param orders
     * @param orderItem
     * @return
     */
    Orders addOrderItem(Orders orders, List<OrderItem> orderItem);

    Orders create(Orders orders);

    void deleteOrders(String ordersId);

    List<Orders> getAll();

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param id
     * @return
     */
    Orders getOrder(String id);

    Orders getOrders(String ordersId);

    /**
     * @param userId
     * @return
     */
    List<Orders> getOrdersByThymeleafUser(String userId);

    Orders updateOrders(Orders orders);

}
