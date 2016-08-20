/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.InvoiceTransactionModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("invoiceTransactionModelToInvoiceTransactionRepresentationConverter")
public class InvoiceTransactionModelToInvoiceTransactionRepresentationConverter extends
        PropertyCopyingConverter<InvoiceTransactionModel, InvoiceTransactionRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceTransactionRepresentation convert(final InvoiceTransactionModel source) {

        InvoiceTransactionRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceTransactionRepresentation> factory) {
        super.setFactory(factory);
    }

}
