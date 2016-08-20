/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.InvoiceTransaction;
import com.meat.domain.MeatInvoice;
import com.meat.model.MeatInvoiceModel;
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
@Component("meatInvoiceModelToMeatInvoiceConverter")
public class MeatInvoiceModelToMeatInvoiceConverter implements Converter<MeatInvoiceModel, MeatInvoice> {
    @Autowired
    private ObjectFactory<MeatInvoice> meatInvoiceFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public MeatInvoice convert(final MeatInvoiceModel source) {
        MeatInvoice meatInvoice = meatInvoiceFactory.getObject();
        BeanUtils.copyProperties(source, meatInvoice);

        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactionModels())) {
            List<InvoiceTransaction> converted = (List<InvoiceTransaction>) conversionService.convert(source.getInvoiceTransactionModels(),
                    TypeDescriptor.forObject(source.getInvoiceTransactionModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransaction.class));
            meatInvoice.getInvoiceTransactions().addAll(converted);
        }

        return meatInvoice;
    }

    @Autowired
    public void setMeatInvoiceFactory(final ObjectFactory<MeatInvoice> meatInvoiceFactory) {
        this.meatInvoiceFactory = meatInvoiceFactory;
    }

}
