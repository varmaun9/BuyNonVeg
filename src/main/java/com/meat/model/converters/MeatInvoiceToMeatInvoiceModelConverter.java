/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.MeatInvoice;
import com.meat.model.InvoiceTransactionModel;
import com.meat.model.MeatInvoiceModel;
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
@Component("meatInvoiceToMeatInvoiceModelConverter")
public class MeatInvoiceToMeatInvoiceModelConverter implements Converter<MeatInvoice, MeatInvoiceModel> {

    private static final Logger LOGGER = Logger.getLogger(MeatInvoiceToMeatInvoiceModelConverter.class);
    @Autowired
    private ObjectFactory<MeatInvoiceModel> meatInvoiceModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public MeatInvoiceModel convert(final MeatInvoice source) {
        // TODO Auto-generated method stub
        MeatInvoiceModel meatInvoiceModel = meatInvoiceModelFactory.getObject();

        BeanUtils.copyProperties(source, meatInvoiceModel);

        if (CollectionUtils.isNotEmpty(source.getInvoiceTransactions())) {
            List<InvoiceTransactionModel> converted = (List<InvoiceTransactionModel>) conversionService.convert(
                    source.getInvoiceTransactions(), TypeDescriptor.forObject(source.getInvoiceTransactions()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceTransactionModel.class));
            meatInvoiceModel.getInvoiceTransactionModels().addAll(converted);
        }

        return meatInvoiceModel;

    }

    @Autowired
    public void setMeatInvoiceFactory(final ObjectFactory<MeatInvoiceModel> meatInvoiceModelFactory) {
        this.meatInvoiceModelFactory = meatInvoiceModelFactory;
    }

}
