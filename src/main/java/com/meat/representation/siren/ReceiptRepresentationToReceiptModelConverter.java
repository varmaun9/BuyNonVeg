/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ReceiptModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("receiptRepresentationToReceiptModelConverter")
public class ReceiptRepresentationToReceiptModelConverter extends PropertyCopyingConverter<ReceiptRepresentation, ReceiptModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ReceiptModel convert(final ReceiptRepresentation source) {

        ReceiptModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ReceiptModel> factory) {
        super.setFactory(factory);
    }

}
