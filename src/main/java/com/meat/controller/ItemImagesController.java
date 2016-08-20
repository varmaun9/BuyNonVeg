/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ItemImagesContext;
import com.meat.model.ItemImagesModel;
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
@RequestMapping(value = "/itemImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ItemImagesController {
    private IBusinessDelegate<ItemImagesModel, ItemImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ItemImagesContext> itemImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemImagesModel> create(@RequestBody final ItemImagesModel itemImagesModel) {
        businessDelegate.create(itemImagesModel);
        return new ResponseEntity<ItemImagesModel>(itemImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemImagesModel> edit(@PathVariable(value = "id") final String itemImagesId,
            @RequestBody final ItemImagesModel itemImagesModel) {
        ItemImagesContext itemImagesContext = new ItemImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(itemImagesId), itemImagesModel);
        return new ResponseEntity<ItemImagesModel>(itemImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllItemImageses() {
        ItemImagesContext itemImagesContext = itemImagesContextFactory.getObject();
        itemImagesContext.setAll("all");
        Collection<ItemImagesModel> itemImagesModel = businessDelegate.getCollection(itemImagesContext);
        IModelWrapper<Collection<ItemImagesModel>> models = new CollectionModelWrapper<ItemImagesModel>(ItemImagesModel.class,
                itemImagesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemImagesModel> getItemImages(@PathVariable(value = "id") final String itemImagesId) {
        ItemImagesContext itemImagesContext = itemImagesContextFactory.getObject();
        ItemImagesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(itemImagesId), itemImagesContext);
        return new ResponseEntity<ItemImagesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "itemImagesBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setItemImagesObjectFactory(final ObjectFactory<ItemImagesContext> itemImagesContextFactory) {
        this.itemImagesContextFactory = itemImagesContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
