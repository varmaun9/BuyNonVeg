/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.PreOrderCartItemsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("preOrderCartItemsModelToPreOrderCartItemsRepresentationConverter")
public class PreOrderCartItemsModelToPreOrderCartItemsRepresentationConverter extends
        PropertyCopyingConverter<PreOrderCartItemsModel, PreOrderCartItemsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public PreOrderCartItemsRepresentation convert(final PreOrderCartItemsModel source) {

        PreOrderCartItemsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<PreOrderCartItemsRepresentation> factory) {
        super.setFactory(factory);
    }

}
