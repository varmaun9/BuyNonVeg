/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchTax;
import com.meat.model.SellerBranchTaxModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("sellerBranchTaxToSellerBranchTaxModelConverter")
public class SellerBranchTaxToSellerBranchTaxModelConverter implements Converter<SellerBranchTax, SellerBranchTaxModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerBranchTaxToSellerBranchTaxModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchTaxModel> sellerBranchTaxModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchTaxModel convert(final SellerBranchTax source) {
        // TODO Auto-generated method stub
        SellerBranchTaxModel sellerBranchTaxModel = sellerBranchTaxModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchTaxModel);
        if (source.getAmountType() != null) {
            sellerBranchTaxModel.setAmountTypeId(source.getAmountType().getId());
            sellerBranchTaxModel.setAmountDescription(source.getAmountType().getAmountDescription());
        }
        if (source.getSellerBranch() != null) {
            sellerBranchTaxModel.setSellerBranchId(source.getSellerBranch().getId());
        }
        if (source.getTax() != null) {
            sellerBranchTaxModel.setTaxId(source.getTax().getId());
            sellerBranchTaxModel.setTaxType(source.getTax().getTaxType());
            sellerBranchTaxModel.setTaxName(source.getTax().getTaxName());
        }
        sellerBranchTaxModel.setTaxValue(source.getTaxValue().toString());
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                sellerBranchTaxModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        /*  if (CollectionUtils.isNotEmpty(source.getSellerItemTaxes())) {
            List<SellerItemTaxModel> converted = (List<SellerItemTaxModel>) conversionService.convert(source.getSellerItemTaxes(),
                    TypeDescriptor.forObject(source.getSellerItemTaxes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxModel.class));
            sellerBranchTaxModel.getSellerItemTaxModels().addAll(converted);
        }*/

        return sellerBranchTaxModel;

    }

    @Autowired
    public void setSellerBranchTaxFactory(final ObjectFactory<SellerBranchTaxModel> sellerBranchTaxModelFactory) {
        this.sellerBranchTaxModelFactory = sellerBranchTaxModelFactory;
    }

}
