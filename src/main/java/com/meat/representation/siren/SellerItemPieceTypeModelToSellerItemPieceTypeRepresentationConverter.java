/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemPieceTypeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author varma
 *
 */
public class SellerItemPieceTypeModelToSellerItemPieceTypeRepresentationConverter
        extends PropertyCopyingConverter<SellerItemPieceTypeModel, SellerItemPieceTypeRepresentation> {

    @Override
    public SellerItemPieceTypeRepresentation convert(final SellerItemPieceTypeModel source) {
        SellerItemPieceTypeRepresentation target = super.convert(source);

        return target;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemPieceTypeRepresentation> factory) {
        super.setFactory(factory);
    }

}
