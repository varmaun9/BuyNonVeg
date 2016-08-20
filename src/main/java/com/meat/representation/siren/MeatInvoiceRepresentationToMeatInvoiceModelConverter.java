/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.InvoiceTransactionModel;
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
@Component("meatInvoiceRepresentationToMeatInvoiceModelConverter")
public class MeatInvoiceRepresentationToMeatInvoiceModelConverter extends
PropertyCopyingConverter<MeatInvoiceRepresentation, MeatInvoiceModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public MeatInvoiceModel convert(final MeatInvoiceRepresentation source) {

        MeatInvoiceModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactionRep())) {
            List<InvoiceTransactionModel> converted = (List<InvoiceTransactionModel>) conversionService.convert(
                    source.getInvoiceTransactionRep(), TypeDescriptor.forObject(source.getInvoiceTransactionRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransactionModel.class));
            target.getInvoiceTransactionModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<MeatInvoiceModel> factory) {
        super.setFactory(factory);
    }

}
