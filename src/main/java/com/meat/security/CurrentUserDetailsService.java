package com.meat.security;
/**
 *
 */
/*
package com.meat.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

*//**
   * @author varma
   *
   */
/*
@Component
public class CurrentUserDetailsService implements UserDetailsService {
   @Autowired
 private UsersService userService;

 *//**
    * {@inheritDoc}
    *
    * @see com.meat.security.UserDetailsService#loadUserByUsernameAndPassword(java.lang.String, java.lang.String)
    *//*
     @Override
     public UserDetails loadUserByUsernameAndPassword(String username, String password) throws UsernameNotFoundException {
      // TODO Auto-generated method stub
      return null;
     }
     
     @Override
     public UserDetails loadUserByUsernameAndPassword(final String username, final String password) throws UsernameNotFoundException {
      //  Users user = userService.findByEmailIdAndPassword(username, password);
      //   System.out.println(user + "______________________________________________");
       .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
      System.out.println(username + "," + password);
      return null;
     }
     }*/