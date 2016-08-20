package com.meat.security;

import com.meat.dao.RolesRepository;
import com.meat.dao.UsersRepository;
import com.meat.domain.Roles;
import com.meat.domain.Users;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RolesRepository rolesRepository;

    /**
     * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
     *
     * @param roles
     *            {@link String} of roles
     * @return list of granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(final List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        Users users = usersRepository.findByEmailId(username);

        /* String SALT = "@!ZYX123abc";
        String saltedPassword = password.concat(SALT);
        String hashedPassword = SimpleMD5Example(saltedPassword);*/
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        if (users == null) {
            throw new BadCredentialsException("Username not found.");
        }

        if (!hashedPassword.equals(users.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }

        List<Roles> rs = rolesRepository.getByUsers(users.getId());
        Set<Roles> roles = new HashSet<Roles>();
        List<String> role = new ArrayList<String>();
        for (Roles r2 : rs) {
            role.add(r2.getRoleName());
        }

        return new UsernamePasswordAuthenticationToken(users, hashedPassword/*getAuthorities1(roles)*//*getGrantedAuthorities(role)*/);
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
     *
     * @param role
     *            the numerical role
     * @return a collection of {@link GrantedAuthority
     *
     */
    public Collection<? extends GrantedAuthority> getAuthorities(final Integer role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     *
     * @param role
     *            the numerical role
     * @return list of roles as as a list of {@link String}
     */
    public List<String> getRoles(final Integer role) {
        List<String> roles = new ArrayList<String>();

        if (role.intValue() == 1) {
            roles.add("ROLE_USER");
            roles.add("ROLE_ADMIN");

        }
        else if (role.intValue() == 2) {
            roles.add("ROLE_USER");
        }

        return roles;
    }

    public List<String> getRoles1(final Set<Roles> roles) {
        List<String> roles1 = new ArrayList<String>();

        for (Roles r : roles) {
            Roles r1 = new Roles();
            //r.setEnabled("true");
            r1.setRoleName(r.getRoleName());
            roles1.add(r.getRoleName());

        }

        return roles1;
    }

    @Override
    public boolean supports(final Class<?> arg0) {
        return true;
    }

}
