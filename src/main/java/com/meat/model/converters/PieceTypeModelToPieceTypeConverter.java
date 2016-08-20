/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.PieceType;
import com.meat.domain.SellerItemPieceType;
import com.meat.model.PieceTypeModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
@Component("pieceTypeModelToPieceTypeConverter")
public class PieceTypeModelToPieceTypeConverter implements Converter<PieceTypeModel, PieceType> {
    @Autowired
    private ObjectFactory<PieceType> pieceTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PieceType convert(final PieceTypeModel source) {
        PieceType pieceType = pieceTypeFactory.getObject();
        BeanUtils.copyProperties(source, pieceType);

        if (CollectionUtils.isNotEmpty(source.getSellerItemPieceTypeModels())) {
            List<SellerItemPieceType> converted = (List<SellerItemPieceType>) conversionService.convert(
                    source.getSellerItemPieceTypeModels(), TypeDescriptor.forObject(source.getSellerItemPieceTypeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemPieceType.class));
            pieceType.getSellerItemPieceTypes().addAll(converted);
        }

        return pieceType;
    }

    @Autowired
    public void setPieceTypeFactory(final ObjectFactory<PieceType> pieceTypeFactory) {
        this.pieceTypeFactory = pieceTypeFactory;
    }

}
