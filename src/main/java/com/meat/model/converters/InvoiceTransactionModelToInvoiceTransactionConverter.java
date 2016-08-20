/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.InvoiceTransaction;
import com.meat.model.InvoiceTransactionModel;

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
@Component("invoiceTransactionModelToInvoiceTransactionConverter")
public class InvoiceTransactionModelToInvoiceTransactionConverter implements Converter<InvoiceTransactionModel, InvoiceTransaction> {
    @Autowired
    private ObjectFactory<InvoiceTransaction> invoiceTransactionFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceTransaction convert(final InvoiceTransactionModel source) {
        InvoiceTransaction invoiceTransaction = invoiceTransactionFactory.getObject();
        BeanUtils.copyProperties(source, invoiceTransaction);

        return invoiceTransaction;
    }

    @Autowired
    public void setInvoiceTransactionFactory(final ObjectFactory<InvoiceTransaction> invoiceTransactionFactory) {
        this.invoiceTransactionFactory = invoiceTransactionFactory;
    }

}
