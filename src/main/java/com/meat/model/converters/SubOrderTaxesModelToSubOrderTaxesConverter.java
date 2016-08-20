/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubOrderTaxes;
import com.meat.model.SubOrderTaxesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("SubOrderTaxesModelToSubOrderTaxesConverter")
public class SubOrderTaxesModelToSubOrderTaxesConverter implements Converter<SubOrderTaxesModel, SubOrderTaxes> {
    @Autowired
    private ObjectFactory<SubOrderTaxes> subOrderTaxesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderTaxes convert(final SubOrderTaxesModel source) {
        SubOrderTaxes subOrderTaxes = subOrderTaxesFactory.getObject();
        BeanUtils.copyProperties(source, subOrderTaxes);

        return subOrderTaxes;
    }

    @Autowired
    public void setSubOrderTaxesFactory(final ObjectFactory<SubOrderTaxes> subOrderTaxesFactory) {
        this.subOrderTaxesFactory = subOrderTaxesFactory;
    }

}
