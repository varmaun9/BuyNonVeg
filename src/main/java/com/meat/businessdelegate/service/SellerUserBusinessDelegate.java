/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.MailConfig;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerUser;
import com.meat.mail.Mail;
import com.meat.model.SellerUserModel;
import com.meat.service.IMailConfigService;
import com.meat.service.IMailService;
import com.meat.service.ISellerUserService;
import com.meat.service.IUsersService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class SellerUserBusinessDelegate implements IBusinessDelegate<SellerUserModel, SellerUserContext, IKeyBuilder<String>, String> {
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISellerUserService sellerUserService;
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IMailConfigService mailConfigService;
    @Autowired
    private IMailService mailService;

    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;
    @Value("${url}")
    private String url;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerUserModel create(final SellerUserModel model) {
        SellerUser sellerUser = new SellerUser();

        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerUser.setSellerBranch(sellerBranch);
        sellerUser.setPassword(model.getPassword());
        sellerUser.setCreatedDate(new Date());
        sellerUser.setUserEmail(model.getUserEmail());
        sellerUser.setSellerUserType(model.getSellerUserType());
        sellerUser.setUserName(model.getUserName());
        sellerUser.setUserPhoneNo(model.getUserPhoneNo());
        sellerUser.setUserStatus(model.getUserStatus());
        sellerUser.setGender(model.getGender());
        sellerUser.setUserRoleType(model.getUserRoleType());
        if (model.getPassword() != null && model.getConfirmPassword() != null) {
            if (model.getPassword().equals(model.getConfirmPassword())) {
                model.setEmailStatus("SUCCESS");
                sellerUser = sellerUserService.create(sellerUser);
            }
            else {
                model.setEmailStatus("Password and ConfirmPassword doesn't match");
            }
        }
        if (sellerUser.getEmailStatus() != null) {
            if (sellerUser.getEmailStatus().equals("DUPLICATEEMAIL")) {
                model.setSellerUserEmailExists("EmailId Entered Already Exists!");
            }
            if (sellerUser.getEmailStatus().equals("DUPLICATEPHONENO")) {
                model.setSellerUserPhoneNoExists("Mobile Number Already Exists!");
            }
        }
        model.setId(sellerUser.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerUserContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerUserModel edit(final IKeyBuilder<String> keyBuilder, final SellerUserModel model) {
        // TODO Auto-generated method stub
        SellerUser sellerUsr = sellerUserService.getSellerUser(model.getId());
        /*   SellerUser sellerUsr = sellerUsr;*/
        sellerUsr.setId(sellerUsr.getId());
        sellerUsr.setSellerBranch(sellerUsr.getSellerBranch());
        if (model.getPassword() != null) {
            sellerUsr.setPassword(model.getPassword());
        }
        if (model.getUserName() != null) {
            sellerUsr.setUserName(model.getUserName());
        }

        if (model.getUserPhoneNo() != null) {
            sellerUsr.setUserPhoneNo(model.getUserPhoneNo());
        }
        sellerUsr.setUsers(sellerUsr.getUsers());
        if (model.getUserEmail() != null) {
            sellerUsr.setUserEmail(model.getUserEmail());
        }
        if (model.getSellerUserType() != null) {
            sellerUsr.setSellerUserType(model.getSellerUserType());
        }
        if (model.getGender() != null) {
            sellerUsr.setGender(model.getGender());
        }

        if (model.getUserRoleType() != null) {
            sellerUsr.setUserRoleType(model.getUserRoleType());
        }

        sellerUsr = sellerUserService.updateSellerUser(sellerUsr);
        if (sellerUsr.getEmailStatus() != null) {
            if (sellerUsr.getEmailStatus().equals("DUPLICATEEMAIL")) {
                model.setSellerUserEmailExists("EmailId Entered Already Exists!");
            }
            if (sellerUsr.getEmailStatus().equals("DUPLICATEPHONENO")) {
                model.setSellerUserPhoneNoExists("Mobile Number Already Exists!");
            }
        }
        model.setId(sellerUsr.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     *
     */

    @Override
    public SellerUserModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerUserContext context) {
        SellerUser sellerUsers = sellerUserService.getSellerUser(keyBuilder.build().toString());
        SellerUserModel sellerUserModel = conversionService.convert(sellerUsers, SellerUserModel.class);

        return sellerUserModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerUserModel> getCollection(final SellerUserContext context) {

        List<SellerUser> sellerUsers = new ArrayList<SellerUser>();

        if (context.getAll() != null) {
            sellerUsers = sellerUserService.getAll();
        }
        if (context.getSellerUserOnly() != null) {
            sellerUsers = sellerUserService.getSellerUserOnly();
        }
        if (context.getForgotPasswordStatus() != null && context.getEmailId() != null) {
            SellerUser sellerUser = sellerUserService.getSellerUserByEmail(context.getEmailId());
            if (sellerUser != null) {
                MailConfig mcfgs = mailConfigService.getUserRegistrationMailConfig();
                if (mcfgs != null) {
                    Mail mail = new Mail();
                    mail.setMailFrom(mailFrom);
                    mail.setMailTo(sellerUser.getUserEmail());
                    mail.setMailSubject("Account Activation Request");
                    mailService.sendSellerUserPasswordResetMail(mail, sellerUser);
                }
            }
            else {
                sellerUser = new SellerUser();
                sellerUser.setId("No Id");
                sellerUser.setAuthenticateStatus("InCorrect::No Such Email Exists");
                sellerUser.setUserEmail("N/A");
                sellerUser.setPassword("N/A");
                sellerUsers.add(sellerUser);
            }
        }
        if (context.getSellerBranchId() != null) {
            sellerUsers = sellerUserService.getSellerBranchAllUsers(context.getSellerBranchId());
        }
        if (context.getSellerBranchId() != null && context.getSellerUserRole() != null) {
            sellerUsers = sellerUserService.getSellerBranchUsersByUserRoles(context.getSellerBranchId(), context.getSellerUserRole());
        }
        if (context.getSellerUserId() != null && context.getConfirmPassword() != null && context.getNewPassword() != null
                && context.getChangePassword() != null && context.getPassword() != null) {
            SellerUser sellerUser = sellerUserService.findByChangePassword(context.getSellerUserId(), context.getConfirmPassword(),
                    context.getNewPassword(), context.getPassword());
            sellerUsers.add(sellerUser);
        }
        List<SellerUserModel> sellerUsersModels = (List<SellerUserModel>) conversionService.convert(sellerUsers,
                TypeDescriptor.forObject(sellerUsers),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerUserModel.class)));
        return sellerUsersModels;
    }
}
