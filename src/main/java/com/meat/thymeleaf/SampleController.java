package com.meat.thymeleaf;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.meat.domain.Item;
import com.meat.service.IUsersService;

@Controller
@RequestMapping("/")
@PropertySource("classpath:application.properties")
public class SampleController {
	
	 @Value("${url}")
	  private String url;
	 
	 @Autowired
	 private IUsersService userService;
	/* @Resource(name="sessionRegistry")
	 private SessionRegistryImpl sessionRegistry;
*/
	/* @RequestMapping(value="/register",method = RequestMethod.GET, consumes = { MediaType.ALL_VALUE })
	 @ResponseBody
     public String getHomePage(HttpServletRequest request,
	         HttpServletResponse res,Item item, BindingResult result,ModelMap model)throws IOException {
		
			 model.addAttribute("title", "Hello world!");
				
		  return "LoginOrRegistrationPage";
	}*/
	
	@RequestMapping(value="/user")
	public String getUserPage(HttpServletRequest request,
	         HttpServletResponse res,Item item, BindingResult result,ModelMap model)throws IOException {
		/* System.out.println("hai user login with user role success");
		 res.setContentType("text/html");  
		
		  url=url+"/welcome1.html";
		
			PrintWriter pw=res.getWriter();  
			res.sendRedirect(url);
		    pw.close();*/
		
		//Authentication auth=authentication.getPrincipal();
		
		    model.addAttribute("user", "Hello world!");
		    model.addAttribute("title", "Hello world!");
			
			  return "index";
		
	}
	
	private boolean isRememberMeAuthenticated() {
		 
		Authentication authentication = 
                    SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
 
		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}
 
	/*@Secured("ROLE_ADMIN")
	@RequestMapping(value="/admin")
	public  String  getAdminPage(HttpServletRequest request,
	         HttpServletResponse res,Item item, BindingResult result,ModelMap model)throws IOException {
		 System.out.println("hai admin login successfully");
		 res.setContentType("text/html");  
		
		 url=url+"/welcome1.html";
		
			PrintWriter pw=res.getWriter();  
			res.sendRedirect(url);
			pw.close();
		   model.addAttribute("title", "Hello world!");
		   model.addAttribute("messageType", "Success");
			
			  return "index";
	}
	   *//**
			  * Handles and retrieves list of logged-in users as JSP view
			  * 
			  * @return the name of the JSP page
			  *//*
			    @RequestMapping(value = "/users", method = RequestMethod.GET)
			    public String getUsersPage(Model model) {
			    // logger.debug("Received request to show users page");
			     
			    System.out.println("Total logged-in users: " + sessionRegistry.getAllPrincipals().size());
			    // logger.debug("List of logged-in users: ");
			     for (Object username: sessionRegistry.getAllPrincipals()) {
			     System.out.println("user name"+username);
			     }
			     System.out.println("Total sessions including expired ones: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), true).size());
			     System.out.println("Total sessions: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), false).size());
			 
			     // Attach to model list of users and granted authorities
			     model.addAttribute("users", sessionRegistry.getAllPrincipals());
			     model.addAttribute("total", sessionRegistry.getAllPrincipals().size());
			      
			     // This will resolve to /WEB-INF/jsp/userspage.jsp
			     return "userspage";
			 }*/
			 
			 
	 
	/* @RequestMapping(value = "/403", method = RequestMethod.GET)
		public String accesssDenied(HttpServletRequest request,
		         HttpServletResponse res,Item item, BindingResult result,ModelMap model,Principal user) {
	 
			//ModelAndView model = new ModelAndView();
			if (user != null) {
				model.addAttribute("msg", "Hi " + user.getName() 
				+ ", you do not have permission to access this page!");
			} else {
				model.addAttribute("msg", 
				"You do not have permission to access this page!");
			}
	 
			//model.setViewName("403");
			return "403";
		}*/
			    
			    
			
}
