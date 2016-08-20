package com.meat.thymeleaf;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.me.JSONException;
import org.json.me.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meat.dao.RolesRepository;
import com.meat.dao.UsersRepository;
import com.meat.domain.Item;
import com.meat.domain.Roles;
import com.meat.domain.Users;
import com.meat.service.IUsersService;

@Controller
@RequestMapping
@PropertySource("classpath:application.properties")
public class UserAuthController {

    @Value("${url}")
    private String url;
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private IUsersService userService;
    @Autowired
    @Qualifier("authenticationManager")
    AuthenticationManager authenticationManager;

    @Autowired
    private RolesRepository rolesRepository;

    /*
    @Autowired
    private RoleRepository roleRepository;
    String restaurant = "ROLE_RESTAURANT";
    @Autowired
    private IRestaurantBranchService restaurantBranchService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ISubOrderService subOrderService;
    @Autowired
    private IRestaurantService restaurantService;
    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
    */
    @RequestMapping(value = "/denied")
    public String denied(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session, final Item item,
            final BindingResult result, final ModelMap model) throws IOException {

        session.invalidate();
        model.addAttribute("title", "Hello world!");
        model.addAttribute("messageType", "Failure");
        return "denied";
    }

    @RequestMapping(value = "/auth/login/failure")
    public String loginauthSessionFailure(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final HttpSession session, final BindingResult result, final ModelMap model) throws IOException {
        /*model.addAttribute("message", message);
        return "access/login";*/
        session.invalidate();
        String message = "Session Login Failure!";
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");
        //model.addAttribute("message", res);
        //System.out.println("session new"+session.isNew());
        // return "index";
        return "redirect:" + url + "/login";

        /*String message = " Session Login Failure!";
        return "redirect:/login?message="+message;*/
    }

    @RequestMapping(value = "/login/failure")
    public String loginFailure(final HttpServletRequest request, final HttpServletResponse res, final Item item, final BindingResult result,
            HttpSession session, final ModelMap model) throws IOException {
        session = request.getSession(false);
        String message = null;
        try {
            session.invalidate();
            message = "Entered UserName or Password is Wrong";
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:" + url + "/login";
    }

    @RequestMapping(value = "/auth/maxSession")
    public String loginFailureMaxSessions(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final BindingResult result, final ModelMap model) throws IOException {
        // session.invalidate();
        HttpSession session = request.getSession(false);
        model.addAttribute("message", "login max seesions exceed failure");
        model.addAttribute("messageType", "Failure");

        return "index";

    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
    public String loginUser(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {

        // String username2 = request.getParameter("reurl");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = request.getParameter(authentication.getName());
        session.setAttribute("username", username);
        for (GrantedAuthority s : authentication.getAuthorities()) {
        }
        String username1 = null;
        String userId = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Users) {
            username1 = ((Users) principal).getUserName();
            userId = ((Users) principal).getId();
        }
        else {
            username1 = principal.toString();
        }
        String role = null;

        if (userId != null) {

            List<Roles> rs = rolesRepository.getByUsers(userId);
            for (Roles r : rs) {
                role = r.getRoleName();

            }
            session.setAttribute("userName", username1);
            session.setAttribute("userId", userId);
            session.setMaxInactiveInterval(24 * 60 * 60);

            model.addAttribute("auth", authentication);
            model.addAttribute("session1", session);
            model.addAttribute("message", "User SuccessFully LoggedIN!");

            return "/index";
        }

        else {
            session.invalidate();
            model.addAttribute("message", "user session was logged out! Please Login");
            model.addAttribute("messageType", "Failure");

            return "redirect:" + url + "/login";
        }

    }

    @RequestMapping(value = "/logout/success")
    public String logoutSuccess(final HttpServletRequest request, final HttpServletResponse res, final Item item, final HttpSession session,
            final BindingResult result, final ModelMap model) throws IOException {
        String message = "Logout Success!";
        session.invalidate();
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");

        return "index";
    }

    @RequestMapping(value = "/restaurant/login")
    public String restaurantLogin(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final HttpSession session, final BindingResult result, final ModelMap model) throws IOException {
        String message = "";//"Restaurant Login Page!";
        //  session.invalidate();
        //model.addAttribute("message", message);
        return "../../Restaurants/login";
    }

    @RequestMapping(value = "/restaurant112/auth", method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
    public String restaurantLoginUser(final HttpServletRequest request, final HttpServletResponse res, final HttpSession session,
            final Item item, final BindingResult result, final ModelMap model) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = request.getParameter(authentication.getName());
        System.out.println("sample in user" + authentication.getName() + authentication.getAuthorities());
        session.setAttribute("username", username);
        //  session.setAttribute("password", password);
        String username1 = null;
        String userId = null;
        if (!authentication.getName().equals("anonymousUser")) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof Users) {
                username1 = ((Users) principal).getUserName();
                userId = ((Users) principal).getId();
            }
            else {
                username1 = principal.toString();
            }

            session.setAttribute("userName", username1);
            session.setAttribute("userId", userId);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(24 * 60 * 60);

            /*	Enumeration names = session.getAttributeNames();
                while (names.hasMoreElements()) {
                  String name = (String) names.nextElement();
                  String value = session.getAttribute(name).toString();
                 System.out.println("session name and values"+name +"val"+value);
                }*/

            model.addAttribute("auth", authentication);
            model.addAttribute("session1", session);
            model.addAttribute("message", "Restaurant User SuccessFully LoggedIN!");

            System.out.println("rest user");
            // http://192.168.0.137:8085/Restaurants/Dashboard/index.html#/dashboards/orders
            // return "/restaurant/index";
            return "../../Restaurants/Dashboard/index";
        }
        else {
            session.invalidate();
            model.addAttribute("message", "Session Expired! Please Login");
            return "../../Restaurants/login";
        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/restaurant/auth", /*consumes = { MediaType.ALL_VALUE }, */headers = {
            "content-type=application/json" })
    @ResponseBody
    public/*LoginStatus*//*User*/String restlogin(/*@RequestParam("j_username") String username,
                                                  @RequestParam("j_password") String password*/@RequestBody final String user) {
        System.out.println("user login " + user);
        JSONObject obj = new JSONObject();
        String username = null;
        String password = null;
        try {
            obj = new JSONObject(user);
            System.out.println("blogURL: " + obj.getString("j_username"));
            System.out.println("blogURL: " + obj.getString("j_password"));
            username = obj.getString("j_username");
            password = obj.getString("j_password");
        }
        catch (JSONException e1) {
            e1.printStackTrace();
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // User details = new User(username);
        Users details = new Users();
        details = userRepository.findByEmailId(username);
        // if(details!=null){
        String SALT = "@!ZYX123abc";

        String csaltedPassword = password.concat(SALT);
        String hashedPassword = SimpleMD5Example(csaltedPassword);
        if (details.getId() != null) {
            if (details.getPassword().equals(hashedPassword)) {
                String saltedPassword = password.concat(SALT);
                String hashedPassword1 = SimpleMD5Example(saltedPassword);
                details.setPassword(hashedPassword1);
                details.setAuthenticateStatus("Success");
                //  details = userService.create(details);

                /*  Mail mail = new Mail();
                  mail.setMailFrom(mailFrom);
                  mail.setMailTo("to@gmail.com"emailId);
                  mail.setMailSubject("Password Changed Successfully");
                  sendMail(mail,emailId);*/

            }
            else {
                details.setAuthenticateStatus("Please Enter Valid Current Password!");
                details.setEmailStatus("Please Enter Valid Current Password!");
            }
        }
        else {
            details.setAuthenticateStatus(" Please Enter Valid EmailId!");
            details.setEmailStatus(" Please Enter Valid EmailId!");
        }

        token.setDetails(details);

        System.out.println("token is" + token.getName() + token.getCredentials().toString());
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
            details.setAuthenticateStatus("true");
            details.setEmailStatus("Success");
            System.out.println("auth is" + auth.isAuthenticated() + auth.getName());
            //return details;//new LoginStatus(auth.isAuthenticated(), auth.getName()/*,details*/);
        }
        catch (BadCredentialsException e) {
            //details.setEmailStatus("false");
            details.setAuthenticateStatus("false");
            // return details;//new LoginStatus(false, null/*,details*/);
        }

        String role = null;
        Users detail1 = new Users();
        /*  CompanyBranch cb1 = new CompanyBranch();
        RestaurantBranch rb1 = new RestaurantBranch();
        RestaurantContacts rc1 = new RestaurantContacts();*/

        if (details.getId() != null) {
            /* if(details.getUserType().equals("RESTAURANT")){
             	RestaurantContacts rc=restaurantContactsRepository.getByUser(details.getId());

             	BeanUtils.copyProperties(rc, rc1);
             	User ru=new User();
             	ru.setEmailId(rc.getEmailId());

             	RestaurantBranch rb=restaurantBranchRepository.findOne(rc.getRestaurantBranch().getId());
             	rb1.setId(rb.getId());
             	rb1.setBranchName(rb.getBranchName());
             	rb1.setBranchStatus(rb.getBranchStatus());
             	rb1.setRestaurantEmailId(rb.getRestaurantEmailId());
             	rb1.setRestaurantPhoneNo(rb.getRestaurantPhoneNo());
             	rb1.setMinimumOrderTime(rb.getMinimumOrderTime());

             	List<Address> address=addressRepository.getRestaurantBranch(rb.getId());

             	Set<Address> address1=new HashSet<Address>();
             	 for(Address r: address){
             	    	Address r1=new Address();
             	    	r1.setId(r.getId());
             	    	r1.setCity(r.getCity());
             	    	r1.setDistrict(r.getDistrict());
             	    	r1.setLine1(r.getLine1());
             	    	r1.setState(r.getState());
             	    	r1.setTown(r.getTown());
             	    	r1.setZipcode(r.getZipcode());
             	    	r1.setType(r.getType());

             	    	address1.add(r1);
             	    }
             	 rb1.setAddresses(address1);
             	rc1.setRestaurantBranch(rb1);

             }*/

            /*  List<Role> roles = roleRepository.getByUser(details.getId());
            Set<Role> roles1 = new HashSet<Role>();
            for (Role r : roles) {
                Role r1 = new Role();
                r1.setId(r.getId());
                r1.setRoleName(r.getRoleName());
                if (r.getRoleName() != null) {
                    if (r.getRoleName().equals(restaurant)) {
                        role = r.getRoleName();
                    }
                }
                r1.setEnabled(r.getEnabled());
                roles1.add(r1);
            }*/

            detail1.setId(details.getId());
            detail1.setAuthenticateStatus(details.getAuthenticateStatus());
            //  detail1.setCompanyBranch(cb1);
            detail1.setUserName(details.getUserName());
            detail1.setUserType(details.getUserType());
            detail1.setEmailId(details.getEmailId());
            detail1.setEmailStatus(details.getEmailStatus());
            detail1.setPhoneNo((details.getPhoneNo()));
            //  detail1.setDeskNo(details.getDeskNo());
            detail1.setDob(details.getDob());
            detail1.setGender(details.getGender());
            //  detail1.setExtensionNo((details.getExtensionNo()));
            detail1.setUserCode((details.getUserCode()));
            detail1.setCreatedDate(details.getCreatedDate());
            detail1.setStatus(details.getStatus());

            //  detail1.setRestaurantContacts(rc1);
            //   detail1.setRoles(roles1);
        }

        /*  if (role != null) {
            if (role.equals(restaurant)) {
                return "../../Restaurants/Dashboard/index";//detail1;
            }
            else {
                return "../../Restaurants/login";
            }
        }*/
        return "../../Restaurants/login";

    }

    public String SimpleMD5Example(final String input) {
        {
            String passwordToHash = input;
            String generatedPassword = null;
            try {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(passwordToHash.getBytes());
                //Get the hash's bytes
                byte[] bytes = md.digest();
                //This bytes[] has bytes in decimal format;
                //Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString();
            }
            catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return generatedPassword;
        }
    }

    @RequestMapping(value = "/restaurant/login/failure")
    public String testaurantAuthLoginFailure(final HttpServletRequest request, final HttpServletResponse res, final Item item,
            final HttpSession session, final BindingResult result, final ModelMap model) throws IOException {
        /*model.addAttribute("message", message);
        return "access/login";*/
        System.out.println("hai user auth Session login failure  user here");
        session.invalidate();
        String message = "Please Enter Valid Username  and Password!";
        model.addAttribute("message", message);
        model.addAttribute("messageType", "Failure");

        return "../../Restaurants/login";
        /*String message = " Session Login Failure!";
        return "redirect:/login?message="+message;*/
    }

    /*@RequestMapping(value = "/Restaurants/Dashboard/index.html#/dashboards/orders")
    public String restaurantDashboard(HttpServletRequest request,
             HttpServletResponse res,Item item,HttpSession session, BindingResult result,ModelMap model)throws IOException  {
    	  //String message = "";//"Restaurant Login Page!";
    	//  session.invalidate();
    	  //model.addAttribute("message", message);
    	String s = (String) session.getAttribute("userId");
    	if (s != null) {

    	}else{
    		return "redirect:"+url+"/Restaurants/login.html";
    	}
    	return "redirect:"+url+"/Restaurants/login.html";
    }*/
}