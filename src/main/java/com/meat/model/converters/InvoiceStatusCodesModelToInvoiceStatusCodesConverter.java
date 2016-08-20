/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.InvoiceStatusCodes;
import com.meat.model.InvoiceStatusCodesModel;

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
@Component("invoiceStatusCodesModelToInvoiceStatusCodesConverter")
public class InvoiceStatusCodesModelToInvoiceStatusCodesConverter implements Converter<InvoiceStatusCodesModel, InvoiceStatusCodes> {
    @Autowired
    private ObjectFactory<InvoiceStatusCodes> invoiceStatusCodesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceStatusCodes convert(final InvoiceStatusCodesModel source) {
        InvoiceStatusCodes invoiceStatusCodes = invoiceStatusCodesFactory.getObject();
        BeanUtils.copyProperties(source, invoiceStatusCodes);

        return invoiceStatusCodes;
    }

    @Autowired
    public void setInvoiceStatusCodesFactory(final ObjectFactory<InvoiceStatusCodes> invoiceStatusCodesFactory) {
        this.invoiceStatusCodesFactory = invoiceStatusCodesFactory;
    }

}
