package com.meat.representation.siren;

import com.meat.model.MailConfigModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("mailConfigModelToMailConfigRepresentationConverter")
public class MailConfigModelToMailConfigRepresentationConverter
        extends PropertyCopyingConverter<MailConfigModel, MailConfigRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public MailConfigRepresentation convert(final MailConfigModel source) {

        MailConfigRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<MailConfigRepresentation> factory) {
        super.setFactory(factory);
    }

}
