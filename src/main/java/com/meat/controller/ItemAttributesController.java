/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ItemAttributesContext;
import com.meat.model.ItemAttributesModel;
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
@RequestMapping(value = "/itemAttributes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ItemAttributesController {
    private IBusinessDelegate<ItemAttributesModel, ItemAttributesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ItemAttributesContext> itemAttributesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemAttributesModel> create(@RequestBody final ItemAttributesModel itemAttributesModel) {
        businessDelegate.create(itemAttributesModel);
        return new ResponseEntity<ItemAttributesModel>(itemAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ItemAttributesModel> edit(@PathVariable(value = "id") final String itemAttributesId,
            @RequestBody final ItemAttributesModel itemAttributesModel) {
        ItemAttributesContext itemAttributesContext = new ItemAttributesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(itemAttributesId), itemAttributesModel);
        return new ResponseEntity<ItemAttributesModel>(itemAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllItemAttributes() {
        ItemAttributesContext itemAttributesContext = itemAttributesContextFactory.getObject();
        itemAttributesContext.setAll("all");
        Collection<ItemAttributesModel> itemAttributesModel = businessDelegate.getCollection(itemAttributesContext);
        IModelWrapper<Collection<ItemAttributesModel>> models = new CollectionModelWrapper<ItemAttributesModel>(ItemAttributesModel.class,
                itemAttributesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ItemAttributesModel> getItemAttributes(@PathVariable(value = "id") final String itemAttributesId) {
        ItemAttributesContext itemAttributesContext = itemAttributesContextFactory.getObject();
        ItemAttributesModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(itemAttributesId), itemAttributesContext);
        return new ResponseEntity<ItemAttributesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "itemAttributesBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setItemAttributesObjectFactory(final ObjectFactory<ItemAttributesContext> itemAttributesContextFactory) {
        this.itemAttributesContextFactory = itemAttributesContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
