package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("rolesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RolesModel extends AbstractModel {

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

    public String getRoleName() {
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

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
