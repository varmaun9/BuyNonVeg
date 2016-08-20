/**
 *
 */
package com.meat.service;

import com.meat.dao.AttributesRepository;
import com.meat.dao.ItemAttributesRepository;
import com.meat.dao.ItemRepository;
import com.meat.domain.Attributes;
import com.meat.domain.ItemAttributes;
import com.meat.domain.Seo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class AttributesService implements IAttributesService {
    @Autowired
    private AttributesRepository attributesRepository;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemAttributesRepository itemAttributesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#create(com.meat.domain.Attributes)
     */
    @Override
    public Attributes create(final Attributes attributes) {
        if (attributes.getSeo() != null) {
            Seo seo = new Seo();
            seo.setId(attributes.getSeo().getId());
            seo.setSeoTitle(attributes.getSeo().getSeoTitle());
            seo.setSeoKeywords(attributes.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(attributes.getSeo().getSeoMetaDescription());
            seo = seoService.create(seo);
            attributes.setSeo(seo);
        }
        return attributesRepository.save(attributes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#deleteAttributes(java.lang.String)
     */
    @Override
    public void deleteAttributes(final String attributesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#getAll()
     */
    @Override
    public List<Attributes> getAll() {
        List<Attributes> attribute = new ArrayList<Attributes>();
        attribute = (List<Attributes>) attributesRepository.findAll();
        return attribute;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#getAttributes(java.lang.String)
     */
    @Override
    public Attributes getAttributes(final String attributeId) {
        Attributes attribute = new Attributes();
        attribute = attributesRepository.findOne(attributeId);
        return attribute;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#getItemAttributesByThymeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public List<Attributes> getItemAttributesByThymeleafCategoryZone(final String categoryId, final String zoneId) {
        List<Attributes> attributes = new ArrayList<Attributes>();
        attributes = attributesRepository.findItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
        List<Attributes> attributs = new ArrayList<Attributes>();
        for (Attributes at : attributes) {
            Attributes a = new Attributes();
            a.setId(at.getId());
            a.setAttributeName(at.getAttributeName());
            a.setDescription(at.getDescription());
            a.setStatus(at.getStatus());
            if (at.getItemAttributeses() != null) {
                List<ItemAttributes> itemAttributes = itemAttributesRepository.findItemAttributesByAttributeId(at.getId());
                List<ItemAttributes> itemAttribute = new ArrayList<ItemAttributes>();
                for (ItemAttributes it : itemAttributes) {
                    ItemAttributes ita = new ItemAttributes();
                    ita.setId(it.getId());
                    ita.setAttributeValue(it.getAttributeValue());
                    ita.setSearchableStatus(it.getSearchableStatus());
                    ita.setAttributes(it.getAttributes());
                    int itemCount = itemRepository.findItemCountByThymeleafCategoryZoneAttributeValue(it.getAttributeValue(), categoryId,
                            zoneId);
                    ita.setCountFlag(itemCount);
                    itemAttribute.add(ita);
                }

                Set<ItemAttributes> itemAttributeSet = new HashSet(itemAttribute);
                a.setItemAttributeses(itemAttributeSet);
            }
            attributs.add(a);
        }
        return attributs;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAttributesService#updateAttributes(com.meat.domain.Attributes)
     */
    @Override
    public Attributes updateAttributes(final Attributes attributes) {
        if (attributes.getSeo() != null) {
            Seo seo = new Seo();
            seo.setId(attributes.getSeo().getId());
            seo.setSeoTitle(attributes.getSeo().getSeoTitle());
            seo.setSeoKeywords(attributes.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(attributes.getSeo().getSeoMetaDescription());
            seo = seoService.updateSeo(seo);
            attributes.setSeo(seo);
        }
        return attributesRepository.save(attributes);
    }

}
