/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.ReceiptContext;
import com.meat.model.ReceiptModel;
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
@RequestMapping(value = "/receipt", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class ReceiptController {
    private IBusinessDelegate<ReceiptModel, ReceiptContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<ReceiptContext> receiptContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ReceiptModel> create(@RequestBody final ReceiptModel receiptModel) {
        businessDelegate.create(receiptModel);
        return new ResponseEntity<ReceiptModel>(receiptModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<ReceiptModel> edit(@PathVariable(value = "id") final String receiptId,
            @RequestBody final ReceiptModel receiptModel) {
        ReceiptContext receiptContext = new ReceiptContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(receiptId), receiptModel);
        return new ResponseEntity<ReceiptModel>(receiptModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllReceiptes() {
        ReceiptContext receiptContext = receiptContextFactory.getObject();
        receiptContext.setAll("all");
        Collection<ReceiptModel> receiptModel = businessDelegate.getCollection(receiptContext);
        IModelWrapper<Collection<ReceiptModel>> models = new CollectionModelWrapper<ReceiptModel>(ReceiptModel.class, receiptModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<ReceiptModel> getReceipt(@PathVariable(value = "id") final String receiptId) {
        ReceiptContext receiptContext = receiptContextFactory.getObject();
        ReceiptModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(receiptId), receiptContext);
        return new ResponseEntity<ReceiptModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "receiptBusinessDelegate")
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
    public void setReceiptObjectFactory(final ObjectFactory<ReceiptContext> receiptContextFactory) {
        this.receiptContextFactory = receiptContextFactory;
    }

}
