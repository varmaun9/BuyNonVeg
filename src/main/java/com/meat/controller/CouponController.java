/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CouponContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CouponModel;
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
@RequestMapping(value = "/coupon", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CouponController {
    private IBusinessDelegate<CouponModel, CouponContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CouponContext> couponContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponModel> create(@RequestBody final CouponModel couponModel) {
        businessDelegate.create(couponModel);
        return new ResponseEntity<CouponModel>(couponModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CouponModel> edit(@PathVariable(value = "id") final String couponId, @RequestBody final CouponModel couponModel) {
        CouponContext couponContext = new CouponContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(couponId), couponModel);
        return new ResponseEntity<CouponModel>(couponModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCoupon() {
        CouponContext couponContext = couponContextFactory.getObject();
        couponContext.setAll("all");
        Collection<CouponModel> couponModel = businessDelegate.getCollection(couponContext);
        IModelWrapper<Collection<CouponModel>> models = new CollectionModelWrapper<CouponModel>(CouponModel.class, couponModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponModel> getCoupon(@PathVariable(value = "id") final String couponId) {
        CouponContext couponContext = couponContextFactory.getObject();
        CouponModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(couponId), couponContext);
        return new ResponseEntity<CouponModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "couponBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCouponObjectFactory(final ObjectFactory<CouponContext> couponContextFactory) {
        this.couponContextFactory = couponContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
