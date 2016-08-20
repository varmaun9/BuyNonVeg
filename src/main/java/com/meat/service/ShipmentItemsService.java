/**
 *
 */
package com.meat.service;


import com.meat.dao.ShipmentItemsRepository;
import com.meat.domain.ShipmentItems;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class ShipmentItemsService implements IShipmentItemsService {
    @Autowired
    private ShipmentItemsRepository shipmentItemsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentItemsService#create(com.meat.domain.ShipmentItems)
     */
    @Override
    public ShipmentItems create(ShipmentItems shipmentItems) {
        // TODO Auto-generated method stub
        return shipmentItemsRepository.save(shipmentItems);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentItemsService#deleteShipmentItems(java.lang.String)
     */
    @Override
    public void deleteShipmentItems(String shipmentItemsId) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentItemsService#getAll()
     */
    @Override
    public List<ShipmentItems> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentItemsService#getShipmentItems(java.lang.String)
     */
    @Override
    public ShipmentItems getShipmentItems(String shipmentItemsId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IShipmentItemsService#updateShipmentItems(com.meat.domain.ShipmentItems)
     */
    @Override
    public ShipmentItems updateShipmentItems(ShipmentItems shipmentItems) {
        // TODO Auto-generated method stub
        return shipmentItemsRepository.save(shipmentItems);
    }

   
}
