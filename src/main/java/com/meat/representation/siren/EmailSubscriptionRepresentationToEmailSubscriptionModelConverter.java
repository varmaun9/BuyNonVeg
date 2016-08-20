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
@Component("emailSubscriptionRepresentationToEmailSubscriptionModelConverter")
public class EmailSubscriptionRepresentationToEmailSubscriptionModelConverter
        extends PropertyCopyingConverter<EmailSubscriptionRepresentation, EmailSubscriptionModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public EmailSubscriptionModel convert(final EmailSubscriptionRepresentation source) {
        EmailSubscriptionModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<EmailSubscriptionModel> factory) {
        super.setFactory(factory);
    }
}
