/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Timings;
import com.meat.model.TimingsModel;
import com.meat.service.ITimingsService;

import java.util.ArrayList;
import java.util.Collection;
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
public class TimingsBusinessDelegate implements IBusinessDelegate<TimingsModel, TimingsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ITimingsService timingsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TimingsModel create(final TimingsModel model) {
        Timings timings = new Timings();
        timings.setTimingName(model.getTimingName());
        timings.setStartTime(model.getStartTime());
        timings.setEndTime(model.getEndTime());
        timings.setStatus(model.getStatus());
        timings.setDescription(model.getDescription());
        timings.setStatusFlag(model.getStatusFlag());
        timings = timingsService.create(timings);
        timings.setId(model.getId());

        /*        if (timings.getId() != null) {
                    if (model.getSellerBranchTimingsModels() != null) {
                        Set<SellerBranchTimings> sbTmings = new HashSet<SellerBranchTimings>();
                        for (SellerBranchTimingsModel slrBranchTimingsModels : model.getSellerBranchTimingsModels()) {
                            SellerBranchTimings sbt = new SellerBranchTimings();
                            Timings t = new Timings();
                            t.setId(slrBranchTimingsModels.getId());
                            sbt.setTimings(t);
                            SellerBranch sb = new SellerBranch();
                            sb.setId(slrBranchTimingsModels.getId());
                            sbt.setSellerBranch(sb);
                            sbt.setStatus(slrBranchTimingsModels.getStatus());
                            sbt.setCreatedDate(new Date());
                            sbTmings.add(sbt);
                        }
                        timings = timingsService.addSellerBranchTmings(timings, sbTmings);
                    }
                }*/
        model.setId(timings.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final TimingsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public TimingsModel edit(final IKeyBuilder<String> keyBuilder, final TimingsModel model) {
        Timings timings = timingsService.getTimings(keyBuilder.build().toString());
        timings.setId(model.getId());
        timings.setDescription(model.getDescription());
        timings.setStartTime(model.getStartTime());
        timings.setEndTime(model.getEndTime());
        timings.setStatus(model.getStatus());
        timings.setStatusFlag(model.getStatusFlag());
        timings.setTimingName(model.getTimingName());
        timings = timingsService.updateTimings(timings);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public TimingsModel getByKey(final IKeyBuilder<String> keyBuilder, final TimingsContext context) {
        Timings timings = timingsService.getTimings(keyBuilder.build().toString());
        TimingsModel timingsModel = conversionService.convert(timings, TimingsModel.class);
        return timingsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<TimingsModel> getCollection(final TimingsContext context) {
        List<Timings> timings = new ArrayList<Timings>();
        if (context.getAll() != null) {
            timings = timingsService.getAll();
        }
        if (context.getTimingsOnly() != null && context.getAll() != null) {
            timings = timingsService.getAllTimingsOnly();
        }
        List<TimingsModel> timingsModels = (List<TimingsModel>) conversionService.convert(timings, TypeDescriptor.forObject(timings),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TimingsModel.class)));
        return timingsModels;
    }

}
