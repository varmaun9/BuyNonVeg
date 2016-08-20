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
@Component("receiptModelToReceiptRepresentationConverter")
public class ReceiptModelToReceiptRepresentationConverter extends PropertyCopyingConverter<ReceiptModel, ReceiptRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ReceiptRepresentation convert(final ReceiptModel source) {

        ReceiptRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ReceiptRepresentation> factory) {
        super.setFactory(factory);
    }

}
