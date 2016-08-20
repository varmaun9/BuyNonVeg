/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.PreOrderCartItemsContext;
import com.meat.model.PreOrderCartItemsModel;
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
@RequestMapping(value = "/preOrderCartItems", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class PreOrderCartItemsController {
    private IBusinessDelegate<PreOrderCartItemsModel, PreOrderCartItemsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PreOrderCartItemsContext> preOrderCartItemsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PreOrderCartItemsModel> create(@RequestBody final PreOrderCartItemsModel preOrderCartItemsModel) {
        businessDelegate.create(preOrderCartItemsModel);
        return new ResponseEntity<PreOrderCartItemsModel>(preOrderCartItemsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deletePreOrderCartItems(@PathVariable(value = "id") final String preOrderCartItemsId) {

        PreOrderCartItemsContext preOrderCartItemsContext = preOrderCartItemsContextFactory.getObject();
        preOrderCartItemsContext.setPreOrderCartItemsId(preOrderCartItemsId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(preOrderCartItemsId), preOrderCartItemsContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PreOrderCartItemsModel> edit(@PathVariable(value = "id") final String preOrderCartItemsId,
            @RequestBody final PreOrderCartItemsModel preOrderCartItemsModel) {
        PreOrderCartItemsContext preOrderCartItemsContext = new PreOrderCartItemsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(preOrderCartItemsId), preOrderCartItemsModel);
        return new ResponseEntity<PreOrderCartItemsModel>(preOrderCartItemsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllPreOrderCartItems() {
        PreOrderCartItemsContext preOrderCartItemsContext = preOrderCartItemsContextFactory.getObject();
        preOrderCartItemsContext.setAll("all");
        Collection<PreOrderCartItemsModel> preOrderCartItemsModel = businessDelegate.getCollection(preOrderCartItemsContext);
        IModelWrapper<Collection<PreOrderCartItemsModel>> models = new CollectionModelWrapper<PreOrderCartItemsModel>(
                PreOrderCartItemsModel.class, preOrderCartItemsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PreOrderCartItemsModel> getPreOrderCartItems(@PathVariable(value = "id") final String preOrderCartItemsId) {
        PreOrderCartItemsContext preOrderCartItemsContext = preOrderCartItemsContextFactory.getObject();
        PreOrderCartItemsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(preOrderCartItemsId),
                preOrderCartItemsContext);
        return new ResponseEntity<PreOrderCartItemsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "preOrderCartItemsBusinessDelegate")
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
    public void setPreOrderCartItemsObjectFactory(final ObjectFactory<PreOrderCartItemsContext> preOrderCartItemsContextFactory) {
        this.preOrderCartItemsContextFactory = preOrderCartItemsContextFactory;
    }

}
