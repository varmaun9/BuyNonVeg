/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.EmailSubscription;
import com.meat.model.EmailSubscriptionModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("emailSubscriptionModelToEmailSubscriptionConverter")
public class EmailSubscriptionModelToEmailSubscriptionConverter implements Converter<EmailSubscriptionModel, EmailSubscription> {
    @Autowired
    private ObjectFactory<EmailSubscription> emailSubscriptionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public EmailSubscription convert(final EmailSubscriptionModel source) {
        EmailSubscription emailSubscription = emailSubscriptionFactory.getObject();
        BeanUtils.copyProperties(source, emailSubscription);

        return emailSubscription;
    }

    @Autowired
    public void setEmailSubscriptionFactory(final ObjectFactory<EmailSubscription> emailSubscriptionFactory) {
        this.emailSubscriptionFactory = emailSubscriptionFactory;
    }

}
