/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerItemPieceType;
import com.meat.model.SellerItemPieceTypeModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerItemPieceTypeToSellerItemPieceTypeModelConverter")
public class SellerItemPieceTypeToSellerItemPieceTypeModelConverter implements Converter<SellerItemPieceType, SellerItemPieceTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerItemPieceTypeToSellerItemPieceTypeModelConverter.class);
    @Autowired
    private ObjectFactory<SellerItemPieceTypeModel> sellerItemPieceTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerItemPieceTypeModel convert(final SellerItemPieceType source) {
        // TODO Auto-generated method stub
        SellerItemPieceTypeModel sellerItemPieceTypeModel = sellerItemPieceTypeModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemPieceTypeModel);

        return sellerItemPieceTypeModel;

    }

    @Autowired
    public void setSellerItemPieceTypeFactory(final ObjectFactory<SellerItemPieceTypeModel> sellerItemPieceTypeModelFactory) {
        this.sellerItemPieceTypeModelFactory = sellerItemPieceTypeModelFactory;
    }
}
