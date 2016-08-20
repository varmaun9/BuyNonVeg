/**
 *
 */
package com.meat.service;

import com.meat.domain.ShipmentItems;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IShipmentItemsService {

    ShipmentItems create(ShipmentItems shipmentItems);

    void deleteShipmentItems(String shipmentItemsId);

    List<ShipmentItems> getAll();

    ShipmentItems getShipmentItems(String shipmentItemsId);

    ShipmentItems updateShipmentItems(ShipmentItems shipmentItems);

}
