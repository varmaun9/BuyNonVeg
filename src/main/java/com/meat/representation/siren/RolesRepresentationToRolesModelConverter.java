/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.RolesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("rolesRepresentationToRolesModelConverter")
public class RolesRepresentationToRolesModelConverter extends PropertyCopyingConverter<RolesRepresentation, RolesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public RolesModel convert(final RolesRepresentation source) {

        RolesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<RolesModel> factory) {
        super.setFactory(factory);
    }
}
