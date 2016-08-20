/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryCutTypeContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryCutTypeModel;
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
@RequestMapping(value = "/categoryCutType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryCutTypeController {
    private IBusinessDelegate<CategoryCutTypeModel, CategoryCutTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryCutTypeContext> categoryCutTypeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryCutTypeModel> create(@RequestBody final CategoryCutTypeModel categoryCutTypeModel) {
        businessDelegate.create(categoryCutTypeModel);
        return new ResponseEntity<CategoryCutTypeModel>(categoryCutTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteCategoryCutType(@PathVariable(value = "id") final String categoryCutTypeId) {

        CategoryCutTypeContext categoryCutTypeContext = categoryCutTypeContextFactory.getObject();
        categoryCutTypeContext.setCategoryCutTypeId(categoryCutTypeId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(categoryCutTypeId), categoryCutTypeContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryCutTypeModel> edit(@PathVariable(value = "id") final String categoryCutTypeId,
            @RequestBody final CategoryCutTypeModel CategoryCutTypeModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryCutTypeId), CategoryCutTypeModel);
        return new ResponseEntity<CategoryCutTypeModel>(CategoryCutTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryCutType() {
        CategoryCutTypeContext categoryCutTypeContext = categoryCutTypeContextFactory.getObject();
        categoryCutTypeContext.setAll("all");
        Collection<CategoryCutTypeModel> categoryCutTypeModel = businessDelegate.getCollection(categoryCutTypeContext);
        IModelWrapper<Collection<CategoryCutTypeModel>> models = new CollectionModelWrapper<CategoryCutTypeModel>(
                CategoryCutTypeModel.class, categoryCutTypeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryCutTypeModel> getCategoryCutType(@PathVariable(value = "id") final String categoryCutTypeId) {
        CategoryCutTypeContext categoryCutTypeContext = categoryCutTypeContextFactory.getObject();
        CategoryCutTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryCutTypeId),
                categoryCutTypeContext);
        return new ResponseEntity<CategoryCutTypeModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryCutTypeBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryCutTypeObjectFactory(final ObjectFactory<CategoryCutTypeContext> categoryCutTypeContextFactory) {
        this.categoryCutTypeContextFactory = categoryCutTypeContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }
}
