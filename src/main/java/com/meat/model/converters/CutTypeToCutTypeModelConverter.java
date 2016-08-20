package com.meat.model.converters;

import com.meat.domain.CutType;
import com.meat.model.CutTypeModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("cutTypeToCutTypeModelConverter")
public class CutTypeToCutTypeModelConverter implements Converter<CutType, CutTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(CutTypeToCutTypeModelConverter.class);
    @Autowired
    private ObjectFactory<CutTypeModel> cutTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CutTypeModel convert(final CutType source) {
        // TODO Auto-generated method stub
        CutTypeModel cutTypeModel = cutTypeModelFactory.getObject();
        BeanUtils.copyProperties(source, cutTypeModel);

        return cutTypeModel;

    }

    @Autowired
    public void setCutTypeFactory(final ObjectFactory<CutTypeModel> cutTypeModelFactory) {
        this.cutTypeModelFactory = cutTypeModelFactory;
    }

}
