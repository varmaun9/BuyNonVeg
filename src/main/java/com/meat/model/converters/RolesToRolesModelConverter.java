/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Roles;
import com.meat.model.RolesModel;

import org.apache.log4j.Logger;
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
@Component("rolesToRolesModelConverter")
public class RolesToRolesModelConverter implements Converter<Roles, RolesModel> {
    @Autowired
    private ObjectFactory<RolesModel> rolesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(RolesToRolesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public RolesModel convert(final Roles source) {
        RolesModel rolesModel = rolesModelFactory.getObject();
        BeanUtils.copyProperties(source, rolesModel);

        return rolesModel;
    }

    @Autowired
    public void setRolesFactory(final ObjectFactory<RolesModel> rolesModelFactory) {
        this.rolesModelFactory = rolesModelFactory;
    }
}
