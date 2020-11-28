package com.aleks._8.config;


import com.aleks._8.DAL.Models.Role;
import com.aleks._8.DAL.Models.User;
import com.aleks._8.DAL.Repository.RolesRepository;
import com.aleks._8.DAL.Repository.UserRepository;
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
        Role role=rolesRepository.findById((long) userEntity.getRole_Id()).get();
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity, role);
    }
}
