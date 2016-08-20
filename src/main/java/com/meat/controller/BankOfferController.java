/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.BankOfferContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.BankOfferModel;
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
@RequestMapping(value = "/bankOffer", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class BankOfferController {
    private IBusinessDelegate<BankOfferModel, BankOfferContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<BankOfferContext> bankOfferContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<BankOfferModel> create(@RequestBody final BankOfferModel bankOffersModel) {
        businessDelegate.create(bankOffersModel);
        return new ResponseEntity<BankOfferModel>(bankOffersModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<BankOfferModel> edit(@PathVariable(value = "id") final String bankOffersId,
            @RequestBody final BankOfferModel bankOffersModel) {
        BankOfferContext bankOffersContext = new BankOfferContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(bankOffersId), bankOffersModel);
        return new ResponseEntity<BankOfferModel>(bankOffersModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllBankOfferses() {
        BankOfferContext bankOffersContext = bankOfferContextFactory.getObject();
        bankOffersContext.setAll("all");
        Collection<BankOfferModel> bankOffersModel = businessDelegate.getCollection(bankOffersContext);
        IModelWrapper<Collection<BankOfferModel>> models = new CollectionModelWrapper<BankOfferModel>(BankOfferModel.class, bankOffersModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<BankOfferModel> getBankOffers(@PathVariable(value = "id") final String bankOffersId) {
        BankOfferContext bankOffersContext = bankOfferContextFactory.getObject();
        BankOfferModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(bankOffersId), bankOffersContext);
        return new ResponseEntity<BankOfferModel>(model, HttpStatus.OK);
    }

    @Autowired
    public void setBankOffersObjectFactory(final ObjectFactory<BankOfferContext> bankOfferContextFactory) {
        this.bankOfferContextFactory = bankOfferContextFactory;
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "bankOfferBusinessDelegate")
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

}
