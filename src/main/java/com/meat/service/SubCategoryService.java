package com.meat.service;

import com.meat.dao.*;
import com.meat.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SubCategoryService implements ISubCategoryService {
    @Autowired
    private ISeoService seoService;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private SubCategoryAttributesRepository subCategoryAttributesRepository;
    @Autowired
    private ISubCategoryImagesService subCategoryImagesService;
    @Autowired
    private SubCategoryImagesRepository subCategoryImagesRepository;
    @Autowired
    private SubCategoryTagsRepository subCategoryTagsRepository;
    @Autowired
    private ISubCategoryAttributesService subCategoryAttributesService;
    @Autowired
    private ISubCategoryTagsService subCategoryTagsService;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SellerBranchRepository sellerBranchRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#addSubCategoryAttributes(com.meat.domain.SubCategory, java.util.List)
     */
    @Override
    public SubCategory addSubCategoryAttributes(final SubCategory subCategory, final List<SubCategoryAttributes> subCatAttributes) {
        Validate.notNull(subCategory, "subCategory must not be null");
        Set<SubCategoryAttributes> addAttributes = new HashSet<SubCategoryAttributes>(subCatAttributes);
        for (SubCategoryAttributes subCategoryAttr : subCatAttributes) {
            SubCategoryAttributes subCategoryAttributes = new SubCategoryAttributes();
            if (subCategoryAttr.getId() != null) {
                subCategoryAttributes = subCategoryAttributesService.getSubCategoryAttributes(subCategoryAttr.getId());
                subCategoryAttributes.setId(subCategoryAttr.getId());
                subCategoryAttributes.setAttributeValue(subCategoryAttr.getAttributeValue());
                subCategoryAttributes.setStatus(subCategoryAttr.getStatus());
                subCategoryAttributes.setAttributes(subCategoryAttr.getAttributes());
                subCategoryAttributes.setSubCategory(subCategoryAttributes.getSubCategory());
                subCategoryAttributes = subCategoryAttributesService.updateSubCategoryAttributes(subCategoryAttributes);
            }
            subCategoryAttributes.setAttributes(subCategoryAttr.getAttributes());
            subCategoryAttributes.setSubCategory(subCategoryAttr.getSubCategory());
            subCategoryAttributes.setAttributeValue(subCategoryAttr.getAttributeValue());
            subCategoryAttributes.setStatus(subCategoryAttr.getStatus());
            addAttributes.add(subCategoryAttributes);
            subCategoryAttributes = subCategoryAttributesRepository.save(subCategoryAttributes);
        }
        subCategory.setSubCategoryAttributeses(addAttributes);
        return subCategory;
    }

    @Override
    public SubCategory addSubCategoryImages(final SubCategory subCategory, final List<SubCategoryImages> subCategoryImages) {
        Validate.notNull(subCategory, "subCategory must not be null");
        Set<SubCategoryImages> addImages = new HashSet<SubCategoryImages>(subCategoryImages);
        for (SubCategoryImages subImages : subCategoryImages) {
            SubCategoryImages subCategoryImages1 = new SubCategoryImages();
            String s = subImages.getImageName();
            s = s.replaceAll("\\\\", "/");
            if (subImages.getId() != null) {
                subCategoryImages1 = subCategoryImagesService.getSubCategoryImages(subImages.getId());
                subCategoryImages1.setId(subCategoryImages1.getId());
                subCategoryImages1.setImageName(s);
                subCategoryImages1.setImageType(subImages.getImageType());
                subCategoryImages1.setImageLocation(subImages.getImageLocation());
                subCategoryImages1.setSubCategory(subCategoryImages1.getSubCategory());
                subCategoryImages1 = subCategoryImagesService.updateSubCategoryImages(subCategoryImages1);
            }
            else {
                subCategoryImages1.setImageName(s);
                subCategoryImages1.setImageType(subImages.getImageType());
                subCategoryImages1.setImageLocation(subImages.getImageLocation());
                subCategoryImages1.setSubCategory(subCategory);
                addImages.add(subCategoryImages1);
                subCategoryImages1 = subCategoryImagesRepository.save(subCategoryImages1);
            }
        }
        subCategory.setSubCategoryImageses(addImages);
        return subCategory;
    }

    @Override
    public SubCategory addSubCategoryTags(final SubCategory subCategory, final List<SubCategoryTags> subCategoryTags) {
        Validate.notNull(subCategory, "subCategory must not be null");
        Set<SubCategoryTags> addTags = new HashSet<SubCategoryTags>(subCategoryTags);
        for (SubCategoryTags subCatTag : subCategoryTags) {
            SubCategoryTags subCategoryTags1 = new SubCategoryTags();
            if (subCatTag.getId() != null) {
                subCategoryTags1 = subCategoryTagsService.getSubCategoryTags(subCatTag.getId());
                subCategoryTags1.setId(subCatTag.getId());
                subCategoryTags1.setSubCategory(subCategoryTags1.getSubCategory());
                subCategoryTags1.setSubCategoryTagsStatus(subCatTag.getSubCategoryTagsStatus());
                subCategoryTags1.setTags(subCatTag.getTags());
                subCategoryTags1 = subCategoryTagsService.updateSubCategoryTags(subCategoryTags1);
            }
            else {
                subCategoryTags1.setTags(subCatTag.getTags());
                subCategoryTags1.setSubCategory(subCatTag.getSubCategory());
                subCategoryTags1.setSubCategoryTagsStatus(subCatTag.getSubCategoryTagsStatus());
                addTags.add(subCategoryTags1);
                subCategoryTags1 = subCategoryTagsRepository.save(subCategoryTags1);
            }
        }
        subCategory.setSubCategoryTagses(addTags);
        return subCategory;
    }

    @Override
    @Transactional
    public SubCategory create(final SubCategory subCategory) {

        Validate.notNull(subCategory, "subCategory must not be null" + subCategory.getSubCategoryName());
        List<SubCategory> sub = new ArrayList<SubCategory>();
        sub = (List<SubCategory>) subCategoryRepository.findAll();
        if (sub != null) {
            for (SubCategory sc : sub) {
                String m = sc.getSubCategoryName();
                String mc = m.replaceAll("\\s", "");
                String mc1 = mc.toLowerCase();

                if (subCategory.getSubCategoryName() != null) {
                    String mc2 = subCategory.getSubCategoryName().replaceAll("\\s", "").toLowerCase();
                    if (mc1.equals(mc2)) {
                        subCategory.setSubCategoryName("Duplicate");
                    }
                }
            }
        }
        if (subCategory.getSubCategoryName() != null) {
            if (subCategory.getSubCategoryName().equals("Duplicate")) {
                subCategory.getSubCategoryName().equals("Duplicate");
            }
            else {
                SubCategory subCategory1 = new SubCategory();
                if (subCategory.getSeo() != null) {
                    Seo seo = new Seo();
                    seo.setSeoTitle(subCategory.getSeo().getSeoTitle());
                    seo.setSeoKeywords(subCategory.getSeo().getSeoKeywords());
                    seo.setSeoMetaDescription(subCategory.getSeo().getSeoMetaDescription());
                    seo = seoService.create(seo);
                    subCategory.setSeo(seo);
                }
                subCategory1 = subCategoryRepository.save(subCategory);
            }
        }

        return subCategory;

    }

    @Override
    public void deleteSubCategory(final String subCategoryId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SubCategory> getAll() {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = (List<SubCategory>) subCategoryRepository.findAll();
        return subCategory;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getAllSubCategoryByCategoryId(java.lang.String)
     */
    @Override
    public List<SubCategory> getAllSubCategoryByCategoryId(final String categoryId) {
        List<SubCategory> subCategory = subCategoryRepository.findAllSubCategoryByCategory(categoryId);

        return subCategory;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getByCategoryId(java.lang.String)
     */
    @Override
    public List<SubCategory> getByCategoryId(final String categoryId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getItemSubCategoriesByThymeleafCategory(java.lang.String)
     */
    @Override
    public List<SubCategory> getItemSubCategoriesByThymeleafCategory(final String categoryId) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = subCategoryRepository.findItemSubCategoryThymeleafByCategory(categoryId);
        return subCategory;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSubCategoriesByThymeleafCategory(java.lang.String, java.lang.String)
     */
    @Override
    public List<SubCategory> getItemSubCategoriesByThymeleafCategoryZone(final String categoryId, final String zoneId) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = subCategoryRepository.findItemSubCategoryThymeleafByCategoryZone(categoryId, zoneId);
        return subCategory;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {

        return subCategoryRepository.getMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSearchItemSubCategoryByZoneOnly(java.lang.String, java.lang.String)
     */
    @Override
    public List<SubCategory> getSearchItemSubCategoryByZoneOnly(final String zoneId, final String searchTerm) {
        List<SubCategory> subCategorys = new ArrayList<SubCategory>();
        if (StringUtils.isBlank(searchTerm)) {
            return subCategoryRepository.findByAll();
        }
        // Pageable page = new PageRequest(0, 15);
        /*products = categoryRepository.splitSearchTermAndRemoveIgnoredCharactersDCCNByZone(searchTerm, userId);*/
        subCategorys = subCategoryRepository.splitSearchTermAndRemoveIgnoredCharactersDCCN(zoneId, searchTerm/*, page*/);
        /* subCategorys = subCategoryRepository.findByAll();*/
        List<SubCategory> subCatgs = new ArrayList<SubCategory>();
        for (SubCategory subCategory : subCategorys) {
            SubCategory sc = new SubCategory();
            sc.setId(subCategory.getId());
            sc.setSubCategoryName(subCategory.getSubCategoryName());
            sc.setCategory(subCategory.getCategory());
            System.out.println(":vsdvbds" + subCategory.getCategory().getCategoryName());
            int icount = itemRepository.getZoneItemCountBySubCategory(zoneId, subCategory.getId());
            List<SellerBranch> sb = sellerBranchRepository.getSellerBranchCountBySubCategory(subCategory.getId());

            sc.setDescription(subCategory.getDescription());
            sc.setSubCategoryImageses(subCategory.getSubCategoryImageses());
            sc.setSeo(subCategory.getSeo());
            sc.setCountFlag(icount);
            sc.setStatus(Integer.toString(sb.size()));
            subCatgs.add(sc);
            if (subCatgs.size() > 10) {
                break;
            }
        }

        return subCatgs;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSearchItemSubCategoryOnly(java.lang.String)
     */
    @Override
    public List<SubCategory> getSearchItemSubCategoryOnly(final String searchTerm) {
        List<SubCategory> subCategories = new ArrayList<SubCategory>();
        if (StringUtils.isBlank(searchTerm)) {
            return subCategoryRepository.findByAll();
        }
        Pageable page = new PageRequest(0, 15);
        subCategories = subCategoryRepository.splitSearchTermAndRemoveIgnoredCharactersDCCNWithOutZone(searchTerm);
        List<SubCategory> subCatg = new ArrayList<SubCategory>();
        for (SubCategory scat : subCategories) {
            SubCategory sc = new SubCategory();
            int icount = itemRepository.getItemCountBySubCategory(scat.getId());
            List<SellerBranch> sb = sellerBranchRepository.getSellerBranchCountBySubCategory(scat.getId());
            sc.setId(scat.getId());
            sc.setSubCategoryName(scat.getSubCategoryName());
            sc.setSubCategoryImageses(scat.getSubCategoryImageses());
            sc.setDescription(scat.getDescription());
            sc.setSeo(scat.getSeo());
            sc.setSellingTag(scat.getSellingTag());
            sc.setStatus(Integer.toString(sb.size()));
            sc.setCategory(scat.getCategory());
            sc.setCountFlag(icount);

            subCatg.add(sc);
            if (subCatg.size() > 5) {
                break;
            }
        }
        return subCatg;
    }

    @Override
    public SubCategory getSubCategory(final String subCategoryId) {
        SubCategory subCategory = new SubCategory();
        subCategory = subCategoryRepository.findOne(subCategoryId);
        return subCategory;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSubCategoryByCategory(java.lang.String)
     */
    @Override
    public List<SubCategory> getSubCategoryByCategory(final String categoryId) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = subCategoryRepository.findSubCategoryByCategory(categoryId);
        List<SubCategory> subCategorys = new ArrayList<SubCategory>();
        for (SubCategory s : subCategory) {
            SubCategory sub = new SubCategory();
            sub.setId(s.getId());
            sub.setSubCategoryName(s.getSubCategoryName());
            sub.setDescription(s.getDescription());
            sub.setCreatedDate(s.getCreatedDate());
            sub.setSubCategoryCount(s.getSubCategoryCount());
            sub.setSubCategoryCode(s.getSubCategoryCode());
            sub.setStatus(s.getStatus());
            sub.setCategory(s.getCategory());
            sub.setSellingTag(s.getSellingTag());
            sub.setSeo(s.getSeo());
            subCategorys.add(sub);
        }
        return subCategorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSubCategoryBySeller(java.lang.String)
     */
    @Override
    public List<SubCategory> getSubCategoryBySeller(final String sellerId) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = subCategoryRepository.findSubCategoryBySeller(sellerId);
        List<SubCategory> subCategorys = new ArrayList<SubCategory>();
        for (SubCategory s : subCategory) {
            SubCategory sub = new SubCategory();
            sub.setId(s.getId());
            sub.setSubCategoryName(s.getSubCategoryName());
            sub.setDescription(s.getDescription());
            sub.setCreatedDate(s.getCreatedDate());
            sub.setSubCategoryCount(s.getSubCategoryCount());
            sub.setSubCategoryCode(s.getSubCategoryCode());
            sub.setStatus(s.getStatus());
            sub.setCategory(s.getCategory());
            sub.setSellingTag(s.getSellingTag());
            sub.setSeo(s.getSeo());
            subCategorys.add(sub);
        }
        return subCategorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSubCategoryBySellerBranch(java.lang.String)
     */
    @Override
    public List<SubCategory> getSubCategoryBySellerBranch(final String sellerBranchId) {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = subCategoryRepository.findSubCategoryBySellerBranch(sellerBranchId);
        List<SubCategory> subCategorys = new ArrayList<SubCategory>();
        for (SubCategory s : subCategory) {
            SubCategory sub = new SubCategory();
            sub.setId(s.getId());
            sub.setSubCategoryName(s.getSubCategoryName());
            sub.setDescription(s.getDescription());
            sub.setCreatedDate(s.getCreatedDate());
            sub.setSubCategoryCount(s.getSubCategoryCount());
            sub.setSubCategoryCode(s.getSubCategoryCode());
            sub.setStatus(s.getStatus());
            sub.setCategory(s.getCategory());
            sub.setSellingTag(s.getSellingTag());
            sub.setSeo(s.getSeo());
            subCategorys.add(sub);
        }
        return subCategorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryService#getSubCategoryOnly()
     */
    @Override
    public List<SubCategory> getSubCategoryOnly() {
        List<SubCategory> subCategory = new ArrayList<SubCategory>();
        subCategory = (List<SubCategory>) subCategoryRepository.findAll();
        List<SubCategory> subCategorys = new ArrayList<SubCategory>();
        for (SubCategory s : subCategory) {
            SubCategory sub = new SubCategory();
            sub.setId(s.getId());
            sub.setSubCategoryName(s.getSubCategoryName());
            sub.setDescription(s.getDescription());
            sub.setCreatedDate(s.getCreatedDate());
            sub.setSubCategoryCount(s.getSubCategoryCount());
            sub.setSubCategoryCode(s.getSubCategoryCode());
            sub.setStatus(s.getStatus());
            sub.setCategory(s.getCategory());
            sub.setSellingTag(s.getSellingTag());
            sub.setSeo(s.getSeo());
            subCategorys.add(sub);
        }
        return subCategorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ISubCategoryService#updateSubCategory(com.ruhungry.domain.SubCategory)
     */
    @Override
    public SubCategory updateSubCategory(final SubCategory subCategory) {
        // TODO Auto-generated method stub
        return subCategoryRepository.save(subCategory);
    }

}
