/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTimingsModel;
import com.meat.model.SellerTimingsConfigModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBranchTimingsRepresentationToSellerBranchTimingsModelConverter")
public class SellerBranchTimingsRepresentationToSellerBranchTimingsModelConverter extends
        PropertyCopyingConverter<SellerBranchTimingsRepresentation, SellerBranchTimingsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTimingsModel convert(final SellerBranchTimingsRepresentation source) {

        SellerBranchTimingsModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerTimingsConfigRep())) {
            List<SellerTimingsConfigModel> converted = (List<SellerTimingsConfigModel>) conversionService.convert(
                    source.getSellerTimingsConfigRep(), TypeDescriptor.forObject(source.getSellerTimingsConfigRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerTimingsConfigModel.class));
            target.getSellerTimingsConfigModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchTimingsModel> factory) {
        super.setFactory(factory);
    }

}
