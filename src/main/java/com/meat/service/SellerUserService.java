/**
 *
 */
package com.meat.service;

import com.meat.constants.DBSequences;
import com.meat.dao.SellerUserRepository;
import com.meat.dao.UsersRepository;
import com.meat.domain.Roles;
import com.meat.domain.SellerUser;
import com.meat.domain.Users;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author varma
 *
 */
@Component
public class SellerUserService implements ISellerUserService {

    @Autowired
    private IUsersService userService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private IRolesService roleService;
    @Autowired
    private SellerUserRepository sellerUserRepository;

    /**
     * @param sellerUser
     * @param confirmPassword
     * @param password
     * @return
     */
    private SellerUser changesignup(SellerUser sellerUser, final String confirmPassword, final String password) {

        if (sellerUser != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, sellerUser.getPassword())) {
                /* if (!newPassword.isEmpty()) {*/
                String hashedPassword1 = passwordEncoder.encode(confirmPassword);
                sellerUser.setPassword(hashedPassword1);
                sellerUser.setAuthenticateStatus("Success");
                sellerUser = sellerUserRepository.save(sellerUser);

                if (sellerUser != null) {
                    Users user = usersRepository.findBySellerUser(sellerUser.getId());
                    Users users = user;
                    users.setPassword(sellerUser.getPassword());
                    users = usersRepository.save(users);
                }
                /*  Mail mail = new Mail();
                  mail.setMailFrom(mailFrom);
                  mail.setMailTo("to@gmail.com"emailId);
                  mail.setMailSubject("Password Changed Successfully");
                  sendMail(mail,emailId);*/

            }
            else {
                sellerUser.setAuthenticateStatus("InCorrect::Please Enter Valid Current Password!");
            }
        }
        else {
            sellerUser.setAuthenticateStatus(" InCorrect::Please Enter Valid EmailId!");
        }
        return sellerUser;
    }

    /* *//**
          * @param phoneNo
          * @return
          *//*
           private boolean checkPhoneNoExists(final String phoneNo) {
           // TODO Auto-generated method stub
           return usersRepository.findByPhoneNo(phoneNo) != null;
           }*/

    /**
     * @param lowerCase
     * @return
     */
    @Override
    public boolean checkEmailExists(final String email) {
        return usersRepository.findByEmailId(email) != null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#create(com.meat.domain.SellerUser)
     */
    @Override
    @Transactional
    public SellerUser create(SellerUser sellerUser) {
        Validate.notNull(sellerUser, "sellerUser must not be null" + sellerUser.getUserEmail());
        sellerUser.setEmailStatus("PENDING");
        sellerUser.setUserStatus("INACTIVE");
        Users user = new Users();
        user.setCreatedDate(new Date());
        user.setEmailId(sellerUser.getUserEmail());
        user.setPassword(sellerUser.getPassword());
        user.setPhoneNo(sellerUser.getUserPhoneNo());
        user.setUserName(sellerUser.getUserName());
        user.setStatus("ACTIVE");

        user.setUserType(sellerUser.getSellerUserType());
        user.setUserRoleType(sellerUser.getUserRoleType());
        Integer i = userService.getMaxCode();
        if (i == null || i == 0) {
            i = 0;
            BigInteger bi = BigInteger.valueOf(i + 1);
            user.setUserCount(bi.longValue());
        }
        else {
            BigInteger bi = BigInteger.valueOf(i + 1);
            user.setUserCount(bi.longValue());
        }
        Integer c = i + 1;
        String m = DBSequences.SELLERUSER.getSequenceName();
        String mc = m.concat(c.toString());
        user.setUserCode(mc);
        user.setAuthenticateStatus("PENDING");
        user.setEmailStatus("PENDING");
        if (checkEmailExists(user.getEmailId().toLowerCase())) {
            user.setAuthenticateStatus("DUPLICATEM");
            user.setEmailStatus("DUPLICATEEMAIL");
            sellerUser.setAuthenticateStatus("DUPLICATE");
            sellerUser.setEmailStatus("DUPLICATEEMAIL");
        }
        /* if (checkPhoneNoExists(user.getPhoneNo())) {
            user.setAuthenticateStatus("DUPLICATEM");
            user.setEmailStatus("DUPLICATEMPHONENO");
            sellerUser.setAuthenticateStatus("DUPLICATE");
            sellerUser.setEmailStatus("DUPLICATEMPHONENO");
        }*/
        List<Users> users = new ArrayList<Users>();
        users = (List<Users>) usersRepository.findAll();
        if (users != null) {
            for (Users u : users) {
                String d = u.getEmailId();
                String dc = d.replaceAll("\\s", "");
                String dc1 = dc.toLowerCase();
                if (user.getEmailId() != null) {
                    String dc2 = user.getEmailId().replaceAll("\\s", "").toLowerCase();
                    if (dc1.equals(dc2)) {
                        user.setAuthenticateStatus("DUPLICATEM");
                        user.setEmailStatus("DUPLICATEEMAIL");
                        sellerUser.setAuthenticateStatus("DUPLICATE");
                        sellerUser.setEmailStatus("DUPLICATEEMAIL");
                    }
                }
            }
        }
        if (user.getEmailId() != null && user.getAuthenticateStatus() != null) {
            if (user.getEmailId().equals("DUPLICATE") || user.getAuthenticateStatus().equals("DUPLICATE")
                    || user.getEmailId().equals("DUPLICATEM") || user.getAuthenticateStatus().equals("DUPLICATEM")) {
            }
            if (user.getPhoneNo() != null && user.getAuthenticateStatus() != null) {
                if (user.getPhoneNo().equals("DUPLICATE") || user.getAuthenticateStatus().equals("DUPLICATE")
                        || user.getPhoneNo().equals("DUPLICATEM") || user.getAuthenticateStatus().equals("DUPLICATEM")) {
                }
                else {
                    user = signup(user);
                    sellerUser.setUsers(user);
                    user.setEmailStatus("SUCCESS");
                    user.setAuthenticateStatus("SUCCESS");
                    sellerUser.setEmailStatus("SUCCESS");
                    sellerUser = signup(sellerUser);
                }
            }
        }

        return sellerUser;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#deleteSellerUser(java.lang.String)
     */
    @Override
    public void deleteSellerUser(final String sellerUserId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#findByChangePassword(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public SellerUser findByChangePassword(final String sellerUserId, final String confirmPassword, final String newPassword,
            final String password) {
        SellerUser sellerUser = sellerUserRepository.findOne(sellerUserId);
        SellerUser selleruser1 = new SellerUser();
        List<SellerUser> users = new ArrayList<SellerUser>();
        if (sellerUser.getId() != null) {
            selleruser1.setUserEmail(sellerUser.getUserEmail());
            selleruser1.setPassword(confirmPassword);
            selleruser1.setId(sellerUser.getId());

            //userRepository.save(user);
            if (newPassword.equals(confirmPassword)) {
                selleruser1 = changesignup(sellerUser, confirmPassword, password);
            }
        }
        else {
            sellerUser.setAuthenticateStatus("InCorrect::Please Enter Valid EmailId!");
        }
        users.add(selleruser1);
        return selleruser1;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getAll()
     */
    @Override
    public List<SellerUser> getAll() {
        // TODO Auto-generated method stub
        return (List<SellerUser>) sellerUserRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getSellerBranchAllUsers(java.lang.String)
     */
    @Override
    public List<SellerUser> getSellerBranchAllUsers(final String sellerBranchId) {
        // TODO Auto-generated method stub
        return sellerUserRepository.findSellerBranchAllUsers(sellerBranchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getSellerBranchUsersByUserRoles(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerUser> getSellerBranchUsersByUserRoles(final String sellerBranchId, final String sellerUserRole) {

        List<SellerUser> sellerUser = new ArrayList<SellerUser>();
        sellerUser = sellerUserRepository.findSellerUsersByRoleBranch(sellerBranchId, sellerUserRole);
        List<SellerUser> sellerUsers = new ArrayList<SellerUser>();
        for (SellerUser su : sellerUser) {
            SellerUser s = new SellerUser();
            s.setId(su.getId());
            s.setUserName(su.getUserName());
            s.setUserEmail(su.getUserEmail());
            s.setUserPhoneNo(su.getUserPhoneNo());
            s.setUserStatus(su.getUserStatus());
            s.setUsers(su.getUsers());
            s.setSellerBranch(su.getSellerBranch());
            s.setEmailStatus(su.getEmailStatus());
            s.setGender(su.getGender());
            s.setAuthenticateStatus(su.getAuthenticateStatus());
            s.setSellerUserType(su.getSellerUserType());
            sellerUsers.add(s);
        }
        return sellerUsers;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getSellerUser(java.lang.String)
     */
    @Override
    public SellerUser getSellerUser(final String sellerUserId) {
        // TODO Auto-generated method stub
        return sellerUserRepository.findOne(sellerUserId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getSellerUserByEmail(java.lang.String)
     */
    @Override
    public SellerUser getSellerUserByEmail(final String emailId) {
        // TODO Auto-generated method stub
        return sellerUserRepository.findByEmailId(emailId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#getSellerUserOnly()
     */

    @Override
    public List<SellerUser> getSellerUserOnly() {
        List<SellerUser> sellerUser = new ArrayList<SellerUser>();
        sellerUser = (List<SellerUser>) sellerUserRepository.findAll();
        List<SellerUser> sellerUsers = new ArrayList<SellerUser>();
        for (SellerUser su : sellerUser) {
            SellerUser s = new SellerUser();
            s.setId(su.getId());
            s.setUserName(su.getUserName());
            s.setUserEmail(su.getUserEmail());
            s.setUserPhoneNo(su.getUserPhoneNo());
            s.setUserStatus(su.getUserStatus());
            s.setUsers(su.getUsers());
            s.setSellerBranch(su.getSellerBranch());
            s.setEmailStatus(su.getEmailStatus());
            s.setGender(su.getGender());
            s.setPassword(su.getPassword());
            s.setCreatedDate(new Date());
            s.setAuthenticateStatus(su.getAuthenticateStatus());
            s.setSellerUserType(su.getSellerUserType());
            sellerUsers.add(s);
        }
        return sellerUsers;
    }

    /**
     * @param sellerUser
     * @return
     */
    private SellerUser signup(SellerUser sellerUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (sellerUser.getPassword() != null) {
            String hashedPassword1 = passwordEncoder.encode(sellerUser.getPassword());
            sellerUser.setPassword(hashedPassword1);
        }
        sellerUser.setUserEmail(sellerUser.getUserEmail());
        return sellerUser = sellerUserRepository.save(sellerUser);
    }

    public Users signup(final Users users) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (users.getPassword() != null) {
            String hashedPassword1 = passwordEncoder.encode(users.getPassword());
            users.setPassword(hashedPassword1);
        }
        users.setEmailId(users.getEmailId());
        Users user1 = new Users();
        user1 = usersRepository.save(users);
        if (user1.getId() != null) {
            Roles r = new Roles();
            r.setDescription("role created");
            r.setEnabled("true");
            if (user1.getUserType().equals("SELLER_ADMIN")) {
                if (user1.getUserRoleType().equals("ADMIN_USER")) {
                    r.setRoleName("ROLE_SELLER_ADMIN");
                }
            }
            if (user1.getUserType().equals("SELLER_USER")) {
                if (user1.getUserRoleType().equals("DELIVERY_USER")) {
                    r.setRoleName("ROLE_DELIVERY_USER");
                }
                if (user1.getUserRoleType().equals("SELLER_ACCOUNT_USER")) {
                    r.setRoleName("ROLE_ACCOUNT_USER");
                }
            }

            r.setUsers(user1);
            r = roleService.create(r);
        }
        return user1;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerUserService#updateSellerUser(com.meat.domain.SellerUser)
     */
    @Override
    public SellerUser updateSellerUser(final SellerUser sellerUser) {
        // TODO Auto-generated method stub
        Users user = userService.getUserBySellerUser(sellerUser.getId());
        user.setUserName(sellerUser.getUserName());
        user.setEmailId(sellerUser.getUserEmail());
        user.setPassword(sellerUser.getPassword());
        user.setPhoneNo(sellerUser.getUserPhoneNo());
        user.setUserName(sellerUser.getUserName());
        user.setStatus(sellerUser.getUserStatus());

        user.setUserType(sellerUser.getSellerUserType());
        user.setUserRoleType(sellerUser.getUserRoleType());
        /* if (checkPhoneNoExists(sellerUser.getUserPhoneNo())) {
            user.setAuthenticateStatus("DUPLICATEM");
            user.setEmailStatus("DUPLICATEMPHONENO");
            sellerUser.setAuthenticateStatus("DUPLICATE");
            sellerUser.setEmailStatus("DUPLICATEMPHONENO");
        }*/
        user.setPhoneNo(sellerUser.getUserPhoneNo());
        user = userService.updateUsers(user);
        sellerUser.setUsers(user);
        return sellerUserRepository.save(sellerUser);
    }

}
