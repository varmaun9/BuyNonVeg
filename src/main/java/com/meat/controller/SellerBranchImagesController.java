/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchImagesContext;
import com.meat.model.SellerBranchImagesModel;
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
@RequestMapping(value = "/sellerBranchImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchImagesController {
    private IBusinessDelegate<SellerBranchImagesModel, SellerBranchImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchImagesContext> sellerBranchImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchImagesModel> create(@RequestBody final SellerBranchImagesModel sellerBranchImagesModel) {
        businessDelegate.create(sellerBranchImagesModel);
        return new ResponseEntity<SellerBranchImagesModel>(sellerBranchImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchImagesModel> edit(@PathVariable(value = "id") final String sellerBranchImagesId,
            @RequestBody final SellerBranchImagesModel sellerBranchImagesModel) {
        SellerBranchImagesContext sellerBranchImagesContext = new SellerBranchImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchImagesId), sellerBranchImagesModel);
        return new ResponseEntity<SellerBranchImagesModel>(sellerBranchImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchImagesModel> getAddress(@PathVariable(value = "id") final String sellerBranchImagesId) {
        SellerBranchImagesContext sellerBranchImagesContext = sellerBranchImagesContextFactory.getObject();
        SellerBranchImagesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchImagesId),
                sellerBranchImagesContext);
        return new ResponseEntity<SellerBranchImagesModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllAddresses() {
        SellerBranchImagesContext sellerBranchImagesContext = sellerBranchImagesContextFactory.getObject();
        sellerBranchImagesContext.setAll("all");
        Collection<SellerBranchImagesModel> sellerBranchImagesModel = businessDelegate.getCollection(sellerBranchImagesContext);
        IModelWrapper<Collection<SellerBranchImagesModel>> models = new CollectionModelWrapper<SellerBranchImagesModel>(
                SellerBranchImagesModel.class, sellerBranchImagesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchImagesBusinessDelegate")
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
    public void setSellerBranchImagesObjectFactory(final ObjectFactory<SellerBranchImagesContext> sellerBranchImagesContextFactory) {
        this.sellerBranchImagesContextFactory = sellerBranchImagesContextFactory;
    }

}
