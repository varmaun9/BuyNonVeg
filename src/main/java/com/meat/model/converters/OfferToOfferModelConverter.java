/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Offer;
import com.meat.model.OfferConfigModel;
import com.meat.model.OfferExcludeConfigModel;
import com.meat.model.OfferModel;
import com.meat.model.PreOrderCartItemsModel;
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
 * @author varma
 *
 */
@Component("offerToOfferModelConverter")
public class OfferToOfferModelConverter implements Converter<Offer, OfferModel> {

    private static final Logger LOGGER = Logger.getLogger(OfferToOfferModelConverter.class);
    @Autowired
    private ObjectFactory<OfferModel> offerModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OfferModel convert(final Offer source) {
        // TODO Auto-generated method stub
        OfferModel offerModel = offerModelFactory.getObject();
        BeanUtils.copyProperties(source, offerModel);

        if (CollectionUtils.isNotEmpty(source.getOfferConfigs())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigs(),
                    TypeDescriptor.forObject(source.getOfferConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            offerModel.getOfferConfigModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigs())) {
            List<OfferExcludeConfigModel> converted = (List<OfferExcludeConfigModel>) conversionService.convert(
                    source.getOfferExcludeConfigs(), TypeDescriptor.forObject(source.getOfferExcludeConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfigModel.class));
            offerModel.getOfferExcludeConfigModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getPreOrderCartItems())) {
            List<PreOrderCartItemsModel> converted = (List<PreOrderCartItemsModel>) conversionService.convert(source.getPreOrderCartItems(),
                    TypeDescriptor.forObject(source.getPreOrderCartItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), PreOrderCartItemsModel.class));
            offerModel.getPreOrderCartItemsModels().addAll(converted);
        }

        return offerModel;

    }

    @Autowired
    public void setOfferFactory(final ObjectFactory<OfferModel> offerModelFactory) {
        this.offerModelFactory = offerModelFactory;
    }
}
