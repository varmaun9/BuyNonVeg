/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderDeliveryOptionsRepository;
import com.meat.domain.OrderDeliveryOptions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dilli
 *
 */
@Component
public class OrderDeliveryOptionsService implements IOrderDeliveryOptionsService {
    @Autowired
    private OrderDeliveryOptionsRepository orderDeliveryOptionsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderDeliveryOptionsService#create(com.nonveg.domain.OrderDeliveryOptions)
     */
    @Override
    @Transactional
    public OrderDeliveryOptions create(final OrderDeliveryOptions orderDeliveryOptions) {
        // TODO Auto-generated method stub
        return orderDeliveryOptionsRepository.save(orderDeliveryOptions);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderDeliveryOptionsService#deleteOrderDeliveryOptions(java.lang.String)
     */
    @Override
    public void deleteOrderDeliveryOptions(final String orderDeliveryOptionsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderDeliveryOptionsService#getAll()
     */
    @Override
    public List<OrderDeliveryOptions> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderDeliveryOptionsService#getOrderDeliveryOptions(java.lang.String)
     */
    @Override
    public OrderDeliveryOptions getOrderDeliveryOptions(final String orderDeliveryOptionsId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderDeliveryOptionsService#updateOrderDeliveryOptions(com.nonveg.domain.OrderDeliveryOptions)
     */
    @Override
    public OrderDeliveryOptions updateOrderDeliveryOptions(final OrderDeliveryOptions orderDeliveryOptions) {
        // TODO Auto-generated method stub
        return orderDeliveryOptionsRepository.save(orderDeliveryOptions);
    }

}
