/**
 *
 */
package com.meat.dao;

import com.meat.domain.Seo;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface SeoRepository extends PagingAndSortingRepository<Seo, Serializable> {

}
