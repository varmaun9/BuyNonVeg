/**
 *
 */
package com.meat.service;

import com.meat.dao.*;
import com.meat.domain.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author
 *
 */
@Component
public class CategoryService implements ICategoryService {
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ICutTypeService cutTypeService;
    @Autowired
    private ICategoryAttributesService categoryAttributesService;
    @Autowired
    private ICategoryCriteriaService categoryCriteriaService;
    @Autowired
    private SeoRepository seoRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryImagesRepository categoryImagesRepository;
    @Autowired
    private CategoryTagsRepository categoryTagsRepository;
    @Autowired
    private ICategoryTagsService categoryTagsService;
    @Autowired
    private ICategoryImagesService categoryImagesService;
    @Autowired
    private CategoryAttributesRepository categoryAttributesRepository;
    @Autowired
    private CategoryCriteriaRepository categoryCriteriaRepository;
    @Autowired
    private ICategoryCutTypeService categoryCutTypeService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#addCategoryAttributes(com.nonveg.domain.Category, java.util.List)
     */

    @Override
    public Category addCategoryAttributes(final Category category, final List<CategoryAttributes> catAttributes) {
        Validate.notNull(category, "category must not be null");
        Set<CategoryAttributes> addAttributes = new HashSet<CategoryAttributes>(catAttributes);
        for (CategoryAttributes categoryAttr : catAttributes) {
            CategoryAttributes categoryAttributes = new CategoryAttributes();
            if (categoryAttr.getId() != null) {
                categoryAttributes = categoryAttributesService.getCategoryAttributes(categoryAttr.getId());
                categoryAttributes.setId(categoryAttr.getId());
                categoryAttributes.setAttributeValue(categoryAttr.getAttributes().getAttributeName());
                categoryAttributes.setStatus(categoryAttr.getStatus());
                categoryAttributes.setAttributes(categoryAttr.getAttributes());
                categoryAttributes.setCategory(categoryAttributes.getCategory());
                categoryAttributes = categoryAttributesService.updateCategoryAttributes(categoryAttributes);
            }
            categoryAttributes.setAttributes(categoryAttr.getAttributes());
            categoryAttributes.setCategory(category);
            categoryAttributes.setAttributeValue(categoryAttr.getAttributes().getAttributeName());
            categoryAttributes.setStatus(categoryAttr.getStatus());
            addAttributes.add(categoryAttributes);
            categoryAttributes = categoryAttributesRepository.save(categoryAttributes);
        }
        category.setCategoryAttributeses(addAttributes);
        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#addCategoryCriteria(com.meat.domain.Category, java.util.List)
     */
    @Override
    public Category addCategoryCriteria(final Category category, final List<CategoryCriteria> catCriteria) {

        Validate.notNull(category, "category must not be null");
        Set<CategoryCriteria> addCriteria = new HashSet<CategoryCriteria>(catCriteria);
        for (CategoryCriteria categoryCrite : catCriteria) {
            CategoryCriteria categoryCriteria1 = new CategoryCriteria();
            if (categoryCrite.getId() != null) {
                categoryCriteria1 = categoryCriteriaService.getCategoryCriteria(categoryCrite.getId());
                categoryCriteria1.setId(categoryCrite.getId());
                categoryCriteria1.setStatus(categoryCrite.getStatus());
                categoryCriteria1.setCriteriaValue(categoryCrite.getCriteriaValue());
                categoryCriteria1.setCriteria(categoryCrite.getCriteria());
                categoryCriteria1.setCategory(categoryCriteria1.getCategory());
                categoryCriteria1 = categoryCriteriaService.updateCategoryCriteria(categoryCriteria1);
            }
            categoryCriteria1.setCriteria(categoryCrite.getCriteria());
            categoryCriteria1.setCategory(category);
            categoryCriteria1.setCriteriaValue(categoryCrite.getCriteriaValue());
            categoryCriteria1.setStatus(categoryCrite.getStatus());
            addCriteria.add(categoryCriteria1);
            categoryCriteria1 = categoryCriteriaRepository.save(categoryCriteria1);
        }

        category.setCategoryCriterias(addCriteria);
        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#addCategoryImages(com.nonveg.domain.Category, java.util.List)
     */
    @Override
    @Transactional
    public Category addCategoryImages(final Category category, final List<CategoryImages> catImages) {
        Validate.notNull(category, "category must not be null");
        Set<CategoryImages> addImages = new HashSet<CategoryImages>(catImages);
        for (CategoryImages cImages : catImages) {
            CategoryImages categoryImages1 = new CategoryImages();
            String s = cImages.getImageName();
            s = s.replaceAll("\\\\", "/");
            if (cImages.getId() != null) {
                categoryImages1 = categoryImagesService.getCategoryImages(cImages.getId());
                //categoryImages1.setId(categoryImages1.getId());
                categoryImages1.setImageName(s);
                categoryImages1.setImageType(cImages.getImageType());
                categoryImages1.setImageLocation(cImages.getImageLocation());
                categoryImages1.setCategory(categoryImages1.getCategory());
                categoryImages1 = categoryImagesService.updateCategoryImages(categoryImages1);
            }
            else {
                categoryImages1.setImageName(s);
                categoryImages1.setImageType(cImages.getImageType());
                categoryImages1.setImageLocation(cImages.getImageLocation());
                categoryImages1.setCategory(category);
                addImages.add(categoryImages1);
                categoryImages1 = categoryImagesRepository.save(categoryImages1);
            }

        }
        category.setCategoryImageses(addImages);

        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#addCategoryTags(com.nonveg.domain.Category, java.util.List)
     */
    @Override
    public Category addCategoryTags(final Category category, final List<CategoryTags> catTags) {
        Validate.notNull(category, "category must not be null");
        Set<CategoryTags> addTags = new HashSet<CategoryTags>(catTags);
        for (CategoryTags cTags : catTags) {
            CategoryTags categoryTags1 = new CategoryTags();
            if (cTags.getId() != null) {
                categoryTags1 = categoryTagsService.getCategoryTags(cTags.getId());
                categoryTags1.setId(cTags.getId());
                categoryTags1.setTags(cTags.getTags());
                categoryTags1.setCategory(cTags.getCategory());
                categoryTags1.setCategoryTagsStatus(cTags.getCategoryTagsStatus());
                addTags.add(categoryTags1);
                categoryTags1 = categoryTagsService.updateCategoryTags(categoryTags1);
            }
            else {
                categoryTags1.setTags(cTags.getTags());
                categoryTags1.setCategory(cTags.getCategory());
                categoryTags1.setCategoryTagsStatus(cTags.getCategoryTagsStatus());
                addTags.add(categoryTags1);
                categoryTags1 = categoryTagsRepository.save(categoryTags1);
            }
            category.setCategoryTagses(addTags);
        }
        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#addCutTypes(com.meat.domain.Category, java.util.List)
     */
    @Override
    public Category addCutTypes(final Category category, final List<CategoryCutType> categoryCutTypes) {
        Validate.notNull(category, "category must not be null");
        Set<CategoryCutType> addCutTypes = new HashSet<CategoryCutType>(categoryCutTypes);
        for (CategoryCutType cutType : categoryCutTypes) {
            CategoryCutType cutType1 = cutType;
            cutType1.setCategory(category);
            cutType1 = categoryCutTypeService.create(cutType1);
            addCutTypes.add(cutType1);
        }
        category.setCategoryCutTypes(addCutTypes);
        return category;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#create(com.ruhungry.domain.Category)
     */
    @Override
    @Transactional
    public Category create(final Category category) {
        Category category1 = new Category();
        if (category.getSeo() != null) {
            Seo seo = new Seo();
            seo.setSeoTitle(category.getSeo().getSeoTitle());
            seo.setSeoKeywords(category.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(category.getSeo().getSeoMetaDescription());
            seo = seoService.create(seo);
            category.setSeo(seo);
        }
        Validate.notNull(category, "category must not be null" + category.getCategoryName());

        List<Category> cat = new ArrayList<Category>();
        cat = (List<Category>) categoryRepository.findAll();
        if (cat != null) {
            for (Category c : cat) {
                String m = c.getCategoryName();
                String mc = m.replaceAll("\\s", "");
                String mc1 = mc.toLowerCase();
                if (category.getCategoryName() != null) {
                    String mc2 = category.getCategoryName().replaceAll("\\s", "").toLowerCase();
                    if (mc1.equals(mc2)) {
                        category.setCategoryName("DUPLICATE");
                    }
                }
            }
        }
        if (category.getCategoryName() != null) {

            if (category.getCategoryName().equals("Duplicate")) {
                category.getCategoryName().equals("Duplicate");
                return category;
            }
            else {
                category1 = categoryRepository.save(category);
            }
        }
        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#deleteCategory(java.lang.String)
     */
    @Override
    public void deleteCategory(final String categoryId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#getAll()
     */
    @Override
    @Transactional
    public List<Category> getAll() {
        List<Category> category = new ArrayList<Category>();
        category = (List<Category>) categoryRepository.findAll();
        return category;
    }

    @Override
    public List<Category> getCategoriesOnlyBySeller(final String sellerId) {
        List<Category> categories = new ArrayList<Category>();
        categories = categoryRepository.findCategoriesOnlyBySeller(sellerId);
        List<Category> categorys = new ArrayList<Category>();
        for (Category category : categories) {
            Category cat = new Category();
            cat.setId(category.getId());
            cat.setCategoryName(category.getCategoryName());
            cat.setCategoryCode(category.getCategoryCode());
            cat.setDescription(category.getDescription());
            cat.setSellingTag(category.getSellingTag());
            cat.setStatus(category.getStatus());
            cat.setSeo(category.getSeo());
            categorys.add(cat);
        }
        return categorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getCategoriesOnlyBySellerBranch(java.lang.String)
     */
    @Override
    public List<Category> getCategoriesOnlyBySellerBranch(final String sellerBranchId) {
        // TODO Auto-generated method stub
        return categoryRepository.findCategoriesOnlyBySellerBranch(sellerBranchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#getCategory(java.lang.String)
     */
    @Override
    public Category getCategory(final String categoryId) {
        Category category = new Category();
        category = categoryRepository.findOne(categoryId);
        return category;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getCategoryOnly()
     */
    @Override
    public List<Category> getCategoryOnly() {
        List<Category> category = new ArrayList<Category>();
        category = (List<Category>) categoryRepository.findAll();
        List<Category> categorys = new ArrayList<Category>();
        for (Category c : category) {
            Category cat = new Category();
            cat.setId(c.getId());
            cat.setCategoryName(c.getCategoryName());
            cat.setCreatedDate(c.getCreatedDate());
            cat.setDescription(c.getDescription());
            cat.setStatus(c.getStatus());
            cat.setCategoryCode(c.getCategoryCode());
            cat.setCategoryCount(c.getCategoryCount());
            cat.setSellingTag(c.getSellingTag());
            cat.setSeo(c.getSeo());
            categorys.add(cat);
        }
        return categorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return categoryRepository.getMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getCategoriesOnlyBySeller(java.lang.String)
     */

    @Override
    public List<Category> getSearchItemCategoryByZoneOnly(final String zoneId, final String searchTerm) {
        List<Category> category = new ArrayList<Category>();
        if (StringUtils.isBlank(searchTerm)) {

            category = (List<Category>) categoryRepository.findAll();
            List<Category> categorys = new ArrayList<Category>();
            for (Category c : category) {
                Category cat = new Category();
                cat.setId(c.getId());
                cat.setCategoryName(c.getCategoryName());
                cat.setCreatedDate(c.getCreatedDate());
                cat.setDescription(c.getDescription());
                cat.setStatus(c.getStatus());
                cat.setCategoryCode(c.getCategoryCode());
                cat.setCategoryCount(c.getCategoryCount());
                cat.setSellingTag(c.getSellingTag());
                cat.setSeo(c.getSeo());
                categorys.add(cat);
            }
            return categorys;
        }

        return categoryRepository.findByAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getSearchItemCategoryOnly(java.lang.String)
     */
    @Override
    public List<Category> getSearchItemCategoryOnly(final String searchTerm) {
        List<Category> category = new ArrayList<Category>();
        if (StringUtils.isBlank(searchTerm)) {

            category = (List<Category>) categoryRepository.findAll();
            List<Category> categorys = new ArrayList<Category>();
            for (Category c : category) {
                Category cat = new Category();
                cat.setId(c.getId());
                cat.setCategoryName(c.getCategoryName());
                cat.setCreatedDate(c.getCreatedDate());
                cat.setDescription(c.getDescription());
                cat.setStatus(c.getStatus());
                cat.setCategoryCode(c.getCategoryCode());
                cat.setCategoryCount(c.getCategoryCount());
                cat.setSellingTag(c.getSellingTag());
                cat.setSeo(c.getSeo());
                categorys.add(cat);
            }
            return categorys;
        }
        return categoryRepository.findByAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ICategoryService#getSubCategoriesAndCatAttributes(java.lang.String)
     */
    @Override
    public List<Category> getSubCategoriesAndCatAttributes(final String categoryId) {
        List<Category> categories = new ArrayList<Category>();
        categories = categoryRepository.findSubCategoriesAndCatAttributes(categoryId);
        List<Category> categorys = new ArrayList<Category>();
        for (Category category : categories) {
            Category cat = new Category();
            cat.setId(category.getId());
            cat.setCategoryName(category.getCategoryName());
            cat.setStatus(category.getStatus());
            if (category.getSubCategories() != null) {
                Set<SubCategory> subCategories = new HashSet<SubCategory>();
                for (SubCategory subC : category.getSubCategories()) {
                    SubCategory sbc = new SubCategory();
                    sbc.setId(subC.getId());
                    sbc.setSubCategoryName(subC.getSubCategoryName());
                    subCategories.add(sbc);

                }
                cat.setSubCategories(subCategories);
            }
            if (category.getCategoryAttributeses() != null) {
                Set<CategoryAttributes> catAttributes = new HashSet<CategoryAttributes>();
                for (CategoryAttributes catAtt : category.getCategoryAttributeses()) {
                    CategoryAttributes catAt = new CategoryAttributes();
                    catAt.setId(catAtt.getId());
                    catAt.setAttributes(catAtt.getAttributes());
                    catAt.setStatus(catAtt.getStatus());
                    // catAt.setAttributeValue(catAtt.getAttributeValue());
                    catAttributes.add(catAt);
                }
                cat.setCategoryAttributeses(catAttributes);
            }

            categorys.add(cat);
        }
        return categorys;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ICategoryService#updateCategory(com.nonveg.domain.Category)
     */
    @Override
    public Category updateCategory(final Category category) {
        // TODO Auto-generated method stub
        return categoryRepository.save(category);
    }

}
