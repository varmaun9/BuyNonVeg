/**
 *
 */
package com.meat.dao;

import com.meat.domain.Criteria;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi1
 *
 */
public interface CriteriaRepository extends PagingAndSortingRepository<Criteria, Serializable> {

}
