/**
 *
 */
package com.meat.service;

import com.meat.domain.OrderDeliveryOptions;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IOrderDeliveryOptionsService {

    OrderDeliveryOptions create(OrderDeliveryOptions orderDeliveryOptions);

    void deleteOrderDeliveryOptions(String orderDeliveryOptionsId);

    List<OrderDeliveryOptions> getAll();

    OrderDeliveryOptions getOrderDeliveryOptions(String orderDeliveryOptionsId);

    OrderDeliveryOptions updateOrderDeliveryOptions(OrderDeliveryOptions orderDeliveryOptions);

}
