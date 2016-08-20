/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBankAccountModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBankAccountModelToSellerBankAccountRepresentationConverter")
public class SellerBankAccountModelToSellerBankAccountRepresentationConverter extends
        PropertyCopyingConverter<SellerBankAccountModel, SellerBankAccountRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBankAccountRepresentation convert(final SellerBankAccountModel source) {

        SellerBankAccountRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBankAccountRepresentation> factory) {
        super.setFactory(factory);
    }

}
