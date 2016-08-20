/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.OrderItem;
import com.meat.domain.Shipment;
import com.meat.domain.ShipmentItems;
import com.meat.model.ShipmentItemsModel;
import com.meat.service.IShipmentItemsService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ShipmentItemsBusinessDelegate implements
IBusinessDelegate<ShipmentItemsModel, ShipmentItemsContext, IKeyBuilder<String>, String> {

    @Autowired
    private IShipmentItemsService shipmentItemsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ShipmentItemsModel create(final ShipmentItemsModel model) {
        ShipmentItems shipmentItems = new ShipmentItems();
        shipmentItems.setId(model.getId());
        Shipment shipment = new Shipment();
        shipment.setId(model.getShipmentId());
        shipmentItems.setShipment(shipment);
        OrderItem orderItem = new OrderItem();
        orderItem.setId(model.getOrderItemId());
        orderItem.setId(model.getId());
        shipmentItems.setOrderItem(orderItem);
        shipmentItems.setShipmentItemStatus(model.getShipmentItemStatus());
        shipmentItems = shipmentItemsService.create(shipmentItems);
        model.setId(shipmentItems.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ShipmentItemsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ShipmentItemsModel edit(final IKeyBuilder<String> keyBuilder, final ShipmentItemsModel model) {
        ShipmentItems shipmentItems = new ShipmentItems();
        shipmentItems.setId(model.getId());
        Shipment shipment = new Shipment();
        shipment.setId(model.getShipmentId());
        shipmentItems.setShipment(shipment);
        OrderItem orderItem = new OrderItem();
        orderItem.setId(model.getOrderItemId());
        orderItem.setId(model.getId());
        shipmentItems.setOrderItem(orderItem);
        shipmentItems.setShipmentItemStatus(model.getShipmentItemStatus());
        shipmentItems = shipmentItemsService.updateShipmentItems(shipmentItems);
        model.setId(shipmentItems.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ShipmentItemsModel getByKey(final IKeyBuilder<String> keyBuilder, final ShipmentItemsContext context) {
        ShipmentItems shipmentItems = shipmentItemsService.getShipmentItems(keyBuilder.build().toString());
        ShipmentItemsModel shipmentItemsModel = conversionService.convert(shipmentItems, ShipmentItemsModel.class);
        return shipmentItemsModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ShipmentItemsModel> getCollection(final ShipmentItemsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
