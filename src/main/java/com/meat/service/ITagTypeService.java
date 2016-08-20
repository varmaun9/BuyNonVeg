/**
 *
 */
package com.meat.service;

import com.meat.domain.TagType;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ITagTypeService {
    TagType create(TagType tagType);

    void deleteTagType(String tagTypeId);

    List<TagType> getAll();

    /**
     * @return
     */
    List<TagType> getAllTagTypesOnly();

    /**
     * @param categoryId
     * @return
     */
    List<TagType> getItemTagTypesByThemeleafCategory(String categoryId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    List<TagType> getItemTagTypesByThemeleafCategoryZone(String categoryId, String zoneId);

    TagType getTagType(String tagTypeId);

    /**
     * @return
     */
    List<TagType> getTagTypeOnly();

    TagType updateTagType(TagType tagType);

}
