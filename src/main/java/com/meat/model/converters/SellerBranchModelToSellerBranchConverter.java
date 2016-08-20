package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.SellerBranchModel;
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

@Component("sellerBranchModelToSellerBranchConverter")
public class SellerBranchModelToSellerBranchConverter implements Converter<SellerBranchModel, SellerBranch> {
    @Autowired
    private ObjectFactory<SellerBranch> sellerBranchFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranch convert(final SellerBranchModel source) {
        SellerBranch sellerBranch = sellerBranchFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranch);

        /* if (CollectionUtils.isNotEmpty(source.getAddressesModels())) {
            List<Address> converted = (List<Address>) conversionService.convert(source.getAddressesModels(),
                    TypeDescriptor.forObject(source.getAddressesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Address.class));
            sellerBranch.getAddresses().addAll(converted);
        }*/

        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressModels())) {
            List<SellerBranchAddress> converted = (List<SellerBranchAddress>) conversionService.convert(
                    source.getSellerBranchAddressModels(), TypeDescriptor.forObject(source.getSellerBranchAddressModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchAddress.class));
            sellerBranch.getSellerBranchAddresses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneModels())) {
            List<SellerBranchZone> converted = (List<SellerBranchZone>) conversionService.convert(source.getSellerBranchZoneModels(),
                    TypeDescriptor.forObject(source.getSellerBranchZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZone.class));
            sellerBranch.getSellerBranchZones().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchImagesModels())) {
            List<SellerBranchImages> converted = (List<SellerBranchImages>) conversionService.convert(source.getSellerBranchImagesModels(),
                    TypeDescriptor.forObject(source.getSellerBranchImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchImages.class));
            sellerBranch.getSellerBranchImageses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsModels())) {
            List<SellerBranchTimings> converted = (List<SellerBranchTimings>) conversionService.convert(
                    source.getSellerBranchTimingsModels(), TypeDescriptor.forObject(source.getSellerBranchTimingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimings.class));
            sellerBranch.getSellerBranchTimingses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItem> converted = (List<SellerItem>) conversionService.convert(source.getSellerItemModels(),
                    TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItem.class));
            sellerBranch.getSellerItems().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxModels())) {
            List<SellerBranchTax> converted = (List<SellerBranchTax>) conversionService.convert(source.getSellerBranchTaxModels(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTax.class));
            sellerBranch.getSellerBranchTaxes().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrder> converted = (List<SubOrder>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrder.class));
            sellerBranch.getSubOrders().addAll(converted);
        }

        return sellerBranch;
    }

    @Autowired
    public void setSellerBranchFactory(final ObjectFactory<SellerBranch> sellerBranchFactory) {
        this.sellerBranchFactory = sellerBranchFactory;
    }

}
