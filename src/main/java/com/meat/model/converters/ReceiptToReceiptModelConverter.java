/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Receipt;
import com.meat.model.ReceiptModel;

import org.apache.log4j.Logger;
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
@Component("receiptToReceiptModelConverter")
public class ReceiptToReceiptModelConverter implements Converter<Receipt, ReceiptModel> {

    private static final Logger LOGGER = Logger.getLogger(ReceiptToReceiptModelConverter.class);
    @Autowired
    private ObjectFactory<ReceiptModel> receiptModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ReceiptModel convert(final Receipt source) {
        // TODO Auto-generated method stub
        ReceiptModel receiptModel = receiptModelFactory.getObject();

        BeanUtils.copyProperties(source, receiptModel);

        return receiptModel;

    }

    @Autowired
    public void setReceiptFactory(final ObjectFactory<ReceiptModel> receiptModelFactory) {
        this.receiptModelFactory = receiptModelFactory;
    }

}
