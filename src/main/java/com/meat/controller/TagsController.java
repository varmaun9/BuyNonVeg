/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.TagsContext;
import com.meat.model.TagsModel;
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
@RequestMapping(value = "/tags", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class TagsController {

    private IBusinessDelegate<TagsModel, TagsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<TagsContext> tagsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TagsModel> create(@RequestBody final TagsModel tagsModel) {
        businessDelegate.create(tagsModel);
        return new ResponseEntity<TagsModel>(tagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TagsModel> edit(@PathVariable(value = "id") final String tagsId, @RequestBody final TagsModel tagsModel) {
        TagsContext tagsContext = new TagsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(tagsId), tagsModel);
        return new ResponseEntity<TagsModel>(tagsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tagOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTagOnly() {
        TagsContext tagContext = tagsContextFactory.getObject();
        tagContext.setTagsOnly("tagOnly");
        Collection<TagsModel> tagsModels = businessDelegate.getCollection(tagContext);
        IModelWrapper<Collection<TagsModel>> models = new CollectionModelWrapper<TagsModel>(TagsModel.class, tagsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTags() {
        TagsContext tagsContext = tagsContextFactory.getObject();
        tagsContext.setAll("all");
        // LOGGER.info("items are");
        Collection<TagsModel> tagsModels = businessDelegate.getCollection(tagsContext);
        IModelWrapper<Collection<TagsModel>> models = new CollectionModelWrapper<TagsModel>(TagsModel.class, tagsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TagsModel> getTags(@PathVariable(value = "id") final String tagsId) {
        TagsContext tagsContext = tagsContextFactory.getObject();
        TagsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(tagsId), tagsContext);
        return new ResponseEntity<TagsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "tagsBusinessDelegate")
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
    public void setTagsObjectFactory(final ObjectFactory<TagsContext> tagsContextFactory) {
        this.tagsContextFactory = tagsContextFactory;
    }
}
