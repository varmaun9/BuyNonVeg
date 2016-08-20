package com.meat.security;

import com.meat.dao.RolesRepository;
import com.meat.dao.UsersRepository;
import com.meat.domain.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository userRepository;
    private final RolesRepository userRolesRepository;

    @Autowired
    public CustomUserDetailsService(final UsersRepository userRepository, final RolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Users user = userRepository.findByEmailId(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        }
        Users users = userRepository.findByEmailIdStatus(username);
        if (null == users) {
            throw new UsernameNotFoundException("user not activated ,please activate your account to continue : " + username);
        }
        else {
            List<String> userRoles = userRolesRepository.findRoleByUserName(username);
            return new CustomUserDetails(user, userRoles);
        }
    }

}
