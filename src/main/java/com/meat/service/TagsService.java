package com.meat.service;

import com.meat.dao.TagsRepository;
import com.meat.domain.Seo;
import com.meat.domain.Tags;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TagsService implements ITagsService {
    @Autowired
    private TagsRepository tagsRepository;
    @Autowired
    private ISeoService seoService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#create(com.meat.domain.Tags)
     */
    @Override
    public Tags create(final Tags tags) {
        if (tags.getSeo() != null) {
            Seo seo = new Seo();
            seo.setSeoTitle(tags.getSeo().getSeoTitle());
            seo.setSeoKeywords(tags.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(tags.getSeo().getSeoMetaDescription());
            seo = seoService.create(seo);
            tags.setSeo(seo);
        }
        Validate.notNull(tags, "tags must not be null" + tags.getTagName());

        List<Tags> tagses = new ArrayList<Tags>();
        tagses = (List<Tags>) tagsRepository.findAll();
        if (tagses != null) {
            for (Tags t : tagses) {
                String m = t.getTagName();
                String mc = m.replaceAll("\\s", "");
                String mc1 = mc.toLowerCase();
                if (tags.getTagName() != null) {
                    String mc2 = tags.getTagName().replaceAll("\\s", "").toLowerCase();
                    if (mc1.equals(mc2)) {
                        tags.setTagName("Duplicate");
                    }
                }
            }
        }
        if (tags.getTagName() != null) {

            if (tags.getTagName().equals("Duplicate")) {
                tags.getTagName().equals("Duplicate");
                return tags;
            }
            else {
                Tags tags1 = new Tags();
                tags1 = tagsRepository.save(tags);
            }
        }
        return tags;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#deleteTags(java.lang.String)
     */
    @Override
    public void deleteTags(final String tagsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#getAll()
     */

    @Override
    public List<Tags> getAll() {
        List<Tags> tags = new ArrayList<Tags>();
        tags = (List<Tags>) tagsRepository.findAll();
        return tags;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#getTags(java.lang.String)
     */
    @Override
    public Tags getTags(final String tagsId) {
        Tags tags = new Tags();
        tags = tagsRepository.findOne(tagsId);
        return tags;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#getTagsOnly()
     */

    @Override
    public List<Tags> getTagsOnly() {
        List<Tags> tags = new ArrayList<Tags>();
        tags = (List<Tags>) tagsRepository.findAll();
        List<Tags> tages = new ArrayList<Tags>();
        for (Tags t : tags) {
            Tags tag = new Tags();
            tag.setId(t.getId());
            tag.setSeo(t.getSeo());
            tag.setTagType(t.getTagType());
            tag.setCreatedDate(t.getCreatedDate());
            tag.setDescription(t.getDescription());
            tag.setStatus(t.getStatus());
            tag.setTagName(t.getTagName());
            tages.add(tag);
        }
        return tages;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#getThymeleafCategoryTags(java.lang.String)
     */
    @Override
    public List<Tags> getThymeleafCategoryTags(final String categoryId) {
        List<Tags> tags = tagsRepository.findTagsByThymeleafCategory(categoryId);
        return tags;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ITagsService#updateTags(com.meat.domain.Tags)
     */
    @Override
    public Tags updateTags(final Tags tags) {
        /*  Tags tag = tagsRepository.findOne(tags.getId());
        System.out.println("tag name is tag s" + tags.getTagName());
        if (tags.getTagName() != null) {
            tag.setTagName(tags.getTagName());
        }
        if (tags.getCreatedDate() != null) {
            tag.setCreatedDate(tags.getCreatedDate());
        }
        if (tags.getDescription() != null) {
            tag.setDescription(tags.getDescription());
        }
        if (tags.getStatus() != null) {
            tag.setStatus(tags.getStatus());
        }
        
        if (tags.getTagType() != null) {
            TagType tagType = new TagType();
            tagType.setId(tags.getTagType().getId());
            tag.setTagType(tagType);
        }
        
        if (tags.getSeo() != null) {
            Seo seo = seoService.getSeo(tags.getSeo().getId());
            seo.setId(tags.getSeo().getId());
            seo.setSeoTitle(tags.getSeo().getSeoTitle());
            seo.setSeoKeywords(tags.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(tags.getSeo().getSeoMetaDescription());
            seo = seoService.updateSeo(seo);
            tag.setSeo(seo);
        }
        return tagsRepository.save(tag);*/
        return tagsRepository.save(tags);
    }
}
