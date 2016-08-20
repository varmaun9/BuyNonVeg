/**

 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.PieceType;
import com.meat.model.PieceTypeModel;
import com.meat.service.IPieceTypeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
@ImportResource("classpath:spring-thymeleaf.xml")
@PropertySource("classpath:mail.properties")
@PropertySource("classpath:application.properties")
public class PieceTypeBusinessDelegate implements IBusinessDelegate<PieceTypeModel, PieceTypeContext, IKeyBuilder<String>, String> {
    @Autowired
    private IPieceTypeService pieceTypeService;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PieceTypeModel create(final PieceTypeModel model) {
        PieceType pt = new PieceType();
        pt.setPieceName(model.getPieceName());
        pt.setPieceCount(Integer.parseInt(model.getPieceCount()));
        pt.setMinQuantity(Integer.parseInt(model.getMinQuantity()));
        pt.setStatus(model.getStatus());
        pt.setDescription(model.getDescription());
        pt = pieceTypeService.create(pt);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PieceTypeContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public PieceTypeModel edit(final IKeyBuilder<String> keyBuilder, final PieceTypeModel model) {
        PieceType pieceType = pieceTypeService.getPieceType(keyBuilder.build().toString());
        pieceType.setId(model.getId());
        if (model.getPieceName() != null) {
            pieceType.setPieceName(model.getPieceName());
        }
        if (model.getPieceCount() != null) {
            pieceType.setPieceCount(Integer.parseInt(model.getPieceCount()));
        }
        if (model.getMinQuantity() != null) {
            pieceType.setMinQuantity(Integer.parseInt(model.getMinQuantity()));
        }
        pieceType.setStatus(model.getStatus());

        pieceType = pieceTypeService.updatePieceType(pieceType);

        return model;
    }

    @Override
    public PieceTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final PieceTypeContext context) {
        PieceType pieceType = pieceTypeService.getPieceType(keyBuilder.build().toString());
        PieceTypeModel pieceTypeModel = conversionService.convert(pieceType, PieceTypeModel.class);
        return pieceTypeModel;
    }

    @Override
    public Collection<PieceTypeModel> getCollection(final PieceTypeContext context) {
        List<PieceType> pieceType = new ArrayList<PieceType>();

        if (context.getAll() != null) {
            pieceType = pieceTypeService.getAll();
        }

        List<PieceTypeModel> cutTypeModels = (List<PieceTypeModel>) conversionService.convert(pieceType,
                TypeDescriptor.forObject(pieceType), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PieceTypeModel.class)));
        return cutTypeModels;
    }

}
