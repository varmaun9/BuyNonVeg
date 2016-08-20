/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Invoice;
import com.meat.model.InvoiceModel;
import com.meat.model.InvoiceStatusCodesModel;
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
@Component("invoiceToInvoiceModelConverter")
public class InvoiceToInvoiceModelConverter implements Converter<Invoice, InvoiceModel> {

    private static final Logger LOGGER = Logger.getLogger(InvoiceToInvoiceModelConverter.class);
    @Autowired
    private ObjectFactory<InvoiceModel> invoiceModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public InvoiceModel convert(final Invoice source) {
        // TODO Auto-generated method stub
        InvoiceModel invoiceModel = invoiceModelFactory.getObject();

        BeanUtils.copyProperties(source, invoiceModel);

        if (CollectionUtils.isNotEmpty(source.getInvoiceStatusCodeses())) {
            List<InvoiceStatusCodesModel> converted = (List<InvoiceStatusCodesModel>) conversionService.convert(
                    source.getInvoiceStatusCodeses(), TypeDescriptor.forObject(source.getInvoiceStatusCodeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceStatusCodesModel.class));
            invoiceModel.getInvoiceStatusCodeModels().addAll(converted);
        }
        return invoiceModel;

    }

    @Autowired
    public void setInvoiceFactory(final ObjectFactory<InvoiceModel> invoiceModelFactory) {
        this.invoiceModelFactory = invoiceModelFactory;
    }

}
