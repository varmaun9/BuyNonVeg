/**
 *
 */
package com.meat.service;


import com.meat.dao.ShipmentRepository;
import com.meat.domain.Shipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class ShipmentService implements IShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentService#create(com.meat.domain.Shipment)
     */
    @Override
    public Shipment create(Shipment shipment) {
        // TODO Auto-generated method stub
        return shipmentRepository.save(shipment);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentService#deleteShipment(java.lang.String)
     */
    @Override
    public void deleteShipment(String shipmentId) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentService#getAll()
     */
    @Override
    public List<Shipment> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentService#getShipment(java.lang.String)
     */
    @Override
    public Shipment getShipment(String shipmentId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentService#updateShipment(com.meat.domain.Shipment)
     */
    @Override
    public Shipment updateShipment(Shipment shipment) {
        // TODO Auto-generated method stub
        return shipmentRepository.save(shipment);
    }

    
}
