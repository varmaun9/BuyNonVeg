/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.EmailSubscriptionModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */

@Component("emailSubscriptionModelToEmailSubscriptionRepresentationConverter")
public class EmailSubscriptionModelToEmailSubscriptionRepresentationConverter
        extends PropertyCopyingConverter<EmailSubscriptionModel, EmailSubscriptionRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public EmailSubscriptionRepresentation convert(final EmailSubscriptionModel source) {

        EmailSubscriptionRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<EmailSubscriptionRepresentation> factory) {
        super.setFactory(factory);
    }

}
