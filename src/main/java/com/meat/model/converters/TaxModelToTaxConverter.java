package com.meat.model.converters;

import com.meat.domain.SellerBranchTax;
import com.meat.domain.Tax;
import com.meat.model.TaxModel;
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

@Component("taxModelToTaxConverter")
public class TaxModelToTaxConverter implements Converter<TaxModel, Tax> {
    @Autowired
    private ObjectFactory<Tax> taxFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Tax convert(final TaxModel source) {
        Tax tax = taxFactory.getObject();
        BeanUtils.copyProperties(source, tax);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxModels())) {
            List<SellerBranchTax> converted = (List<SellerBranchTax>) conversionService.convert(source.getSellerBranchTaxModels(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTax.class));
            tax.getSellerBranchTaxes().addAll(converted);
        }

        return tax;
    }

    @Autowired
    public void setTaxFactory(final ObjectFactory<Tax> taxFactory) {
        this.taxFactory = taxFactory;
    }

}
