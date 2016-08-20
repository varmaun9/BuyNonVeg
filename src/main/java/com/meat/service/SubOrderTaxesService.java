/**
 *
 */
package com.meat.service;

import com.meat.dao.SubOrderTaxesRepository;
import com.meat.domain.SubOrderTaxes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class SubOrderTaxesService implements ISubOrderTaxesService {

    @Autowired
    private SubOrderTaxesRepository subOrderTaxesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderTaxesService#create(com.meat.domain.SubOrderTaxes)
     */
    @Override
    public SubOrderTaxes create(final SubOrderTaxes subOrderTaxes) {
        // TODO Auto-generated method stub
        return subOrderTaxesRepository.save(subOrderTaxes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderTaxesService#deleteSubOrderTaxes(java.lang.String)
     */
    @Override
    public void deleteSubOrderTaxes(final String subOrderTaxesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderTaxesService#getAll()
     */
    @Override
    public List<SubOrderTaxes> getAll() {
        List<SubOrderTaxes> subOrderTaxes = new ArrayList<SubOrderTaxes>();
        subOrderTaxes = (List<SubOrderTaxes>) subOrderTaxesRepository.findAll();
        return subOrderTaxes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderTaxesService#getSubOrderTaxes(java.lang.String)
     */
    @Override
    public SubOrderTaxes getSubOrderTaxes(final String subOrderTaxesId) {
        SubOrderTaxes subOrderTaxes = new SubOrderTaxes();
        subOrderTaxes = subOrderTaxesRepository.findOne(subOrderTaxesId);
        return subOrderTaxes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderTaxesService#updateSubOrderTaxes(com.meat.domain.Shipment)
     */
    @Override
    public SubOrderTaxes updateSubOrderTaxes(final SubOrderTaxes subOrderTaxes) {
        // TODO Auto-generated method stub
        return subOrderTaxesRepository.save(subOrderTaxes);
    }

}
