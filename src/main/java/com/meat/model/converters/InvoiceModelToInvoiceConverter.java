/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Invoice;
import com.meat.domain.InvoiceStatusCodes;
import com.meat.model.InvoiceModel;
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
@Component("invoiceModelToInvoiceConverter")
public class InvoiceModelToInvoiceConverter implements Converter<InvoiceModel, Invoice> {
    @Autowired
    private ObjectFactory<Invoice> invoiceFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Invoice convert(final InvoiceModel source) {
        Invoice invoice = invoiceFactory.getObject();
        BeanUtils.copyProperties(source, invoice);

        if (CollectionUtils.isNotEmpty(source.getInvoiceStatusCodeModels())) {
            List<InvoiceStatusCodes> converted = (List<InvoiceStatusCodes>) conversionService.convert(source.getInvoiceStatusCodeModels(),
                    TypeDescriptor.forObject(source.getInvoiceStatusCodeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), InvoiceStatusCodes.class));
            invoice.getInvoiceStatusCodeses().addAll(converted);
        }
        return invoice;
    }

    @Autowired
    public void setInvoiceFactory(final ObjectFactory<Invoice> invoiceFactory) {
        this.invoiceFactory = invoiceFactory;
    }

}
