/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.MailConfig;
import com.meat.domain.Roles;
import com.meat.domain.UserImages;
import com.meat.domain.Users;
import com.meat.mail.Mail;
import com.meat.model.UserImagesModel;
import com.meat.model.UsersModel;
import com.meat.service.IMailConfigService;
import com.meat.service.IMailService;
import com.meat.service.IRolesService;
import com.meat.service.IUsersService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
@ImportResource("classpath:spring-thymeleaf.xml")
@PropertySource("classpath:mail.properties")
@PropertySource("classpath:application.properties")
public class UsersBusinessDelegate implements IBusinessDelegate<UsersModel, UsersContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IRolesService roleService;
    @Autowired
    private IMailConfigService mailConfigService;
    @Autowired
    private IMailService mailService;
    /* @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;*/

    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;
    @Value("${url}")
    private String url;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel create(final UsersModel model) {

        Users users = new Users();
        users.setId(model.getId());
        users.setUserName(model.getUserName());
        users.setEmailId(model.getEmailId());
        users.setPhoneNo(model.getPhoneNo());
        users.setStatus(model.getStatus().toUpperCase());
        users.setUserType(model.getUserType());
        users.setAuthenticateStatus(model.getAuthenticateStatus());
        users.setCreatedDate(new Date());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = model.getDob();
        if (dateInString != null && dateInString != "") {
            try {
                Date date = format.parse(dateInString);
                users.setDob(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        users.setGender(model.getGender());
        users.setPassword(model.getPassword());

        Integer i = usersService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            users.setUserCount(bi);
        }
        else {
            long bi = (i + 1);
            users.setUserCount(bi);
        }
        Integer ca = i + 1;
        if (model.getUserType().equals("CUSTOMER")) {
            String m = DBSequences.USERS.getSequenceName();
            String mc = m.concat(ca.toString());
            users.setUserCode(mc);
        }
        if (model.getUserType().equals("ADMINUSER")) {
            String m = DBSequences.ADMINUSER.getSequenceName();
            String mc = m.concat(ca.toString());
            users.setUserCode(mc);
        }
        if (model.getPassword() != null && model.getConfirmPassword() != null) {
            if (model.getPassword().equals(model.getConfirmPassword())) {
                model.setEmailStatus("SUCCESS");
                users = usersService.create(users);

                if (users.getId() != null) {
                    Roles r = new Roles();
                    r.setDescription("role created");
                    r.setEnabled("true");
                    if (model.getUserType().equals("CUSTOMER")) {
                        r.setRoleName("ROLE_USER");
                    }
                    if (model.getUserType().equals("ADMINUSER")) {
                        r.setRoleName("ROLE_ADMIN");
                    }
                    if (model.getUserType().equals("SELLERADMIN")) {
                        r.setRoleName("ROLE_SADMIN");
                    }
                    r.setUsers(users);
                    r = roleService.create(r);
                }
            }
            else {
                model.setEmailStatus("Password and ConfirmPassword Not Match");
            }
        }
        if (users.getEmailStatus() != null) {
            if (users.getEmailStatus().equals("DUPLICATEE")) {
                model.setEmailStatus("DUPLICATEE");
                model.setUserEmailIdStatus("You are Already Registered. Please Login !");
            }
            if (users.getEmailStatus().equals("DUPLICATEM")) {
                model.setEmailStatus("DUPLICATEM");
                model.setUserPhoneNoStatus("You are Already Registered With PhoneNo. Please Login !");
            }
            if (users.getEmailStatus().equals("DUPLICATEEM")) {
                model.setEmailStatus("DUPLICATEEM");
                model.setUserPhoneNoStatus("Email-Id And Phone-No Already Exists. Please Login !");
            }
        }
        if (users.getId() != null) {
            if (model.getUserImagesModels() != null) {
                List<UserImages> userImag = new ArrayList<UserImages>();
                for (UserImagesModel userImagesModel : model.getUserImagesModels()) {
                    UserImages userImages = new UserImages();
                    userImages.setUsers(users);
                    userImages.setImageName(userImagesModel.getImageName());
                    userImages.setImageType(userImagesModel.getImageType());
                    userImages.setImageLocation(userImagesModel.getImageLocation());
                    userImag.add(userImages);
                }

                users = usersService.addUserImages(users, userImag);
            }
        }
        if (users.getId() != null) {
            MailConfig mcfgs = mailConfigService.getUserRegistrationMailConfig();
            if (mcfgs != null) {
                Mail mail = new Mail();
                mail.setMailFrom(mailFrom);
                mail.setMailTo(users.getEmailId());
                mail.setMailSubject("Account Activation Request");
                mailService.sendUserRegistraionMail(mail, users);
            }
        }
        model.setId(users.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public UsersModel edit(final IKeyBuilder<String> keyBuilder, final UsersModel model) {
        Users users = usersService.getUsers(keyBuilder.build().toString());
        if (model.getUserName() != null) {
            users.setUserName(model.getUserName());
        }
        if (model.getPhoneNo() != null) {
            users.setPhoneNo(model.getPhoneNo());
        }
        if (model.getEmailId() != null) {
            users.setEmailId(model.getEmailId());
        }
        if (model.getStatus() != null) {
            users.setStatus(model.getStatus());
        }
        // users.setUserType(model.getUserType());
        // users.setAuthenticateStatus(model.getAuthenticateStatus());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = model.getDob();
        if (dateInString != null && dateInString != "") {
            try {
                Date date = format.parse(dateInString);
                users.setDob(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        users.setGender(model.getGender());
        users = usersService.updateUsers(users);
        model.setId(users.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UsersModel getByKey(final IKeyBuilder<String> keyBuilder, final UsersContext context) {
        Users users = usersService.getUsers(keyBuilder.build().toString());
        UsersModel usersModel = conversionService.convert(users, UsersModel.class);

        return usersModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UsersModel> getCollection(final UsersContext context) {
        List<Users> users = new ArrayList<Users>();

        if (context.getAll() != null) {
            users = usersService.getAll();
        }
        if (context.getUsersOnly() != null) {
            users = usersService.getUsersOnly();
        }

        if (context.getUserType() != null) {
            users = usersService.getByUserType(context.getUserType());
        }
        if (context.getUserId() != null && context.getConfirmPassword() != null && context.getNewPassword() != null
                && context.getChangePassword() != null && context.getPassword() != null) {
            Users user = usersService.getByChangePassword(context.getUserId(), context.getConfirmPassword(), context.getNewPassword(),
                    context.getPassword());
            users.add(user);
        }

        if (context.getUserId() != null && context.getResetPasswordStatus() != null && context.getNewPassword() != null
                && context.getConfirmPassword() != null) {
            Users user = usersService.getByResetPassword(context.getUserId(), context.getConfirmPassword(), context.getNewPassword());
            users.add(user);
        }

        if (context.getForgotPasswordStatus() != null && context.getEmailId() != null) {
            Users user = usersService.getUsersByEmailId(context.getEmailId());
            Users usr = new Users();
            if (user != null) {
                if (user.getId() != null) {
                    MailConfig mcfgs = mailConfigService.getUserForgotPasswordMailConfig();
                    if (mcfgs != null) {
                        Mail mail = new Mail();
                        mail.setMailFrom(mailFrom);
                        mail.setMailTo(user.getEmailId());
                        mail.setMailSubject("Forgot Password Request");
                        mailService.sendUserPasswordResetMail(mail, user);
                    }
                }

            }
            else {
                usr = new Users();
                usr.setId("No Id");
                usr.setAuthenticateStatus("N/A");
                usr.setEmailId("N/A");
                usr.setEmailStatus("INCORRECT");
                usr.setGender("N/A");
                usr.setPassword("N/A");
                usr.setPhoneNo("N/A");
                usr.setStatus("INCORRECT::No Such Email Exists");
                usr.setUserCode("N/A");
                usr.setUserName("N/A");
                usr.setUserType("N/A");
            }
            users.add(usr);
        }
        if (context.getEmailId() != null && context.getPassword() != null) {
            Users usr = usersService.findByEmailIdAndPassword(context.getEmailId(), context.getPassword());
            if (usr == null || usr.equals(null)) {
                //throw new ResourceNotFoundException("EmailId " + context.getEmailId() + " not found");
                Users u = new Users();
                u.setAuthenticateStatus("Please Enter Valid UserName!");
                users.add(u);
            }
            else {

                if (usr.getId() != null) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    String hashedPassword = passwordEncoder.encode(context.getPassword());
                    if ((usr.getEmailId().equals(context.getEmailId().toLowerCase())
                            && (usr.getPassword().equals(hashedPassword/*context.getPassword()*/)))) {
                        usr.setAuthenticateStatus("Success");
                        if (usr.getStatus() != null) {
                            if (usr.getStatus().equals("ACTIVE")) {
                                users.add(usr);
                            }
                            else {
                                Users u = new Users();
                                u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                                // user.setStatus("User Not Activated");
                                u.setEmailId(usr.getEmailId());
                                users.add(u);
                            }
                        }
                        else {
                            Users u = new Users();
                            u.setAuthenticateStatus("Sorry User Not Activated,Please Check Your Mail!");
                            // user.setStatus("User Not Activated");
                            u.setEmailId(usr.getEmailId());
                            users.add(u);
                        }
                    }
                    else {
                        Users u = new Users();
                        u.setAuthenticateStatus("Please Enter Valid Password!");
                        u.setEmailId(usr.getEmailId());
                        users.add(u);
                    }
                }
                else {
                    Users u = new Users();
                    u.setAuthenticateStatus("Please Enter Valid EmailId!");
                    users.add(u);
                }
            }

        }

        List<UsersModel> usersModels = (List<UsersModel>) conversionService.convert(users, TypeDescriptor.forObject(users),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersModel.class)));
        return usersModels;
    }
}
