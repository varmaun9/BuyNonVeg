/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CategoryCriteriaContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CategoryCriteriaModel;
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
@RequestMapping(value = "/categoryCriteria", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CategoryCriteriaController {
    private IBusinessDelegate<CategoryCriteriaModel, CategoryCriteriaContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CategoryCriteriaContext> categoryCriteriaContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryCriteriaModel> create(@RequestBody final CategoryCriteriaModel categoryCriteriaModel) {
        businessDelegate.create(categoryCriteriaModel);
        return new ResponseEntity<CategoryCriteriaModel>(categoryCriteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CategoryCriteriaModel> edit(@PathVariable(value = "id") final String categoryCriteriaId,
            @RequestBody final CategoryCriteriaModel CategoryCriteriaModel) {
        CategoryCriteriaContext categoryCriteriaContext = new CategoryCriteriaContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(categoryCriteriaId), CategoryCriteriaModel);
        return new ResponseEntity<CategoryCriteriaModel>(CategoryCriteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategoryCriteria() {
        CategoryCriteriaContext categoryCriteriaContext = categoryCriteriaContextFactory.getObject();
        categoryCriteriaContext.setAll("all");
        Collection<CategoryCriteriaModel> categoryCriteriaModel = businessDelegate.getCollection(categoryCriteriaContext);
        IModelWrapper<Collection<CategoryCriteriaModel>> models = new CollectionModelWrapper<CategoryCriteriaModel>(
                CategoryCriteriaModel.class, categoryCriteriaModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CategoryCriteriaModel> getCategoryCriteria(@PathVariable(value = "id") final String categoryCriteriaId) {
        CategoryCriteriaContext categoryCriteriaContext = categoryCriteriaContextFactory.getObject();
        CategoryCriteriaModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(categoryCriteriaId),
                categoryCriteriaContext);
        return new ResponseEntity<CategoryCriteriaModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "categoryCriteriaBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryCriteriaObjectFactory(final ObjectFactory<CategoryCriteriaContext> categoryCriteriaContextFactory) {
        this.categoryCriteriaContextFactory = categoryCriteriaContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
