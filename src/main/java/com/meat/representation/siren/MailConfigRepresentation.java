package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.MailConfigModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mailConfigRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "mailConfig", uri = "/mailConfigs/{id}")
@Representation(MailConfigModel.class)
public class MailConfigRepresentation extends BaseResource {

    private String id;
    private String mailAttributeName;
    private String mailAttributeValue;
    private String status;
    private String createdDate;
    private String modifiedDate;

    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public String getMailAttributeName() {
        return mailAttributeName;
    }

    public String getMailAttributeValue() {
        return mailAttributeValue;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    public void setMailAttributeName(final String mailAttributeName) {
        this.mailAttributeName = mailAttributeName;
    }

    public void setMailAttributeValue(final String mailAttributeValue) {
        this.mailAttributeValue = mailAttributeValue;
    }

    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
