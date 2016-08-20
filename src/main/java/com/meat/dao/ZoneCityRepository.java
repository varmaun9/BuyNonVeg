/**
 *
 */
package com.meat.dao;

import com.meat.domain.ZoneCity;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface ZoneCityRepository extends PagingAndSortingRepository<ZoneCity, Serializable> {

}
