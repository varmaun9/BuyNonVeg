/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryTagsContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryTagsModel;
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
@RequestMapping(value = "/categoryTags", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryTagsController {

    private IBusinessDelegate<CategoryTagsModel, CategoryTagsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryTagsContext> categoryTagsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryTagsModel> createCategoryTags(@RequestBody final CategoryTagsModel CategoryTagsModel) {
        businessDelegate.create(CategoryTagsModel);
        return new ResponseEntity<CategoryTagsModel>(CategoryTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryTagsModel> edit(@PathVariable(value = "id") final String categoryTagsId,
            @RequestBody final CategoryTagsModel CategoryTagsModel) {

        CategoryTagsContext categoryTagsContext = new CategoryTagsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryTagsId), CategoryTagsModel);
        return new ResponseEntity<CategoryTagsModel>(CategoryTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryTags() {
        CategoryTagsContext categoryTagsContext = categoryTagsContextFactory.getObject();
        categoryTagsContext.setAll("all");
        Collection<CategoryTagsModel> categoryTagsModels = businessDelegate.getCollection(categoryTagsContext);
        IModelWrapper<Collection<CategoryTagsModel>> models = new CollectionModelWrapper<CategoryTagsModel>(CategoryTagsModel.class,
                categoryTagsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryTagsModel> getCategoryTags(@PathVariable(value = "id") final String categoryTagsId) {
        CategoryTagsContext categoryTagsContext = categoryTagsContextFactory.getObject();
        CategoryTagsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryTagsId), categoryTagsContext);
        return new ResponseEntity<CategoryTagsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryTagsBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryTagsObjectFactory(final ObjectFactory<CategoryTagsContext> categoryTagsContextFactory) {
        this.categoryTagsContextFactory = categoryTagsContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }
}
