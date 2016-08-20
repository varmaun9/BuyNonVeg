/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.UsersContext;
import com.meat.model.UsersModel;
import com.meat.security.CustomUserDetails;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi1
 *
 */
@RestController
@RequestMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class UsersController {
    private IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<UsersContext> usersContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/changePassword", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> changePassword(@RequestBody final UsersModel userModel,
            final HttpSession session) /*throws ResourceNotFoundException */ {
        UsersContext usersContext = usersContextFactory.getObject();
        //String s = (String) session.getAttribute("userId");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        // System.out.println("userDetails" + userDetails.getId());
        if (userDetails.getId() != null) {
            usersContext.setUserId(userDetails.getId());
            usersContext.setChangePassword("YES");
            usersContext.setPassword(userModel.getPassword());
            usersContext.setNewPassword(userModel.getNewPassword());
            usersContext.setConfirmPassword(userModel.getConfirmPassword());
            Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
            IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, usersModels);
            return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
        }
        else {
            session.invalidate();
            // model.addAttribute("message", "Session Expired! Login Again");
            // return "redirect:" + url + "/login";
            IModelWrapper<Collection<UsersModel>> models = null;
            return new ResponseEntity<IModelWrapper>(models, HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersModel> create(@RequestBody final UsersModel usersModel) {
        businessDelegate.create(usersModel);
        return new ResponseEntity<UsersModel>(usersModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UsersModel> edit(@PathVariable(value = "id") final String usersId, @RequestBody final UsersModel usersModel) {
        UsersContext usersContext = new UsersContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(usersId), usersModel);
        return new ResponseEntity<UsersModel>(usersModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/forgotPassword", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> forgotPassword(@RequestBody final UsersModel userModel) /*throws ResourceNotFoundException */ {
        UsersContext userContext = usersContextFactory.getObject();
        userContext.setEmailId(userModel.getEmailId());

        userContext.setForgotPasswordStatus("YES");
        Collection<UsersModel> userModels = businessDelegate.getCollection(userContext);
        IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, userModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userType}/All", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAll(@PathVariable(value = "userType") final String userType) {
        UsersContext usersContext = usersContextFactory.getObject();
        usersContext.setUserType(userType);
        Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, usersModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUsers() {
        UsersContext usersContext = usersContextFactory.getObject();
        usersContext.setAll("all");
        Collection<UsersModel> UsersModel = businessDelegate.getCollection(usersContext);
        IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, UsersModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllUsersOnly() {
        UsersContext usersContext = usersContextFactory.getObject();
        usersContext.setUsersOnly("usersOnly");
        Collection<UsersModel> usersModels = businessDelegate.getCollection(usersContext);
        IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, usersModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<UsersModel> getUsers(@PathVariable(value = "id") final String usersId) {
        UsersContext usersContext = usersContextFactory.getObject();
        UsersModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(usersId), usersContext);
        return new ResponseEntity<UsersModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/resetPassword", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> resetPassword(@RequestBody final UsersModel userModel) /*throws ResourceNotFoundException */ {
        UsersContext userContext = usersContextFactory.getObject();
        userContext.setUserId(userModel.getId());
        userContext.setResetPasswordStatus("YES");
        userContext.setNewPassword(userModel.getNewPassword());
        userContext.setConfirmPassword(userModel.getConfirmPassword());
        Collection<UsersModel> userModels = businessDelegate.getCollection(userContext);
        IModelWrapper<Collection<UsersModel>> models = new CollectionModelWrapper<UsersModel>(UsersModel.class, userModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "usersBusinessDelegate")
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
    public void setUsersObjectFactory(final ObjectFactory<UsersContext> usersContextFactory) {
        this.usersContextFactory = usersContextFactory;
    }

}
