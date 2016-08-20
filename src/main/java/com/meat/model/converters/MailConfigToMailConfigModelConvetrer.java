/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.MailConfig;
import com.meat.model.MailConfigModel;

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

@Component("mailConfigToMailConfigModelConvetrer")
public class MailConfigToMailConfigModelConvetrer implements Converter<MailConfig, MailConfigModel> {

    private static final Logger LOGGER = Logger.getLogger(MailConfigToMailConfigModelConvetrer.class);
    @Autowired
    private ObjectFactory<MailConfigModel> mailConfigModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public MailConfigModel convert(final MailConfig source) {
        // TODO Auto-generated method stub
        MailConfigModel mailConfigModel = mailConfigModelFactory.getObject();
        BeanUtils.copyProperties(source, mailConfigModel);

        return mailConfigModel;

    }

    @Autowired
    public void setMailConfigFactory(final ObjectFactory<MailConfigModel> mailConfigModelFactory) {
        this.mailConfigModelFactory = mailConfigModelFactory;
    }

}
