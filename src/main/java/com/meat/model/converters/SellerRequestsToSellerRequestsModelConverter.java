/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerRequests;
import com.meat.model.SellerRequestsModel;

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

@Component("sellerRequestsToSellerRequestsModelConverter")
public class SellerRequestsToSellerRequestsModelConverter implements Converter<SellerRequests, SellerRequestsModel> {

    @Autowired
    private ObjectFactory<SellerRequestsModel> sellerRequestsModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerRequestsToSellerRequestsModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerRequestsModel convert(final SellerRequests source) {
        // TODO Auto-generated method stub
        SellerRequestsModel sellerRequestsModel = sellerRequestsModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerRequestsModel);

        return sellerRequestsModel;

    }

    @Autowired
    public void setSellerRequestsFactory(final ObjectFactory<SellerRequestsModel> sellerRequestsModelFactory) {
        this.sellerRequestsModelFactory = sellerRequestsModelFactory;
    }

}
