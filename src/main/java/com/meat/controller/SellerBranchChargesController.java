/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchChargesContext;
import com.meat.model.SellerBranchChargesModel;
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
 * @author varma
 *
 */
@RestController
@RequestMapping(value = "/sellerBranchCharges", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchChargesController {
    private IBusinessDelegate<SellerBranchChargesModel, SellerBranchChargesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchChargesContext> sellerBranchChargesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchChargesModel> create(@RequestBody final SellerBranchChargesModel sellerBranchChargesModel) {
        businessDelegate.create(sellerBranchChargesModel);
        return new ResponseEntity<SellerBranchChargesModel>(sellerBranchChargesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchChargesModel> edit(@PathVariable(value = "id") final String sellerBranchChargesId,
            @RequestBody final SellerBranchChargesModel sellerBranchChargesModel) {
        SellerBranchChargesContext sellerBranchChargesContext = new SellerBranchChargesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchChargesId), sellerBranchChargesModel);
        return new ResponseEntity<SellerBranchChargesModel>(sellerBranchChargesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchCharges() {
        SellerBranchChargesContext sellerBranchChargesContext = sellerBranchChargesContextFactory.getObject();
        sellerBranchChargesContext.setAll("all");
        Collection<SellerBranchChargesModel> sellerBranchChargesModel = businessDelegate.getCollection(sellerBranchChargesContext);
        IModelWrapper<Collection<SellerBranchChargesModel>> models = new CollectionModelWrapper<SellerBranchChargesModel>(
                SellerBranchChargesModel.class, sellerBranchChargesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchChargesModel> getSellerBranchCharges(@PathVariable(value = "id") final String sellerBranchChargesId) {
        SellerBranchChargesContext sellerBranchChargesContext = sellerBranchChargesContextFactory.getObject();
        SellerBranchChargesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchChargesId),
                sellerBranchChargesContext);
        return new ResponseEntity<SellerBranchChargesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchChargesBusinessDelegate")
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
    public void setSellerBranchChargesObjectFactory(final ObjectFactory<SellerBranchChargesContext> sellerBranchChargesContextFactory) {
        this.sellerBranchChargesContextFactory = sellerBranchChargesContextFactory;
    }
}
