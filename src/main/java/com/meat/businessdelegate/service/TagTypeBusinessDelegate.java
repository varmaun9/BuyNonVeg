/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.TagType;
import com.meat.domain.Tags;
import com.meat.model.TagTypeModel;
import com.meat.model.TagsModel;
import com.meat.service.ISeoService;
import com.meat.service.ITagTypeService;
import com.meat.service.ITagsService;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author venu1
 *
 */

@Service
public class TagTypeBusinessDelegate implements IBusinessDelegate<TagTypeModel, TagTypeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ITagTypeService tagTypeService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ITagsService tagsService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TagTypeModel create(final TagTypeModel model) {
        TagType tagType = new TagType();
        tagType.setId(model.getId());
        tagType.setCreatedDate(new Date());
        tagType.setDescription(model.getDescription());
        tagType.setStatus(model.getStatus());
        tagType.setTagTypeName(model.getTagTypeName());
        tagType = tagTypeService.create(tagType);
        model.setId(tagType.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final TagTypeContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TagTypeModel edit(final IKeyBuilder<String> keyBuilder, final TagTypeModel model) {
        TagType tagType = tagTypeService.getTagType(keyBuilder.build().toString());
        tagType.setId(model.getId());
        tagType.setDescription(model.getDescription());
        tagType.setStatus(model.getStatus());
        tagType.setTagTypeName(model.getTagTypeName());

        Set<Tags> tagses = new HashSet<Tags>();
        if (CollectionUtils.isNotEmpty(model.getTagModel())) {
            for (TagsModel tagModel : model.getTagModel()) {
                Tags tags = tagsService.getTags(tagModel.getId());

                tags.setId(tagModel.getId());
                tags.setTagName(tagModel.getTagName());
                tags.setDescription(tagModel.getDescription());
                tags.setStatus(tagModel.getStatus());
                tags.setTagType(tagType);
                tagses.add(tags);
            }
            tagType.setTagses(tagses);

        }
        tagType = tagTypeService.updateTagType(tagType);

        model.setId(tagType.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public TagTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final TagTypeContext context) {
        TagType tagType = tagTypeService.getTagType(keyBuilder.build().toString());
        TagTypeModel tagTypeModel = conversionService.convert(tagType, TagTypeModel.class);

        return tagTypeModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public Collection<TagTypeModel> getCollection(final TagTypeContext context) {
        List<TagType> tagType = new ArrayList<TagType>();

        if (context.getAll() != null) {
            tagType = tagTypeService.getAll();
        }
        if (context.getTagTypeOnly() != null) {
            tagType = tagTypeService.getTagTypeOnly();
        }
        if (context.getAll() != null && context.getTagTypeOnly() != null) {
            tagType = tagTypeService.getAllTagTypesOnly();
        }
        List<TagTypeModel> tagTypeModels = (List<TagTypeModel>) conversionService.convert(tagType, TypeDescriptor.forObject(tagType),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TagTypeModel.class)));

        return tagTypeModels;
    }

}
