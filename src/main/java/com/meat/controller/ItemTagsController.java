/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ItemTagsContext;
import com.meat.model.ItemTagsModel;
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
@RequestMapping(value = "/itemTags", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ItemTagsController {
    private IBusinessDelegate<ItemTagsModel, ItemTagsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ItemTagsContext> itemTagsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemTagsModel> create(@RequestBody final ItemTagsModel itemTagsModel) {
        businessDelegate.create(itemTagsModel);
        return new ResponseEntity<ItemTagsModel>(itemTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemTagsModel> edit(@PathVariable(value = "id") final String itemTagsId,
            @RequestBody final ItemTagsModel itemTagsModel) {
        ItemTagsContext itemTagsContext = new ItemTagsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(itemTagsId), itemTagsModel);
        return new ResponseEntity<ItemTagsModel>(itemTagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemTagsModel> getAddress(@PathVariable(value = "id") final String itemTagsId) {
        ItemTagsContext itemTagsContext = itemTagsContextFactory.getObject();
        ItemTagsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(itemTagsId), itemTagsContext);
        return new ResponseEntity<ItemTagsModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllAddresses() {
        ItemTagsContext itemTagsContext = itemTagsContextFactory.getObject();
        itemTagsContext.setAll("all");
        Collection<ItemTagsModel> itemTagsModel = businessDelegate.getCollection(itemTagsContext);
        IModelWrapper<Collection<ItemTagsModel>> models = new CollectionModelWrapper<ItemTagsModel>(ItemTagsModel.class, itemTagsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "itemTagsBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setItemTagsObjectFactory(final ObjectFactory<ItemTagsContext> itemTagsContextFactory) {
        this.itemTagsContextFactory = itemTagsContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
