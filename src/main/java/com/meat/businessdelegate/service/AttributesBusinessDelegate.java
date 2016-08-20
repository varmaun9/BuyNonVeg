/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Attributes;
import com.meat.domain.Seo;
import com.meat.model.AttributesModel;
import com.meat.service.IAttributesService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class AttributesBusinessDelegate implements IBusinessDelegate<AttributesModel, AttributesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IAttributesService attributesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public AttributesModel create(final AttributesModel model) {
        Attributes attributes = new Attributes();
        attributes.setId(model.getId());
        attributes.setAttributeName(model.getAttributeName());
        attributes.setAttributeCreatedDate(new Date());
        attributes.setDescription(model.getDescription());
        attributes.setStatus(model.getStatus());

        Seo seo = new Seo();
        //seo.setId(model.getSeoId());
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        attributes.setSeo(seo);

        attributes = attributesService.create(attributes);
        model.setId(attributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final AttributesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public AttributesModel edit(final IKeyBuilder<String> keyBuilder, final AttributesModel model) {
        Attributes attributes = attributesService.getAttributes(keyBuilder.build().toString());
        attributes.setId(model.getId());
        if (model.getAttributeName() != null) {
            attributes.setAttributeName(model.getAttributeName());
        }
        if (model.getDescription() != null) {
            attributes.setDescription(model.getDescription());
        }
        if (model.getStatus() != null) {
            attributes.setStatus(model.getStatus());
        }
        if (model.getSeoId() != null) {
            Seo seo = new Seo();
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            attributes.setSeo(seo);
        }
        attributes = attributesService.updateAttributes(attributes);
        model.setId(attributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public AttributesModel getByKey(final IKeyBuilder<String> keyBuilder, final AttributesContext context) {
        Attributes attributes = attributesService.getAttributes(keyBuilder.build().toString());
        AttributesModel attributesModel = conversionService.convert(attributes, AttributesModel.class);
        return attributesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<AttributesModel> getCollection(final AttributesContext context) {
        List<Attributes> attributes = new ArrayList<Attributes>();

        if (context.getAll() != null) {
            attributes = attributesService.getAll();
        }

        List<AttributesModel> attributesModels = (List<AttributesModel>) conversionService.convert(attributes,
                TypeDescriptor.forObject(attributes), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AttributesModel.class)));

        return attributesModels;
    }

}
