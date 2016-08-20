/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Orders;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.model.OrderItemModel;
import com.meat.model.OrdersModel;
import com.meat.model.ShipmentModel;
import com.meat.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */

@Component("ordersToOrdersModelConverter")
public class OrdersToOrdersModelConverter implements Converter<Orders, OrdersModel> {

    @Autowired
    private ObjectFactory<OrdersModel> ordersModelFactory;
    private static final Logger LOGGER = Logger.getLogger(OrdersToOrdersModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OrdersModel convert(final Orders source) {
        // TODO Auto-generated method stub
        OrdersModel ordersModel = ordersModelFactory.getObject();

        BeanUtils.copyProperties(source, ordersModel);
        ordersModel.setUsersId(source.getUsers().getId());
        ordersModel.setName(source.getUsers().getUserName());

        String ds1 = null;
        if (source.getOrderCreatedDate() != null) {
            ds1 = source.getOrderCreatedDate().toString();
        }

        String ds3 = null;
        if (source.getOrderModifiedDate() != null) {
            ds3 = source.getOrderModifiedDate().toString();
        }

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                ordersModel.setOrderCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (ds3 != null) {
            try {
                String ds4 = sdf2.format(sdf1.parse(ds3));
                ordersModel.setOrderModifiedDate(ds4);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionses())) {
            List<OrderDeliveryOptionsModel> converted = (List<OrderDeliveryOptionsModel>) conversionService.convert(
                    source.getOrderDeliveryOptionses(), TypeDescriptor.forObject(source.getOrderDeliveryOptionses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsModel.class));
            ordersModel.getOrderDeliveryOptionsesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderStatusCodeses())) {
            List<OrderDeliveryOptionsModel> converted = (List<OrderDeliveryOptionsModel>) conversionService.convert(
                    source.getOrderStatusCodeses(), TypeDescriptor.forObject(source.getOrderStatusCodeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsModel.class));
            ordersModel.getOrderDeliveryOptionsesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderItems())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItems(),
                    TypeDescriptor.forObject(source.getOrderItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            ordersModel.getOrderItemsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipments())) {
            List<ShipmentModel> converted = (List<ShipmentModel>) conversionService.convert(source.getShipments(),
                    TypeDescriptor.forObject(source.getShipments()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentModel.class));
            ordersModel.getShipmentsModels().addAll(converted);
        }

        return ordersModel;

    }

    @Autowired
    public void setOrdersFactory(final ObjectFactory<OrdersModel> ordersModelFactory) {
        this.ordersModelFactory = ordersModelFactory;
    }

}
