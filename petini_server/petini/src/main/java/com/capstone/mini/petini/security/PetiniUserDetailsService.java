package com.capstone.mini.petini.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.capstone.mini.petini.model.PetiniUser;
import com.capstone.mini.petini.security.role_config.Role;
import com.capstone.mini.petini.service.IUserService;

@Configuration
public class PetiniUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PetiniUser user = this.userService.findUserByUsername(username);
        List<SimpleGrantedAuthority> petiniUserAuthorities = new ArrayList<>();
        petiniUserAuthorities.addAll(Role.valueOf(user.getRole().getName()).getAuthorities());
        return User.builder().username(user.getUsername()).password(user.getPassword())
                .authorities(petiniUserAuthorities)
                .build();
    }

}
