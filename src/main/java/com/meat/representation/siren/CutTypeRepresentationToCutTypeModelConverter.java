/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CutTypeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("cutTypeRepresentationToCutTypeModelConverter")
public class CutTypeRepresentationToCutTypeModelConverter extends PropertyCopyingConverter<CutTypeRepresentation, CutTypeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CutTypeModel convert(final CutTypeRepresentation source) {

        CutTypeModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CutTypeModel> factory) {
        super.setFactory(factory);
    }
}
