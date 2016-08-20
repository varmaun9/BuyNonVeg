/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderItemStatusCodesRepository;
import com.meat.domain.OrderItemStatusCodes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class OrderItemStatusCodesService implements IOrderItemStatusCodesService {
    @Autowired
    private OrderItemStatusCodesRepository orderItemStatusCodesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemStatusCodesService#create(com.nonveg.domain.OrderItemStatusCodes)
     */
    @Override
    public OrderItemStatusCodes create(final OrderItemStatusCodes orderItemStatusCodes) {
        // TODO Auto-generated method stub
        return orderItemStatusCodesRepository.save(orderItemStatusCodes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemStatusCodesService#deleteOrderItemStatusCodes(java.lang.String)
     */
    @Override
    public void deleteOrderItemStatusCodes(final String orderItemStatusCodesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemStatusCodesService#getAll()
     */
    @Override
    public List<OrderItemStatusCodes> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemStatusCodesService#getOrderItemStatusCodes(java.lang.String)
     */
    @Override
    public OrderItemStatusCodes getOrderItemStatusCodes(final String orderItemStatusCodesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemStatusCodesService#updateOrder(com.nonveg.domain.OrderItemStatusCodes)
     */
    @Override
    public OrderItemStatusCodes updateOrderItemStatusCodes(final OrderItemStatusCodes orderItemStatusCodes) {
        // TODO Auto-generated method stub
        return orderItemStatusCodesRepository.save(orderItemStatusCodes);
    }

}
