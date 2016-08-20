/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubOrderStatusCodeContext;
import com.meat.model.SubOrderStatusCodeModel;
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
 * @author arthvedi1
 *
 */

@RestController
@RequestMapping(value = "/subOrderStatusCode", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubOrderStatusCodeController {
    private IBusinessDelegate<SubOrderStatusCodeModel, SubOrderStatusCodeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubOrderStatusCodeContext> subOrderStatusCodeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubOrderStatusCodeModel> create(@RequestBody final SubOrderStatusCodeModel subOrderStatusCodeModel) {
        businessDelegate.create(subOrderStatusCodeModel);
        return new ResponseEntity<SubOrderStatusCodeModel>(subOrderStatusCodeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubOrderStatusCodeModel> edit(@PathVariable(value = "id") final String subOrderStatusCodeId,
            @RequestBody final SubOrderStatusCodeModel subOrderStatusCodeModel) {
        SubOrderStatusCodeContext subOrderStatusCodeContext = new SubOrderStatusCodeContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subOrderStatusCodeId), subOrderStatusCodeModel);
        return new ResponseEntity<SubOrderStatusCodeModel>(subOrderStatusCodeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubOrderStatusCode() {
        SubOrderStatusCodeContext subOrderStatusCodeContext = subOrderStatusCodeContextFactory.getObject();
        subOrderStatusCodeContext.setAll("all");
        Collection<SubOrderStatusCodeModel> subOrderStatusCodeModel = businessDelegate.getCollection(subOrderStatusCodeContext);
        IModelWrapper<Collection<SubOrderStatusCodeModel>> models = new CollectionModelWrapper<SubOrderStatusCodeModel>(
                SubOrderStatusCodeModel.class, subOrderStatusCodeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubOrderStatusCodeModel> getSubOrderStatusCode(@PathVariable(value = "id") final String subOrderStatusCodeId) {
        SubOrderStatusCodeContext subOrderStatusCodeContext = subOrderStatusCodeContextFactory.getObject();
        SubOrderStatusCodeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subOrderStatusCodeId),
                subOrderStatusCodeContext);
        return new ResponseEntity<SubOrderStatusCodeModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subOrderStatusCodeBusinessDelegate")
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
    public void setSubOrderStatusCodeObjectFactory(final ObjectFactory<SubOrderStatusCodeContext> subOrderStatusCodeContextFactory) {
        this.subOrderStatusCodeContextFactory = subOrderStatusCodeContextFactory;
    }

}
