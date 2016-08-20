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
@Component("invoiceStatusCodesModelToInvoiceStatusCodesRepresentationConverter")
public class InvoiceStatusCodesModelToInvoiceStatusCodesRepresentationConverter extends
        PropertyCopyingConverter<InvoiceStatusCodesModel, InvoiceStatusCodesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceStatusCodesRepresentation convert(final InvoiceStatusCodesModel source) {

        InvoiceStatusCodesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceStatusCodesRepresentation> factory) {
        super.setFactory(factory);
    }

}
