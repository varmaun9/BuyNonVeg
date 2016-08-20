/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchTimingsRepository;
import com.meat.domain.SellerBranchTimings;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class SellerBranchTimingsService implements ISellerBranchTimingsService {
    @Autowired
    private SellerBranchTimingsRepository sellerBranchTimingsRepository;

    /**
     * @param id
     * @return
     */
    private boolean checkTimingsExists(final String id) {
        // TODO Auto-generated method stub
        return sellerBranchTimingsRepository.findOne(id) != null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#create(com.meat.domain.SellerBranchTimings)
     */
    @Override
    public SellerBranchTimings create(final SellerBranchTimings sellerBranchTimings) {
        // TODO Auto-generated method stub
        if (checkTimingsExists(sellerBranchTimings.getTimings().getId())) {
            sellerBranchTimings.setStatus("DuplicateTimings");
        }
        List<SellerBranchTimings> sellrBranchTimings = (List<SellerBranchTimings>) sellerBranchTimingsRepository.findAll();
        for (SellerBranchTimings slrBranchTiming : sellrBranchTimings) {
            if (slrBranchTiming.getTimings().equals(sellerBranchTimings.getTimings().getId())) {
                sellerBranchTimings.setStatus("DuplicateTimings");
            }
        }
        return sellerBranchTimingsRepository.save(sellerBranchTimings);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#deleteSellerBranchTimings(java.lang.String)
     */
    @Override
    public void deleteSellerBranchTimings(final String sellerBranchTimingsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#getAll()
     */
    @Override
    public List<SellerBranchTimings> getAll() {
        List<SellerBranchTimings> sellerBranchTimings = new ArrayList<SellerBranchTimings>();
        sellerBranchTimings = (List<SellerBranchTimings>) sellerBranchTimingsRepository.findAll();
        return sellerBranchTimings;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#getSellerBranchTimings(java.lang.String)
     */
    @Override
    public SellerBranchTimings getSellerBranchTimings(final String sellerBranchTimingsId) {

        return sellerBranchTimingsRepository.findOne(sellerBranchTimingsId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#getSellerBranchTimingsBySellerBranch(java.lang.String)
     */
    @Override
    public List<SellerBranchTimings> getSellerBranchTimingsBySellerBranch(final String sellerBranchId) {
        List<SellerBranchTimings> sellerBranchTimingses = sellerBranchTimingsRepository
                .findSellerBranchTimingsBySellerBranch(sellerBranchId);
        return sellerBranchTimingses;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchTimingsService#updateSellerBranchTimings(com.meat.domain.SellerBranchTimings)
     */
    @Override
    public SellerBranchTimings updateSellerBranchTimings(final SellerBranchTimings sellerBranchTimings) {
        // TODO Auto-generated method stub
        return sellerBranchTimingsRepository.save(sellerBranchTimings);
    }

}
