/**
 *
 */
package com.meat.service;

import com.meat.domain.Shipment;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IShipmentService {

    Shipment create(Shipment shipment);

    void deleteShipment(String shipmentId);

    List<Shipment> getAll();

    Shipment getShipment(String shipmentId);

    Shipment updateShipment(Shipment shipment);

}
