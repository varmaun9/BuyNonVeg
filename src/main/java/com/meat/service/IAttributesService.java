/**
 *
 */
package com.meat.service;

import com.meat.domain.Attributes;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IAttributesService {

    Attributes create(Attributes attributes);

    void deleteAttributes(String attributesId);

    List<Attributes> getAll();

    Attributes getAttributes(String attributeId);

    /**
     * @param categoryId
     * @param zoneId
     * @return
     */
    List<Attributes> getItemAttributesByThymeleafCategoryZone(String categoryId, String zoneId);

    Attributes updateAttributes(Attributes attributes);

}
