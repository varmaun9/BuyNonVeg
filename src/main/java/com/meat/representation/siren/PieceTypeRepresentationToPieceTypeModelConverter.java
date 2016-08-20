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
@Component("pieceTypeRepresentationToPieceTypeModelConverter ")
public class PieceTypeRepresentationToPieceTypeModelConverter extends PropertyCopyingConverter<PieceTypeRepresentation, PieceTypeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public PieceTypeModel convert(final PieceTypeRepresentation source) {

    	PieceTypeModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<PieceTypeModel> factory) {
        super.setFactory(factory);
    }

}
