package com.aleks._8.config;


import Models.Role;
import Models.User;
import Repository.RolesRepository;
import Repository.UserRepository;
import Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userService;
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.findByUserName(username);
        Role role=rolesRepository.findById(userEntity.getRole_Id());
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity, role);
    }
}
