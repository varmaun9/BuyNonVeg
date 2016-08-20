/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerItemPieceType;
import com.meat.model.SellerItemPieceTypeModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

/**
 * @author varma
 *
 */
public class SellerItemPieceTypeModelToSellerItemPieceTypeConverter implements Converter<SellerItemPieceTypeModel, SellerItemPieceType> {
    @Autowired
    private ObjectFactory<SellerItemPieceType> sellerItemPieceTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemPieceType convert(final SellerItemPieceTypeModel source) {
        SellerItemPieceType sellerItemPieceType = sellerItemPieceTypeFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemPieceType);
        return sellerItemPieceType;
    }

    @Autowired
    public void setSellerItemPieceTypeFactory(final ObjectFactory<SellerItemPieceType> sellerItemPieceTypeFactory) {
        this.sellerItemPieceTypeFactory = sellerItemPieceTypeFactory;
    }
}
