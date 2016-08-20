/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.MeatInvoiceContext;
import com.meat.model.MeatInvoiceModel;
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
@RequestMapping(value = "/meatInvoice", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class MeatInvoiceController {
    private IBusinessDelegate<MeatInvoiceModel, MeatInvoiceContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<MeatInvoiceContext> meatInvoiceContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<MeatInvoiceModel> create(@RequestBody final MeatInvoiceModel meatInvoiceModel) {
        businessDelegate.create(meatInvoiceModel);
        return new ResponseEntity<MeatInvoiceModel>(meatInvoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MeatInvoiceModel> edit(@PathVariable(value = "id") final String meatInvoiceId,
            @RequestBody final MeatInvoiceModel meatInvoiceModel) {
        MeatInvoiceContext meatInvoiceContext = new MeatInvoiceContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(meatInvoiceId), meatInvoiceModel);
        return new ResponseEntity<MeatInvoiceModel>(meatInvoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllMeatInvoicees() {
        MeatInvoiceContext meatInvoiceContext = meatInvoiceContextFactory.getObject();
        meatInvoiceContext.setAll("all");
        Collection<MeatInvoiceModel> meatInvoiceModel = businessDelegate.getCollection(meatInvoiceContext);
        IModelWrapper<Collection<MeatInvoiceModel>> models = new CollectionModelWrapper<MeatInvoiceModel>(MeatInvoiceModel.class,
                meatInvoiceModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<MeatInvoiceModel> getMeatInvoice(@PathVariable(value = "id") final String meatInvoiceId) {
        MeatInvoiceContext meatInvoiceContext = meatInvoiceContextFactory.getObject();
        MeatInvoiceModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(meatInvoiceId), meatInvoiceContext);
        return new ResponseEntity<MeatInvoiceModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "meatInvoiceBusinessDelegate")
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
    public void setMeatInvoiceObjectFactory(final ObjectFactory<MeatInvoiceContext> meatInvoiceContextFactory) {
        this.meatInvoiceContextFactory = meatInvoiceContextFactory;
    }

}
