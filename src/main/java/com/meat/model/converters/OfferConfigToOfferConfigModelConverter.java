/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OfferConfig;
import com.meat.model.OfferConfigModel;
import com.meat.model.UsersOfferModel;
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
@Component("offerConfigToOfferConfigModelConverter")
public class OfferConfigToOfferConfigModelConverter implements Converter<OfferConfig, OfferConfigModel> {

    private static final Logger LOGGER = Logger.getLogger(OfferConfigToOfferConfigModelConverter.class);
    @Autowired
    private ObjectFactory<OfferConfigModel> offerConfigModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OfferConfigModel convert(final OfferConfig source) {
        // TODO Auto-generated method stub
        OfferConfigModel offerConfigModel = offerConfigModelFactory.getObject();

        BeanUtils.copyProperties(source, offerConfigModel);
        offerConfigModel.setOfferId(source.getOffer().getId());
        if (source.getSellerItem() != null) {
            offerConfigModel.setSellerItemId(source.getSellerItem().getId());
        }
        if (CollectionUtils.isNotEmpty(source.getUsersOffers())) {
            List<UsersOfferModel> converted = (List<UsersOfferModel>) conversionService.convert(source.getUsersOffers(),
                    TypeDescriptor.forObject(source.getUsersOffers()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersOfferModel.class));
            offerConfigModel.getUsersOfferModels().addAll(converted);
        }
        /*  if (CollectionUtils.isNotEmpty(source.getUsers())) {
            List<UsersModel> converted = (List<UsersModel>) conversionService.convert(source.getUsers(),
                    TypeDescriptor.forObject(source.getUsers()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersModel.class));
            OfferConfigModel.getUserModels().addAll(converted);
        }*/
        /* if (CollectionUtils.isNotEmpty(source.getSellerBranches())) {
            List<SellerBranchModel> converted = (List<SellerBranchModel>) conversionService.convert(source.getSellerBranches(),
                    TypeDescriptor.forObject(source.getSellerBranches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchModel.class));
            OfferConfigModel.getSellerBranchModels().addAll(converted);
        }*/
        return offerConfigModel;

    }

    @Autowired
    public void setOfferConfigFactory(final ObjectFactory<OfferConfigModel> offerConfigModelFactory) {
        this.offerConfigModelFactory = offerConfigModelFactory;
    }

}
