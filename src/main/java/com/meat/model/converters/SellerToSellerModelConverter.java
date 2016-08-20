/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Seller;
import com.meat.model.SellerBranchModel;
import com.meat.model.SellerModel;
import com.meat.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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
@Component("sellerToSellerModelConverter")
public class SellerToSellerModelConverter implements Converter<Seller, SellerModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerToSellerModelConverter.class);
    @Autowired
    private ObjectFactory<SellerModel> sellerModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public SellerModel convert(final Seller source) {
        // TODO Auto-generated method stub
        SellerModel sellerModel = sellerModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerModel);

        if (source.getSeo() != null) {
            sellerModel.setSeoId(source.getSeo().getId());
            sellerModel.setSeoTitle(source.getSeo().getSeoTitle());
            sellerModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            sellerModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        sellerModel.setSellerCount(Long.toString(source.getSellerCount()));
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                sellerModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranches())) {
            List<SellerBranchModel> converted = (List<SellerBranchModel>) conversionService.convert(source.getSellerBranches(),
                    TypeDescriptor.forObject(source.getSellerBranches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchModel.class));
            sellerModel.getSellerBranchModels().addAll(converted);
        }
        /*  if (CollectionUtils.isNotEmpty(source.getSellerImageses())) {
            List<SellerImagesModel> converted = (List<SellerImagesModel>) conversionService.convert(source.getSellerImageses(),
                    TypeDescriptor.forObject(source.getSellerImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerImagesModel.class));
            sellerModel.getSellerImagesModels().addAll(converted);
        }*/

        return sellerModel;

    }

    @Autowired
    public void setSellerFactory(final ObjectFactory<SellerModel> sellerModelFactory) {
        this.sellerModelFactory = sellerModelFactory;
    }

}
