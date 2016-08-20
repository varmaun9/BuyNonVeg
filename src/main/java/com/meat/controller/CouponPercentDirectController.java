/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CouponPercentDirectContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CouponPercentDirectModel;
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
@RequestMapping(value = "/couponPercentDirect", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CouponPercentDirectController {
    private IBusinessDelegate<CouponPercentDirectModel, CouponPercentDirectContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CouponPercentDirectContext> couponPercentDirectContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponPercentDirectModel> create(@RequestBody final CouponPercentDirectModel couponPercentDirectModel) {
        businessDelegate.create(couponPercentDirectModel);
        return new ResponseEntity<CouponPercentDirectModel>(couponPercentDirectModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CouponPercentDirectModel> edit(@PathVariable(value = "id") final String couponPercentDirectId,
            @RequestBody final CouponPercentDirectModel couponPercentDirectModel) {
        CouponPercentDirectContext couponPercentDirectContext = new CouponPercentDirectContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(couponPercentDirectId), couponPercentDirectModel);
        return new ResponseEntity<CouponPercentDirectModel>(couponPercentDirectModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCouponPercentDirect() {
        CouponPercentDirectContext couponPercentDirectContext = couponPercentDirectContextFactory.getObject();
        couponPercentDirectContext.setAll("all");
        Collection<CouponPercentDirectModel> couponPercentDirectModel = businessDelegate.getCollection(couponPercentDirectContext);
        IModelWrapper<Collection<CouponPercentDirectModel>> models = new CollectionModelWrapper<CouponPercentDirectModel>(
                CouponPercentDirectModel.class, couponPercentDirectModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponPercentDirectModel> getCouponPercentDirect(@PathVariable(value = "id") final String couponPercentDirectId) {
        CouponPercentDirectContext couponPercentDirectContext = couponPercentDirectContextFactory.getObject();
        CouponPercentDirectModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(couponPercentDirectId),
                couponPercentDirectContext);
        return new ResponseEntity<CouponPercentDirectModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "couponPercentDirectBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCouponPercentDirectObjectFactory(final ObjectFactory<CouponPercentDirectContext> couponPercentDirectContextFactory) {
        this.couponPercentDirectContextFactory = couponPercentDirectContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
