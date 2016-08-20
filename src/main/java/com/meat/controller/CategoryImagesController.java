/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryImagesContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryImagesModel;
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
 * @author varma
 *
 */
@RestController
@RequestMapping(value = "/categoryImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryImagesController {

    private IBusinessDelegate<CategoryImagesModel, CategoryImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryImagesContext> categoryImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryImagesModel> createCategoryImages(@RequestBody final CategoryImagesModel CategoryImagesModel) {
        businessDelegate.create(CategoryImagesModel);
        return new ResponseEntity<CategoryImagesModel>(CategoryImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryImagesModel> edit(@PathVariable(value = "id") final String categoryImagesId,
            @RequestBody final CategoryImagesModel CategoryImagesModel) {

        CategoryImagesContext categoryImagesContext = new CategoryImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryImagesId), CategoryImagesModel);
        return new ResponseEntity<CategoryImagesModel>(CategoryImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryCoupon() {
        CategoryImagesContext categoryImagesContext = categoryImagesContextFactory.getObject();
        categoryImagesContext.setAll("all");
        Collection<CategoryImagesModel> categoryImagesModels = businessDelegate.getCollection(categoryImagesContext);
        IModelWrapper<Collection<CategoryImagesModel>> models = new CollectionModelWrapper<CategoryImagesModel>(CategoryImagesModel.class,
                categoryImagesModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryImagesModel> getCategoryImages(@PathVariable(value = "id") final String categoryImagesId) {
        CategoryImagesContext categoryImagesContext = categoryImagesContextFactory.getObject();
        CategoryImagesModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(categoryImagesId), categoryImagesContext);
        return new ResponseEntity<CategoryImagesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryImagesBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryImagesObjectFactory(final ObjectFactory<CategoryImagesContext> categoryImagesContextFactory) {
        this.categoryImagesContextFactory = categoryImagesContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }
}
