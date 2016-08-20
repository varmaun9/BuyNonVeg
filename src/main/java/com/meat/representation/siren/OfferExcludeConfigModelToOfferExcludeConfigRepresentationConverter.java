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
@Component("offerExcludeConfigModelToOfferExcludeConfigRepresentationConverter")
public class OfferExcludeConfigModelToOfferExcludeConfigRepresentationConverter extends
        PropertyCopyingConverter<OfferExcludeConfigModel, OfferExcludeConfigRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferExcludeConfigRepresentation convert(final OfferExcludeConfigModel source) {

        OfferExcludeConfigRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OfferExcludeConfigRepresentation> factory) {
        super.setFactory(factory);
    }

}
