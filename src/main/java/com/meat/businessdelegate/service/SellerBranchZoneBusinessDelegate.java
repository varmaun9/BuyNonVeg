/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchZone;
import com.meat.domain.Zone;
import com.meat.model.SellerBranchZoneModel;
import com.meat.service.ISellerBranchZoneService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class SellerBranchZoneBusinessDelegate
        implements IBusinessDelegate<SellerBranchZoneModel, SellerBranchZoneContext, IKeyBuilder<String>, String> {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISellerBranchZoneService sellerBranchZoneService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchZoneModel create(final SellerBranchZoneModel model) {
        SellerBranchZone sellerBranchZone = new SellerBranchZone();
        sellerBranchZone.setId(model.getId());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchZone.setSellerBranch(sellerBranch);
        Zone zone = new Zone();
        zone.setId(model.getZoneId());
        sellerBranchZone.setZone(zone);
        sellerBranchZone.setStatus(model.getStatus());
        sellerBranchZone.setCreatedDate(new Date());
        sellerBranchZone = sellerBranchZoneService.create(sellerBranchZone);
        model.setId(sellerBranchZone.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchZoneContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchZoneModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchZoneModel model) {
        SellerBranchZone sellerBranchZone = new SellerBranchZone();
        sellerBranchZone.setId(model.getId());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getId());
        sellerBranchZone.setSellerBranch(sellerBranch);
        Zone zone = new Zone();
        zone.setId(model.getId());
        sellerBranchZone.setZone(zone);
        sellerBranchZone.setStatus(model.getStatus());
        sellerBranchZone.setCreatedDate(new Date());
        sellerBranchZone = sellerBranchZoneService.updateSellerBranchZone(sellerBranchZone);
        model.setId(sellerBranchZone.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchZoneModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchZoneContext context) {
        SellerBranchZone sellerBranchZone = sellerBranchZoneService.getSellerBranchZone(keyBuilder.build().toString());
        SellerBranchZoneModel sellerBranchZoneModel = conversionService.convert(sellerBranchZone, SellerBranchZoneModel.class);
        return sellerBranchZoneModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchZoneModel> getCollection(final SellerBranchZoneContext context) {
        List<SellerBranchZone> sellerBranchZone = new ArrayList<SellerBranchZone>();
        if (context.getAll() != null) {
            sellerBranchZone = sellerBranchZoneService.getAll();
        }
        /*  if (context.getSellerBranchOnly() != null) {
            sellerBranch = sellerBranchZoneService.getSellerBranchOnly();
        }*/
        List<SellerBranchZoneModel> slrBranchZoneModels = (List<SellerBranchZoneModel>) conversionService.convert(sellerBranchZone,
                TypeDescriptor.forObject(sellerBranchZone),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchZoneModel.class)));

        return slrBranchZoneModels;
    }

}
