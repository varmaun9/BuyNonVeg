/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemPieceTypeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerItemPieceTypeRepresentationToSellerItemPieceTypeModelConverter ")
public class SellerItemPieceTypeRepresentationToSellerItemPieceTypeModelConverter
        extends PropertyCopyingConverter<SellerItemPieceTypeRepresentation, SellerItemPieceTypeModel> {

    @Override
    public SellerItemPieceTypeModel convert(final SellerItemPieceTypeRepresentation source) {

        SellerItemPieceTypeModel target = super.convert(source);

        return target;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemPieceTypeModel> factory) {
        super.setFactory(factory);
    }
}
