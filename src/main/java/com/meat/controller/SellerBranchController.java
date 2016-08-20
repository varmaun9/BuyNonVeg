/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchContext;
import com.meat.model.SellerBranchModel;
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
@RequestMapping(value = "/sellerBranch", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchController {
    private IBusinessDelegate<SellerBranchModel, SellerBranchContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchContext> sellerBranchContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchModel> create(@RequestBody final SellerBranchModel sellerBranchModel) {
        businessDelegate.create(sellerBranchModel);
        return new ResponseEntity<SellerBranchModel>(sellerBranchModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchModel> edit(@PathVariable(value = "id") final String sellerBranchId,
            @RequestBody final SellerBranchModel sellerBranchModel) {
        SellerBranchContext sellerBranchContext = new SellerBranchContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchId), sellerBranchModel);
        return new ResponseEntity<SellerBranchModel>(sellerBranchModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranches() {
        SellerBranchContext sellerBranchContext = sellerBranchContextFactory.getObject();
        sellerBranchContext.setAll("all");
        Collection<SellerBranchModel> sellerBranchModel = businessDelegate.getCollection(sellerBranchContext);
        IModelWrapper<Collection<SellerBranchModel>> models = new CollectionModelWrapper<SellerBranchModel>(SellerBranchModel.class,
                sellerBranchModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranchOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchOnly() {
        SellerBranchContext sellerBranchContext = sellerBranchContextFactory.getObject();
        sellerBranchContext.setSellerBranchOnly("sellerBranchOnly");
        Collection<SellerBranchModel> sellerBranchModel = businessDelegate.getCollection(sellerBranchContext);
        IModelWrapper<Collection<SellerBranchModel>> models = new CollectionModelWrapper<SellerBranchModel>(SellerBranchModel.class,
                sellerBranchModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/seller/{sellerId}/sellerBranchOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchOnlyBySellerId(@PathVariable(value = "sellerId") final String sellerId) {
        SellerBranchContext sellerBranchContext = sellerBranchContextFactory.getObject();
        sellerBranchContext.setSellerBranchOnly("sellerBranchOnly");
        sellerBranchContext.setSellerId(sellerId);
        Collection<SellerBranchModel> sellerBranchModel = businessDelegate.getCollection(sellerBranchContext);
        IModelWrapper<Collection<SellerBranchModel>> models = new CollectionModelWrapper<SellerBranchModel>(SellerBranchModel.class,
                sellerBranchModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{sellerBranchId}/sellerBranchOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getItemOnlyByCategory(@PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerBranchContext sellerBranchContext = sellerBranchContextFactory.getObject();
        sellerBranchContext.setSellerBranchId(sellerBranchId);
        sellerBranchContext.setSellerBranchOnly("sellerBranchOnly");
        Collection<SellerBranchModel> sellerBranchModels = businessDelegate.getCollection(sellerBranchContext);
        IModelWrapper<Collection<SellerBranchModel>> models = new CollectionModelWrapper<SellerBranchModel>(SellerBranchModel.class,
                sellerBranchModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchModel> getSellerBranch(@PathVariable(value = "id") final String sellerBranchId) {
        SellerBranchContext sellerBranchContext = sellerBranchContextFactory.getObject();
        SellerBranchModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchId), sellerBranchContext);
        return new ResponseEntity<SellerBranchModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchBusinessDelegate")
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
    public void setSellerBranchObjectFactory(final ObjectFactory<SellerBranchContext> sellerBranchContextFactory) {
        this.sellerBranchContextFactory = sellerBranchContextFactory;
    }

}
