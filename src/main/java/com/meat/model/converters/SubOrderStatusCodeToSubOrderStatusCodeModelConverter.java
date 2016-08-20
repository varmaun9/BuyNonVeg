/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubOrderStatusCode;
import com.meat.model.SubOrderStatusCodeModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderStatusCodeToSubOrderStatusCodeModelConverter")
public class SubOrderStatusCodeToSubOrderStatusCodeModelConverter implements Converter<SubOrderStatusCode, SubOrderStatusCodeModel> {

    private static final Logger LOGGER = Logger.getLogger(SubOrderStatusCodeToSubOrderStatusCodeModelConverter.class);
    @Autowired
    private ObjectFactory<SubOrderStatusCodeModel> subOrderStatusCodeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SubOrderStatusCodeModel convert(final SubOrderStatusCode source) {
        // TODO Auto-generated method stub
        SubOrderStatusCodeModel subOrderStatusCodeModel = subOrderStatusCodeModelFactory.getObject();

        BeanUtils.copyProperties(source, subOrderStatusCodeModel);

        return subOrderStatusCodeModel;

    }

    @Autowired
    public void setAttributesFactory(final ObjectFactory<SubOrderStatusCodeModel> subOrderStatusCodeModelFactory) {
        this.subOrderStatusCodeModelFactory = subOrderStatusCodeModelFactory;
    }

}
