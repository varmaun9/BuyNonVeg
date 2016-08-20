/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ItemContext;
import com.meat.model.ItemModel;
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
@RequestMapping(value = "/item", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ItemController {
    private IBusinessDelegate<ItemModel, ItemContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ItemContext> itemContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemModel> create(@RequestBody final ItemModel itemModel) {
        businessDelegate.create(itemModel);
        return new ResponseEntity<ItemModel>(itemModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemModel> edit(@PathVariable(value = "id") final String itemId, @RequestBody final ItemModel ItemModel) {
        ItemContext itemContext = new ItemContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(itemId), ItemModel);
        return new ResponseEntity<ItemModel>(ItemModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllItem() {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setAll("all");
        Collection<ItemModel> itemModel = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}/zone/{zoneId}/items", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllItemByCategoryAndZoneOnly(@PathVariable(value = "categoryId") final String categoryId,
            @PathVariable(value = "zoneId") final String zoneId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setCategoryId(categoryId);
        itemContext.setZoneId(zoneId);
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllItemOnly() {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setItemOnly("itemOnly");
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemModel> getItem(@PathVariable(value = "id") final String itemId) {
        ItemContext itemContext = itemContextFactory.getObject();
        ItemModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(itemId), itemContext);
        return new ResponseEntity<ItemModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemByCategory(@PathVariable(value = "categoryId") final String categoryId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setCategoryId(categoryId);
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/subCategory/{subCategoryId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemBySubCategory(@PathVariable(value = "subCategoryId") final String subCategoryId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setItemId(subCategoryId);
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{categoryId}/itemOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemOnlyByCategory(@PathVariable(value = "categoryId") final String categoryId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setCategoryId(categoryId);
        itemContext.setItemOnly("itemOnly");
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemWithOutSellerItem/{itemId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemWithOutSellerItem(@PathVariable(value = "itemId") final String itemId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setItemId(itemId);
        itemContext.setItemWithOutSellerItem("itemWithOutSellerItem");
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/itemWithSellerItem/{itemId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemWithSellerItem(@PathVariable(value = "itemId") final String itemId) {
        ItemContext itemContext = itemContextFactory.getObject();
        itemContext.setItemId(itemId);
        itemContext.setItemWithSellerItem("itemWithSellerItem");
        Collection<ItemModel> itemModels = businessDelegate.getCollection(itemContext);
        IModelWrapper<Collection<ItemModel>> models = new CollectionModelWrapper<ItemModel>(ItemModel.class, itemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "itemBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setItemObjectFactory(final ObjectFactory<ItemContext> itemContextFactory) {
        this.itemContextFactory = itemContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
