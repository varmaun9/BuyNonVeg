/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Criteria;
import com.meat.domain.Seo;
import com.meat.model.CriteriaModel;
import com.meat.service.ICriteriaService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CriteriaBusinessDelegate implements IBusinessDelegate<CriteriaModel, CriteriaContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICriteriaService criteriaService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CriteriaModel create(final CriteriaModel model) {
        Criteria criteria = new Criteria();
        criteria.setId(model.getId());
        criteria.setCriteriaName(model.getCriteriaName());
        criteria.setCreatedDate(new Date());
        criteria.setDescription(model.getDescription());
        criteria.setOrderOfPlace(Integer.parseInt(model.getOrderOfPlace()));
        criteria.setStatus(model.getStatus());

        Seo seo = new Seo();
        seo.setId(model.getSeoId());
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        criteria.setSeo(seo);

        criteria = criteriaService.create(criteria);
        model.setId(model.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CriteriaContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CriteriaModel edit(final IKeyBuilder<String> keyBuilder, final CriteriaModel model) {
        Criteria criteria = criteriaService.getCriteria(keyBuilder.build().toString());
        criteria.setId(model.getId());
        if (model.getCriteriaName() != null) {
            criteria.setCriteriaName(model.getCriteriaName());
        }
        if (model.getDescription() != null) {
            criteria.setDescription(model.getDescription());
        }

        if (model.getStatus() != null) {
            criteria.setStatus(model.getStatus());
        }
        if (model.getSeoId() != null) {
            Seo seo = new Seo();
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            criteria.setSeo(seo);
        }
        criteria = criteriaService.updateCriteria(criteria);
        model.setId(model.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CriteriaModel getByKey(final IKeyBuilder<String> keyBuilder, final CriteriaContext context) {
        Criteria criteria = criteriaService.getCriteria(keyBuilder.build().toString());
        CriteriaModel criteriaModel = conversionService.convert(criteria, CriteriaModel.class);
        return criteriaModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CriteriaModel> getCollection(final CriteriaContext context) {
        List<Criteria> criteria = new ArrayList<Criteria>();

        if (context.getAll() != null) {
            criteria = criteriaService.getAll();
        }
        if (context.getCriteriaOnly() != null) {
            criteria = criteriaService.getCriteriaOnly();
        }

        List<CriteriaModel> criteriaModels = (List<CriteriaModel>) conversionService.convert(criteria, TypeDescriptor.forObject(criteria),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CriteriaModel.class)));

        return criteriaModels;
    }
}
