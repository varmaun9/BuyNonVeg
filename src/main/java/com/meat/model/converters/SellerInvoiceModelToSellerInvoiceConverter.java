/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.SellerInvoiceModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerInvoiceModelToSellerInvoiceConverter")
public class SellerInvoiceModelToSellerInvoiceConverter implements Converter<SellerInvoiceModel, SellerInvoice> {
    @Autowired
    private ObjectFactory<SellerInvoice> sellerInvoiceFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerInvoice convert(final SellerInvoiceModel source) {
        SellerInvoice sellerInvoice = sellerInvoiceFactory.getObject();
        BeanUtils.copyProperties(source, sellerInvoice);

        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactionModels())) {
            List<InvoiceTransaction> converted = (List<InvoiceTransaction>) conversionService.convert(source.getInvoiceTransactionModels(),
                    TypeDescriptor.forObject(source.getInvoiceTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransaction.class));
            sellerInvoice.getInvoiceTransactions().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getReceiptModels())) {
            List<Receipt> converted = (List<Receipt>) conversionService.convert(source.getReceiptModels(),
                    TypeDescriptor.forObject(source.getReceiptModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Receipt.class));
            sellerInvoice.getReceipts().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getMeatInvoiceModels())) {
            List<MeatInvoice> converted = (List<MeatInvoice>) conversionService.convert(source.getMeatInvoiceModels(),
                    TypeDescriptor.forObject(source.getMeatInvoiceModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), MeatInvoice.class));
            sellerInvoice.getMeatInvoices().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrder> converted = (List<SubOrder>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrder.class));
            sellerInvoice.getSubOrders().addAll(converted);
        }

        return sellerInvoice;
    }

    @Autowired
    public void setSellerInvoiceFactory(final ObjectFactory<SellerInvoice> sellerInvoiceFactory) {
        this.sellerInvoiceFactory = sellerInvoiceFactory;
    }

}
