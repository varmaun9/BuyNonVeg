/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component("offerRepresentationToOfferModelConverter")
public class OfferRepresentationToOfferModelConverter extends PropertyCopyingConverter<OfferRepresentation, OfferModel> {

    private static final Logger LOGGER = Logger.getLogger(OfferRepresentationToOfferModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferModel convert(final OfferRepresentation source) {
        OfferModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getBankOfferRep())) {
            List<BankOfferModel> converted = (List<BankOfferModel>) conversionService.convert(source.getBankOfferRep(),
                    TypeDescriptor.forObject(source.getBankOfferRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), BankOfferModel.class));
            target.getBankOfferModels().addAll(converted);

        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigRep())) {
            System.out.println(source.getOfferConfigRep().get(0).getOfferId());
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigRep(),
                    TypeDescriptor.forObject(source.getOfferConfigRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            target.getOfferConfigModels().addAll(converted);

        }
        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigRep())) {
            List<OfferExcludeConfigModel> converted = (List<OfferExcludeConfigModel>) conversionService.convert(
                    source.getOfferExcludeConfigRep(), TypeDescriptor.forObject(source.getOfferExcludeConfigRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfigModel.class));
            target.getOfferExcludeConfigModels().addAll(converted);

        }
        if (CollectionUtils.isNotEmpty(source.getUsersOfferRep())) {
            List<UsersOfferModel> converted = (List<UsersOfferModel>) conversionService.convert(source.getUsersOfferRep(),
                    TypeDescriptor.forObject(source.getUsersOfferRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersOfferModel.class));
            target.getUsersOfferModels().addAll(converted);

        }

        return target;
    }

    @Autowired
    public ConversionService getConversionService() {
        return conversionService;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.PropertyCopyingConverter#setFactory(org.springframework.beans.factory.ObjectFactory)
     */
    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OfferModel> factory) {
        super.setFactory(factory);
    }
}
