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
@Component("invoiceTransactionRepresentationToInvoiceTransactionModelConverter")
public class InvoiceTransactionRepresentationToInvoiceTransactionModelConverter extends
        PropertyCopyingConverter<InvoiceTransactionRepresentation, InvoiceTransactionModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceTransactionModel convert(final InvoiceTransactionRepresentation source) {

        InvoiceTransactionModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceTransactionModel> factory) {
        super.setFactory(factory);
    }

}
