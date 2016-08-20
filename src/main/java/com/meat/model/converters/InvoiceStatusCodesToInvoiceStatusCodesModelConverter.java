/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.InvoiceStatusCodes;
import com.meat.model.InvoiceStatusCodesModel;

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
@Component("invoiceStatusCodesToInvoiceStatusCodesModelConverter")
public class InvoiceStatusCodesToInvoiceStatusCodesModelConverter implements Converter<InvoiceStatusCodes, InvoiceStatusCodesModel> {

    private static final Logger LOGGER = Logger.getLogger(InvoiceStatusCodesToInvoiceStatusCodesModelConverter.class);
    @Autowired
    private ObjectFactory<InvoiceStatusCodesModel> invoiceStatusCodesModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public InvoiceStatusCodesModel convert(final InvoiceStatusCodes source) {
        // TODO Auto-generated method stub
        InvoiceStatusCodesModel invoiceStatusCodesModel = invoiceStatusCodesModelFactory.getObject();

        BeanUtils.copyProperties(source, invoiceStatusCodesModel);

        return invoiceStatusCodesModel;

    }

    @Autowired
    public void setInvoiceStatusCodesFactory(final ObjectFactory<InvoiceStatusCodesModel> invoiceStatusCodesModelFactory) {
        this.invoiceStatusCodesModelFactory = invoiceStatusCodesModelFactory;
    }

}
