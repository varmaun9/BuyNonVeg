/**
 *
 */
package com.meat.service;

import com.meat.dao.*;
import com.meat.domain.*;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi1
 *
 */
@Component
public class ItemService implements IItemService {

    @Autowired
    private ItemAttributesRepository itemAttributesRepository;
    @Autowired
    private ItemTagsRepository itemTagsRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private SellerItemRepository sellerItemRepository;
    @Autowired
    private IItemTagsService itemTagsService;
    @Autowired
    private ITagsService tagsService;
    @Autowired
    private ItemImagesRepository itemImagesRepository;
    @Autowired
    private IItemImagesService itemImagesService;
    @Autowired
    private IItemAttributesService itemAttributesService;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private OfferConfigRepository offerConfigRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#addItemAttributes(com.meat.domain.Item, java.util.List)
     */
    @Override
    @Transactional
    public Item addItemAttributes(final Item item, final List<ItemAttributes> itemAttribute) {
        Validate.notNull(item, "item must not be null");
        Set<ItemAttributes> addItAttributes = new HashSet<ItemAttributes>(itemAttribute);
        for (ItemAttributes itemAttr : itemAttribute) {
            ItemAttributes itemAttributes = new ItemAttributes();
            if (itemAttr.getId() != null) {
                itemAttributes = itemAttributesService.getItemAttributes(itemAttr.getId());
                itemAttributes.setId(itemAttr.getId());
                itemAttributes.setAttributes(itemAttributes.getAttributes());
                itemAttributes.setAttributeName(itemAttributes.getAttributeName());
                itemAttributes.setCategoryAttributes(itemAttributes.getCategoryAttributes());
                itemAttributes.setAttributeValue(itemAttr.getAttributeValue());
                itemAttributes.setItem(itemAttributes.getItem());
                itemAttributes.setStatus(itemAttr.getStatus());
                itemAttributes = itemAttributesService.updateItemAttributes(itemAttributes);
            }
            else {
                itemAttributes.setAttributes(itemAttr.getAttributes());
                itemAttributes.setAttributeName(itemAttributes.getAttributeName());
                itemAttributes.setItem(itemAttr.getItem());
                itemAttributes.setCategoryAttributes(itemAttr.getCategoryAttributes());
                itemAttributes.setAttributeValue(itemAttr.getAttributeValue());
                itemAttributes.setStatus(itemAttr.getStatus());
                addItAttributes.add(itemAttributes);
                itemAttributes = itemAttributesRepository.save(itemAttributes);
            }
        }
        return item;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#addItemImages(com.meat.domain.Item, java.util.List)
     */
    @Override
    @Transactional
    public Item addItemImages(final Item item, final List<ItemImages> itemImages) {
        Validate.notNull(item, "item must not be null");
        Set<ItemImages> addImages = new HashSet<ItemImages>(itemImages);
        for (ItemImages iImages : itemImages) {
            ItemImages itemImages1 = new ItemImages();
            String s = iImages.getImageName();
            s = s.replaceAll("\\\\", "/");
            if (iImages.getId() != null) {
                itemImages1 = itemImagesService.getItemImages(iImages.getId());
                itemImages1.setId(itemImages1.getId());
                itemImages1.setImageName(s);
                itemImages1.setItem(itemImages1.getItem());
                itemImages1.setImageType(iImages.getImageType());
                itemImages1.setImageLocation(iImages.getImageLocation());
                itemImages1 = itemImagesService.updateItemImages(itemImages1);
            }
            else {
                itemImages1.setImageName(s);
                itemImages1.setItem(item);
                itemImages1.setImageType(iImages.getImageType());
                itemImages1.setImageLocation(iImages.getImageLocation());
                addImages.add(itemImages1);
                itemImages1 = itemImagesRepository.save(itemImages1);

            }

        }
        item.setItemImageses(addImages);
        return item;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#addItemTags(com.meat.domain.Item, java.util.List)
     */
    @Override
    @Transactional
    public Item addItemTags(final Item item, final List<ItemTags> itemTagses) {
        Validate.notNull(item, "item must not be null");
        Set<ItemTags> addItTags = new HashSet<ItemTags>(itemTagses);
        for (ItemTags itemTags : itemTagses) {
            ItemTags itemTags1 = new ItemTags();
            if (itemTags.getId() != null) {
                itemTags1 = itemTagsService.getItemTags(itemTags.getId());
                itemTags1.setId(itemTags.getId());
                itemTags1.setItem(itemTags1.getItem());
                itemTags1.setItemTagsStatus(itemTags.getItemTagsStatus());
                itemTags1.setTags(itemTags1.getTags());
                itemTags1 = itemTagsService.updateItemTags(itemTags1);
            }
            else {
                itemTags1.setTags(itemTags.getTags());
                itemTags1.setItem(itemTags.getItem());
                itemTags1.setItemTagsStatus(itemTags.getItemTagsStatus());
                addItTags.add(itemTags1);
                itemTags1 = itemTagsRepository.save(itemTags1);
            }
        }
        return item;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#addSellerItems(com.meat.domain.Item, java.util.Set)
     */
    @Override
    @Transactional
    public Item addSellerItems(final Item item, final Set<SellerItem> sellerItems) {

        Validate.notNull(item, "item must not be null");
        Set<SellerItem> addsellItems = new HashSet<SellerItem>(sellerItems);
        for (SellerItem selleItem : sellerItems) {

            SellerItem sellItem = new SellerItem();
            if (selleItem.getId() != null) {
                sellItem = sellerItemService.getSellerItem(selleItem.getId());
                sellItem.setId(selleItem.getId());
                sellItem.setDescription(selleItem.getDescription());
                // sellItem.setIngredients(selleItem.getIngredients());
                sellItem.setItem(sellItem.getItem());
                sellItem.setItemAvailableStatus(selleItem.getItemAvailableStatus());
                sellItem.setSellingPrice(selleItem.getSellingPrice());
                sellItem.setQuantity(selleItem.getQuantity());
                sellItem.setSellerBranch(sellItem.getSellerBranch());
                sellItem.setSellerItemName(selleItem.getSellerItemName());
                sellItem.setSellerStock(selleItem.getSellerStock());
                sellItem.setSellingTag(selleItem.getSellingTag());
                sellItem.setSeo(sellItem.getSeo());
                sellItem.setSpecialTag(selleItem.getSpecialTag());
                sellItem = sellerItemService.updateSellerItem(sellItem);

            }
            else {
                sellItem.setItem(item);
                Seo seo = new Seo();
                seo.setId(selleItem.getSeo().getId());
                seo.setSeoKeywords(selleItem.getSeo().getSeoKeywords());
                seo.setSeoMetaDescription(selleItem.getSeo().getSeoMetaDescription());
                seo.setSeoTitle(selleItem.getSeo().getSeoTitle());
                seo = seoService.create(seo);
                sellItem.setSeo(seo);
                sellItem.setSellerItemName(selleItem.getSellerItemName());
                sellItem.setSellingTag(selleItem.getSellingTag());
                sellItem.setQuantity(selleItem.getQuantity());

                sellItem.setSpecialTag(selleItem.getSpecialTag());
                sellItem.setDescription(selleItem.getDescription());
                // sellItem.setIngredients(selleItem.getIngredients());

                sellItem.setSellingPrice(selleItem.getSellingPrice());
                sellItem.setItemAvailableStatus(selleItem.getItemAvailableStatus());
                // SellerBranch SellerBranch = new SellerBranch();
                sellItem.setSellerBranch(selleItem.getSellerBranch());

                sellItem.setCreatedDate(new Date());
                sellItem.setSellerStock(selleItem.getSellerStock());
                addsellItems.add(sellItem);
                sellItem = sellerItemRepository.save(sellItem);
            }
        }
        item.setSellerItems(addsellItems);
        return item;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#create(com.meat.domain.Item)
     */
    @Override
    @Transactional
    public Item create(final Item item) {

        Validate.notNull(item, "item must not be null" + item.getItemName());
        List<Item> itm = new ArrayList<Item>();
        itm = (List<Item>) itemRepository.findAll();
        if (itm != null) {
            for (Item it : itm) {
                String m = it.getItemName();
                String mc = m.replaceAll("\\s", "");
                String mc1 = mc.toLowerCase();
                if (item.getItemName() != null) {
                    String mc2 = item.getItemName().replaceAll("\\s", "").toLowerCase();
                    if (mc1.equals(mc2)) {
                        item.setItemName("Duplicate");
                    }
                }
            }
        }
        if (item.getItemName() != null) {
            if (item.getItemName().equals("Duplicate")) {
                item.getItemName().equals("Duplicate");
            }
            else {
                Item item1 = new Item();
                if (item.getSeo() != null) {
                    Seo seo = new Seo();
                    seo.setId(item.getSeo().getId());
                    seo.setSeoTitle(item.getSeo().getSeoTitle());
                    seo.setSeoKeywords(item.getSeo().getSeoKeywords());
                    seo.setSeoMetaDescription(item.getSeo().getSeoMetaDescription());
                    seo = seoService.create(seo);
                    item.setSeo(seo);
                }
                item1 = itemRepository.save(item);
            }
        }
        return item;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#deleteItem(java.lang.String)
     */
    @Override
    public void deleteItem(final String itemId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getAll()
     */
    @Override
    public List<Item> getAll() {
        List<Item> item = new ArrayList<Item>();
        item = (List<Item>) itemRepository.findAll();
        return item;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getCategoriesItemPagesByThemeleaf(java.lang.String, java.lang.String, java.lang.Integer,
     *      java.lang.Integer)
     */
    @Override
    public List<Item> getCategoriesItemPagesByThemeleaf(final String categoryId, final String zoneId) {
        List<Item> items = itemRepository.findItemByCategoryAndZoneThymeleaf(zoneId, categoryId);

        return items;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getCategorySellerItemPriceFilterThymeleafPageAll(java.lang.String[], java.lang.String,
     *      java.lang.String[], java.lang.String[], java.lang.String[], int, int, java.lang.String, java.lang.String)
     */
    @Override
    public List<Item> getCategoryItemPriceFilterThymeleafPageAll(final String[] categoryId, final String zoneId,
            final String[] subCategoryId, final String[] tagId, final String[] attributesId, final String[] attributeValue,
            final String sp1, final String ep1, final int page, final int pageSize, final String sort, final String type) {
        // TODO Auto-generated method stub  Pageable pageable = new PageRequest(page, pageSize);

        PageRequest request = null;
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellingPrice");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "sellingPrice");
            }
        }
        /*  if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "itemName");
            }
        }*/
        /*
        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "itemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
        }*/

        List<String> category = new ArrayList<String>();
        if (categoryId.length != 0) {
            for (int i = 0; i < categoryId.length; i++) {
                category.add(categoryId[i]);
                if (categoryId[i].equals("N/A")) {
                    category.clear();
                }
            }
        }

        List<String> tag = new ArrayList<String>();
        if (tagId.length != 0) {
            for (int i = 0; i < tagId.length; i++) {
                tag.add(tagId[i]);
                if (tagId[i].equals("N/A")) {
                    tag.clear();
                }
            }
        }

        List<String> subCategory = new ArrayList<String>();
        if (subCategoryId.length != 0) {
            for (int i = 0; i < subCategoryId.length; i++) {
                subCategory.add(subCategoryId[i]);
                if (subCategoryId[i].equals("N/A")) {
                    subCategory.clear();
                }
            }
        }
        List<String> attributes = new ArrayList<String>();
        if (attributesId.length != 0) {
            for (int i = 0; i < attributesId.length; i++) {
                attributes.add(attributesId[i]);
                if (attributesId[i].equals("N/A")) {
                    attributes.clear();
                }
            }
        }

        List<String> attributeValues = new ArrayList<String>();
        if (attributeValue.length != 0) {
            for (int i = 0; i < attributeValue.length; i++) {
                attributeValues.add(attributeValue[i]);
                if (attributeValue[i].equals("N/A")) {
                    attributeValues.clear();
                }
            }
        }

        String zone = zoneId;
        String sp = "0";
        String ep = "0";
        if (sp1.equals("N/A")) {
            sp = sp1;
        }
        else {
            sp = sp1;
        }
        if (ep1.equals("N/A")) {
            ep = ep1;
        }
        else {
            ep = ep1;
        }

        List<Item> itAll = new ArrayList<Item>();
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryFilterThymeleafPageRCPrice(category, zone, request);

        }
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithItemAttributesFilterThymeleafPageRCPrice(category, zone, attributes, attributeValues,
                    request);

        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithSubCategoryItemAttributesFilterThymeleafPageRCPrice(category, zone, subCategory,
                    attributes, attributeValues, request);

        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithSubCategoryFilterThymeleafPageRCPrice(category, zone, subCategory, request);

        }

        if (!category.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithSubCategoryAndTagFilterThymeleafPageRCPrice(category, zone, tag, subCategory,
                    request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithSubCategoryTagITemAttributesFilterThymeleafPageRCPrice(category, zone, tag,
                    subCategory, attributes, attributeValues, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithTagFilterThymeleafPageRCPrice(category, zone, tag, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findZoneCategoryWithTagAndItemAttributesFilterThymeleafPageRCPrice(category, zone, tag, attributes,
                    attributeValues, request);
        }

        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findZoneCategoryFilterThymeleafPageRCPriceRange(category, zone, spf, epf, request);
        }
        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findZoneCategoryWithTagFilterThymeleafPageRCPriceRange(category, zone, tag, spf, epf, request);
        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findZoneCategoryWithSubCategoryFilterThymeleafPageRCPriceRange(category, zone, subCategory, spf, epf,
                    request);
        }
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findZoneCategoryItemAttributesFilterThymeleafPageRCPriceByPriceRange(category, zone, attributes,
                    attributeValues, spf, epf, request);
        }

        if (!category.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findZoneCategoryTagSubCategoryFilterThymeleafPageRCPriceRange(category, zone, tag, subCategory, spf, epf,
                    request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && !tag.isEmpty() && subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findZoneCategoryTagItemAttributesFilterThymeleafPageRCPriceRange(category, zone, tag, attributes,
                    attributeValues, spf, epf, request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findZoneCategoryTagItemAttributesSubCategoryFilterThymeleafPageRCPriceRange(category, zone, tag,
                    subCategory, attributes, attributeValues, spf, epf, request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findZoneCategorySubCategoryItemAttributesFilterThymeleafPageRCPriceRange(category, zone, subCategory,
                    attributes, attributeValues, spf, epf, request);
        }
        itAll = getOfferAppliedSortedSellerItems(itAll, zone);
        return itAll;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItem(java.lang.String)
     */
    @Override
    public Item getItem(final String itemId) {
        Item item = new Item();
        item = itemRepository.findOne(itemId);
        return item;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemByCategoryId(java.lang.String)
     */
    @Override
    public List<Item> getItemByCategoryId(final String categoryId) {
        List<Item> items = itemRepository.findItemByCategoryId(categoryId);
        return items;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemByCategoryItemOnly(java.lang.String)
     */
    @Override
    public List<Item> getItemByCategoryItemOnly(final String categoryId) {
        List<Item> items = itemRepository.findItemByCategoryId(categoryId);
        List<Item> itms = new ArrayList<Item>();
        for (Item it : items) {
            Item i = new Item();
            i.setId(it.getId());
            i.setDescription(it.getDescription());
            i.setCreatedDate(it.getCreatedDate());
            i.setItemCode(it.getItemCode());
            i.setItemName(it.getItemName());
            i.setSubCategory(it.getSubCategory());
            i.setSellingTag(it.getSellingTag());
            i.setStatus(it.getStatus());
            i.setSeo(it.getSeo());
            itms.add(i);
        }
        return itms;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemBySubCategoryId(java.lang.String)
     */
    @Override
    public List<Item> getItemBySubCategoryId(final String subCategoryId) {
        List<Item> items = itemRepository.findItemBySubCategoryId(subCategoryId);
        Set<Item> itms = new HashSet<Item>();
        for (Item it : items) {
            Item itm = it;
            itm.setId(it.getId());
            List<SellerItem> si = sellerItemRepository.findSellerItemByItemMobileThymeleaf(it.getId());
            Set<SellerItem> sellerItems = new HashSet<SellerItem>(si);
            itm.setSellerItems(sellerItems);
            itms.add(itm);
        }

        return items;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemByThymeleafWithSellerItem(java.lang.String)
     */
    @Override
    public Item getItemByThymeleafWithSellerItem(final String itemId) {
        Item item = itemRepository.findOne(itemId);
        Item itm1 = new Item();
        itm1.setId(item.getId());
        itm1.setItemName(item.getItemName());
        itm1.setDescription(item.getDescription());
        itm1.setCreatedDate(item.getCreatedDate());
        itm1.setItemCode(item.getItemCode());
        itm1.setItemCount(item.getItemCount());
        itm1.setMeatStatus(item.getMeatStatus());
        itm1.setSellingTag(item.getSellingTag());
        itm1.setSeo(item.getSeo());
        itm1.setStatus(item.getStatus());
        itm1.setSubCategory(item.getSubCategory());
        if (item.getItemAttributeses() != null) {
            Set<ItemAttributes> itemAttributes = new HashSet<ItemAttributes>();
            for (ItemAttributes itmAttributes : item.getItemAttributeses()) {
                ItemAttributes itmAtt = new ItemAttributes();
                itmAtt.setId(itmAttributes.getId());
                itmAtt.setAttributeName(itmAttributes.getAttributeName());
                itmAtt.setAttributeValue(itmAttributes.getAttributeValue());
                itmAtt.setSearchableStatus(itmAttributes.getSearchableStatus());
                itmAtt.setCountFlag(itmAttributes.getCountFlag());
                itmAtt.setStatus(itmAttributes.getStatus());
                itmAtt.setCategoryAttributes(itmAttributes.getCategoryAttributes());
                itemAttributes.add(itmAtt);
            }
            itm1.setItemAttributeses(itemAttributes);
        }

        if (item.getSellerItems() != null) {
            Set<SellerItem> sellerItems = sellerItemService.getSellerItemsByThymeleafItem(item.getId());
            Set<SellerItem> sellrItms = new HashSet<SellerItem>();
            for (SellerItem sitm : sellerItems) {
                SellerItem si = new SellerItem();
                si.setId(sitm.getId());
                si.setSellerItemName(sitm.getSellerItemName());
                si.setSellingPrice(sitm.getSellingPrice());
                si.setItemAvailableStatus(sitm.getItemAvailableStatus());
                si.setQuantity(sitm.getQuantity());
                si.setSeo(sitm.getSeo());
                si.setSellerBranch(sitm.getSellerBranch());
                si.setSellerItemImageses(sitm.getSellerItemImageses());
                si.setSellerItemCriterias(sitm.getSellerItemCriterias());
                si.setSellerItemTaxes(sitm.getSellerItemTaxes());
                si.setSellingTag(sitm.getSellingTag());
                si.setSpecialTag(sitm.getSpecialTag());
                sellrItms.add(si);
            }
            itm1.setSellerItems(sellerItems);
        }
        if (item.getItemTagses() != null) {
            Set<ItemTags> itemTags = new HashSet<ItemTags>();
            for (ItemTags itmTags : item.getItemTagses()) {
                ItemTags itmTgs = new ItemTags();
                itmTgs.setItem(itmTags.getItem());
                itmTgs.setItemTagsStatus(itmTags.getItemTagsStatus());
                itmTgs.setTags(itmTags.getTags());
                itemTags.add(itmTgs);
            }
            itm1.setItemTagses(itemTags);
        }
        if (item.getItemImageses() != null) {
            Set<ItemImages> itemImages = new HashSet<ItemImages>();
            for (ItemImages itmImages : item.getItemImageses()) {
                ItemImages itmImags = new ItemImages();
                itmImags.setId(itmImages.getId());
                itmImags.setImageName(itmImages.getImageName());
                itmImags.setImageType(itmImages.getImageType());
                itmImags.setImageLocation(itmImages.getImageLocation());
                itmImags.setItem(itmImages.getItem());
                itemImages.add(itmImags);
            }
            itm1.setItemImageses(itemImages);
        }
        return itm1;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemByZoneAndCategory(java.lang.String, java.lang.String)
     */
    @Override
    public List<Item> getItemByZoneAndCategory(final String zoneId, final String categoryId) {
        // TODO Auto-generated method stub
        return itemRepository.findItemByCategoryAndZoneThymeleaf(zoneId, categoryId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemOnly()
     */
    @Override
    public List<Item> getItemOnly() {
        List<Item> item = new ArrayList<Item>();
        item = (List<Item>) itemRepository.findAll();
        List<Item> itemses = new ArrayList<Item>();
        for (Item it : item) {
            Item itm = new Item();
            itm.setId(it.getId());
            itm.setSubCategory(it.getSubCategory());
            itm.setItemName(it.getItemName());
            itm.setSeo(it.getSeo());
            itm.setSellingTag(it.getSellingTag());
            itm.setCreatedDate(it.getCreatedDate());
            itm.setMeatStatus(it.getMeatStatus());
            itm.setDescription(it.getDescription());
            itm.setStatus(it.getStatus());
            itm.setItemCode(it.getItemCode());
            itm.setItemCount(it.getItemCount());
            itemses.add(itm);
        }
        return itemses;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemsByThymeleafCategory(java.lang.String, int, int, java.lang.String, java.lang.String)
     */
    @Override
    public List<Item> getItemsByThymeleafCategory(final String categoryId, final int page, final int pageSize, final String sort,
            final String type) {
        int p = page;
        int ps = pageSize;
        Pageable pageable = new PageRequest(p, ps);

        PageRequest request = null; // new PageRequest(p - 1, ps,
                                    // Sort.Direction.DESC,
                                    // "restaurantItemName");
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "itemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
        }

        List<Item> items = itemRepository.findItemByThymeleafCategory(categoryId, request);

        return items;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemsByThymeleafCategoryZone(java.lang.String, java.lang.String, int, int, java.lang.String,
     *      java.lang.String)
     */
    @Override
    public List<Item> getItemsByThymeleafCategoryZone(final String categoryId, final String zoneId, final int page, final int pageSize,
            final String sort, final String type) {
        int p = page;
        int ps = pageSize;
        Pageable pageable = new PageRequest(p, ps);

        PageRequest request = null; // new PageRequest(p - 1, ps,
                                    // Sort.Direction.DESC,
                                    // "restaurantItemName");
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        /*   else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "itemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
        }
        */

        List<Item> itemses = itemRepository.findItemByThymeleafCategoryZone(categoryId, zoneId, request);
        if (zoneId != null) {
            List<Item> items = getOfferAppliedSortedSellerItems(itemses, zoneId);
            return items;
        }
        else {
            List<Item> items = getOfferAppliedSortedSellerItems(itemses);
            return items;
        }

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemsByThymeleafPageAllCategory(java.lang.String[], java.lang.String[], java.lang.String[],
     *      java.lang.String[], java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String)
     */
    @Override
    public List<Item> getItemsByThymeleafPageAllCategory(final String[] categoryId, final String[] subCategoryId, final String[] tagId,
            final String[] attributesId, final String[] attributeValue, final String sp1, final String ep1, final int page,
            final int pageSize, final String sort, final String type) {
        PageRequest request = null;
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "itemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "itemName");
        }

        List<String> category = new ArrayList<String>();
        if (categoryId.length != 0) {
            for (int i = 0; i < categoryId.length; i++) {
                category.add(categoryId[i]);
                if (categoryId[i].equals("N/A")) {
                    category.clear();
                }
            }
        }

        List<String> tag = new ArrayList<String>();
        if (tagId.length != 0) {
            for (int i = 0; i < tagId.length; i++) {
                tag.add(tagId[i]);
                if (tagId[i].equals("N/A")) {
                    tag.clear();
                }
            }
        }

        List<String> subCategory = new ArrayList<String>();
        if (subCategoryId.length != 0) {
            for (int i = 0; i < subCategoryId.length; i++) {
                subCategory.add(subCategoryId[i]);
                if (subCategoryId[i].equals("N/A")) {
                    subCategory.clear();
                }
            }
        }
        List<String> attributes = new ArrayList<String>();
        if (attributesId.length != 0) {
            for (int i = 0; i < attributesId.length; i++) {
                attributes.add(attributesId[i]);
                if (attributesId[i].equals("N/A")) {
                    attributes.clear();
                }
            }
        }

        List<String> attributeValues = new ArrayList<String>();
        if (attributeValue.length != 0) {
            for (int i = 0; i < attributeValue.length; i++) {
                attributeValues.add(attributeValue[i]);
                if (attributeValue[i].equals("N/A")) {
                    attributeValues.clear();
                }
            }
        }

        String sp = "0";
        String ep = "0";
        if (sp1.equals("N/A")) {
            sp = sp1;
        }
        else {
            sp = sp1;
        }
        if (ep1.equals("N/A")) {
            ep = ep1;
        }
        else {
            ep = ep1;
        }

        List<Item> itAll = new ArrayList<Item>();
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryFilterThymeleafPageRCPrice(category, request);

        }
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithItemAttributesFilterThymeleafPageRCPrice(category, attributes, attributeValues, request);

        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithSubCategoryItemAttributesFilterThymeleafPageRCPrice(category, subCategory, attributes,
                    attributeValues, request);

        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithSubCategoryFilterThymeleafPageRCPrice(category, subCategory, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithSubCategoryAndTagFilterThymeleafPageRCPrice(category, tag, subCategory, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithSubCategoryTagITemAttributesFilterThymeleafPageRCPrice(category, tag, subCategory,
                    attributes, attributeValues, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithTagFilterThymeleafPageRCPrice(category, tag, request);
        }

        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && sp.equals("N/A") && ep.equals("N/A")) {

            itAll = itemRepository.findCategoryWithTagAndItemAttributesFilterThymeleafPageRCPrice(category, tag, attributes,
                    attributeValues, request);
        }

        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findCategoryFilterThymeleafPageRCPriceRange(category, spf, epf, request);
        }
        if (!category.isEmpty() && !tag.isEmpty() && subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findCategoryWithTagFilterThymeleafPageRCPriceRange(category, tag, spf, epf, request);
        }
        if (!category.isEmpty() && tag.isEmpty() && !subCategory.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {
            BigDecimal spf = new BigDecimal(sp);
            BigDecimal epf = new BigDecimal(ep);

            itAll = itemRepository.findCategoryWithSubCategoryFilterThymeleafPageRCPriceRange(category, subCategory, spf, epf, request);
        }
        if (!category.isEmpty() && tag.isEmpty() && subCategory.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findCategoryItemAttributesFilterThymeleafPageRCPriceByPriceRange(category, attributes, attributeValues,
                    spf, epf, request);
        }

        if (!category.isEmpty() && attributes.isEmpty() && attributeValues.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findCategoryTagSubCategoryFilterThymeleafPageRCPriceRange(category, tag, subCategory, spf, epf, request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && !tag.isEmpty() && subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findCategoryTagItemAttributesFilterThymeleafPageRCPriceRange(category, tag, attributes, attributeValues,
                    spf, epf, request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && !tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findCategoryTagItemAttributesSubCategoryFilterThymeleafPageRCPriceRange(category, tag, subCategory,
                    attributes, attributeValues, spf, epf, request);
        }

        if (!category.isEmpty() && !attributes.isEmpty() && !attributeValues.isEmpty() && tag.isEmpty() && !subCategory.isEmpty()
                && !sp.equals("N/A") && !ep.equals("N/A")) {

            BigDecimal spf = new BigDecimal(sp.replaceAll(",", ""));
            BigDecimal epf = new BigDecimal(ep.replaceAll(",", ""));

            itAll = itemRepository.findCategorySubCategoryItemAttributesFilterThymeleafPageRCPriceRange(category, subCategory, attributes,
                    attributeValues, spf, epf, request);
        }
        return itAll;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemWithOutSellerItem(java.lang.String)
     */
    @Override
    public List<Item> getItemWithOutSellerItem(final String itemId) {
        List<Item> items = itemRepository.findItemWithOutSellerItem(itemId);
        List<Item> itms = new ArrayList<Item>();
        for (Item it : items) {
            Item i = new Item();
            i.setId(it.getId());
            i.setDescription(it.getDescription());
            i.setCreatedDate(it.getCreatedDate());
            i.setItemCode(it.getItemCode());
            i.setItemName(it.getItemName());
            i.setSubCategory(it.getSubCategory());
            i.setSellingTag(it.getSellingTag());
            i.setStatus(it.getStatus());
            i.setSeo(it.getSeo());
            if (it.getItemAttributeses() != null) {
                Set<ItemAttributes> itemAttributes = new HashSet<ItemAttributes>();
                for (ItemAttributes itAt : it.getItemAttributeses()) {
                    ItemAttributes itA = new ItemAttributes();
                    itA.setAttributeValue(itAt.getAttributeValue());
                    itA.setAttributes(itAt.getAttributes());
                    itA.setCategoryAttributes(itAt.getCategoryAttributes());
                    itA.setItem(itAt.getItem());
                    itA.setStatus(itAt.getStatus());
                    itA.setId(itAt.getId());
                    itemAttributes.add(itA);
                }
                i.setItemAttributeses(itemAttributes);
            }
            if (it.getItemTagses() != null) {
                Set<ItemTags> itemTags = new HashSet<ItemTags>();
                for (ItemTags itags : it.getItemTagses()) {
                    ItemTags itg = new ItemTags();
                    itg.setId(itags.getId());
                    itg.setItem(itags.getItem());
                    itg.setItemTagsStatus(itags.getItemTagsStatus());
                    itg.setTags(itags.getTags());
                    itemTags.add(itg);
                }
                i.setItemTagses(itemTags);
            }
            if (it.getItemImageses() != null) {
                Set<ItemImages> itmImages = new HashSet<ItemImages>();
                for (ItemImages itImages : it.getItemImageses()) {
                    ItemImages itImg = new ItemImages();
                    itImg.setId(itImages.getId());
                    itImg.setImageName(itImages.getImageName());
                    itImg.setImageLocation(itImages.getImageLocation());
                    itImg.setImageType(itImages.getImageType());
                    itImg.setItem(itImages.getItem());
                    itmImages.add(itImg);
                }
                i.setItemImageses(itmImages);
            }
            itms.add(i);
        }
        return itms;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getItemWithSellerItem(java.lang.String)
     */
    @Override
    public List<Item> getItemWithSellerItem(final String itemId) {
        List<Item> items = itemRepository.findItemWithOutSellerItem(itemId);
        List<Item> itms = new ArrayList<Item>();
        for (Item it : items) {
            Item i = new Item();
            i.setId(it.getId());
            i.setDescription(it.getDescription());
            i.setCreatedDate(it.getCreatedDate());
            i.setItemCode(it.getItemCode());
            i.setItemName(it.getItemName());
            i.setSubCategory(it.getSubCategory());
            i.setSellingTag(it.getSellingTag());
            i.setStatus(it.getStatus());
            i.setSeo(it.getSeo());
            if (it.getItemAttributeses() != null) {
                Set<ItemAttributes> itemAttributes = new HashSet<ItemAttributes>();
                for (ItemAttributes itAt : it.getItemAttributeses()) {
                    ItemAttributes itA = new ItemAttributes();
                    itA.setAttributeValue(itAt.getAttributeValue());
                    itA.setAttributes(itAt.getAttributes());
                    itA.setCategoryAttributes(itAt.getCategoryAttributes());
                    itA.setItem(itAt.getItem());
                    itA.setStatus(itAt.getStatus());
                    itA.setId(itAt.getId());
                    itemAttributes.add(itA);
                }
                i.setItemAttributeses(itemAttributes);
            }
            if (it.getItemTagses() != null) {
                Set<ItemTags> itemTags = new HashSet<ItemTags>();
                for (ItemTags itags : it.getItemTagses()) {
                    ItemTags itg = new ItemTags();
                    itg.setId(itags.getId());
                    itg.setItem(itags.getItem());
                    itg.setItemTagsStatus(itags.getItemTagsStatus());
                    itg.setTags(itags.getTags());
                    itemTags.add(itg);
                }
                i.setItemTagses(itemTags);
            }
            if (it.getItemImageses() != null) {
                Set<ItemImages> itmImages = new HashSet<ItemImages>();
                for (ItemImages itImages : it.getItemImageses()) {
                    ItemImages itImg = new ItemImages();
                    itImg.setId(itImages.getId());
                    itImg.setImageName(itImages.getImageName());
                    itImg.setImageLocation(itImages.getImageLocation());
                    itImg.setImageType(itImages.getImageType());
                    itImg.setItem(itImages.getItem());
                    itmImages.add(itImg);
                }
                i.setItemImageses(itmImages);
            }
            if (it.getSellerItems() != null) {
                Set<SellerItem> sellerItms = new HashSet<SellerItem>();
                for (SellerItem slrItm : it.getSellerItems()) {
                    SellerItem si = new SellerItem();
                    si.setId(slrItm.getId());
                    si.setSellerItemName(slrItm.getSellerItemName());
                    si.setItemAvailableStatus(slrItm.getItemAvailableStatus());
                    si.setQuantity(slrItm.getQuantity());
                    si.setSellingPrice(slrItm.getSellingPrice());
                    si.setBaseUnit(slrItm.getBaseUnit());
                    si.setMeasurementUnit(slrItm.getMeasurementUnit());
                    si.setSellerBranch(slrItm.getSellerBranch());
                    si.setItem(slrItm.getItem());
                    si.setSeo(slrItm.getSeo());
                    si.setSellerStock(slrItm.getSellerStock());
                    sellerItms.add(si);
                }
                i.setSellerItems(sellerItms);
            }
            itms.add(i);
        }
        return itms;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return itemRepository.getMaxCode();
    }

    protected List<Item> getOfferAppliedSortedSellerItems(final List<Item> items) {
        List<Item> itms = new ArrayList<Item>();
        for (Item it : items) {
            Item item = it;
            item.setId(it.getId());

            List<SellerItem> sellerItems = sellerItemService
                    .getSellerItemWithOffer(sellerItemRepository.findSellerItemByThymeleafItem(it.getId()));
            Set<SellerItem> sellerItms = new HashSet<SellerItem>(sellerItems);
            item.setSellerItems(sellerItms);
            itms.add(item);
        }

        return itms;
    }

    /**
     * @param itemses
     * @param zoneId
     * @return
     */
    private List<Item> getOfferAppliedSortedSellerItems(final List<Item> itemses, final String zoneId) {
        List<Item> itms = new ArrayList<Item>();
        for (Item it : itemses) {
            Item item = it;
            item.setId(it.getId());

            List<SellerItem> sellerItems = sellerItemService
                    .getSellerItemWithOffer(sellerItemRepository.findSellerItemByThymeleafItemZone(it.getId(), zoneId));
            Set<SellerItem> sellerItms = new HashSet<SellerItem>(sellerItems);
            item.setSellerItems(sellerItms);
            itms.add(item);
        }
        return itms;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getSearchItemsByZoneOnly(java.lang.String, java.lang.String, int)
     */
    @Override
    public List<Item> getSearchItemsByZoneOnly(final String zoneId, final String searchTerm, final int pageSize) {
        List<Item> items = new ArrayList<Item>();
        List<Item> returnItems = new ArrayList<Item>();
        if (StringUtils.isBlank(searchTerm)) {
            return itemRepository.findByAll();
        }
        Pageable page = new PageRequest(0, pageSize);
        items = itemRepository.splitSearchTermAndRemoveIgnoredCharactersDCCNByZone(zoneId, searchTerm, page);
        returnItems = getOfferAppliedSortedSellerItems(items, zoneId);
        List<Item> dproduct = new ArrayList<Item>();

        for (Item itm : items) {
            Item p = new Item();
            p.setId(itm.getId());
            p.setItemName(itm.getItemName());
            p.setItemImageses(itm.getItemImageses());
            p.setDescription(itm.getDescription());
            p.setSeo(itm.getSeo());
            p.setSellingTag(itm.getSellingTag());
            p.setStatus(itm.getStatus());

            Set<SellerItem> sellerItems = sellerItemRepository.findSellerItemBySearchItem(itm.getId());
            Set<SellerItem> sitems = new HashSet<SellerItem>();
            for (SellerItem si : sellerItems) {
                SellerItem sitm = new SellerItem();
                sitm.setId(si.getId());
                sitm.setSellingPrice(si.getSellingPrice());
                sitm.setItem(si.getItem());
                sitm.setItemAvailableStatus(si.getItemAvailableStatus());
                sitm.setMeasurementUnit(si.getMeasurementUnit());
                sitm.setBaseUnit(si.getBaseUnit());
                sitm.setOfferPrice(si.getOfferPrice());
                sitm.setQuantity(si.getQuantity());
                sitm.setMarketPrice(si.getMarketPrice());

                sitm.setSeo(si.getSeo());
                sitm.setSellerBranch(si.getSellerBranch());
                sitems.add(sitm);
            }
            p.setSellerItems(sitems);
            dproduct.add(p);
            if (dproduct.size() > pageSize - 1) {
                break;
            }
        }

        return returnItems;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getSearchItemsOnly(java.lang.String)
     */
    @Override
    public List<Item> getSearchItemsOnly(final String searchTerm) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getSearchItemsOnly(java.lang.String, int)
     */
    @Override
    public List<Item> getSearchItemsOnly(final String searchTerm, final int pageSize) {
        List<Item> items = new ArrayList<Item>();
        if (StringUtils.isBlank(searchTerm)) {
            return itemRepository.findByAll();
        }
        Pageable page = new PageRequest(0, 15);
        String[] searchTermArray = searchTerm.split(" +");

        items = itemRepository.splitSearchTermAndRemoveIgnoredCharactersDCCNWithOutZone(searchTerm);
        items = getOfferAppliedSortedSellerItems(items);

        List<Item> dproduct = new ArrayList<Item>();
        for (Item itm : items) {
            Item p = new Item();
            p.setId(itm.getId());
            p.setItemName(itm.getItemName());
            p.setItemImageses(itm.getItemImageses());
            p.setDescription(itm.getDescription());
            p.setSeo(itm.getSeo());
            p.setSellingTag(itm.getSellingTag());
            p.setStatus(itm.getStatus());

            Set<SellerItem> sellerItems = sellerItemRepository.findSellerItemBySearchItem(itm.getId());
            Set<SellerItem> sitems = new HashSet<SellerItem>();
            for (SellerItem si : sellerItems) {
                SellerItem sitm = new SellerItem();
                sitm.setId(si.getId());
                sitm.setSellingPrice(si.getSellingPrice());
                sitm.setItem(si.getItem());
                sitm.setItemAvailableStatus(si.getItemAvailableStatus());
                sitm.setMeasurementUnit(si.getMeasurementUnit());
                sitm.setBaseUnit(si.getBaseUnit());
                sitm.setQuantity(si.getQuantity());
                sitm.setSeo(si.getSeo());
                sitm.setMarketPrice(si.getMarketPrice());
                sitm.setSellerBranch(si.getSellerBranch());
                sitm.setOfferPrice(si.getOfferPrice());
                sitems.add(sitm);

            }
            p.setSellerItems(sitems);
            dproduct.add(p);
            if (dproduct.size() > pageSize - 1) {
                break;
            }
        }
        return dproduct;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#getSubCatRelativeRelativeItemsPage(java.lang.String, int, int)
     */
    @Override
    public List<Item> getSubCatRelativeRelativeItemsPage(final String subCategoryId, final String zoneId, final int p, final int pz) {
        Pageable pageable = new PageRequest(p, pz);
        PageRequest request = new PageRequest(p - 1, pz, Sort.Direction.DESC, "itemName");

        List<Item> items = new ArrayList<Item>();

        items = itemRepository.getSubCategoryItems(subCategoryId, zoneId, request);
        return items;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemService#updateItem(com.meat.domain.Item)
     */
    @Override
    public Item updateItem(final Item item) {
        Item i = new Item();

        i.setId(item.getId());
        if (item.getItemName() != null) {
            item.setItemName(item.getItemName());
        }
        if (item.getDescription() != null) {
            item.setDescription(item.getDescription());
        }
        if (item.getStatus() != null) {
            item.setStatus(item.getStatus());
        }
        if (item.getSellingTag() != null) {
            item.setSellingTag(item.getSellingTag());
        }

        if (item.getSubCategory() != null) {
            SubCategory subCategory = new SubCategory();
            subCategory.setId(item.getSubCategory().getId());
            i.setSubCategory(subCategory);

        }

        if (item.getSeo() != null) {
            Seo seo = seoService.getSeo(item.getSeo().getId());

            seo.setId(item.getSeo().getId());
            seo.setSeoTitle(item.getSeo().getSeoTitle());
            seo.setSeoKeywords(item.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(item.getSeo().getSeoMetaDescription());
            seo = seoService.updateSeo(seo);
            item.setSeo(seo);
        }
        Set<ItemTags> itetags = new HashSet<ItemTags>();
        if (item.getItemTagses() != null) {
            for (ItemTags tagModel : item.getItemTagses()) {

                ItemTags itemTags = new ItemTags();
                // ItemTags itemTags = itemTagsService.getItemTags(tgModel.getId());
                itemTags.setId(tagModel.getId());
                itemTags.setItem(item);
                itemTags.setItemTagsStatus(tagModel.getItemTagsStatus());
                Tags tags = new Tags();
                tags.setId(tagModel.getTags().getId());
                itemTags.setTags(tags);
                itemTags = itemTagsService.create(itemTags);
                itetags.add(itemTags);
            }
            item.setItemTagses(itetags);
        }

        /* Set<ItemTags> iteTagses = new HashSet<ItemTags>();
         if (item.getItemTagses() != null) {
             for (ItemTags tagModel : item.getItemTagses()) {
                 if (tagModel.getId() != null) {
                     ItemTags itemTags = itemTagsService.getItemTags(tgModel
                                     .getId());
                     ItemTags itemTags = new ItemTags();
                     itemTags.setId(tagModel.getId());
                     itemTags.setItem(item);
                     if (tagModel.getItemTagsStatus() != null) {
                         itemTags.setItemTagsStatus(tagModel.getItemTagsStatus());
                     }
                     if (tagModel.getTags().getId() != null) {
                         Tags tags = new Tags();
                         Tags tags = tagsService.getTags(itemTags.getTags()
                                         .getId());
                         tags.setId(tagModel.getTags().getId());
                         tags.setTagName(tagModel.getTags().getTagName());
                         tags = tagsService.updateTags(tags);
                         itemTags.setTags(tags);
                     }
                     itemTags = itemTagsService.updateItemTags(itemTags);
                     iteTagses.add(itemTags);
        
                 }
                 else {
                     ItemTags itemTags = new ItemTags();
                     itemTags.setItem(item);
                     Tags tags = new Tags();
                     tags.setId(tagModel.getTags().getId());
                     itemTags.setTags(tags);
                     itemTags.setItemTagsStatus(tagModel.getItemTagsStatus());
        
                     itemTags = itemTagsService.create(itemTags);
                     iteTagses.add(itemTags);
                     item.setItemTagses(iteTagses);
                 }
        
             }
         }
         */
        return itemRepository.save(item);
    }

}
