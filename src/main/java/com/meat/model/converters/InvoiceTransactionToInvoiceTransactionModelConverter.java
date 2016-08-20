/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.InvoiceTransaction;
import com.meat.model.InvoiceTransactionModel;

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
@Component("invoiceTransactionToInvoiceTransactionModelConverter")
public class InvoiceTransactionToInvoiceTransactionModelConverter implements Converter<InvoiceTransaction, InvoiceTransactionModel> {

    private static final Logger LOGGER = Logger.getLogger(InvoiceTransactionToInvoiceTransactionModelConverter.class);
    @Autowired
    private ObjectFactory<InvoiceTransactionModel> invoiceTransactionModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public InvoiceTransactionModel convert(final InvoiceTransaction source) {
        // TODO Auto-generated method stub
        InvoiceTransactionModel invoiceTransactionModel = invoiceTransactionModelFactory.getObject();

        BeanUtils.copyProperties(source, invoiceTransactionModel);

        return invoiceTransactionModel;

    }

    @Autowired
    public void setInvoiceTransactionFactory(final ObjectFactory<InvoiceTransactionModel> invoiceTransactionModelFactory) {
        this.invoiceTransactionModelFactory = invoiceTransactionModelFactory;
    }

}
