package com.meat.representation.siren;

import com.meat.model.RolesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("rolesModelToRolesRepresentationConverter")
public class RolesModelToRolesRepresentationConverter extends PropertyCopyingConverter<RolesModel, RolesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public RolesRepresentation convert(final RolesModel source) {

        RolesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<RolesRepresentation> factory) {
        super.setFactory(factory);
    }

}
