/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryTagsModel;
import com.meat.model.CutTypeModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("cutTypeModelToCutTypeRepresentationConverter.java")
public class CutTypeModelToCutTypeRepresentationConverter extends
PropertyCopyingConverter<CutTypeModel, CutTypeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CutTypeRepresentation convert(final CutTypeModel source) {

    	CutTypeRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CutTypeRepresentation> factory) {
        super.setFactory(factory);
    }
}
