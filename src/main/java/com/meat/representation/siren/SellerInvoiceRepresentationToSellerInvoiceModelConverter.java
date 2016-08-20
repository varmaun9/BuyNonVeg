/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
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
@Component("sellerInvoiceRepresentationToSellerInvoiceModelConverter")
public class SellerInvoiceRepresentationToSellerInvoiceModelConverter extends
PropertyCopyingConverter<SellerInvoiceRepresentation, SellerInvoiceModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerInvoiceModel convert(final SellerInvoiceRepresentation source) {

        SellerInvoiceModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getReceiptRep())) {
            List<ReceiptModel> converted = (List<ReceiptModel>) conversionService.convert(source.getReceiptRep(),
                    TypeDescriptor.forObject(source.getReceiptRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ReceiptModel.class));
            target.getReceiptModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getMeatInvoiceRep())) {
            List<MeatInvoiceModel> converted = (List<MeatInvoiceModel>) conversionService.convert(source.getMeatInvoiceRep(),
                    TypeDescriptor.forObject(source.getMeatInvoiceRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), MeatInvoiceModel.class));
            target.getMeatInvoiceModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderRep())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrderRep(),
                    TypeDescriptor.forObject(source.getSubOrderRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            target.getSubOrderModels().addAll(converted);
        }

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
    public void setFactory(final ObjectFactory<SellerInvoiceModel> factory) {
        super.setFactory(factory);
    }

}
