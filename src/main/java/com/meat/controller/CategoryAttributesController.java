/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryAttributesContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryAttributesModel;
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
@RequestMapping(value = "/categoryAttributes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryAttributesController {

    private IBusinessDelegate<CategoryAttributesModel, CategoryAttributesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryAttributesContext> categoryAttributesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryAttributesModel> createCategoryAttributes(
            @RequestBody final CategoryAttributesModel categoryAttributesModel) {
        businessDelegate.create(categoryAttributesModel);
        return new ResponseEntity<CategoryAttributesModel>(categoryAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryAttributesModel> edit(@PathVariable(value = "id") final String categoryAttributesId,
            @RequestBody final CategoryAttributesModel categoryAttributesModel) {

        CategoryAttributesContext categoryAttributesContext = new CategoryAttributesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryAttributesId), categoryAttributesModel);
        return new ResponseEntity<CategoryAttributesModel>(categoryAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryAttributeses() {
        CategoryAttributesContext categoryAttributesContext = categoryAttributesContextFactory.getObject();
        categoryAttributesContext.setAll("all");
        Collection<CategoryAttributesModel> categoryAttributesModels = businessDelegate.getCollection(categoryAttributesContext);
        IModelWrapper<Collection<CategoryAttributesModel>> models = new CollectionModelWrapper<CategoryAttributesModel>(
                CategoryAttributesModel.class, categoryAttributesModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryAttributesModel> getCategory(@PathVariable(value = "id") final String categoryAttributesId) {
        CategoryAttributesContext categoryAttributesContext = categoryAttributesContextFactory.getObject();
        CategoryAttributesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryAttributesId),
                categoryAttributesContext);
        return new ResponseEntity<CategoryAttributesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryAttributesBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryAttributesObjectFactory(final ObjectFactory<CategoryAttributesContext> categoryAttributesContextFactory) {
        this.categoryAttributesContextFactory = categoryAttributesContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}