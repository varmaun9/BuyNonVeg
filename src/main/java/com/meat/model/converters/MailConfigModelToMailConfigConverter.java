package com.meat.model.converters;

import com.meat.domain.MailConfig;
import com.meat.model.MailConfigModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("mailConfigModelToMailConfigConverter")
public class MailConfigModelToMailConfigConverter implements Converter<MailConfigModel, MailConfig> {
    @Autowired
    private ObjectFactory<MailConfig> mailConfigFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public MailConfig convert(final MailConfigModel source) {
        MailConfig mailConfig = mailConfigFactory.getObject();
        BeanUtils.copyProperties(source, mailConfig);

        return mailConfig;
    }

    @Autowired
    public void setMailConfigFactory(final ObjectFactory<MailConfig> mailConfigFactory) {
        this.mailConfigFactory = mailConfigFactory;
    }

}
