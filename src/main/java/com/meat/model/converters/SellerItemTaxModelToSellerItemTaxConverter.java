/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerItemTax;
import com.meat.model.SellerItemTaxModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */

@Component("sellerItemTaxModelToSellerItemTaxConverter")
public class SellerItemTaxModelToSellerItemTaxConverter implements Converter<SellerItemTaxModel, SellerItemTax> {
    @Autowired
    private ObjectFactory<SellerItemTax> sellerItemTaxFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemTax convert(final SellerItemTaxModel source) {
        SellerItemTax sellerItemTax = sellerItemTaxFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemTax);

        return sellerItemTax;
    }

    @Autowired
    public void setUserAddressFactory(final ObjectFactory<SellerItemTax> sellerItemTaxFactory) {
        this.sellerItemTaxFactory = sellerItemTaxFactory;
    }

}
