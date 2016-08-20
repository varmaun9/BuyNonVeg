package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.RolesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("rolesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "roles", uri = "/roleses/{id}")
@Representation(RolesModel.class)
public class RolesRepresentation extends BaseResource {

    private String id;
    private String usersId;
    private String roleName;
    private String enabled;
    private String description;

    public String getDescription() {
        return description;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getId() {
        return id;
    }

    public String getRolesName() {
        return roleName;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setEnabled(final String enabled) {
        this.enabled = enabled;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
