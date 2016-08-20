/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Seller;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerImages;
import com.meat.model.SellerModel;
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

/**
 * @author arthvedi
 *
 */

@Component("sellerModelToSellerConverter")
public class SellerModelToSellerConverter implements Converter<SellerModel, Seller> {
    @Autowired
    private ObjectFactory<Seller> sellerFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Seller convert(final SellerModel source) {
        Seller seller = sellerFactory.getObject();
        BeanUtils.copyProperties(source, seller);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchModels())) {
            List<SellerBranch> converted = (List<SellerBranch>) conversionService.convert(source.getSellerBranchModels(),
                    TypeDescriptor.forObject(source.getSellerBranchModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranch.class));
            seller.getSellerBranches().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerImagesModels())) {
            List<SellerImages> converted = (List<SellerImages>) conversionService.convert(source.getSellerImagesModels(),
                    TypeDescriptor.forObject(source.getSellerImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerImages.class));
            seller.getSellerImageses().addAll(converted);
        }

        return seller;
    }

    @Autowired
    public void setSellerFactory(final ObjectFactory<Seller> sellerFactory) {
        this.sellerFactory = sellerFactory;
    }

}
