/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.AttributesContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.domain.Attributes;
import com.meat.model.AttributesModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi1
 *
 */
@RestController
@RequestMapping(value = "/attributes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class AttributesController {

    private static final Logger LOGGER = Logger.getLogger(AttributesController.class);
    private IBusinessDelegate<AttributesModel, AttributesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<AttributesContext> attributeObjectFactory;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<AttributesModel> createAttribute(@RequestBody final AttributesModel attributeModel) {
        Attributes attributes = new Attributes();
        businessDelegate.create(attributeModel);
        return new ResponseEntity<AttributesModel>(attributeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<AttributesModel> editAttribute(@PathVariable(value = "id") final String attributeId,
            @RequestBody final AttributesModel attributeModel) {
        AttributesContext attributeContext = attributeObjectFactory.getObject();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(attributeId), attributeModel);
        return new ResponseEntity<AttributesModel>(attributeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<AttributesModel> getAttribute(@PathVariable(value = "id") final String attributeId) {
        AttributesContext attributeContext = attributeObjectFactory.getObject();
        AttributesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(attributeId), attributeContext);
        return new ResponseEntity<AttributesModel>(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getStates() {
        AttributesContext attributeContext = attributeObjectFactory.getObject();
        attributeContext.setAll("all");
        Collection<AttributesModel> attributeModelCollection = businessDelegate.getCollection(attributeContext);
        IModelWrapper<Collection<AttributesModel>> models = new CollectionModelWrapper<AttributesModel>(AttributesModel.class,
                attributeModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @Autowired
    public void setAttributeObjectFactory(final ObjectFactory<AttributesContext> attributeObjectFactory) {
        this.attributeObjectFactory = attributeObjectFactory;
    }

    @Resource(name = "attributesBusinessDelegate")
    public void setAttributesBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
