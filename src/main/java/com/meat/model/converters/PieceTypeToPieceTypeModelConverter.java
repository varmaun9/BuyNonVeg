/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Offer;
import com.meat.domain.PieceType;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("pieceTypeToPieceTypeModelConverter")
public class PieceTypeToPieceTypeModelConverter implements Converter<PieceType, PieceTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(PieceTypeToPieceTypeModelConverter.class);
    @Autowired
    private ObjectFactory<PieceTypeModel> pieceTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public PieceTypeModel convert(final PieceType source) {
        // TODO Auto-generated method stub
    	PieceTypeModel pieceTypeModel = pieceTypeModelFactory.getObject();
        BeanUtils.copyProperties(source, pieceTypeModel);

        if (CollectionUtils.isNotEmpty(source.getSellerItemPieceTypes())) {
            List<SellerItemPieceTypeModel> converted = (List<SellerItemPieceTypeModel>) conversionService.convert(
                    source.getSellerItemPieceTypes(), TypeDescriptor.forObject(source.getSellerItemPieceTypes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemPieceTypeModel.class));
            pieceTypeModel.getSellerItemPieceTypeModels().addAll(converted);
        }

        return pieceTypeModel;

    }

    @Autowired
    public void setPieceTypeFactory(final ObjectFactory<PieceTypeModel> pieceTypeModelFactory) {
        this.pieceTypeModelFactory = pieceTypeModelFactory;
    }
}
