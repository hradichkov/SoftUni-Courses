package com.example.mobitech.service;

import com.example.mobitech.model.dtos.UserRegistrationDTO;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.UserRepository;
import com.example.mobitech.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    @Autowired
    public AuthService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       ModelMapper modelMapper,
                       RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        User newUser = modelMapper.map(userRegistrationDTO, User.class);
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        newUser.setRoles(roleRepository.findByUserRole(UserRoleEnum.USER));

        userRepository.save(newUser);
    }
}
