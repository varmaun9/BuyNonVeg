/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 *
 */

@RestController
@RequestMapping(value = "/category", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryController {

    private IBusinessDelegate<CategoryModel, CategoryContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryContext> categoryContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryModel> createCategory(@RequestBody final CategoryModel categoryModel) {
        businessDelegate.create(categoryModel);
        return new ResponseEntity<CategoryModel>(categoryModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryModel> edit(@PathVariable(value = "id") final String categoryId,
            @RequestBody final CategoryModel categoryModel) {
        //CategoryContext categoryContext = new CategoryContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryId), categoryModel);
        return new ResponseEntity<CategoryModel>(categoryModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAll() {
        CategoryContext categoryContext = categoryContextFactory.getObject();
        categoryContext.setAll("all");
        Collection<CategoryModel> categoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<CategoryModel>> models = new CollectionModelWrapper<CategoryModel>(CategoryModel.class, categoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/categoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryOnly() {
        CategoryContext categoryContext = categoryContextFactory.getObject();
        categoryContext.setCategoryOnly("categoryOnly");
        Collection<CategoryModel> categoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<CategoryModel>> models = new CollectionModelWrapper<CategoryModel>(CategoryModel.class, categoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/categoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryOnlyBySeller(@PathVariable(value = "sellerId") final String sellerId) {
        CategoryContext categoryContext = categoryContextFactory.getObject();
        categoryContext.setCategoryOnly("categoryOnly");
        categoryContext.setSellerId(sellerId);
        Collection<CategoryModel> categoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<CategoryModel>> models = new CollectionModelWrapper<CategoryModel>(CategoryModel.class, categoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}/categoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryOnlyBySellerBranch(
            @PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        CategoryContext categoryContext = categoryContextFactory.getObject();
        categoryContext.setCategoryOnly("categoryOnly");
        categoryContext.setSellerBranchId(sellerBranchId);
        Collection<CategoryModel> categoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<CategoryModel>> models = new CollectionModelWrapper<CategoryModel>(CategoryModel.class, categoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{categoryId}/subCategoryAndCatAttributes", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubCategoryAndCatAttributes(@PathVariable(value = "categoryId") final String categoryId) {
        CategoryContext categoryContext = categoryContextFactory.getObject();
        categoryContext.setCategoryOnly("categoryOnly");
        categoryContext.setCategoryId(categoryId);
        Collection<CategoryModel> categoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<CategoryModel>> models = new CollectionModelWrapper<CategoryModel>(CategoryModel.class, categoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryModel> getCategory(@PathVariable(value = "id") final String categoryId) {
        CategoryContext categoryContext = categoryContextFactory.getObject();

        CategoryModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryId), categoryContext);
        return new ResponseEntity<CategoryModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryObjectFactory(final ObjectFactory<CategoryContext> categoryContextFactory) {
        this.categoryContextFactory = categoryContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
