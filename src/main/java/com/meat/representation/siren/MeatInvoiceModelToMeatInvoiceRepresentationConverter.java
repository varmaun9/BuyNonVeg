/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.MeatInvoiceModel;
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
@Component("meatInvoiceModelToMeatInvoiceRepresentationConverter")
public class MeatInvoiceModelToMeatInvoiceRepresentationConverter extends
        PropertyCopyingConverter<MeatInvoiceModel, MeatInvoiceRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public MeatInvoiceRepresentation convert(final MeatInvoiceModel source) {

        MeatInvoiceRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactionModels())) {
            List<InvoiceTransactionRepresentation> converted = (List<InvoiceTransactionRepresentation>) conversionService.convert(
                    source.getInvoiceTransactionModels(), TypeDescriptor.forObject(source.getInvoiceTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransactionRepresentation.class));
            target.getInvoiceTransactionRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<MeatInvoiceRepresentation> factory) {
        super.setFactory(factory);
    }

}
