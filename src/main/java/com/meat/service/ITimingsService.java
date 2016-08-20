/**
 *
 */
package com.meat.service;

import com.meat.domain.Timings;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface ITimingsService {

    /**
     * @param timings
     * @param sbTmings
     * @return
     */
    //Timings addSellerBranchTmings(Timings timings, Set<SellerBranchTimings> sbTmings);

    Timings create(Timings timings);

    void deleteCategoryAttributes(String timingsId);

    List<Timings> getAll();

    /**
     * @return
     */
    List<Timings> getAllTimingsOnly();

    Timings getTimings(String timingsId);

    Timings updateTimings(Timings timings);

}
