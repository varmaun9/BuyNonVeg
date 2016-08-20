/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.AccountContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.AccountModel;
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
@RequestMapping(value = "/account", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class AccountController {
    private IBusinessDelegate<AccountModel, AccountContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<AccountContext> accountContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<AccountModel> create(@RequestBody final AccountModel accountModel) {
        businessDelegate.create(accountModel);
        return new ResponseEntity<AccountModel>(accountModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AccountModel> edit(@PathVariable(value = "id") final String accountId,
            @RequestBody final AccountModel accountModel) {
        AccountContext accountContext = new AccountContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(accountId), accountModel);
        return new ResponseEntity<AccountModel>(accountModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<AccountModel> getAccount(@PathVariable(value = "id") final String accountId) {
        AccountContext accountContext = accountContextFactory.getObject();
        AccountModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(accountId), accountContext);
        return new ResponseEntity<AccountModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "sellerBranch/{branchId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<AccountModel> getAccountByRestaurantBranch(@PathVariable(value = "branchId") final String branchId) {
        AccountContext accountContext = accountContextFactory.getObject();
        accountContext.setBranch(branchId);
        AccountModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(branchId), accountContext);
        return new ResponseEntity<AccountModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllAccountes() {
        AccountContext accountContext = accountContextFactory.getObject();
        accountContext.setAll("all");
        Collection<AccountModel> accountModel = businessDelegate.getCollection(accountContext);
        IModelWrapper<Collection<AccountModel>> models = new CollectionModelWrapper<AccountModel>(AccountModel.class, accountModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @Autowired
    public void setAccountObjectFactory(final ObjectFactory<AccountContext> accountContextFactory) {
        this.accountContextFactory = accountContextFactory;
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "accountBusinessDelegate")
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

}
