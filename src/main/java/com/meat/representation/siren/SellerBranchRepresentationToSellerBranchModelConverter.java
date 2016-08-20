/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
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
 * @author Dilli
 *
 */
@Component("sellerBranchRepresentationToSellerBranchModelConverter")
public class SellerBranchRepresentationToSellerBranchModelConverter
        extends PropertyCopyingConverter<SellerBranchRepresentation, SellerBranchModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchModel convert(final SellerBranchRepresentation source) {

        SellerBranchModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressRep())) {
            List<SellerBranchAddressModel> converted = (List<SellerBranchAddressModel>) conversionService.convert(
                    source.getSellerBranchAddressRep(), TypeDescriptor.forObject(source.getSellerBranchAddressRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchAddressModel.class));
            target.getSellerBranchAddressModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneRep())) {
            List<SellerBranchZoneModel> converted = (List<SellerBranchZoneModel>) conversionService.convert(source.getSellerBranchZoneRep(),
                    TypeDescriptor.forObject(source.getSellerBranchZoneRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneModel.class));
            target.getSellerBranchZoneModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchImagesRep())) {
            List<SellerBranchImagesModel> converted = (List<SellerBranchImagesModel>) conversionService.convert(
                    source.getSellerBranchImagesRep(), TypeDescriptor.forObject(source.getSellerBranchImagesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchImagesModel.class));
            target.getSellerBranchImagesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsRep())) {
            List<SellerBranchTimingsModel> converted = (List<SellerBranchTimingsModel>) conversionService.convert(
                    source.getSellerBranchTimingsRep(), TypeDescriptor.forObject(source.getSellerBranchTimingsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsModel.class));
            target.getSellerBranchTimingsModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemRep())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItemRep(),
                    TypeDescriptor.forObject(source.getSellerItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            target.getSellerItemModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxRep())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxRep(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            target.getSellerBranchTaxModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderRep())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrderRep(),
                    TypeDescriptor.forObject(source.getSubOrderRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            target.getSubOrderModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchModel> factory) {
        super.setFactory(factory);
    }
}
