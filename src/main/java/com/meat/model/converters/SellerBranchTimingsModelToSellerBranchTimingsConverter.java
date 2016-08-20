/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchTimings;
import com.meat.domain.SellerTimingsConfig;
import com.meat.model.SellerBranchTimingsModel;
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
@Component("sellerBranchTimingsModelToSellerBranchTimingsConverter")
public class SellerBranchTimingsModelToSellerBranchTimingsConverter implements Converter<SellerBranchTimingsModel, SellerBranchTimings> {
    @Autowired
    private ObjectFactory<SellerBranchTimings> sellerBranchTimingsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTimings convert(final SellerBranchTimingsModel source) {
        SellerBranchTimings sellerBranchTimings = sellerBranchTimingsFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchTimings);

        if (CollectionUtils.isNotEmpty(source.getSellerTimingsConfigModels())) {
            List<SellerTimingsConfig> converted = (List<SellerTimingsConfig>) conversionService.convert(
                    source.getSellerTimingsConfigModels(), TypeDescriptor.forObject(source.getSellerTimingsConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerTimingsConfig.class));
            sellerBranchTimings.getSellerTimingsConfigs().addAll(converted);
        }

        return sellerBranchTimings;
    }

    @Autowired
    public void setSellerBranchTimingsFactory(final ObjectFactory<SellerBranchTimings> sellerBranchTimingsFactory) {
        this.sellerBranchTimingsFactory = sellerBranchTimingsFactory;
    }

}
