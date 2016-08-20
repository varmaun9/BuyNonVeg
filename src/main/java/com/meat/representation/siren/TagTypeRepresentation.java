/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.TagTypeModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("tagTypeRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "tagType", uri = "/tagTypes/{id}")
@Representation(TagTypeModel.class)
public class TagTypeRepresentation extends BaseResource {
    private String id;
    private String tagTypeName;
    private String tagTypeNameStatus;
    private String description;
    private String createdDate;
    private String status;
    @Siren4JSubEntity
    private List<TagsRepresentation> tagRep = new ArrayList<TagsRepresentation>(0);

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public List<TagsRepresentation> getTagRep() {
        return tagRep;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setTagRep(final List<TagsRepresentation> tagRep) {
        this.tagRep = tagRep;
    }

    public void setTagTypeName(final String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

    public String getTagTypeNameStatus() {
        return tagTypeNameStatus;
    }

    public void setTagTypeNameStatus(String tagTypeNameStatus) {
        this.tagTypeNameStatus = tagTypeNameStatus;
    }

}
