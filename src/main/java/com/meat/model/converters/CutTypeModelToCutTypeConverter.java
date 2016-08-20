/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.CutType;
import com.meat.domain.Invoice;
import com.meat.domain.InvoiceStatusCodes;
import com.meat.model.CutTypeModel;
import com.meat.model.InvoiceModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
@Component("cutTypeModelToCutTypeConverter")
public class CutTypeModelToCutTypeConverter implements Converter<CutTypeModel, CutType> {
    @Autowired
    private ObjectFactory<CutType> cutTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public CutType convert(final CutTypeModel source) {
    	CutType cutType= cutTypeFactory.getObject();
        BeanUtils.copyProperties(source, cutType);

     
        return cutType;
    }

    @Autowired
    public void setCutTypeFactory(final ObjectFactory<CutType> cutTypeFactory) {
        this.cutTypeFactory = cutTypeFactory;
    }

}
