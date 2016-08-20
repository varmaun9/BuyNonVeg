/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ItemTagsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemTagsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "itemTag", uri = "/itemTags/{id}")
@Representation(ItemTagsModel.class)
public class ItemTagsRepresentation extends BaseResource {
    private String id;
    private String tagsId;
    private String itemId;
    private String itemName;
    private String tagName;
    private String tagTypeName;

    private String itemTagsStatus;

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemTagsStatus() {
        return itemTagsStatus;
    }

    public String getTagName() {
        return tagName;
    }

    public String getTagsId() {
        return tagsId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(final String itemName) {
        this.itemName = itemName;
    }

    public void setItemTagsStatus(final String itemTagsStatus) {
        this.itemTagsStatus = itemTagsStatus;
    }

    public void setTagName(final String tagName) {
        this.tagName = tagName;
    }

    public void setTagsId(final String tagsId) {
        this.tagsId = tagsId;
    }

    public void setTagTypeName(final String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

}
