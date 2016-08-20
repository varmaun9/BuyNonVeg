/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.*;
import com.meat.model.OrderItemModel;
import com.meat.model.SubOrderModel;
import com.meat.service.IOrderItemService;
import com.meat.service.ISubOrderService;
import com.meat.service.ISubOrderStatusCodeService;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi1
 *
 */

@Service
public class SubOrderBusinessDelegate implements IBusinessDelegate<SubOrderModel, SubOrderContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private ISubOrderStatusCodeService subOrderStatusCodeService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubOrderModel create(final SubOrderModel model) {
        SubOrder subOrder = new SubOrder();
        subOrder.setId(model.getId());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        subOrder.setSellerBranch(sellerBranch);
        Timings timings = new Timings();
        timings.setId(model.getTimingsId());
        subOrder.setTimings(timings);
        Orders orders = new Orders();
        orders.setId(model.getSellerBranchId());
        subOrder.setOrders(orders);
        // subOrder.setSubOrderDeliveryDate(model.getSubOrderDeliveryDate());
        subOrder.setSubOrderDeliveryTime(model.getSubOrderDeliveryTime());
        subOrder.setSubOrderStatus(model.getSubOrderStatus());

        subOrder.setCreatedDate(new Date());
        Integer i = subOrderService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            subOrder.setSubOrderCount(bi);
        }
        else {
            long bi = (i + 1);
            subOrder.setSubOrderCount(bi);
        }
        Integer ca = i + 1;
        String m = DBSequences.SUBORDER.getSequenceName();
        String mc = m.concat(ca.toString());
        subOrder.setSubOrderCode(mc);

        String value = model.getSubOrderTotalPrice();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            subOrder.setSubOrderTotalPrice(b);
        }
        subOrder.setTaxValue(Integer.parseInt(model.getTaxValue()));
        subOrder.setDiscount(new BigDecimal(model.getDiscount()));
        subOrder = subOrderService.create(subOrder);
        model.setId(subOrder.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubOrderContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubOrderModel edit(final IKeyBuilder<String> keyBuilder, final SubOrderModel model) {
        SubOrder subOrder = subOrderService.getSubOrder(keyBuilder.build().toString());
        subOrder.setId(model.getId());
        if (model.getSubOrderStatus() != null) {
            subOrder.setSubOrderStatus(model.getSubOrderStatus());
        }
        if (model.getOrdersId() != null) {
            Orders o = new Orders();
            o.setId(model.getOrdersId());
            subOrder.setOrders(o);
        }
        if (model.getSubOrderStatus().equals("SHIPPED")) {
            if (model.getDeliveryContactId() != null) {
                SellerUser deliveryContact = new SellerUser();
                deliveryContact.setId(model.getDeliveryContactId());
                subOrder.setDeliveryUser(deliveryContact);
            }
            else {
                model.setSubOrderStatus("InCorrect::Assign a Delivery Boy");
                return model;
            }
        }

        /*  subOrder.setModifiedDate(new Date());
          Orders orders = new Orders();
          orders.setId(model.getOrderId());
          subOrder.setOrders(orders);
          subOrder.setDiscount(Integer.parseInt(model.getDiscount()));
          subOrder.setSubOrderStatus(model.getSubOrderStatus());
          RestaurantBranch resB = new RestaurantBranch();
          resB.setId(model.getRestaurantBranchId());
          subOrder.setRestaurantBranch(resB);
          subOrder.setSubOrderTotalPrice(new BigDecimal(model.getSubOrderTotalPrice()));
          subOrder.setTaxValue(Integer.parseInt(model.getTaxValue()));
          TimingsInterval timingsInterval = new TimingsInterval();
          timingsInterval.setId(model.getTimingsIntervalId());
          subOrder.setTimingsInterval(timingsInterval);
          TimingDetails td = new TimingDetails();
          td.setId(model.getTimingDetailsId());
          subOrder.setTimingDetails(td);*/
        if (model.getOrderItemModels() != null) {
            Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
            for (OrderItemModel oim : model.getOrderItemModels()) {
                OrderItem oi = null;
                if (oim.getId() != null) {
                    oi = orderItemService.getOrderItem(oim.getId());
                    if (oim.getOrderItemStatus() != null) {
                        oi.setOrderItemStatus(oim.getOrderItemStatus());
                    }
                    orderItemService.updateOrderItem(oi);

                }
                else {

                    String oldOrderItemId = "";
                    for (OrderItemModel oim1 : model.getOrderItemModels()) {
                        if (oim1.getId() != null) {
                            oldOrderItemId = oim1.getId();

                        }

                    }
                    OrderItem oiD = orderItemService.getOrderItem(oldOrderItemId);
                    OrderItem oiDI = new OrderItem();

                    if (oiD.getSellerItem() != null) {
                        SellerItem si = new SellerItem();
                        si.setId(oim.getSellerItemId());
                        oiDI.setSellerItem(si);
                    }

                    oiDI.setUnits(Float.parseFloat(oim.getUnits()));
                    oiDI.setOrderItemStatus("NEWLYPLACED");
                    oiDI.setCreatedDate(new Date());
                    if (oiD.getTimings() != null) {
                        oiDI.setTimings(oiD.getTimings());
                    }

                    /*  oiDI.setPrice(oiD.getPrice());
                    */
                    if (oim.getCutType() != null) {
                        oiDI.setCutType(oim.getCutType());
                    }
                    else {
                        oiDI.setCutType(oiD.getCutType());
                    }
                    oiDI.setDeliveryDate(oiD.getDeliveryDate());
                    oiDI.setDeliveryTime(oiD.getDeliveryTime());
                    oiDI.setDiscount(oiD.getDiscount());
                    oiDI.setTaxValue(oiD.getTaxValue());
                    oiDI.setOrders(oiD.getOrders());
                    oiDI.setSubOrder(oiD.getSubOrder());
                    oiDI.setQuantity(oiD.getQuantity());
                    oiDI.setDeliveryTime(oiD.getDeliveryTime());

                    oiDI.setOrderItemTotalPrice(oiD.getOrderItemTotalPrice());

                    /* oi.setOrderItemTotalPrice(oim.getOrderItemTotalPrice());
                     orI.setOrders(oit.getOrders());*/

                    Integer oic = orderItemService.getMaxCode();
                    if (oic == null || oic == 0) {
                        oic = 9999;
                        long bi = (oic + 1);
                        oiDI.setOrderItemCount(bi);
                    }
                    Integer oia = oic + 1;

                    String m2 = DBSequences.ORDERITEM.getSequenceName();
                    String mc2 = m2.concat(oia.toString());
                    oiDI.setOrderItemCode(mc2);

                    oiDI = orderItemService.create(oiDI);

                }

            }
        }

        subOrder = subOrderService.updateSubOrder(subOrder);
        if (subOrder.getId() != null) {
            Set<SubOrderStatusCode> subOrderStatusCodes = new HashSet<SubOrderStatusCode>();
            SubOrderStatusCode subosc = new SubOrderStatusCode();
            subosc.setSubOrderStatusName(subOrder.getSubOrderStatus());
            subosc.setSubOrderStatusDate(new Date());
            subosc.setSubOrderStatusDescription("SubOrderPlaced Status");
            subosc.setSubOrder(subOrder);
            subOrderStatusCodes.add(subosc);

            subosc = subOrderStatusCodeService.create(subosc);
            //sOrder.setSubOrderStatusCodes(subOrderStatusCodes);
        }
        model.setSubOrderStatus(subOrder.getSubOrderStatus());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SubOrderModel getByKey(final IKeyBuilder<String> keyBuilder, final SubOrderContext context) {
        SubOrder subOrder = subOrderService.getSubOrder(keyBuilder.build().toString());
        SubOrderModel subOrderModel = conversionService.convert(subOrder, SubOrderModel.class);
        return subOrderModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SubOrderModel> getCollection(final SubOrderContext context) {
        List<SubOrder> subOrders = new ArrayList<SubOrder>();

        if (context.getAll() != null) {
            subOrders = subOrderService.getAll();
        }

        if (context.getSellerBranchId() != null) {
            subOrders = subOrderService.getSubOrderBySellerBranchId(context.getSellerBranchId());
        }
        if (context.getSubOrderBranchDateStatus() != null) {
            subOrders = subOrderService.getSubOrderByBranchStatusDate(context.getSellerBranchId(), context.getDate(), context.getStatus());
        }
        List<SubOrderModel> subOrdersModels = (List<SubOrderModel>) conversionService.convert(subOrders,
                TypeDescriptor.forObject(subOrders), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SubOrderModel.class)));

        return subOrdersModels;
    }

}
