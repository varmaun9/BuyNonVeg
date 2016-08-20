/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBankAccountContext;
import com.meat.model.SellerBankAccountModel;
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
@RequestMapping(value = "/sellerBankAccount", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBankAccountController {
    private IBusinessDelegate<SellerBankAccountModel, SellerBankAccountContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBankAccountContext> sellerBankAccountContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBankAccountModel> create(@RequestBody final SellerBankAccountModel sellerBankAccountModel) {
        businessDelegate.create(sellerBankAccountModel);
        return new ResponseEntity<SellerBankAccountModel>(sellerBankAccountModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBankAccountModel> edit(@PathVariable(value = "id") final String sellerBankAccountId,
            @RequestBody final SellerBankAccountModel sellerBankAccountModel) {
        SellerBankAccountContext sellerBankAccountContext = new SellerBankAccountContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBankAccountId), sellerBankAccountModel);
        return new ResponseEntity<SellerBankAccountModel>(sellerBankAccountModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBankAccountes() {
        SellerBankAccountContext sellerBankAccountContext = sellerBankAccountContextFactory.getObject();
        sellerBankAccountContext.setAll("all");
        Collection<SellerBankAccountModel> sellerBankAccountModel = businessDelegate.getCollection(sellerBankAccountContext);
        IModelWrapper<Collection<SellerBankAccountModel>> models = new CollectionModelWrapper<SellerBankAccountModel>(
                SellerBankAccountModel.class, sellerBankAccountModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBankAccountModel> getSellerBankAccount(@PathVariable(value = "id") final String sellerBankAccountId) {
        SellerBankAccountContext sellerBankAccountContext = sellerBankAccountContextFactory.getObject();
        SellerBankAccountModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBankAccountId),
                sellerBankAccountContext);
        return new ResponseEntity<SellerBankAccountModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBankAccountBusinessDelegate")
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
    public void setSellerBankAccountObjectFactory(final ObjectFactory<SellerBankAccountContext> sellerBankAccountContextFactory) {
        this.sellerBankAccountContextFactory = sellerBankAccountContextFactory;
    }

}
