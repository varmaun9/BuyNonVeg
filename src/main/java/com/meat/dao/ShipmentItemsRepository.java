/**
 *
 */
package com.meat.dao;

import com.meat.domain.ShipmentItems;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface ShipmentItemsRepository extends PagingAndSortingRepository<ShipmentItems, Serializable> {

}
