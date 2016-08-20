package com.meat.service;

import com.meat.domain.Tags;

import java.util.List;

public interface ITagsService {

    Tags create(Tags tags);

    void deleteTags(String tagsId);

    List<Tags> getAll();

    Tags getTags(String tagsId);

    /**
     * @return
     */
    List<Tags> getTagsOnly();

    /**
     * @param categoryId
     * @return
     */
    List<Tags> getThymeleafCategoryTags(String categoryId);

    Tags updateTags(Tags tags);

}
