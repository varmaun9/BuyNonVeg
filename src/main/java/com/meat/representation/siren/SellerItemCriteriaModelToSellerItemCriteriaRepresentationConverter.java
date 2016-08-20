/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemCriteriaModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemCriteriaModelToSellerItemCriteriaRepresentationConverter")
public class SellerItemCriteriaModelToSellerItemCriteriaRepresentationConverter extends
        PropertyCopyingConverter<SellerItemCriteriaModel, SellerItemCriteriaRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemCriteriaRepresentation convert(final SellerItemCriteriaModel source) {

        SellerItemCriteriaRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemCriteriaRepresentation> factory) {
        super.setFactory(factory);
    }
}
