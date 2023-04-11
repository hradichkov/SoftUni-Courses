package com.example.mobitech.service;

import com.example.mobitech.model.entity.Role;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class ApplicationUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username).
                map(this::map).
                orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private UserDetails map(User userEntity) {
        return org.springframework.security.core.userdetails.User.builder().
                username(userEntity.getUsername()).
                password(userEntity.getPassword()).
                authorities(userEntity.
                        getRoles().
                        stream().
                        map(this::map).
                        toList()).
                build();
    }

    private GrantedAuthority map(Role userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getUserRole().name());
    }
}
