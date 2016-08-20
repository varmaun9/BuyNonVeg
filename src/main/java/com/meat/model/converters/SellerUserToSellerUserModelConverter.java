/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerUser;
import com.meat.model.SellerUserModel;

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
@Component("sellerUserToSellerUserModelConverter")
public class SellerUserToSellerUserModelConverter implements Converter<SellerUser, SellerUserModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerUserToSellerUserModelConverter.class);
    @Autowired
    private ObjectFactory<SellerUserModel> sellerUserModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerUserModel convert(final SellerUser source) {
        // TODO Auto-generated method stub
        SellerUserModel sellerUserModel = sellerUserModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerUserModel);

        if (source.getSellerBranch() != null) {
            sellerUserModel.setSellerBranchId(source.getSellerBranch().getId());
            sellerUserModel.setSellerBranchName(source.getSellerBranch().getBranchName());
            sellerUserModel.setSellerName(source.getSellerBranch().getSeller().getSellerName());
        }
        return sellerUserModel;

    }

    @Autowired
    public void setSellerUserFactory(final ObjectFactory<SellerUserModel> sellerUserModelFactory) {
        this.sellerUserModelFactory = sellerUserModelFactory;
    }

}
