/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.InvoiceModel;
import com.meat.model.InvoiceStatusCodesModel;
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
@Component("invoiceRepresentationToInvoiceModelConverter")
public class InvoiceRepresentationToInvoiceModelConverter extends PropertyCopyingConverter<InvoiceRepresentation, InvoiceModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public InvoiceModel convert(final InvoiceRepresentation source) {

        InvoiceModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getInvoiceStatusCodeRep())) {
            List<InvoiceStatusCodesModel> converted = (List<InvoiceStatusCodesModel>) conversionService.convert(
                    source.getInvoiceStatusCodeRep(), TypeDescriptor.forObject(source.getInvoiceStatusCodeRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceStatusCodesModel.class));
            target.getInvoiceStatusCodeModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<InvoiceModel> factory) {
        super.setFactory(factory);
    }

}
