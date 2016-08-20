/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerUserContext;
import com.meat.model.SellerUserModel;
import com.meat.model.UsersModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
@RequestMapping(value = "/sellerUser", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerUserController {
    private IBusinessDelegate<SellerUserModel, SellerUserContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerUserContext> sellerUserContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/changePassword", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> changePassword(@RequestBody final SellerUserModel sellerUserModel, final HttpSession session) {
        String sellerUserId = sellerUserModel.getId();
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        if (sellerUserId != null) {
            sellerUserContext.setSellerUserId(sellerUserId);
            sellerUserContext.setChangePassword("YES");
            sellerUserContext.setPassword(sellerUserModel.getPassword());
            sellerUserContext.setNewPassword(sellerUserModel.getNewPassword());
            sellerUserContext.setConfirmPassword(sellerUserModel.getConfirmPassword());
            Collection<SellerUserModel> usersModels = businessDelegate.getCollection(sellerUserContext);
            IModelWrapper<Collection<SellerUserModel>> models = new CollectionModelWrapper<SellerUserModel>(SellerUserModel.class,
                    usersModels);
            return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
        }
        else {
            session.invalidate();
            // model.addAttribute("message", "Session Expired! Login Again");
            // return "redirect:" + url + "/login";
            IModelWrapper<Collection<SellerUserModel>> models = null;
            return new ResponseEntity<IModelWrapper>(models, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerUserModel> create(@RequestBody final SellerUserModel sellerUserModel) {
        SellerUserModel model = businessDelegate.create(sellerUserModel);
        return new ResponseEntity<SellerUserModel>(model, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerUserModel> edit(@PathVariable(value = "id") final String sellerUserId,
            @RequestBody final SellerUserModel sellerUserModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerUserId), sellerUserModel);
        return new ResponseEntity<SellerUserModel>(sellerUserModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/forgotPassword", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> forgotPassword(@RequestBody final UsersModel userModel) /*throws ResourceNotFoundException */ {
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        sellerUserContext.setEmailId(userModel.getEmailId());
        sellerUserContext.setForgotPasswordStatus("YES");
        Collection<SellerUserModel> sellerUserModels = businessDelegate.getCollection(sellerUserContext);
        IModelWrapper<Collection<SellerUserModel>> models = new CollectionModelWrapper<SellerUserModel>(SellerUserModel.class,
                sellerUserModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAll() {
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        sellerUserContext.setAll("all");
        Collection<SellerUserModel> sellerUserModel = businessDelegate.getCollection(sellerUserContext);
        IModelWrapper<Collection<SellerUserModel>> models = new CollectionModelWrapper<SellerUserModel>(SellerUserModel.class,
                sellerUserModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}/allUsers", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerUsers(@PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        sellerUserContext.setSellerBranchId(sellerBranchId);
        Collection<SellerUserModel> sellerUserModel = businessDelegate.getCollection(sellerUserContext);
        IModelWrapper<Collection<SellerUserModel>> models = new CollectionModelWrapper<SellerUserModel>(SellerUserModel.class,
                sellerUserModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranch}/users/{userRole}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSellerBranchUsersByUserRole(@PathVariable(value = "sellerBranch") final String sellerBranchId,
            @PathVariable(value = "userRole") final String userRole) {
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        sellerUserContext.setSellerBranchId(sellerBranchId);
        sellerUserContext.setSellerUserRole(userRole);
        Collection<SellerUserModel> sellerUserModel = businessDelegate.getCollection(sellerUserContext);
        IModelWrapper<Collection<SellerUserModel>> models = new CollectionModelWrapper<SellerUserModel>(SellerUserModel.class,
                sellerUserModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerUserModel> getSellerUser(@PathVariable(value = "id") final String sellerUserId) {
        SellerUserContext sellerUserContext = sellerUserContextFactory.getObject();
        SellerUserModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerUserId), sellerUserContext);
        return new ResponseEntity<SellerUserModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerUserBusinessDelegate")
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
    public void setSellerUserObjectFactory(final ObjectFactory<SellerUserContext> sellerUserContextFactory) {
        this.sellerUserContextFactory = sellerUserContextFactory;
    }

}
