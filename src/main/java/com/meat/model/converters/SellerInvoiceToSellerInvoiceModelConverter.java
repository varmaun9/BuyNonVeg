/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerInvoice;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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
@Component("sellerInvoiceToSellerInvoiceModelConverter")
public class SellerInvoiceToSellerInvoiceModelConverter implements Converter<SellerInvoice, SellerInvoiceModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerInvoiceToSellerInvoiceModelConverter.class);
    @Autowired
    private ObjectFactory<SellerInvoiceModel> sellerInvoiceModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public SellerInvoiceModel convert(final SellerInvoice source) {
        // TODO Auto-generated method stub
        SellerInvoiceModel sellerInvoiceModel = sellerInvoiceModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerInvoiceModel);

        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactions())) {
            List<InvoiceTransactionModel> converted = (List<InvoiceTransactionModel>) conversionService.convert(
                    source.getInvoiceTransactions(), TypeDescriptor.forObject(source.getInvoiceTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransactionModel.class));
            sellerInvoiceModel.getInvoiceTransactionModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getReceipts())) {
            List<ReceiptModel> converted = (List<ReceiptModel>) conversionService.convert(source.getReceipts(),
                    TypeDescriptor.forObject(source.getReceipts()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ReceiptModel.class));
            sellerInvoiceModel.getReceiptModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getMeatInvoices())) {
            List<MeatInvoiceModel> converted = (List<MeatInvoiceModel>) conversionService.convert(source.getMeatInvoices(),
                    TypeDescriptor.forObject(source.getMeatInvoices()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), MeatInvoiceModel.class));
            sellerInvoiceModel.getMeatInvoiceModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrders())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrders(),
                    TypeDescriptor.forObject(source.getSubOrders()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            sellerInvoiceModel.getSubOrderModels().addAll(converted);
        }

        return sellerInvoiceModel;

    }

    @Autowired
    public void setSellerInvoiceFactory(final ObjectFactory<SellerInvoiceModel> sellerInvoiceModelFactory) {
        this.sellerInvoiceModelFactory = sellerInvoiceModelFactory;
    }

}
