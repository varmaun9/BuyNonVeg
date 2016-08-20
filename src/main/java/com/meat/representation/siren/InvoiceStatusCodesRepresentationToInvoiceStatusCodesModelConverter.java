/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.InvoiceStatusCodesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("invoiceStatusCodesRepresentationToInvoiceStatusCodesModelConverter")
public class InvoiceStatusCodesRepresentationToInvoiceStatusCodesModelConverter extends
        PropertyCopyingConverter<InvoiceStatusCodesRepresentation, InvoiceStatusCodesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceStatusCodesModel convert(final InvoiceStatusCodesRepresentation source) {

        InvoiceStatusCodesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceStatusCodesModel> factory) {
        super.setFactory(factory);
    }

}
