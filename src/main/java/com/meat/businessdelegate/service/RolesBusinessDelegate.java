/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Roles;
import com.meat.domain.Users;
import com.meat.model.RolesModel;
import com.meat.service.IRolesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
public class RolesBusinessDelegate implements IBusinessDelegate<RolesModel, RolesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IRolesService roleService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public RolesModel create(final RolesModel model) {

        Roles role = new Roles();
        role.setRoleName(model.getRoleName());
        role.setDescription(model.getDescription());
        Users users = new Users();
        users.setId(model.getUsersId());
        role.setUsers(users);
        role.setEnabled(model.getEnabled());
        role = roleService.create(role);

        model.setId(role.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final RolesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public RolesModel edit(final IKeyBuilder<String> keyBuilder, final RolesModel model) {
        Roles role = roleService.getRoles(keyBuilder.build().toString());
        role.setRoleName(model.getRoleName());
        role.setDescription(model.getDescription());
        Users users = new Users();
        users.setId(model.getUsersId());
        role.setUsers(users);
        role.setEnabled(model.getEnabled());
        role.setId(model.getId());
        role = roleService.updateRoles(role);
        model.setId(role.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public RolesModel getByKey(final IKeyBuilder<String> keyBuilder, final RolesContext context) {
        Roles role = roleService.getRoles(keyBuilder.build().toString());
        RolesModel roleModel = conversionService.convert(role, RolesModel.class);

        return roleModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<RolesModel> getCollection(final RolesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
