/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.PieceType;
import com.meat.domain.SellerItem;
import com.meat.domain.SellerItemPieceType;
import com.meat.model.SellerItemPieceTypeModel;
import com.meat.service.ISellerItemPieceTypeService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class SellerItemPieceTypeBusinessDelegate
        implements IBusinessDelegate<SellerItemPieceTypeModel, SellerItemPieceTypeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerItemPieceTypeService sellerItemPieceTypeService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemPieceTypeModel create(final SellerItemPieceTypeModel model) {
        SellerItemPieceType sipt = new SellerItemPieceType();
        sipt.setMinQuantity(Integer.parseInt(model.getMinQuantity()));
        PieceType pieceType = new PieceType();
        pieceType.setId(model.getPieceTypeId());
        sipt.setPieceType(pieceType);
        sipt.setPieceCount(Integer.parseInt(model.getPieceCount()));
        sipt.setDescription(model.getDescription());
        SellerItem si = new SellerItem();
        si.setId(model.getSellerItemId());
        sipt.setSellerItem(si);
        sipt.setStatus(model.getStatus());
        sipt.setCreatedDate(new Date());
        sipt = sellerItemPieceTypeService.create(sipt);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerItemPieceTypeContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemPieceTypeModel edit(final IKeyBuilder<String> keyBuilder, final SellerItemPieceTypeModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerItemPieceTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerItemPieceTypeContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerItemPieceTypeModel> getCollection(final SellerItemPieceTypeContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
