/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.InvoiceTransactionContext;
import com.meat.model.InvoiceTransactionModel;
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
@RequestMapping(value = "/invoiceTransaction", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class InvoiceTransactionController {
    private IBusinessDelegate<InvoiceTransactionModel, InvoiceTransactionContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<InvoiceTransactionContext> invoiceTransactionContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceTransactionModel> create(@RequestBody final InvoiceTransactionModel invoiceTransactionModel) {
        businessDelegate.create(invoiceTransactionModel);
        return new ResponseEntity<InvoiceTransactionModel>(invoiceTransactionModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<InvoiceTransactionModel> edit(@PathVariable(value = "id") final String invoiceTransactionId,
            @RequestBody final InvoiceTransactionModel invoiceTransactionModel) {
        InvoiceTransactionContext invoiceTransactionContext = new InvoiceTransactionContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(invoiceTransactionId), invoiceTransactionModel);
        return new ResponseEntity<InvoiceTransactionModel>(invoiceTransactionModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllInvoiceTransactiones() {
        InvoiceTransactionContext invoiceTransactionContext = invoiceTransactionContextFactory.getObject();
        invoiceTransactionContext.setAll("all");
        Collection<InvoiceTransactionModel> invoiceTransactionModel = businessDelegate.getCollection(invoiceTransactionContext);
        IModelWrapper<Collection<InvoiceTransactionModel>> models = new CollectionModelWrapper<InvoiceTransactionModel>(
                InvoiceTransactionModel.class, invoiceTransactionModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<InvoiceTransactionModel> getInvoiceTransaction(@PathVariable(value = "id") final String invoiceTransactionId) {
        InvoiceTransactionContext invoiceTransactionContext = invoiceTransactionContextFactory.getObject();
        InvoiceTransactionModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(invoiceTransactionId),
                invoiceTransactionContext);
        return new ResponseEntity<InvoiceTransactionModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "invoiceTransactionBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setInvoiceTransactionObjectFactory(final ObjectFactory<InvoiceTransactionContext> invoiceTransactionContextFactory) {
        this.invoiceTransactionContextFactory = invoiceTransactionContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
