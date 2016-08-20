/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchZoneRepository;
import com.meat.dao.ZoneRepository;
import com.meat.domain.SellerBranchZone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dilli
 *
 */
@Component
public class SellerBranchZoneService implements ISellerBranchZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private SellerBranchZoneRepository sellerBranchZoneRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchZoneService#create(com.meat.domain.SellerBranchZone)
     */
    @Override
    @Transactional
    public SellerBranchZone create(final SellerBranchZone sellerBranchZone) {
        // TODO Auto-generated method stub
        return sellerBranchZoneRepository.save(sellerBranchZone);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchZoneService#deleteSellerBranchZone(java.lang.String)
     */
    @Override
    public void deleteSellerBranchZone(final String sellerBranchZoneId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SellerBranchZone> getAll() {
        List<SellerBranchZone> sellerbZone = new ArrayList<SellerBranchZone>();
        sellerbZone = (List<SellerBranchZone>) sellerBranchZoneRepository.findAll();
        return sellerbZone;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchZoneService#getSellerBranchZone(java.lang.String)
     */
    @Override
    public SellerBranchZone getSellerBranchZone(final String sellerBranchZoneId) {
        // TODO Auto-generated method stub
        return sellerBranchZoneRepository.findOne(sellerBranchZoneId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchZoneService#updateSellerBranchZone(com.meat.domain.SellerBranchZone)
     */
    @Override
    public SellerBranchZone updateSellerBranchZone(final SellerBranchZone sellerBranchZone) {
        // TODO Auto-generated method stub
        return sellerBranchZoneRepository.save(sellerBranchZone);
    }

}
