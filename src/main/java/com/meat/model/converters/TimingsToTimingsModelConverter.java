/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Timings;
import com.meat.model.SellerBranchTimingsModel;
import com.meat.model.SubOrderModel;
import com.meat.model.TimingsModel;
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
 * @author arthvedi
 *
 */
@Component("timingsToTimingsModelConverter")
public class TimingsToTimingsModelConverter implements Converter<Timings, TimingsModel> {

    @Autowired
    private ObjectFactory<TimingsModel> timingsModelFactory;
    private static final Logger LOGGER = Logger.getLogger(TimingsToTimingsModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public TimingsModel convert(final Timings source) {
        // TODO Auto-generated method stub
        TimingsModel timingsModel = timingsModelFactory.getObject();

        BeanUtils.copyProperties(source, timingsModel);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingses())) {
            List<SellerBranchTimingsModel> converted = (List<SellerBranchTimingsModel>) conversionService.convert(
                    source.getSellerBranchTimingses(), TypeDescriptor.forObject(source.getSellerBranchTimingses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsModel.class));
            timingsModel.getSellerBranchTimingsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrders())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrders(),
                    TypeDescriptor.forObject(source.getSubOrders()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            timingsModel.getSubOrderModels().addAll(converted);
        }

        return timingsModel;

    }

    @Autowired
    public void setTimingsFactory(final ObjectFactory<TimingsModel> timingsModelFactory) {
        this.timingsModelFactory = timingsModelFactory;
    }

}
