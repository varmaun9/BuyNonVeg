/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.TagTypeContext;
import com.meat.model.TagTypeModel;
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
@RequestMapping(value = "/tagType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class TagTypeController {
    private IBusinessDelegate<TagTypeModel, TagTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<TagTypeContext> tagTypeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TagTypeModel> create(@RequestBody final TagTypeModel tagTypeModel) {
        businessDelegate.create(tagTypeModel);
        return new ResponseEntity<TagTypeModel>(tagTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<TagTypeModel> edit(@PathVariable(value = "id") final String tagTypeId,
            @RequestBody final TagTypeModel tagTypeModel) {
        TagTypeContext tagTypeContext = new TagTypeContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(tagTypeId), tagTypeModel);
        return new ResponseEntity<TagTypeModel>(tagTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTagType() {
        TagTypeContext tagTypeContext = tagTypeContextFactory.getObject();
        tagTypeContext.setAll("all");
        Collection<TagTypeModel> tagTypeModel = businessDelegate.getCollection(tagTypeContext);
        IModelWrapper<Collection<TagTypeModel>> models = new CollectionModelWrapper<TagTypeModel>(TagTypeModel.class, tagTypeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tagTypeOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTagTypeOnly() {
        TagTypeContext tagTypeContext = tagTypeContextFactory.getObject();
        tagTypeContext.setTagTypeOnly("tagTypeOnly");
        Collection<TagTypeModel> tagTypeModels = businessDelegate.getCollection(tagTypeContext);
        IModelWrapper<Collection<TagTypeModel>> models = new CollectionModelWrapper<TagTypeModel>(TagTypeModel.class, tagTypeModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all/tagTypesOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllTagTypesOnly() {
        TagTypeContext tagTypeContext = tagTypeContextFactory.getObject();
        tagTypeContext.setAll("all");
        tagTypeContext.setTagTypeOnly("tagTypeOnly");
        Collection<TagTypeModel> tagTypeModel = businessDelegate.getCollection(tagTypeContext);
        IModelWrapper<Collection<TagTypeModel>> models = new CollectionModelWrapper<TagTypeModel>(TagTypeModel.class, tagTypeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<TagTypeModel> getTagType(@PathVariable(value = "id") final String tagTypeId) {
        TagTypeContext tagTypeContext = tagTypeContextFactory.getObject();
        TagTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(tagTypeId), tagTypeContext);
        return new ResponseEntity<TagTypeModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "tagTypeBusinessDelegate")
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
    public void setTagTypeObjectFactory(final ObjectFactory<TagTypeContext> tagTypeContextFactory) {
        this.tagTypeContextFactory = tagTypeContextFactory;
    }

}
