/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchTimings;
import com.meat.domain.SubOrder;
import com.meat.domain.Timings;
import com.meat.model.TimingsModel;
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
 * @author arthvedi
 *
 */
@Component("timingsModelToTimingsConverter")
public class TimingsModelToTimingsConverter implements Converter<TimingsModel, Timings> {
    @Autowired
    private ObjectFactory<Timings> timingsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Timings convert(final TimingsModel source) {
        Timings timings = timingsFactory.getObject();
        BeanUtils.copyProperties(source, timings);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsModels())) {
            List<SellerBranchTimings> converted = (List<SellerBranchTimings>) conversionService.convert(
                    source.getSellerBranchTimingsModels(), TypeDescriptor.forObject(source.getSellerBranchTimingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimings.class));
            timings.getSellerBranchTimingses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrder> converted = (List<SubOrder>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrder.class));
            timings.getSubOrders().addAll(converted);
        }

        return timings;
    }

    @Autowired
    public void setTimingsFactory(final ObjectFactory<Timings> timingsFactory) {
        this.timingsFactory = timingsFactory;
    }

}
