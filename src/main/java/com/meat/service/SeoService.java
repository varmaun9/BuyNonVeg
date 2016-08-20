package com.meat.service;

import com.meat.dao.SeoRepository;
import com.meat.domain.Seo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeoService implements ISeoService {
    @Autowired
    private SeoRepository seoRepository;

    @Override
    @Transactional
    public Seo create(final Seo seo) {
        // TODO Auto-generated method stub
        return seoRepository.save(seo);
    }

    @Override
    public void deleteSeo(final String seoId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Seo> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Seo getSeo(final String seoId) {
        // TODO Auto-generated method stub
        return seoRepository.findOne(seoId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ISeoService#updateSeo(com.ruhungry.domain.Seo)
     */
    @Override
    public Seo updateSeo(final Seo seo) {
        // TODO Auto-generated method stub
        return seoRepository.save(seo);
    }

}
