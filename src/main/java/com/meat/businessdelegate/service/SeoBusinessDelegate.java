/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Seo;
import com.meat.model.SeoModel;
import com.meat.service.ISeoService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
public class SeoBusinessDelegate implements IBusinessDelegate<SeoModel, SeoContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISeoService seoService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SeoModel create(final SeoModel model) {

        Seo seo = new Seo();
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        seo.setId(model.getId());
        seo = seoService.create(seo);
        model.setId(seo.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SeoContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public SeoModel edit(final IKeyBuilder<String> keyBuilder, final SeoModel model) {
        Seo seo = seoService.getSeo(keyBuilder.build().toString());
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        seo.setId(model.getId());
        seo = seoService.updateSeo(seo);
        model.setId(seo.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SeoModel getByKey(final IKeyBuilder<String> keyBuilder, final SeoContext context) {
        Seo seo = seoService.getSeo(keyBuilder.build().toString());
        SeoModel seoModel = conversionService.convert(seo, SeoModel.class);

        return seoModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SeoModel> getCollection(final SeoContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
