/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubCategoryTagsContext;
import com.meat.model.SubCategoryTagsModel;
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
;

/**
 * @author arthvedi1
 *
 */
@RestController
@RequestMapping(value = "/subCategoryTags", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubCategoryTagsController {

    private IBusinessDelegate<SubCategoryTagsModel, SubCategoryTagsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubCategoryTagsContext> subCategoryTagsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryTagsModel> createCategory(@RequestBody final SubCategoryTagsModel subCategoryTagsModel) {
        businessDelegate.create(subCategoryTagsModel);
        return new ResponseEntity<SubCategoryTagsModel>(subCategoryTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubCategoryTagsModel> edit(@PathVariable(value = "id") final String subCategoryTagsId,
            @RequestBody final SubCategoryTagsModel subCategoryTagsModel) {
        SubCategoryTagsContext subCategoryTagsContext = new SubCategoryTagsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subCategoryTagsId), subCategoryTagsModel);
        return new ResponseEntity<SubCategoryTagsModel>(subCategoryTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategories() {
        SubCategoryTagsContext subCategoryTagsContext = subCategoryTagsContextFactory.getObject();
        subCategoryTagsContext.setAll("all");
        Collection<SubCategoryTagsModel> subCategoryTagsModels = businessDelegate.getCollection(subCategoryTagsContext);
        IModelWrapper<Collection<SubCategoryTagsModel>> models = new CollectionModelWrapper<SubCategoryTagsModel>(
                SubCategoryTagsModel.class, subCategoryTagsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryTagsModel> getSubCategoryTags(@PathVariable(value = "id") final String subCategoryTagsId) {
        SubCategoryTagsContext categoryContext = subCategoryTagsContextFactory.getObject();
        SubCategoryTagsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subCategoryTagsId), categoryContext);
        return new ResponseEntity<SubCategoryTagsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subCategoryTagsBusinessDelegate")
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
    public void setSubCategoryTagsObjectFactory(final ObjectFactory<SubCategoryTagsContext> subCategoryTagsContextFactory) {
        this.subCategoryTagsContextFactory = subCategoryTagsContextFactory;
    }

}
