/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderStatusCodesRepository;
import com.meat.domain.OrderStatusCodes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class OrderStatusCodesService implements IOrderStatusCodesService {
    @Autowired
    private OrderStatusCodesRepository orderStatusCodesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderStatusCodesService#create(com.nonveg.domain.OrderStatusCodes)
     */
    @Override
    public OrderStatusCodes create(final OrderStatusCodes orderStatusCodes) {
        // TODO Auto-generated method stub
        return orderStatusCodesRepository.save(orderStatusCodes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderStatusCodesService#deleteOrderStatusCodes(java.lang.String)
     */
    @Override
    public void deleteOrderStatusCodes(final String orderStatusCodesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderStatusCodesService#getAll()
     */
    @Override
    public List<OrderStatusCodes> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderStatusCodesService#getOrderStatusCodes(java.lang.String)
     */
    @Override
    public OrderStatusCodes getOrderStatusCodes(final String orderStatusCodesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderStatusCodesService#updateOrderStatusCodes(com.nonveg.domain.OrderStatusCodes)
     */
    @Override
    public OrderStatusCodes updateOrderStatusCodes(final OrderStatusCodes orderStatusCodes) {
        // TODO Auto-generated method stub
        return orderStatusCodesRepository.save(orderStatusCodes);
    }

}
