package com.meat.service;

import com.meat.businessdelegate.exception.ResourceNotFoundException;
import com.meat.dao.UserImagesRepository;
import com.meat.dao.UsersRepository;
import com.meat.domain.UserImages;
import com.meat.domain.Users;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UsersService implements IUsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserImagesRepository userImagesRepository;
    @Autowired
    private IUserImagesService userImagesService;

    /* Cipher dcipher;
    
    byte[] salt = new String("12345678").getBytes();
    
    int iterationCount = 1024;
    
    int keyStrength = 256;
    
    SecretKeySpec key;
    
    byte[] iv;
    
    public static String generateHash(final String input) {
        StringBuilder hash = new StringBuilder();
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
            for (int idx = 0; idx < hashedBytes.length; idx++) {
                byte b = hashedBytes[idx];
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        }
        catch (NoSuchAlgorithmException e) {
        }
        return hash.toString();
    
    }
    */
    @Override
    public Users addUserImages(final Users users, final List<UserImages> userImag) {
        Validate.notNull(users, "users must not be null");
        Set<UserImages> addImages = new HashSet<UserImages>(userImag);
        for (UserImages uImages : userImag) {
            UserImages userImages = new UserImages();
            String s = uImages.getImageName();
            s = s.replaceAll("\\\\", "/");
            if (uImages.getId() != null) {
                userImages = userImagesService.getUserImages(uImages.getId());
                userImages.setId(userImages.getId());
                userImages.setImageName(s);
                userImages.setImageType(uImages.getImageType());
                userImages.setImageLocation(uImages.getImageLocation());
                userImages.setUsers(userImages.getUsers());
                userImages = userImagesService.updateUserImages(userImages);
            }
            else {
                userImages.setImageName(s);
                userImages.setImageType(uImages.getImageType());
                userImages.setImageLocation(uImages.getImageLocation());
                userImages.setUsers(users);
                addImages.add(userImages);
                userImages = userImagesRepository.save(userImages);
            }

        }
        users.setUserImageses(addImages);
        return users;
    }

    /**
     * @param emailId
     * @param confirmPassword
     * @param password
     * @return
     */
    private Users changesignup(Users user, final String newPassword, final String currentPassword) {

        if (user != null) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(currentPassword, user.getPassword())) {

                /* if (!newPassword.isEmpty()) {*/
                String hashedPassword1 = passwordEncoder.encode(newPassword);
                user.setPassword(hashedPassword1);
                user.setAuthenticateStatus("Success");
                user = usersRepository.save(user);

                /*  Mail mail = new Mail();
                  mail.setMailFrom(mailFrom);
                  mail.setMailTo("to@gmail.com"emailId);
                  mail.setMailSubject("Password Changed Successfully");
                  sendMail(mail,emailId);*/

            }
            else {
                user.setAuthenticateStatus("InCorrect::Please Enter Valid Current Password!");
            }
        }
        else {
            user.setAuthenticateStatus(" InCorrect::Please Enter Valid EmailId!");
        }
        return user;
    }

    @Override
    public boolean checkEmailExists(final String email) {
        return usersRepository.findByEmailId(email) != null;
    }

    public boolean checkPhoneNoExists(final String phoneNo) {
        return usersRepository.findByPhoneNo(phoneNo) != null;
    }

    @Override
    @Transactional
    public Users create(final Users users) {
        Validate.notNull(users, "user must not be null" + users.getEmailId());
        users.setAuthenticateStatus("PENDING");
        users.setEmailStatus("PENDING");
        boolean emailExists = checkEmailExists(users.getEmailId().toLowerCase());
        boolean phoneNoExists = checkPhoneNoExists(users.getPhoneNo());
        if (emailExists || phoneNoExists) {
            if (emailExists && phoneNoExists) {
                users.setEmailStatus("DUPLICATEEM");
                return users;
            }
            if (emailExists) {
                users.setEmailStatus("DUPLICATEE");
                return users;
            }
            if (phoneNoExists) {
                users.setEmailStatus("DUPLICATEM");
                return users;
            }
        }
        else {
            signup(users);
            users.setEmailStatus("SUCCESS");
            users.setAuthenticateStatus("SUCCESS");
        }
        return users;
    }

    @Override
    public void deleteUsers(final String usersId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#findByEmailIdAndPassword(java.lang.String, java.lang.String)
     */
    @Transactional(rollbackFor = ResourceNotFoundException.class)
    @Override
    public Users findByEmailIdAndPassword(final String emailId, final String password) /*throws ResourceNotFoundException*/ {
        Validate.notNull(emailId, "emailId must not be null");

        String e = emailId.toLowerCase();
        Users usr = usersRepository.findByEmailIdAndPassword(e);
        if (usr == null || usr.equals("") || usr.equals(null)) {
            usr = new Users();
            usr.setAuthenticateStatus("Please Enter Valid EmailId!");
        }
        else {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(usr.getPassword());
            //users.setPassword(hashedPassword);
            if (hashedPassword.equals(usr.getPassword())) {
                return usr;
            }
            else {
                usr.setAuthenticateStatus("Please Enter Valid Password!");
                return usr;
            }
        }
        return usr;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#findByUser(java.lang.String)
     */
    @Override
    public Users findByUser(final String id) {
        // TODO Auto-generated method stub
        return usersRepository.findByUserId(id);
    }

    @Override
    public List<Users> getAll() {
        List<Users> user = new ArrayList<Users>();
        user = (List<Users>) usersRepository.findAll();
        return user;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#findByChangePassword(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Users getByChangePassword(final String userId, final String confirmPassword, final String newPassword, final String password) {
        Users user = usersRepository.findOne(userId);
        Users user1 = new Users();
        List<Users> users = new ArrayList<Users>();
        if (user.getId() != null) {
            user1.setEmailId(user.getEmailId());
            user1.setPassword(confirmPassword);
            user1.setPhoneNo(user.getPhoneNo());
            user1.setUserType(user.getUserType());
            user1.setId(user.getId());

            //userRepository.save(user);
            if (newPassword.equals(confirmPassword)) {
                user1 = changesignup(user, confirmPassword, password);
            }
        }
        else {
            user.setAuthenticateStatus("InCorrect::Please Enter Valid EmailId!");
        }
        users.add(user1);
        return user1;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getByResetPassword(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Users getByResetPassword(final String userId, final String confirmPassword, final String newPassword) {
        Users user = usersRepository.findByUserId(userId);
        Users user1 = user;
        List<Users> users = new ArrayList<Users>();
        if (user.getId() != null) {
            user1.setEmailId(user.getEmailId());
            user1.setId(user.getId());
            if (newPassword.equals(confirmPassword)) {
                user1.setPassword(newPassword);
                user1 = getUserResetPassword(user1);
            }
            else {
                user1.setAuthenticateStatus("INCORRECT:: New Password and Confirm Password Doesn't Match ");
            }
        }
        else {
            user1.setAuthenticateStatus("INCORRECT:: Something went Wrong!");
        }
        users.add(user1);
        return user1;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getByUserType(java.lang.String)
     */
    @Override
    public List<Users> getByUserType(final String userType) {
        List<Users> users = usersRepository.getByUserType(userType);
        for (Users u : users) {
            Users user = new Users();
            if (CollectionUtils.isEmpty(users)) {
                return new ArrayList<Users>();
            }
        }
        return users;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        Integer c = usersRepository.getMaxCode();
        return c;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getUserBySellerUser(java.lang.String)
     */
    @Override
    public Users getUserBySellerUser(final String sellerUserId) {
        // TODO Auto-generated method stub
        return usersRepository.findBySellerUser(sellerUserId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getUserResetPassword(com.meat.domain.Users)
     */
    @Override
    public Users getUserResetPassword(final Users user) {
        Users users = user;
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        users.setPassword(hashedPassword);
        users = usersRepository.save(users);
        return users;
    }

    @Override
    public Users getUsers(final String usersId) {
        Users users = new Users();
        users = usersRepository.findOne(usersId);
        return users;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getUsersByEmailId(java.lang.String)
     */
    @Override
    public Users getUsersByEmailId(final String emailId) {
        Users users = new Users();
        users = usersRepository.findByEmailId(emailId);
        return users;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersService#getUsersOnly()
     */

    @Override
    public List<Users> getUsersOnly() {
        List<Users> user = new ArrayList<Users>();
        user = (List<Users>) usersRepository.findAll();
        List<Users> users = new ArrayList<Users>();
        for (Users us : user) {
            Users u1 = new Users();
            u1.setId(us.getId());
            u1.setUserName(us.getUserName());
            u1.setUserType(us.getUserType());
            u1.setEmailId(us.getEmailId());
            u1.setPhoneNo(us.getPhoneNo());
            u1.setDob(us.getDob());
            u1.setGender(us.getGender());
            u1.setPassword(us.getPassword());
            u1.setStatus(us.getStatus());
            u1.setUserCode(us.getUserCode());
            u1.setAuthenticateStatus(us.getAuthenticateStatus());
            u1.setUserCount(us.getUserCount());
            u1.setCreatedDate(us.getCreatedDate());
            u1.setEmailStatus(us.getEmailStatus());
            users.add(u1);
        }
        return users;
    }

    public void signup(Users users/*String username, String password,String emailId*/) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashedPassword);
        users.setEmailId(users.getEmailId());
        users = usersRepository.save(users);

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IUserService#updateUser(com.ruhungry.domain.User)
     */
    @Override
    @Transactional
    public Users updateUsers(final Users users) {
        // TODO Auto-generated method stub
        return usersRepository.save(users);

    }
}
