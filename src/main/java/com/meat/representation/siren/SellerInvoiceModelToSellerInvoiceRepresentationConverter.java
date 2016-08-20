/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerInvoiceModel;
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
@Component("sellerInvoiceModelToSellerInvoiceRepresentationConverter")
public class SellerInvoiceModelToSellerInvoiceRepresentationConverter extends
PropertyCopyingConverter<SellerInvoiceModel, SellerInvoiceRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerInvoiceRepresentation convert(final SellerInvoiceModel source) {

        SellerInvoiceRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getReceiptModels())) {
            List<ReceiptRepresentation> converted = (List<ReceiptRepresentation>) conversionService.convert(source.getReceiptModels(),
                    TypeDescriptor.forObject(source.getReceiptModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ReceiptRepresentation.class));
            target.getReceiptRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactionModels())) {
            List<InvoiceTransactionRepresentation> converted = (List<InvoiceTransactionRepresentation>) conversionService.convert(
                    source.getInvoiceTransactionModels(), TypeDescriptor.forObject(source.getInvoiceTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransactionRepresentation.class));
            target.getInvoiceTransactionRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrderRepresentation> converted = (List<SubOrderRepresentation>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderRepresentation.class));
            target.getSubOrderRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getMeatInvoiceModels())) {
            List<MeatInvoiceRepresentation> converted = (List<MeatInvoiceRepresentation>) conversionService.convert(
                    source.getMeatInvoiceModels(), TypeDescriptor.forObject(source.getMeatInvoiceModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), MeatInvoiceRepresentation.class));
            target.getMeatInvoiceRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerInvoiceRepresentation> factory) {
        super.setFactory(factory);
    }

}
