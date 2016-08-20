/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerItemTax;
import com.meat.model.SellerItemTaxModel;

import org.apache.log4j.Logger;
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

@Component("sellerItemTaxToSellerItemTaxModelConverter")
public class SellerItemTaxToSellerItemTaxModelConverter implements Converter<SellerItemTax, SellerItemTaxModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerItemTaxToSellerItemTaxModelConverter.class);
    @Autowired
    private ObjectFactory<SellerItemTaxModel> sellerItemTaxModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerItemTaxModel convert(final SellerItemTax source) {
        // TODO Auto-generated method stub
        SellerItemTaxModel sellerItemTaxModel = sellerItemTaxModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemTaxModel);

        return sellerItemTaxModel;

    }

    @Autowired
    public void setSellerItemTaxFactory(final ObjectFactory<SellerItemTaxModel> sellerItemTaxModelFactory) {
        this.sellerItemTaxModelFactory = sellerItemTaxModelFactory;
    }

}
