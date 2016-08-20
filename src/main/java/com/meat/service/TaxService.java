package com.meat.service;

import com.meat.dao.TaxRepository;
import com.meat.domain.Tax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxService implements ITaxService {
    @Autowired
    private TaxRepository taxRepository;

    @Override
    public Tax create(final Tax tax) {
        // TODO Auto-generated method stub
        return taxRepository.save(tax);
    }

    @Override
    public void deleteTax(final String taxId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Tax> getAll() {
        // TODO Auto-generated method stub
        return (List<Tax>) taxRepository.findAll();
    }

    @Override
    public Tax getTax(final String taxId) {
        // TODO Auto-generated method stub
        return taxRepository.findOne(taxId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ITaxService#updateTax(com.ruhungry.domain.Tax)
     */
    @Override
    public Tax updateTax(final Tax tax) {
        // TODO Auto-generated method stub
        return taxRepository.save(tax);
    }

}
