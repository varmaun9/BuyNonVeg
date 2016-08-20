/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderItem;
import com.meat.model.OrderItemModel;
import com.meat.model.OrderItemStatusCodesModel;
import com.meat.model.ShipmentItemsModel;
import com.meat.util.CollectionTypeDescriptor;

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

@Component("orderItemToOrderItemModelConverter")
public class OrderItemToOrderItemModelConverter implements Converter<OrderItem, OrderItemModel> {

    private static final Logger LOGGER = Logger.getLogger(OrderItemToOrderItemModelConverter.class);
    @Autowired
    private ObjectFactory<OrderItemModel> orderItemModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OrderItemModel convert(final OrderItem source) {
        // TODO Auto-generated method stub
        OrderItemModel orderItemModel = orderItemModelFactory.getObject();
        BeanUtils.copyProperties(source, orderItemModel);
        if (source.getSellerItem() != null) {
            orderItemModel.setSellerItemId(source.getSellerItem().getId());
            orderItemModel.setSellerItemName(source.getSellerItem().getSellerItemName());
        }
        if (source.getDeliveryDate() != null) {
            orderItemModel.setDeliveryDate(source.getDeliveryDate().toString());
        }

        orderItemModel.setMarketPrice(source.getMarketPrice().toString());
        orderItemModel.setFinalUnitPrice(source.getFinalUnitPrice().toString());
        orderItemModel.setSellerPrice(source.getSellerPrice().toString());
        orderItemModel.setSellerDiscounts(source.getSellerDiscounts().toString());
        orderItemModel.setOtherDiscounts(source.getOtherDiscounts().toString());
        orderItemModel.setUnits(source.getUnits().toString());

        orderItemModel.setQuantity(source.getQuantity());

        orderItemModel.setOrderItemTotalPrice(source.getOrderItemTotalPrice().toString());
        if (source.getTimings() != null) {
            orderItemModel.setTimingsId(source.getTimings().getId());
            orderItemModel.setTimingName(source.getTimings().getTimingName());
        }
        orderItemModel.setMeasurementUnit(source.getSellerItem().getMeasurementUnit());

        if (CollectionUtils.isNotEmpty(source.getOrderItemStatusCodeses())) {
            List<OrderItemStatusCodesModel> converted = (List<OrderItemStatusCodesModel>) conversionService.convert(
                    source.getOrderItemStatusCodeses(), TypeDescriptor.forObject(source.getOrderItemStatusCodeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemStatusCodesModel.class));
            orderItemModel.getOrderItemStatusCodesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getShipmentItemses())) {
            List<ShipmentItemsModel> converted = (List<ShipmentItemsModel>) conversionService.convert(source.getShipmentItemses(),
                    TypeDescriptor.forObject(source.getShipmentItemses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItemsModel.class));
            orderItemModel.getShipmentItemsesModels().addAll(converted);
        }
        return orderItemModel;

    }

    @Autowired
    public void setOrderItemFactory(final ObjectFactory<OrderItemModel> orderItemModelFactory) {
        this.orderItemModelFactory = orderItemModelFactory;
    }

}
