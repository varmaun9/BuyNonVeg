/**
 *
 */
package com.meat.dao;

import com.meat.domain.Timings;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface TimingsRepository extends PagingAndSortingRepository<Timings, Serializable> {

}
