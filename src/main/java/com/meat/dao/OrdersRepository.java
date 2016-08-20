/**
 *
 */
package com.meat.dao;

import com.meat.domain.Orders;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Serializable> {

    /**
     * @param userId
     * @return
     */
    @Query("select distinct o from Orders o where o.users.id=?1")
    List<Orders> findOrdersByThymeleafUser(String userId);

    /**
     * @return
     */
    @Query("select MAX(orderCount) from Orders o")
    Integer getMaxCode();

}
