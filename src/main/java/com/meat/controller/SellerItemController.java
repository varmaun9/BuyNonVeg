/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerItemContext;
import com.meat.model.SellerItemModel;
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
@RequestMapping(value = "/sellerItem", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerItemController {

    private IBusinessDelegate<SellerItemModel, SellerItemContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerItemContext> sellerItemContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemModel> createSellerItem(@RequestBody final SellerItemModel sellerItemModel) {
        businessDelegate.create(sellerItemModel);
        return new ResponseEntity<SellerItemModel>(sellerItemModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerItemModel> edit(@PathVariable(value = "id") final String sellerItemId,
            @RequestBody final SellerItemModel sellerItemModel) {
        SellerItemContext sellerItemContext = new SellerItemContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerItemId), sellerItemModel);
        return new ResponseEntity<SellerItemModel>(sellerItemModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItem() {
        SellerItemContext sellerItemContext = sellerItemContextFactory.getObject();
        sellerItemContext.setAll("all");
        Collection<SellerItemModel> sellerItemModel = businessDelegate.getCollection(sellerItemContext);
        IModelWrapper<Collection<SellerItemModel>> models = new CollectionModelWrapper<SellerItemModel>(SellerItemModel.class,
                sellerItemModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerItemOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItemOnly() {
        SellerItemContext sellerItemContext = sellerItemContextFactory.getObject();
        sellerItemContext.setSellerItemOnly("sellerItemOnly");
        Collection<SellerItemModel> sellerItemModels = businessDelegate.getCollection(sellerItemContext);
        IModelWrapper<Collection<SellerItemModel>> models = new CollectionModelWrapper<SellerItemModel>(SellerItemModel.class,
                sellerItemModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranchItemOnly/{sellerBranchId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSellerBranchItemsOnly(@PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerItemContext sellerBranchItemContext = sellerItemContextFactory.getObject();
        sellerBranchItemContext.setSellerBranchItemsOnly("sellerBranchItemsOnly");
        sellerBranchItemContext.setSellerBranchId(sellerBranchId);
        Collection<SellerItemModel> sellerBranchItemsModels = businessDelegate.getCollection(sellerBranchItemContext);
        IModelWrapper<Collection<SellerItemModel>> models = new CollectionModelWrapper<SellerItemModel>(SellerItemModel.class,
                sellerBranchItemsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemModel> getSellerItem(@PathVariable(value = "id") final String sellerItemId) {
        SellerItemContext sellerItemContext = sellerItemContextFactory.getObject();
        SellerItemModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerItemId), sellerItemContext);
        return new ResponseEntity<SellerItemModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerItemOnly/{sellerBranchId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSellerItemsOnly(@PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerItemContext sellerBranchItemContext = sellerItemContextFactory.getObject();
        sellerBranchItemContext.setSellerItemOnly("sellerItemsOnly");
        sellerBranchItemContext.setSellerBranchId(sellerBranchId);
        Collection<SellerItemModel> sellerBranchItemsModels = businessDelegate.getCollection(sellerBranchItemContext);
        IModelWrapper<Collection<SellerItemModel>> models = new CollectionModelWrapper<SellerItemModel>(SellerItemModel.class,
                sellerBranchItemsModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerItemBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCategoryObjectFactory(final ObjectFactory<SellerItemContext> sellerItemContextFactory) {
        this.sellerItemContextFactory = sellerItemContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
