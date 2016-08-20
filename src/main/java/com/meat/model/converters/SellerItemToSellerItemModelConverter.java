/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerItem;
import com.meat.model.*;
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

@Component("sellerItemToSellerItemModelConverter")
public class SellerItemToSellerItemModelConverter implements Converter<SellerItem, SellerItemModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerItemToSellerItemModelConverter.class);
    @Autowired
    private ObjectFactory<SellerItemModel> sellerItemModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerItemModel convert(final SellerItem source) {

        SellerItemModel sellerItemModel = sellerItemModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemModel);
        if (source.getDescription() != null) {
            sellerItemModel.setDescription(source.getDescription());
        }
        sellerItemModel.setId(source.getId());
        if (source.getItem() != null) {
            sellerItemModel.setItemId(source.getItem().getId());
        }
        if (source.getSellingPrice() != null) {
            sellerItemModel.setSellingPrice(source.getSellingPrice().toString());
        }
        if (source.getBaseUnit() != null) {
            sellerItemModel.setBaseUnit(source.getBaseUnit().toString());
        }
        if (source.getMarketPrice() != null) {
            sellerItemModel.setMarketPrice(source.getMarketPrice().toString());
        }
        if (source.getSellingTag() != null) {
            sellerItemModel.setSellingTag(source.getSellingTag().toString());
        }
        if (source.getSeo() != null) {
            sellerItemModel.setSeoId(source.getSeo().getId());
            sellerItemModel.setSeoTitle(source.getSeo().getSeoTitle());
            sellerItemModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            sellerItemModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        if (source.getSellerBranch() != null) {
            sellerItemModel.setSellerBranchId(source.getSellerBranch().getId());
            sellerItemModel.setBranchName(source.getSellerBranch().getBranchName());
        }

        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                sellerItemModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemImageses())) {
            List<SellerItemImagesModel> converted = (List<SellerItemImagesModel>) conversionService.convert(source.getSellerItemImageses(),
                    TypeDescriptor.forObject(source.getSellerItemImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemImagesModel.class));
            sellerItemModel.getSellerItemImageModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemCriterias())) {
            List<SellerItemCriteriaModel> converted = (List<SellerItemCriteriaModel>) conversionService.convert(
                    source.getSellerItemCriterias(), TypeDescriptor.forObject(source.getSellerItemCriterias()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaModel.class));
            sellerItemModel.getSellerItemCriteriaModels().addAll(converted);
        }
        /*  if (CollectionUtils.isNotEmpty(source.getSellerItemTaxes())) {
              List<SellerItemTaxModel> converted = (List<SellerItemTaxModel>) conversionService.convert(source.getSellerItemTaxes(),
                      TypeDescriptor.forObject(source.getSellerItemTaxes()),
                      CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxModel.class));
              sellerItemModel.getSellerItemTaxModels().addAll(converted);
          }*/

        if (CollectionUtils.isNotEmpty(source.getOrderItems())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItems(),
                    TypeDescriptor.forObject(source.getOrderItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            sellerItemModel.getOrderItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatings())) {
            List<UserSellerItemRatingModel> converted = (List<UserSellerItemRatingModel>) conversionService.convert(
                    source.getUserSellerItemRatings(), TypeDescriptor.forObject(source.getUserSellerItemRatings()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingModel.class));
            sellerItemModel.getUserSellerItemRatingModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigs())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigs(),
                    TypeDescriptor.forObject(source.getOfferConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            sellerItemModel.getOfferConfigModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemPieceTypes())) {
            List<SellerItemPieceTypeModel> converted = (List<SellerItemPieceTypeModel>) conversionService.convert(
                    source.getSellerItemPieceTypes(), TypeDescriptor.forObject(source.getSellerItemPieceTypes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemPieceTypeModel.class));
            sellerItemModel.getSellerItemPieceTypeModels().addAll(converted);
        }

        return sellerItemModel;

    }

    @Autowired
    public void setSellerItemFactory(final ObjectFactory<SellerItemModel> sellerItemModelFactory) {
        this.sellerItemModelFactory = sellerItemModelFactory;
    }

}
