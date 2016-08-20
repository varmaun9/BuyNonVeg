/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Tax;
import com.meat.model.SellerBranchTaxModel;
import com.meat.model.TaxModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("taxToTaxModelConverter")
public class TaxToTaxModelConverter implements Converter<Tax, TaxModel> {

    @Autowired
    private ObjectFactory<TaxModel> taxModelFactory;
    private static final Logger LOGGER = Logger.getLogger(TaxToTaxModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public TaxModel convert(final Tax source) {
        // TODO Auto-generated method stub
        TaxModel taxModel = taxModelFactory.getObject();

        BeanUtils.copyProperties(source, taxModel);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxes())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxes(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            taxModel.getSellerBranchTaxModels().addAll(converted);
        }

        return taxModel;

    }

    @Autowired
    public void setTaxFactory(final ObjectFactory<TaxModel> taxModelFactory) {
        this.taxModelFactory = taxModelFactory;
    }

}
