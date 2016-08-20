/**
 *
 */
package com.meat.service;

import com.meat.domain.OrderStatusCodes;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IOrderStatusCodesService {

    OrderStatusCodes create(OrderStatusCodes orderStatusCodes);

    void deleteOrderStatusCodes(String orderStatusCodesId);

    List<OrderStatusCodes> getAll();

    OrderStatusCodes getOrderStatusCodes(String orderStatusCodesId);

    OrderStatusCodes updateOrderStatusCodes(OrderStatusCodes orderStatusCodes);

}
