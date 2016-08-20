/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerModelToSellerRepresentationConverter")
public class SellerModelToSellerRepresentationConverter extends PropertyCopyingConverter<SellerModel, SellerRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerRepresentation convert(final SellerModel source) {

        SellerRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getSellerBranchModels())) {
            List<SellerBranchRepresentation> converted = (List<SellerBranchRepresentation>) conversionService.convert(
                    source.getSellerBranchModels(), TypeDescriptor.forObject(source.getSellerBranchModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchRepresentation.class));
            target.getSellerBranchRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerImagesModels())) {
            List<SellerImagesRepresentation> converted = (List<SellerImagesRepresentation>) conversionService.convert(
                    source.getSellerImagesModels(), TypeDescriptor.forObject(source.getSellerImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerImagesRepresentation.class));
            target.getSellerImagesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerRepresentation> factory) {
        super.setFactory(factory);
    }
}
