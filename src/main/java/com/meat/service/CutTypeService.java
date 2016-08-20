package com.meat.service;

import com.meat.dao.CategoryRepository;
import com.meat.dao.CutTypeRepository;
import com.meat.domain.CutType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CutTypeService implements ICutTypeService {

    @Autowired
    private CutTypeRepository cutTyperepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public CutType create(final CutType cutType) {

        return cutTyperepository.save(cutType);
    }

    @Override
    public void deleteCutType(final String cutType) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<CutType> getAll() {
        // TODO Auto-generated method stub
        return (List<CutType>) cutTyperepository.findAll();
    }

    @Override
    public CutType getCutType(final String cutTypeId) {
        // TODO Auto-generated method stub
        return cutTyperepository.findOne(cutTypeId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICutTypeService#getCutTypeByCategory(java.lang.String)
     */
    @Override
    public List<CutType> getCutTypeByCategory(final String categoryId) {
        // TODO Auto-generated method stub
        return cutTyperepository.findByCategory(categoryId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICutTypeService#getCutTypeByItem(java.lang.String)
     */
    @Override
    public List<CutType> getCutTypeByItem(final String itemId) {
        // TODO Auto-generated method stub
        return cutTyperepository.findByItem(itemId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICutTypeService#getCutTypeBySellerItem(java.lang.String)
     */
    @Override
    public List<CutType> getCutTypeBySellerItem(final String sellerItemId) {
        // TODO Auto-generated method stub
        return cutTyperepository.findBySellerItemId(sellerItemId);
    }

    @Override
    public List<CutType> getCutTypeOnly() {
        // TODO Auto-generated method stub
        List<CutType> cutTypes = (List<CutType>) cutTyperepository.findAll();
        List<CutType> cutTyps = new ArrayList<CutType>();
        for (CutType cutType : cutTypes) {
            CutType cutTyp = cutType;
            cutTyps.add(cutTyp);
        }
        return cutTyps;
    }

    @Override
    public CutType updateCutType(final CutType cutType) {
        // TODO Auto-generated method stub
        return cutTyperepository.save(cutType);
    }

}
