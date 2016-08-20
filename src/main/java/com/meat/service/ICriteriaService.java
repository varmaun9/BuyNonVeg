/**
 *
 */
package com.meat.service;

import com.meat.domain.Criteria;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ICriteriaService {

    Criteria create(Criteria criteria);

    void deleteCriteria(String criteriaId);

    List<Criteria> getAll();

    Criteria getCriteria(String criteriaId);

    /**
     * @return
     */
    List<Criteria> getCriteriaOnly();

    Criteria updateCriteria(Criteria criteria);

}
