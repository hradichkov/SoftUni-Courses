package com.example.mobitech.service;

import com.example.mobitech.model.dtos.UserRegistrationDTO;
import com.example.mobitech.model.entity.Role;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.RoleRepository;
import com.example.mobitech.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    private final String NEW_USERNAME = "radoslav";
    private final String RAW_PASSWORD = "radoslav";
    private final String ENCODED_PASSWORD = "%($)GGPPP3fdfd";

    private final String FIRST_NAME = "Radoslav";
    private final String LAST_NAME = "Radichkov";
    private final String EMAIL = "radoslav@exmple.com";

    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private ModelMapper mockModelMapper;
    @Mock
    private RoleRepository mockRoleRepository;
    @Mock
    private UserRepository mockUserRepository;
    @Captor
    private ArgumentCaptor<User> userEntityArgumentCaptor;

    private AuthService toTest;

    @BeforeEach
    void setUp() {
        toTest = new AuthService(mockPasswordEncoder, mockUserRepository,
                mockModelMapper, mockRoleRepository);
    }

    @Test
    void TestUserRegistration() {
        //Arrange
        Role testRole = new Role();
        testRole.setUserRole(UserRoleEnum.USER);

        UserRegistrationDTO testRegistrationDTO = new UserRegistrationDTO()
                .setUsername(NEW_USERNAME)
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setEmail(EMAIL)
                .setPassword(RAW_PASSWORD);

        User testUser = User.builder()
                .username(NEW_USERNAME)
                .roles(List.of(testRole))
                .email(EMAIL)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .password(mockPasswordEncoder.encode(RAW_PASSWORD))
                .build();

        when(mockPasswordEncoder.encode(testRegistrationDTO.getPassword()))
                .thenReturn(ENCODED_PASSWORD);
        when(mockModelMapper.map(testRegistrationDTO, User.class)).thenReturn(testUser);
        when(mockRoleRepository.findByUserRole(UserRoleEnum.USER)).thenReturn(List.of(testRole));
        toTest.registerUser(testRegistrationDTO);

        Mockito.verify(mockUserRepository).save(userEntityArgumentCaptor.capture());
        Assertions.assertEquals(FIRST_NAME, testUser.getFirstName());
        Assertions.assertEquals(ENCODED_PASSWORD, testUser.getPassword());
        Assertions.assertEquals(1, testUser.getRoles().size());
    }
}
