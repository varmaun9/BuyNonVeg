/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubOrderStatusCodeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderStatusCodeModelToSubOrderStatusCodeRepresentationConverter")
public class SubOrderStatusCodeModelToSubOrderStatusCodeRepresentationConverter extends
        PropertyCopyingConverter<SubOrderStatusCodeModel, SubOrderStatusCodeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderStatusCodeRepresentation convert(final SubOrderStatusCodeModel source) {

        SubOrderStatusCodeRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderStatusCodeRepresentation> factory) {
        super.setFactory(factory);
    }

}
