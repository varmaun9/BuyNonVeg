/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.AddressContext;
import com.meat.businessdelegate.service.CouponBuyXGetYContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CouponBuyXGetYModel;
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
@RequestMapping(value = "/couponBuyXGetY", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CouponBuyXGetYController {
    private IBusinessDelegate<CouponBuyXGetYModel, CouponBuyXGetYContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CouponBuyXGetYContext> couponBuyXGetYContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponBuyXGetYModel> create(@RequestBody final CouponBuyXGetYModel couponBuyXGetYModel) {
        businessDelegate.create(couponBuyXGetYModel);
        return new ResponseEntity<CouponBuyXGetYModel>(couponBuyXGetYModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CouponBuyXGetYModel> edit(@PathVariable(value = "id") final String couponBuyXGetYId,
            @RequestBody final CouponBuyXGetYModel couponBuyXGetYModel) {
        CouponBuyXGetYContext couponBuyXGetYContext = new CouponBuyXGetYContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(couponBuyXGetYId), couponBuyXGetYModel);
        return new ResponseEntity<CouponBuyXGetYModel>(couponBuyXGetYModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCouponBuyXGetY() {
        CouponBuyXGetYContext couponBuyXGetYContext = couponBuyXGetYContextFactory.getObject();
        couponBuyXGetYContext.setAll("all");
        Collection<CouponBuyXGetYModel> couponBuyXGetYModel = businessDelegate.getCollection(couponBuyXGetYContext);
        IModelWrapper<Collection<CouponBuyXGetYModel>> models = new CollectionModelWrapper<CouponBuyXGetYModel>(CouponBuyXGetYModel.class,
                couponBuyXGetYModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CouponBuyXGetYModel> getCouponBuyXGetY(@PathVariable(value = "id") final String couponBuyXGetYId) {
        CouponBuyXGetYContext couponBuyXGetYContext = couponBuyXGetYContextFactory.getObject();
        CouponBuyXGetYModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(couponBuyXGetYId), couponBuyXGetYContext);
        return new ResponseEntity<CouponBuyXGetYModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "couponBuyXGetYBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCouponBuyXGetYObjectFactory(final ObjectFactory<AddressContext> addressContextFactory) {
        couponBuyXGetYContextFactory = couponBuyXGetYContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
