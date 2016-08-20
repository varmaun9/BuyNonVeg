/**
 *
 */
package com.meat.service;

import com.meat.dao.CriteriaRepository;
import com.meat.domain.Criteria;
import com.meat.domain.Seo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component
public class CriteriaService implements ICriteriaService {
    @Autowired
    private CriteriaRepository criteriaRepository;
    @Autowired
    private ISeoService seoService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#create(com.meat.domain.Criteria)
     */
    @Override
    public Criteria create(final Criteria criteria) {
        if (criteria.getSeo() != null) {
            Seo seo = new Seo();
            seo.setSeoTitle(criteria.getSeo().getSeoTitle());
            seo.setSeoKeywords(criteria.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(criteria.getSeo().getSeoMetaDescription());
            seo = seoService.create(seo);
            criteria.setSeo(seo);
        }
        return criteriaRepository.save(criteria);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#deleteCriteria(java.lang.String)
     */
    @Override
    public void deleteCriteria(final String criteriaId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#getAll()
     */
    @Override
    public List<Criteria> getAll() {
        List<Criteria> criteria = new ArrayList<Criteria>();
        criteria = (List<Criteria>) criteriaRepository.findAll();
        return criteria;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#getCriteria(java.lang.String)
     */
    @Override
    public Criteria getCriteria(final String criteriaId) {
        Criteria criteria = new Criteria();
        criteria = criteriaRepository.findOne(criteriaId);
        return criteria;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#getCriteriaOnly()
     */
    @Override
    public List<Criteria> getCriteriaOnly() {
        List<Criteria> criteria = new ArrayList<Criteria>();
        criteria = (List<Criteria>) criteriaRepository.findAll();
        return criteria;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICriteriaService#updateCriteria(com.meat.domain.Criteria)
     */
    @Override
    public Criteria updateCriteria(final Criteria criteria) {
        // TODO Auto-generated method stub
        return criteriaRepository.save(criteria);
    }

}
