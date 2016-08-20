/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Receipt;
import com.meat.model.ReceiptModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("receiptModelToReceiptConverter")
public class ReceiptModelToReceiptConverter implements Converter<ReceiptModel, Receipt> {
    @Autowired
    private ObjectFactory<Receipt> receiptFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Receipt convert(final ReceiptModel source) {
        Receipt receipt = receiptFactory.getObject();
        BeanUtils.copyProperties(source, receipt);

        return receipt;
    }

    @Autowired
    public void setReceiptFactory(final ObjectFactory<Receipt> receiptFactory) {
        this.receiptFactory = receiptFactory;
    }

}
