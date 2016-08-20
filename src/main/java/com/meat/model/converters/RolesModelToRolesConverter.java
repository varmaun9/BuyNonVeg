/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Roles;
import com.meat.model.RolesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("rolesModelToRolesConverter")
public class RolesModelToRolesConverter implements Converter<RolesModel, Roles> {
    @Autowired
    private ObjectFactory<Roles> rolesFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Roles convert(final RolesModel source) {
        Roles roles = rolesFactory.getObject();
        BeanUtils.copyProperties(source, roles);

        return roles;
    }

    @Autowired
    public void setRolesFactory(final ObjectFactory<Roles> rolesFactory) {
        this.rolesFactory = rolesFactory;
    }

}
