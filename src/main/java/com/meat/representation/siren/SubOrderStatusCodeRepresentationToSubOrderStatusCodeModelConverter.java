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

@Component("subOrderStatusCodeRepresentationToSubOrderStatusCodeModelConverter")
public class SubOrderStatusCodeRepresentationToSubOrderStatusCodeModelConverter extends
        PropertyCopyingConverter<SubOrderStatusCodeRepresentation, SubOrderStatusCodeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderStatusCodeModel convert(final SubOrderStatusCodeRepresentation source) {

        SubOrderStatusCodeModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderStatusCodeModel> factory) {
        super.setFactory(factory);
    }

}
