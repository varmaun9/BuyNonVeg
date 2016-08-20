/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerItemCriteriaRepository;
import com.meat.domain.SellerItemCriteria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerItemCriteriaService implements ISellerItemCriteriaService {
    @Autowired
    private SellerItemCriteriaRepository sellerItemCriteriaRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemCriteriaService#create(com.meat.domain.SellerItemCriteria)
     */
    @Override
    public SellerItemCriteria create(final SellerItemCriteria sellerItemCriteria) {
        // TODO Auto-generated method stub
        return sellerItemCriteriaRepository.save(sellerItemCriteria);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemCriteriaService#deleteSellerItemCriteria(java.lang.String)
     */
    @Override
    public void deleteSellerItemCriteria(final String sellerItemCriteriaId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemCriteriaService#getAll()
     */
    @Override
    public List<SellerItemCriteria> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemCriteriaService#getSellerItemCriteria(java.lang.String)
     */
    @Override
    public SellerItemCriteria getSellerItemCriteria(final String sellerItemCriteriaId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemCriteriaService#updateSellerItemCriteria(com.meat.domain.SellerItemCriteria)
     */
    @Override
    public SellerItemCriteria updateSellerItemCriteria(final SellerItemCriteria sellerItemCriteria) {
        // TODO Auto-generated method stub
        return sellerItemCriteriaRepository.save(sellerItemCriteria);
    }

}
