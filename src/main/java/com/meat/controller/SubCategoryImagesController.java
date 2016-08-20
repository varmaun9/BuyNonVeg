/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubCategoryImagesContext;
import com.meat.model.SubCategoryImagesModel;
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
@RequestMapping(value = "/subCategoryImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubCategoryImagesController {

    private IBusinessDelegate<SubCategoryImagesModel, SubCategoryImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubCategoryImagesContext> subCategoryImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryImagesModel> createCategoryImages(@RequestBody final SubCategoryImagesModel subCategoryImagesModel) {
        businessDelegate.create(subCategoryImagesModel);
        return new ResponseEntity<SubCategoryImagesModel>(subCategoryImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubCategoryImagesModel> edit(@PathVariable(value = "id") final String subCategoryImagesId,
            @RequestBody final SubCategoryImagesModel subCategoryImagesModel) {

        SubCategoryImagesContext categoryImagesContext = new SubCategoryImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subCategoryImagesId), subCategoryImagesModel);
        return new ResponseEntity<SubCategoryImagesModel>(subCategoryImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCategories() {
        SubCategoryImagesContext subCategoryImagesContext = subCategoryImagesContextFactory.getObject();
        subCategoryImagesContext.setAll("all");
        Collection<SubCategoryImagesModel> subCategoryImagesModels = businessDelegate.getCollection(subCategoryImagesContext);
        IModelWrapper<Collection<SubCategoryImagesModel>> models = new CollectionModelWrapper<SubCategoryImagesModel>(
                SubCategoryImagesModel.class, subCategoryImagesModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryImagesModel> getSubCategoryImages(@PathVariable(value = "id") final String subCategoryImagesId) {
        SubCategoryImagesContext subCategoryImagesContext = subCategoryImagesContextFactory.getObject();
        SubCategoryImagesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subCategoryImagesId),
                subCategoryImagesContext);
        return new ResponseEntity<SubCategoryImagesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subCategoryImagesBusinessDelegate")
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
    public void setSubCategoryImagesObjectFactory(final ObjectFactory<SubCategoryImagesContext> subCategoryImagesContextFactory) {
        this.subCategoryImagesContextFactory = subCategoryImagesContextFactory;
    }
}
