/**
 *
 */
package com.meat.service;

import com.meat.domain.OrderItemStatusCodes;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IOrderItemStatusCodesService {

    OrderItemStatusCodes create(OrderItemStatusCodes orderItemStatusCodes);

    void deleteOrderItemStatusCodes(String orderItemStatusCodesId);

    List<OrderItemStatusCodes> getAll();

    OrderItemStatusCodes getOrderItemStatusCodes(String orderItemStatusCodesId);

    OrderItemStatusCodes updateOrderItemStatusCodes(OrderItemStatusCodes orderItemStatusCodes);

}
