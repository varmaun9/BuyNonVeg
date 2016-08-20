/**
 *
 */
package com.meat.dao;

import com.meat.domain.Shipment;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface ShipmentRepository extends PagingAndSortingRepository<Shipment, Serializable> {

}
