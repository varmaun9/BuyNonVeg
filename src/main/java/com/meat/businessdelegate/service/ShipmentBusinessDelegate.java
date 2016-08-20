/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Orders;
import com.meat.domain.Shipment;
import com.meat.model.ShipmentModel;
import com.meat.service.IShipmentService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ShipmentBusinessDelegate implements IBusinessDelegate<ShipmentModel, ShipmentContext, IKeyBuilder<String>, String> {

    @Autowired
    private IShipmentService shipmentService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ShipmentModel create(final ShipmentModel model) {
        Shipment shipment = new Shipment();
        shipment.setId(model.getId());
        Orders orders = new Orders();
        orders.setId(model.getOrderId());
        shipment.setOrders(orders);
        shipment.setShipmentTrackingNumber(model.getShipmentTrackingNumber());
        shipment.setShipmentDetails(model.getShipmentDetails());
        shipment.setShipmentDate(new Date());
        /*Invoice invoice=new Invoice();
        invoice.setId(model.getInvoiceId());
        shipment.setInvoice(invoice);*/
        shipment = shipmentService.create(shipment);
        model.setId(shipment.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ShipmentContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ShipmentModel edit(final IKeyBuilder<String> keyBuilder, final ShipmentModel model) {
        Shipment shipment = new Shipment();
        shipment.setId(model.getId());
        Orders orders = new Orders();
        orders.setId(model.getOrderId());
        shipment.setOrders(orders);
        shipment.setShipmentTrackingNumber(model.getShipmentTrackingNumber());
        shipment.setShipmentDetails(model.getShipmentDetails());
        shipment.setShipmentDate(new Date());
        /*Invoice invoice=new Invoice();
        invoice.setId(model.getInvoiceId());
        shipment.setInvoice(invoice);*/
        shipment = shipmentService.updateShipment(shipment);
        model.setId(shipment.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ShipmentModel getByKey(final IKeyBuilder<String> keyBuilder, final ShipmentContext context) {
        Shipment shipment = shipmentService.getShipment(keyBuilder.build().toString());
        ShipmentModel shipmentModel = conversionService.convert(shipment, ShipmentModel.class);
        return shipmentModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ShipmentModel> getCollection(final ShipmentContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
