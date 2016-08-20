/**
 *
 */

package com.meat.security;

import com.meat.domain.SellerBranch;
import com.meat.domain.Users;
import com.meat.service.ISellerBranchService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ISellerBranchService sellerBranchService;
    private RedirectStrategy redirect = new DefaultRedirectStrategy();

    /**
     * @param authentication
     * @return
     */
    private String determineTargetUrl(final Authentication authentication) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) throws IOException, ServletException {
        // super.onAuthenticationSuccess(request, response, authentication);
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        //Authentication authenticate = SecurityContextHolder.getContext().getAuthentication();
        //CustomUserDetails userDetails = (CustomUserDetails) authenticate.getPrincipal();
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        // clearAuthenticationAttributes(request);
        HttpSession session = request.getSession();

        session.setAttribute("userId", user.getId());
        session.setAttribute("userName", user.getUserName());
        session.setAttribute("userType", user.getUserType());
        /* Cookie cookie = new Cookie("sessionId", session.getId());
        response.addCookie(cookie);*/
        /* String targetUrl = "/customer/Dashboard";
        */
        if (request.getParameter("channel") != null) {

            /*     HttpSession session1 = request.getSession(false);*/
            /* response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Headers",
                    "Cache-Control, Pragma, Origin, Authorization, Content-Type,Accept, X-Requested-With");
            response.addHeader("Access-Control-Allow-Methods", "GET, PUT, OPTIONS, POST, X-XSRF-TOKEN, DELETE");*/
            SellerBranch sellerBranch = new SellerBranch();
            String userObject = "";
            if (user.getUserType().equals("SELLER_USER") || user.getUserType().equals("SELLER_ADMIN")) {
                sellerBranch = sellerBranchService.getSellerBranchByUserId(user.getId());
                userObject = user.getId() + ":::" + user.getUserName() + ":::" + sellerBranch.getId() + ":::"
                        + sellerBranch.getBranchName();
                response.getWriter().write(userObject);
                response.setStatus(200);
            }
            else {
                if (request.getParameter("channel").equals("SELLERMOBILE")) {
                    response.setStatus(401);
                }
                else {
                    userObject = user.getId() + ":::" + user.getUserName();
                    response.getWriter().write(userObject);
                }
            }

            HttpSession session1 = request.getSession(true);
            if (session1 == null) {
                return;

            }

        }
        else {
            /* super.onAuthenticationSuccess();*/
            redirect.sendRedirect(request, response, request.getParameter("refUrl"));
            // super.onAuthenticationSuccess(request, response, authentication);

        }
    }

}
