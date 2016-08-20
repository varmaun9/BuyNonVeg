/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubCategoryContext;
import com.meat.model.SubCategoryModel;
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
 * @author arthvedi
 *
 */

@RestController
@RequestMapping(value = "/subCategory", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubCategoryController {
    private IBusinessDelegate<SubCategoryModel, SubCategoryContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubCategoryContext> subCategoryContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryModel> create(@RequestBody final SubCategoryModel subCategoryModel) {
        businessDelegate.create(subCategoryModel);
        return new ResponseEntity<SubCategoryModel>(subCategoryModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubCategoryModel> edit(@PathVariable(value = "id") final String subCategoryId,
            @RequestBody final SubCategoryModel subCategoryModel) {
        SubCategoryContext subCategoryContext = new SubCategoryContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subCategoryId), subCategoryModel);
        return new ResponseEntity<SubCategoryModel>(subCategoryModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubCategory() {
        SubCategoryContext subCategoryContext = subCategoryContextFactory.getObject();
        subCategoryContext.setAll("all");
        Collection<SubCategoryModel> subCategoryModel = businessDelegate.getCollection(subCategoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubCategoryByCategory(@PathVariable(value = "categoryId") final String categoryId) {
        SubCategoryContext categoryContext = subCategoryContextFactory.getObject();
        categoryContext.setCategoryId(categoryId);
        categoryContext.setAll("all");
        Collection<SubCategoryModel> subCategoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subCategoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubCategoryOnly() {
        SubCategoryContext categoryContext = subCategoryContextFactory.getObject();
        categoryContext.setSubCategoryOnly("categoryOnly");
        categoryContext.setAll("all");
        Collection<SubCategoryModel> subCategoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryModel> getSubCategory(@PathVariable(value = "id") final String subCategoryId) {
        SubCategoryContext subCategoryContext = subCategoryContextFactory.getObject();
        SubCategoryModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subCategoryId), subCategoryContext);
        return new ResponseEntity<SubCategoryModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}/subCategoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSubCategoryOnlyByCategory(@PathVariable(value = "categoryId") final String categoryId) {
        SubCategoryContext categoryContext = subCategoryContextFactory.getObject();
        categoryContext.setSubCategoryOnly("subCategoryOnly");
        categoryContext.setCategoryId(categoryId);
        Collection<SubCategoryModel> subCategoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/subCategoryOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSubCategoryOnlyBySeller(@PathVariable(value = "sellerId") final String sellerId) {
        SubCategoryContext categoryContext = subCategoryContextFactory.getObject();
        categoryContext.setSubCategoryOnly("subCategoryOnly");
        categoryContext.setSellerId(sellerId);
        Collection<SubCategoryModel> subCategoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}/subCategoryOnly", consumes = {
            MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSubCategoryOnlyBySellerBranch(
            @PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SubCategoryContext categoryContext = subCategoryContextFactory.getObject();
        categoryContext.setSubCategoryOnly("subCategoryOnly");
        categoryContext.setSellerBranchId(sellerBranchId);
        Collection<SubCategoryModel> subCategoryModels = businessDelegate.getCollection(categoryContext);
        IModelWrapper<Collection<SubCategoryModel>> models = new CollectionModelWrapper<SubCategoryModel>(SubCategoryModel.class,
                subCategoryModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subCategoryBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Autowired
    public void setSubCategoryObjectFactory(final ObjectFactory<SubCategoryContext> subCategoryContextFactory) {
        this.subCategoryContextFactory = subCategoryContextFactory;
    }

}
