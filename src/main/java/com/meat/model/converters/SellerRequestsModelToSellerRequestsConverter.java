/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerRequests;
import com.meat.model.SellerRequestsModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author venkat
 *
 */

@Component("sellerRequestsModelToSellerRequestsConverter")
public class SellerRequestsModelToSellerRequestsConverter implements Converter<SellerRequestsModel, SellerRequests> {
    @Autowired
    private ObjectFactory<SellerRequests> sellerRequestsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerRequests convert(final SellerRequestsModel source) {
        SellerRequests sellerRequests = sellerRequestsFactory.getObject();
        BeanUtils.copyProperties(source, sellerRequests);

        return sellerRequests;
    }

    @Autowired
    public void setSellerRequestsFactory(final ObjectFactory<SellerRequests> sellerRequestsFactory) {
        this.sellerRequestsFactory = sellerRequestsFactory;
    }

}
