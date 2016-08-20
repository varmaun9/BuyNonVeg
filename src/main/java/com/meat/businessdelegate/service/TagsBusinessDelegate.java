/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Seo;
import com.meat.domain.TagType;
import com.meat.domain.Tags;
import com.meat.model.TagsModel;
import com.meat.service.ITagsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author venu1
 *
 */

@Service
public class TagsBusinessDelegate implements IBusinessDelegate<TagsModel, TagsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ITagsService tagsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TagsModel create(final TagsModel model) {
        Tags tags = new Tags();
        tags.setId(model.getId());
        TagType tagType = new TagType();
        tagType.setId(model.getTagTypeId());
        tags.setTagType(tagType);

        tags.setTagName(model.getTagName());
        tags.setDescription(model.getDescription());
        tags.setStatus(model.getStatus());
        tags.setCreatedDate(new Date());

        Seo seo = new Seo();
        seo.setId(model.getSeoId());
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        tags.setSeo(seo);

        tags = tagsService.create(tags);

        if (tags.getTagName() != null) {
            if (tags.getTagName().equals("Duplicate")) {
                model.setTagNameStatus(model.getTagName() + " Already Exists!");
            }
        }

        model.setId(tags.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final TagsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TagsModel edit(final IKeyBuilder<String> keyBuilder, final TagsModel model) {
        Tags tags = tagsService.getTags(keyBuilder.build().toString());
        tags.setId(model.getId());
        if (tags.getTagName() != null) {
            tags.setTagName(model.getTagName());
        }
        if (tags.getDescription() != null) {
            tags.setDescription(model.getDescription());
        }
        if (tags.getStatus() != null) {
            tags.setStatus(model.getStatus());
        }

        if (tags.getTagType() != null) {
            TagType tagType = new TagType();
            tagType.setId(model.getTagTypeId());
            tags.setTagType(tagType);
        }
        if (model.getSeoId() != null) {
            Seo seo = new Seo();
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            tags.setSeo(seo);
        }

        tags = tagsService.updateTags(tags);
        model.setId(tags.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public TagsModel getByKey(final IKeyBuilder<String> keyBuilder, final TagsContext context) {
        Tags tags = tagsService.getTags(keyBuilder.build().toString());
        TagsModel tagsModel = conversionService.convert(tags, TagsModel.class);
        return tagsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<TagsModel> getCollection(final TagsContext context) {

        List<Tags> tags = new ArrayList<Tags>();

        if (context.getAll() != null) {
            tags = tagsService.getAll();
        }
        /* if (context.getCategoryId() != null && context.getTagsOnly() != null) {
             tags = tagsService.getCategoryTag(context.getCategoryId());
         }

         if (context.getTagTypeId() != null) {
             tags = tagsService.getTagsByTagType(context.getTagTypeId());
         }

         if (context.getTagsOnly() != null && context.getTagTypeId() != null) {
             tags = tagsService.getTagsOnlyByTagType(context.getTagTypeId());
         }*/
        if (context.getTagsOnly() != null) {
            tags = tagsService.getTagsOnly();
        }
        List<TagsModel> tagsModels = (List<TagsModel>) conversionService.convert(tags, TypeDescriptor.forObject(tags),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TagsModel.class)));
        return tagsModels;
    }

}
