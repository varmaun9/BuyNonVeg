/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerUser;
import com.meat.model.SellerUserModel;

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
@Component("sellerUserModelToSellerUserConverter")
public class SellerUserModelToSellerUserConverter implements Converter<SellerUserModel, SellerUser> {
    @Autowired
    private ObjectFactory<SellerUser> sellerUserFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerUser convert(final SellerUserModel source) {
        SellerUser sellerUser = sellerUserFactory.getObject();
        BeanUtils.copyProperties(source, sellerUser);

        return sellerUser;
    }

    @Autowired
    public void setSellerUserFactory(final ObjectFactory<SellerUser> sellerUserFactory) {
        this.sellerUserFactory = sellerUserFactory;
    }

}
