/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.InvoiceStatusCodesContext;
import com.meat.model.InvoiceStatusCodesModel;
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
@RequestMapping(value = "/invoiceStatusCodes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class InvoiceStatusCodesController {
    private IBusinessDelegate<InvoiceStatusCodesModel, InvoiceStatusCodesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<InvoiceStatusCodesContext> invoiceStatusCodesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceStatusCodesModel> create(@RequestBody final InvoiceStatusCodesModel invoiceStatusCodesModel) {
        businessDelegate.create(invoiceStatusCodesModel);
        return new ResponseEntity<InvoiceStatusCodesModel>(invoiceStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<InvoiceStatusCodesModel> edit(@PathVariable(value = "id") final String invoiceStatusCodesId,
            @RequestBody final InvoiceStatusCodesModel invoiceStatusCodesModel) {
        InvoiceStatusCodesContext invoiceStatusCodesContext = new InvoiceStatusCodesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(invoiceStatusCodesId), invoiceStatusCodesModel);
        return new ResponseEntity<InvoiceStatusCodesModel>(invoiceStatusCodesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllInvoiceStatusCodeses() {
        InvoiceStatusCodesContext invoiceStatusCodesContext = invoiceStatusCodesContextFactory.getObject();
        invoiceStatusCodesContext.setAll("all");
        Collection<InvoiceStatusCodesModel> invoiceStatusCodesModel = businessDelegate.getCollection(invoiceStatusCodesContext);
        IModelWrapper<Collection<InvoiceStatusCodesModel>> models = new CollectionModelWrapper<InvoiceStatusCodesModel>(
                InvoiceStatusCodesModel.class, invoiceStatusCodesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceStatusCodesModel> getInvoiceStatusCodes(@PathVariable(value = "id") final String invoiceStatusCodesId) {
        InvoiceStatusCodesContext invoiceStatusCodesContext = invoiceStatusCodesContextFactory.getObject();
        InvoiceStatusCodesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(invoiceStatusCodesId),
                invoiceStatusCodesContext);
        return new ResponseEntity<InvoiceStatusCodesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "invoiceStatusCodesBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setInvoiceStatusCodesObjectFactory(final ObjectFactory<InvoiceStatusCodesContext> invoiceStatusCodesContextFactory) {
        this.invoiceStatusCodesContextFactory = invoiceStatusCodesContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
