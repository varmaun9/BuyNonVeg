package com.meat.model.converters;

import com.meat.domain.SellerBranch;
import com.meat.model.*;
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

@Component("sellerBranchToSellerBranchModelConverter")
public class SellerBranchToSellerBranchModelConverter implements Converter<SellerBranch, SellerBranchModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerBranchToSellerBranchModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchModel> sellerBranchModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchModel convert(final SellerBranch source) {
        // TODO Auto-generated method stub
        SellerBranchModel sellerBranchModel = sellerBranchModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerBranchModel);
        if (source.getDeliveryCharges() != null) {
            sellerBranchModel.setDeliveryCharges(source.getDeliveryCharges().toString());
        }
        if (source.getMinimumOrderDeliveryAmount() != null) {
            sellerBranchModel.setMinimunOrderDeliveryAmount(source.getMinimumOrderDeliveryAmount().toString());
        }
        if (source.getMinimumOrderAmount() != null) {
            sellerBranchModel.setMinimumOrderAmount(source.getMinimumOrderAmount().toString());
        }
        if (source.getDeliveryCutoffDays() != null) {
            sellerBranchModel.setDeliveryCutoffDays(source.getDeliveryCutoffDays().toString());
        }

        if (source.getSeller() != null) {
            sellerBranchModel.setSellerId(source.getSeller().getId());
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchCharges())) {
            List<SellerBranchChargesModel> converted = (List<SellerBranchChargesModel>) conversionService.convert(
                    source.getSellerBranchCharges(), TypeDescriptor.forObject(source.getSellerBranchCharges()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchChargesModel.class));
            sellerBranchModel.getSellerBranchChargesModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddresses())) {
            List<SellerBranchAddressModel> converted = (List<SellerBranchAddressModel>) conversionService.convert(
                    source.getSellerBranchAddresses(), TypeDescriptor.forObject(source.getSellerBranchAddresses()),

                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchAddressModel.class));
            sellerBranchModel.getSellerBranchAddressModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchZones())) {
            List<SellerBranchZoneModel> converted = (List<SellerBranchZoneModel>) conversionService.convert(source.getSellerBranchZones(),
                    TypeDescriptor.forObject(source.getSellerBranchZones()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneModel.class));
            sellerBranchModel.getSellerBranchZoneModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchImageses())) {
            List<SellerBranchImagesModel> converted = (List<SellerBranchImagesModel>) conversionService.convert(
                    source.getSellerBranchImageses(), TypeDescriptor.forObject(source.getSellerBranchImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchImagesModel.class));
            sellerBranchModel.getSellerBranchImagesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItems())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItems(),
                    TypeDescriptor.forObject(source.getSellerItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            sellerBranchModel.getSellerItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingses())) {
            List<SellerBranchTimingsModel> converted = (List<SellerBranchTimingsModel>) conversionService.convert(
                    source.getSellerBranchTimingses(), TypeDescriptor.forObject(source.getSellerBranchTimingses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsModel.class));
            sellerBranchModel.getSellerBranchTimingsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxes())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxes(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            sellerBranchModel.getSellerBranchTaxModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrders())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrders(),
                    TypeDescriptor.forObject(source.getSubOrders()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            sellerBranchModel.getSubOrderModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAccounts())) {
            List<AccountModel> converted = (List<AccountModel>) conversionService.convert(source.getAccounts(),
                    TypeDescriptor.forObject(source.getAccounts()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AccountModel.class));
            sellerBranchModel.getAccountModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigs())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigs(),
                    TypeDescriptor.forObject(source.getOfferConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            sellerBranchModel.getOfferConfigModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigs())) {
            List<OfferExcludeConfigModel> converted = (List<OfferExcludeConfigModel>) conversionService.convert(
                    source.getOfferExcludeConfigs(), TypeDescriptor.forObject(source.getOfferExcludeConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfigModel.class));
            sellerBranchModel.getOfferExcludeConfigModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBankAccounts())) {
            List<SellerBankAccountModel> converted = (List<SellerBankAccountModel>) conversionService.convert(
                    source.getSellerBankAccounts(), TypeDescriptor.forObject(source.getSellerBankAccounts()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBankAccountModel.class));
            sellerBranchModel.getSellerBankAccountModels().addAll(converted);
        }

        return sellerBranchModel;

    }

    @Autowired
    public void setSellerBranchFactory(final ObjectFactory<SellerBranchModel> sellerBranchModelFactory) {
        this.sellerBranchModelFactory = sellerBranchModelFactory;
    }

}
