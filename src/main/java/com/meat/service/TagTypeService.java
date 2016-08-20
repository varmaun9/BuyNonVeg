package com.meat.service;

import com.meat.dao.TagTypeRepository;
import com.meat.domain.TagType;
import com.meat.domain.Tags;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagTypeService implements ITagTypeService {
    @Autowired
    private TagTypeRepository tagTypeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#create(com.meat.domain.TagType)
     */
    @Override
    public TagType create(final TagType tagType) {
        return tagTypeRepository.save(tagType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#deleteTagType(java.lang.String)
     */
    @Override
    public void deleteTagType(final String tagTypeId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getAll()
     */

    @Override
    public List<TagType> getAll() {
        List<TagType> tagType = new ArrayList<TagType>();
        tagType = (List<TagType>) tagTypeRepository.findAll();
        return tagType;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getAllTagTypesOnly()
     */
    @Override
    public List<TagType> getAllTagTypesOnly() {
        List<TagType> tagType = new ArrayList<TagType>();
        tagType = (List<TagType>) tagTypeRepository.findAll();
        List<TagType> tagTypes = new ArrayList<TagType>();
        for (TagType tt : tagType) {
            TagType tagTy = new TagType();
            tagTy.setId(tt.getId());
            tagTy.setTagTypeName(tt.getTagTypeName());
            tagTy.setCreatedDate(tt.getCreatedDate());
            tagTy.setDescription(tt.getDescription());
            tagTy.setStatus(tt.getStatus());
            tagTypes.add(tagTy);
        }
        return tagTypes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getItemTagTypesByThemeleafCategory(java.lang.String)
     */
    @Override
    public List<TagType> getItemTagTypesByThemeleafCategory(final String categoryId) {
        List<TagType> tagType = new ArrayList<TagType>();
        tagType = tagTypeRepository.findItemTagTypesByThymeleafCategory(categoryId);

        List<TagType> tagTypes = new ArrayList<TagType>();
        for (TagType tt : tagType) {
            TagType tt1 = new TagType();
            tt1.setId(tt.getId());
            tt1.setTagTypeName(tt.getTagTypeName());
            tt1.setStatus(tt.getStatus());
            Set<Tags> tags = new HashSet<Tags>();
            for (Tags ts : tt.getTagses()) {
                Tags t = new Tags();
                t.setId(ts.getId());
                t.setTagName(ts.getTagName());
                t.setStatus(t.getStatus());
                tags.add(t);
            }
            tt1.setTagses(tags);
            tagTypes.add(tt1);
        }
        return tagTypes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getCategoryTagTypesByThemeleaf(java.lang.String)
     */
    @Override
    public List<TagType> getItemTagTypesByThemeleafCategoryZone(final String categoryId, final String zoneId) {
        List<TagType> tagType = new ArrayList<TagType>();
        tagType = tagTypeRepository.findItemTagTypesByThymeleafCategoryZone(categoryId, zoneId);

        List<TagType> tagTypes = new ArrayList<TagType>();
        for (TagType tt : tagType) {
            TagType tt1 = new TagType();
            tt1.setId(tt.getId());
            tt1.setTagTypeName(tt.getTagTypeName());
            tt1.setStatus(tt.getStatus());
            Set<Tags> tags = new HashSet<Tags>();
            for (Tags ts : tt.getTagses()) {
                Tags t = new Tags();
                t.setId(ts.getId());
                t.setTagName(ts.getTagName());
                t.setStatus(t.getStatus());
                tags.add(t);
            }
            tt1.setTagses(tags);
            tagTypes.add(tt1);
        }
        return tagTypes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getTagType(java.lang.String)
     */
    @Override
    public TagType getTagType(final String tagTypeId) {
        return tagTypeRepository.findOne(tagTypeId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#getTagTypeOnly()
     */

    @Override
    public List<TagType> getTagTypeOnly() {
        List<TagType> tagType = new ArrayList<TagType>();
        tagType = (List<TagType>) tagTypeRepository.findAll();
        List<TagType> tagTypes = new ArrayList<TagType>();
        for (TagType tt : tagType) {
            TagType tagTy = new TagType();
            tagTy.setId(tt.getId());
            tagTy.setTagTypeName(tt.getTagTypeName());
            tagTy.setDescription(tt.getDescription());
            tagTy.setStatus(tt.getStatus());
            tagTypes.add(tagTy);
        }
        return tagTypes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagTypeService#updateTagType(com.meat.domain.TagType)
     */
    @Override
    public TagType updateTagType(final TagType tagType) {
        // TODO Auto-generated method stub
        return tagTypeRepository.save(tagType);
    }

}
