/**
 *
 */
package com.meat.dao;

import com.meat.domain.OrderItem;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OrderItemRepository extends PagingAndSortingRepository<OrderItem, Serializable> {

    /**
     * @param id
     * @param string
     * @return
     */
    @Query("select oi from OrderItem oi where oi.subOrder.id=?1 and oi.orderItemStatus=?2")
    List<OrderItem> findOrderItemsBySubOrderAndStatus(String id, String string);

}
