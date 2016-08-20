/**
 *
 */
package com.meat.service;

import com.meat.domain.OrderItem;
import com.meat.domain.SubOrder;

import java.util.List;
import java.util.Set;

/**
 * @author arthvedi1
 *
 */
public interface IOrderItemService {

    OrderItem create(OrderItem orderItem);

    /**
     * @param sOrder
     * @param orderItems
     * @return
     */
    List<OrderItem> createOrderItems(SubOrder sOrder, Set<OrderItem> orderItems);

    void deleteOrderItem(String orderItemId);

    List<OrderItem> getAll();

    /**
     * @return
     */
    Integer getMaxCode();

    OrderItem getOrderItem(String orderItemId);

    OrderItem updateOrderItem(OrderItem orderItem);
}
