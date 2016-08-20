/**
 *
 */
package com.meat.service;

import com.meat.dao.OrderItemRepository;
import com.meat.domain.OrderItem;
import com.meat.domain.SubOrder;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Venu
 *
 */
@Component
public class OrderItemService implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ISubOrderService subOrderService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemService#create(com.ruhungry.domain.OrderItem)
     */
    @Override
    @Transactional
    public OrderItem create(final OrderItem orderItem) {
        // TODO Auto-generated method stub
        return orderItemRepository.save(orderItem);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderItemService#createOrderItems(java.util.Set)
     */
    @Override
    public List<OrderItem> createOrderItems(final SubOrder sOrder, final Set<OrderItem> orderItems) {
        // TODO Auto-generated method stub

        return (List<OrderItem>) orderItemRepository.save(orderItems);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemService#deleteOrderItem(java.lang.String)
     */
    @Override
    public void deleteOrderItem(final String orderItemId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemService#getAll()
     */
    @Override
    public List<OrderItem> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOrderItemService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return (int) orderItemRepository.count();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemService#getOrderItem(java.lang.String)
     */
    @Override
    public OrderItem getOrderItem(final String orderItemId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IOrderItemService#updateOrderItem(com.ruhungry.domain.OrderItem)
     */
    @Override
    public OrderItem updateOrderItem(final OrderItem orderItem) {
        // TODO Auto-generated method stub
        //OrderItem oi=orderItemRepository.findOne(orderItem.getId());
        SubOrder so = subOrderService.getSubOrder(orderItem.getSubOrder().getId());
        if (so.getSubOrderStatus().equals("CANCELLED")) {
            List<OrderItem> ois = orderItemRepository.findOrderItemsBySubOrderAndStatus(so.getId(), "CANCELLED");
            if (ois != null) {
                if (so.getOrderItems().size() == ois.size()) {
                    so.setSubOrderStatus("CANCELLED");
                }
                else {
                    so.setSubOrderStatus("PARTIALLYCONFIRMED");
                }
                so.setSubOrderTotalPrice(so.getSubOrderTotalPrice().subtract(orderItem.getOrderItemTotalPrice()));
                subOrderService.updateSubOrder(so);
            }
        }

        OrderItem oi = orderItemRepository.save(orderItem);
        /*  //
          Orders o=orderRepository.getByOrder(oi.getOrders().getId());
          int soiq=oi.getUnits();
          double up= oi.getPrice().doubleValue()/soiq;
          double tp=up*orderItem.getUnits();
        
        BigDecimal bd= new BigDecimal(tp);
        o.setAmount(bd);
        o=orderRepository.save(o);*/
        return oi;
    }

}
