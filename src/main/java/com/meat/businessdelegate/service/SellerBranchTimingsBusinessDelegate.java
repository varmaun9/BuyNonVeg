/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchTimings;
import com.meat.domain.Timings;
import com.meat.model.SellerBranchTimingsModel;
import com.meat.service.ISellerBranchTimingsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SellerBranchTimingsBusinessDelegate
        implements IBusinessDelegate<SellerBranchTimingsModel, SellerBranchTimingsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBranchTimingsService sellerBranchTimingsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchTimingsModel create(final SellerBranchTimingsModel model) {

        SellerBranchTimings sellerBranchTimings = new SellerBranchTimings();
        Timings timings = new Timings();
        timings.setId(model.getTimingsId());
        sellerBranchTimings.setTimings(timings);
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchTimings.setSellerBranch(sellerBranch);
        sellerBranchTimings.setStatus(model.getStatus());
        sellerBranchTimings.setCreatedDate(new Date());
        sellerBranchTimings.setId(model.getId());
        sellerBranchTimings = sellerBranchTimingsService.create(sellerBranchTimings);
        if (sellerBranchTimings.getTimingsStatus() != null) {
            if (sellerBranchTimings.getTimingsStatus().equals("DUPLICATE")) {
                model.setTimingsStatus("DUPLICATE");
                model.setStatus("Timings you assigning are Already Assigned. Please Try Another Timings !");
            }
        }
        model.setId(sellerBranchTimings.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchTimingsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchTimingsModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchTimingsModel model) {
        SellerBranchTimings sbtimings = sellerBranchTimingsService.getSellerBranchTimings(keyBuilder.build().toString());
        SellerBranchTimings sbt = new SellerBranchTimings();
        sbt.setId(model.getId());
        Timings t = new Timings();
        t.setId(model.getTimingsId());
        sbt.setTimings(t);
        sbt.setStatus(model.getStatus());
        sbt.setSellerBranch(sbtimings.getSellerBranch());
        sbt = sellerBranchTimingsService.updateSellerBranchTimings(sbt);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchTimingsModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchTimingsContext context) {
        SellerBranchTimings sellerBranchTimings = sellerBranchTimingsService.getSellerBranchTimings(keyBuilder.build().toString());
        SellerBranchTimingsModel sellerBranchTimingsModel = conversionService.convert(sellerBranchTimings, SellerBranchTimingsModel.class);
        return sellerBranchTimingsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchTimingsModel> getCollection(final SellerBranchTimingsContext context) {
        List<SellerBranchTimings> sellerBranchTimings = new ArrayList<SellerBranchTimings>();
        if (context.getAll() != null) {
            sellerBranchTimings = sellerBranchTimingsService.getAll();
        }
        if (context.getSellerBranchId() != null && context.getAll() != null) {
            sellerBranchTimings = sellerBranchTimingsService.getSellerBranchTimingsBySellerBranch(context.getSellerBranchId());
        }
        List<SellerBranchTimingsModel> slrBranchTimingsModels = (List<SellerBranchTimingsModel>) conversionService.convert(
                sellerBranchTimings, TypeDescriptor.forObject(sellerBranchTimings),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchTimingsModel.class)));
        return slrBranchTimingsModels;
    }
}
