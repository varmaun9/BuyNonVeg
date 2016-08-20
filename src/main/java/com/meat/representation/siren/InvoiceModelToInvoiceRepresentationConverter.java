/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.InvoiceModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("invoiceModelToInvoiceRepresentationConverter")
public class InvoiceModelToInvoiceRepresentationConverter extends PropertyCopyingConverter<InvoiceModel, InvoiceRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceRepresentation convert(final InvoiceModel source) {

        InvoiceRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getInvoiceStatusCodeModels())) {
            List<InvoiceStatusCodesRepresentation> converted = (List<InvoiceStatusCodesRepresentation>) conversionService.convert(
                    source.getInvoiceStatusCodeModels(), TypeDescriptor.forObject(source.getInvoiceStatusCodeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceStatusCodesRepresentation.class));
            target.getInvoiceStatusCodeRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceRepresentation> factory) {
        super.setFactory(factory);
    }

}
