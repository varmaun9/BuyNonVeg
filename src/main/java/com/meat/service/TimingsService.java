/**
 *
 */
package com.meat.service;

import com.meat.dao.TimingsRepository;
import com.meat.domain.Timings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class TimingsService implements ITimingsService {
    @Autowired
    private TimingsRepository timingsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#addSellerBranchTmings(com.meat.domain.Timings, java.util.Set)
     */
    /* @Override
     public Timings addSellerBranchTmings(final Timings timings, final Set<SellerBranchTimings> sbTmings) {
         // TODO Auto-generated method stub
         return null;
     }*/

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#create(com.meat.domain.Timings)
     */
    @Override
    public Timings create(final Timings timings) {
        // TODO Auto-generated method stub
        return timingsRepository.save(timings);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#deleteCategoryAttributes(java.lang.String)
     */
    @Override
    public void deleteCategoryAttributes(final String timingsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#getAll()
     */
    @Override
    public List<Timings> getAll() {
        List<Timings> timings = new ArrayList<Timings>();
        timings = (List<Timings>) timingsRepository.findAll();
        return timings;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#getAllTimingsOnly()
     */
    @Override
    public List<Timings> getAllTimingsOnly() {
        List<Timings> timings = new ArrayList<Timings>();
        timings = (List<Timings>) timingsRepository.findAll();
        List<Timings> timngs = new ArrayList<Timings>();
        for (Timings tm : timings) {
            Timings t = new Timings();
            t.setId(tm.getId());
            t.setTimingName(tm.getTimingName());
            t.setStartTime(tm.getStartTime());
            t.setEndTime(tm.getEndTime());
            timngs.add(t);
        }
        return timngs;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#getTimings(java.lang.String)
     */
    @Override
    public Timings getTimings(final String timingsId) {

        return timingsRepository.findOne(timingsId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITimingsService#updateTimings(com.meat.domain.Timings)
     */
    @Override
    public Timings updateTimings(final Timings timings) {
        // TODO Auto-generated method stub
        return timingsRepository.save(timings);
    }

}
