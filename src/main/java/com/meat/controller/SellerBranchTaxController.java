/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchTaxContext;
import com.meat.model.SellerBranchTaxModel;
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
@RequestMapping(value = "/sellerBranchTax", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchTaxController {
    private IBusinessDelegate<SellerBranchTaxModel, SellerBranchTaxContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchTaxContext> sellerBranchTaxContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchTaxModel> create(@RequestBody final SellerBranchTaxModel sellerBranchTaxModel) {
        businessDelegate.create(sellerBranchTaxModel);
        return new ResponseEntity<SellerBranchTaxModel>(sellerBranchTaxModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchTaxModel> edit(@PathVariable(value = "id") final String sellerBranchTaxId,
            @RequestBody final SellerBranchTaxModel sellerBranchTaxModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchTaxId), sellerBranchTaxModel);
        return new ResponseEntity<SellerBranchTaxModel>(sellerBranchTaxModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchTax() {
        SellerBranchTaxContext sellerBranchTaxContext = sellerBranchTaxContextFactory.getObject();
        sellerBranchTaxContext.setAll("all");
        Collection<SellerBranchTaxModel> sellerBranchTaxModel = businessDelegate.getCollection(sellerBranchTaxContext);
        IModelWrapper<Collection<SellerBranchTaxModel>> models = new CollectionModelWrapper<SellerBranchTaxModel>(
                SellerBranchTaxModel.class, sellerBranchTaxModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchTaxModel> getSellerBranchTax(@PathVariable(value = "id") final String sellerBranchTaxId) {
        SellerBranchTaxContext sellerBranchTaxContext = sellerBranchTaxContextFactory.getObject();
        SellerBranchTaxModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchTaxId),
                sellerBranchTaxContext);
        return new ResponseEntity<SellerBranchTaxModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchTaxBusinessDelegate")
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
    public void setSellerBranchTaxObjectFactory(final ObjectFactory<SellerBranchTaxContext> sellerBranchTaxContextFactory) {
        this.sellerBranchTaxContextFactory = sellerBranchTaxContextFactory;
    }

}
