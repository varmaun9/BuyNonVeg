/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchTimings;
import com.meat.model.SellerBranchTimingsModel;
import com.meat.model.SellerTimingsConfigModel;
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
@Component("sellerBranchTimingsToSellerBranchTimingsModelConverter")
public class SellerBranchTimingsToSellerBranchTimingsModelConverter implements Converter<SellerBranchTimings, SellerBranchTimingsModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerBranchTimingsToSellerBranchTimingsModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchTimingsModel> sellerBranchTimingsModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchTimingsModel convert(final SellerBranchTimings source) {
        // TODO Auto-generated method stub
        SellerBranchTimingsModel sellerBranchTimingsModel = sellerBranchTimingsModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchTimingsModel);
        if (source.getTimings() != null) {
            sellerBranchTimingsModel.setTimingsId(source.getTimings().getId());
            sellerBranchTimingsModel.setStartTime(source.getTimings().getStartTime());
            sellerBranchTimingsModel.setTimingName(source.getTimings().getTimingName());
            sellerBranchTimingsModel.setEndTime(source.getTimings().getEndTime());
        }
        if (source.getSellerBranch() != null) {
            sellerBranchTimingsModel.setSellerBranchId(source.getSellerBranch().getId());
            sellerBranchTimingsModel.setSellerBranchName(source.getSellerBranch().getBranchName());
            sellerBranchTimingsModel.setSellerName(source.getSellerBranch().getSeller().getSellerName());
        }

        if (CollectionUtils.isNotEmpty(source.getSellerTimingsConfigs())) {
            List<SellerTimingsConfigModel> converted = (List<SellerTimingsConfigModel>) conversionService.convert(
                    source.getSellerTimingsConfigs(), TypeDescriptor.forObject(source.getSellerTimingsConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerTimingsConfigModel.class));
            sellerBranchTimingsModel.getSellerTimingsConfigModels().addAll(converted);
        }
        return sellerBranchTimingsModel;

    }

    @Autowired
    public void setSellerBranchTimingsFactory(final ObjectFactory<SellerBranchTimingsModel> sellerBranchTimingsModelFactory) {
        this.sellerBranchTimingsModelFactory = sellerBranchTimingsModelFactory;
    }

}
