/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchModel;
import com.meat.model.SellerImagesModel;
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
@Component("sellerRepresentationToSellerModelConverter")
public class SellerRepresentationToSellerModelConverter extends PropertyCopyingConverter<SellerRepresentation, SellerModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerModel convert(final SellerRepresentation source) {

        SellerModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchRep())) {
            List<SellerBranchModel> converted = (List<SellerBranchModel>) conversionService.convert(source.getSellerBranchRep(),
                    TypeDescriptor.forObject(source.getSellerBranchRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchModel.class));
            target.getSellerBranchModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerImagesRep())) {
            List<SellerImagesModel> converted = (List<SellerImagesModel>) conversionService.convert(source.getSellerImagesRep(),
                    TypeDescriptor.forObject(source.getSellerImagesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerImagesModel.class));
            target.getSellerImagesModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerModel> factory) {
        super.setFactory(factory);
    }
}