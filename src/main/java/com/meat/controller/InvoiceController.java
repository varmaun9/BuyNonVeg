/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.InvoiceContext;
import com.meat.model.InvoiceModel;
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
@RequestMapping(value = "/invoice", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class InvoiceController {
    private IBusinessDelegate<InvoiceModel, InvoiceContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<InvoiceContext> invoiceContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceModel> create(@RequestBody final InvoiceModel invoiceModel) {
        businessDelegate.create(invoiceModel);
        return new ResponseEntity<InvoiceModel>(invoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<InvoiceModel> edit(@PathVariable(value = "id") final String invoiceId,
            @RequestBody final InvoiceModel invoiceModel) {
        InvoiceContext invoiceContext = new InvoiceContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(invoiceId), invoiceModel);
        return new ResponseEntity<InvoiceModel>(invoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllInvoicees() {
        InvoiceContext invoiceContext = invoiceContextFactory.getObject();
        invoiceContext.setAll("all");
        Collection<InvoiceModel> invoiceModel = businessDelegate.getCollection(invoiceContext);
        IModelWrapper<Collection<InvoiceModel>> models = new CollectionModelWrapper<InvoiceModel>(InvoiceModel.class, invoiceModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceModel> getInvoice(@PathVariable(value = "id") final String invoiceId) {
        InvoiceContext invoiceContext = invoiceContextFactory.getObject();
        InvoiceModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(invoiceId), invoiceContext);
        return new ResponseEntity<InvoiceModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "invoiceBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setInvoiceObjectFactory(final ObjectFactory<InvoiceContext> invoiceContextFactory) {
        this.invoiceContextFactory = invoiceContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
