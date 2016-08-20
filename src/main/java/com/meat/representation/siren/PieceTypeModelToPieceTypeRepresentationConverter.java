/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.PieceTypeModel;
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
@Component("pieceTypeModelToPieceTypeRepresentationConverter")
public class PieceTypeModelToPieceTypeRepresentationConverter extends PropertyCopyingConverter<PieceTypeModel, PieceTypeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public PieceTypeRepresentation convert(final PieceTypeModel source) {

    	PieceTypeRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<PieceTypeRepresentation> factory) {
        super.setFactory(factory);
    }

}
