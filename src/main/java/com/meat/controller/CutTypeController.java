/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CutTypeContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CutTypeModel;
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
@RequestMapping(value = "/cutType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CutTypeController {

    private IBusinessDelegate<CutTypeModel, CutTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CutTypeContext> cutTypeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CutTypeModel> cutTypeCategory(@RequestBody final CutTypeModel cutTypeModel) {
        businessDelegate.create(cutTypeModel);
        return new ResponseEntity<CutTypeModel>(cutTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CutTypeModel> edit(@PathVariable(value = "id") final String cutTypeId,
            @RequestBody final CutTypeModel cutTypeModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(cutTypeId), cutTypeModel);
        return new ResponseEntity<CutTypeModel>(cutTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAll() {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();
        cutTypeContext.setAll("all");
        Collection<CutTypeModel> cutTypeModels = businessDelegate.getCollection(cutTypeContext);
        IModelWrapper<Collection<CutTypeModel>> models = new CollectionModelWrapper<CutTypeModel>(CutTypeModel.class, cutTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cutTypeOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCutTypeOnly() {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();
        cutTypeContext.setCutTypeOnly("cutTypeOnly");
        Collection<CutTypeModel> cutTypeModels = businessDelegate.getCollection(cutTypeContext);
        IModelWrapper<Collection<CutTypeModel>> models = new CollectionModelWrapper<CutTypeModel>(CutTypeModel.class, cutTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}/cutTypeOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getCategoryCutTypeOnly(@PathVariable(value = "categoryId") final String categoryId) {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();
        cutTypeContext.setCategoryId(categoryId);
        cutTypeContext.setCutTypeOnly("cutTypeOnly");
        Collection<CutTypeModel> cutTypeModels = businessDelegate.getCollection(cutTypeContext);
        IModelWrapper<Collection<CutTypeModel>> models = new CollectionModelWrapper<CutTypeModel>(CutTypeModel.class, cutTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CutTypeModel> getCutType(@PathVariable(value = "id") final String cutTypeId) {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();

        CutTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(cutTypeId), cutTypeContext);
        return new ResponseEntity<CutTypeModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/item/{itemId}/cutTypeOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemCutTypeOnly(@PathVariable(value = "itemId") final String itemId) {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();
        cutTypeContext.setCutTypeOnly("cutTypeOnly");
        cutTypeContext.setItemId(itemId);
        Collection<CutTypeModel> cutTypeModels = businessDelegate.getCollection(cutTypeContext);
        IModelWrapper<Collection<CutTypeModel>> models = new CollectionModelWrapper<CutTypeModel>(CutTypeModel.class, cutTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerItem/{sellerItemId}/cutTypeOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSellerItemCutTypeOnly(@PathVariable(value = "sellerItemId") final String sellerItemId) {
        CutTypeContext cutTypeContext = cutTypeContextFactory.getObject();
        cutTypeContext.setCutTypeOnly("cutTypeOnly");
        cutTypeContext.setSellerItemId(sellerItemId);
        Collection<CutTypeModel> cutTypeModels = businessDelegate.getCollection(cutTypeContext);
        IModelWrapper<Collection<CutTypeModel>> models = new CollectionModelWrapper<CutTypeModel>(CutTypeModel.class, cutTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "cutTypeBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCutTypeObjectFactory(final ObjectFactory<CutTypeContext> cutTypeContextFactory) {
        this.cutTypeContextFactory = cutTypeContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
