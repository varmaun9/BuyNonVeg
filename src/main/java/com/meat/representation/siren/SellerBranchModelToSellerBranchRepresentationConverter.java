/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchModel;
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
@Component("sellerBranchModelToSellerBranchRepresentationConverter")
public class SellerBranchModelToSellerBranchRepresentationConverter
        extends PropertyCopyingConverter<SellerBranchModel, SellerBranchRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchRepresentation convert(final SellerBranchModel source) {

        SellerBranchRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressModels())) {
            List<SellerBranchAddressRepresentation> converted = (List<SellerBranchAddressRepresentation>) conversionService.convert(
                    source.getSellerBranchAddressModels(), TypeDescriptor.forObject(source.getSellerBranchAddressModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchAddressRepresentation.class));
            target.getSellerBranchAddressRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneModels())) {
            List<SellerBranchZoneRepresentation> converted = (List<SellerBranchZoneRepresentation>) conversionService.convert(
                    source.getSellerBranchZoneModels(), TypeDescriptor.forObject(source.getSellerBranchZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneRepresentation.class));
            target.getSellerBranchZoneRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchImagesModels())) {
            List<SellerBranchImagesRepresentation> converted = (List<SellerBranchImagesRepresentation>) conversionService.convert(
                    source.getSellerBranchImagesModels(), TypeDescriptor.forObject(source.getSellerBranchImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchImagesRepresentation.class));
            target.getSellerBranchImagesRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsModels())) {
            List<SellerBranchTimingsRepresentation> converted = (List<SellerBranchTimingsRepresentation>) conversionService.convert(
                    source.getSellerBranchTimingsModels(), TypeDescriptor.forObject(source.getSellerBranchTimingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsRepresentation.class));
            target.getSellerBranchTimingsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItemRepresentation> converted = (List<SellerItemRepresentation>) conversionService.convert(
                    source.getSellerItemModels(), TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemRepresentation.class));
            target.getSellerItemRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxModels())) {
            List<SellerBranchTaxRepresentation> converted = (List<SellerBranchTaxRepresentation>) conversionService.convert(
                    source.getSellerBranchTaxModels(), TypeDescriptor.forObject(source.getSellerBranchTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxRepresentation.class));
            target.getSellerBranchTaxRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchChargesModels())) {
            List<SellerBranchChargesRepresentation> converted = (List<SellerBranchChargesRepresentation>) conversionService.convert(
                    source.getSellerBranchChargesModels(), TypeDescriptor.forObject(source.getSellerBranchChargesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchChargesRepresentation.class));
            target.getSellerBranchChargesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrderRepresentation> converted = (List<SubOrderRepresentation>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderRepresentation.class));
            target.getSubOrderRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchRepresentation> factory) {
        super.setFactory(factory);
    }
}
