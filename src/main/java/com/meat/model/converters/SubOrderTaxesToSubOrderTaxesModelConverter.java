/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubOrderTaxes;
import com.meat.model.SubOrderTaxesModel;

import org.apache.log4j.Logger;
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
@Component("subOrderTaxesToSubOrderTaxesModelConverter")
public class SubOrderTaxesToSubOrderTaxesModelConverter implements Converter<SubOrderTaxes, SubOrderTaxesModel> {

    private static final Logger LOGGER = Logger.getLogger(SubOrderTaxesToSubOrderTaxesModelConverter.class);
    @Autowired
    private ObjectFactory<SubOrderTaxesModel> subOrderTaxesModelFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderTaxesModel convert(final SubOrderTaxes source) {
        // TODO Auto-generated method stub
        SubOrderTaxesModel subOrderTaxesModel = subOrderTaxesModelFactory.getObject();
        BeanUtils.copyProperties(source, subOrderTaxesModel);

        return subOrderTaxesModel;

    }

    @Autowired
    public void setSubOrderTaxesFactory(final ObjectFactory<SubOrderTaxesModel> subOrderTaxesModelFactory) {
        this.subOrderTaxesModelFactory = subOrderTaxesModelFactory;
    }

}
