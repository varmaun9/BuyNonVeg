/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubOrderStatusCode;
import com.meat.model.SubOrderStatusCodeModel;

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

@Component("subOrderStatusCodeModelToSubOrderStatusCodeConverter")
public class SubOrderStatusCodeModelToSubOrderStatusCodeConverter implements Converter<SubOrderStatusCodeModel, SubOrderStatusCode> {
    @Autowired
    private ObjectFactory<SubOrderStatusCode> subOrderStatusCodeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderStatusCode convert(final SubOrderStatusCodeModel source) {
        SubOrderStatusCode subOrderStatusCode = subOrderStatusCodeFactory.getObject();
        BeanUtils.copyProperties(source, subOrderStatusCode);

        return subOrderStatusCode;
    }

    @Autowired
    public void setSubOrderStatusCodeFactory(final ObjectFactory<SubOrderStatusCode> subOrderStatusCodeFactory) {
        this.subOrderStatusCodeFactory = subOrderStatusCodeFactory;
    }

}
