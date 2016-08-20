/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchTax;
import com.meat.domain.SellerItemTax;
import com.meat.model.SellerBranchTaxModel;
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
 * @author arthvedi1
 *
 */
@Component("sellerBranchTaxModelToSellerBranchTaxConverter")
public class SellerBranchTaxModelToSellerBranchTaxConverter implements Converter<SellerBranchTaxModel, SellerBranchTax> {
    @Autowired
    private ObjectFactory<SellerBranchTax> sellerBranchTaxFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTax convert(final SellerBranchTaxModel source) {
        SellerBranchTax sellerBranchTax = sellerBranchTaxFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchTax);

        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxModels())) {
            List<SellerItemTax> converted = (List<SellerItemTax>) conversionService.convert(source.getSellerItemTaxModels(),
                    TypeDescriptor.forObject(source.getSellerItemTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTax.class));
            sellerBranchTax.getSellerItemTaxes().addAll(converted);
        }

        return sellerBranchTax;
    }

    @Autowired
    public void setSellerBranchTaxFactory(final ObjectFactory<SellerBranchTax> sellerBranchTaxFactory) {
        this.sellerBranchTaxFactory = sellerBranchTaxFactory;
    }

}
