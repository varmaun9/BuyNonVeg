/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OfferExcludeConfigModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("offerExcludeConfigRepresentationToOfferExcludeConfigModelConverter")
public class OfferExcludeConfigRepresentationToOfferExcludeConfigModelConverter
        extends PropertyCopyingConverter<OfferExcludeConfigRepresentation, OfferExcludeConfigModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferExcludeConfigModel convert(final OfferExcludeConfigRepresentation source) {

        OfferExcludeConfigModel target = super.convert(source);
        target.setStatus(source.getStatus());

        return target;

    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OfferExcludeConfigModel> factory) {
        super.setFactory(factory);
    }

}
