package com.example.mobitech.service;

import com.example.mobitech.model.entity.Role;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

    private final String NOT_EXISTING_USERNAME = "notExisting";

    private ApplicationUserDetailsService toTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void TestUserFound() {
        //start Arrange
        Role testAdminRole = new Role().setUserRole(UserRoleEnum.ADMIN);

        String EXISTING_USERNAME = "admin";
        User testUser = new User().
                setUsername(EXISTING_USERNAME).
                setPassword("admin").
                setRoles(List.of(testAdminRole));

        when(mockUserRepository.findByUsername(EXISTING_USERNAME)).
                thenReturn(Optional.of(testUser));
        //end Arrange

        //Act
        UserDetails adminDetails = toTest.loadUserByUsername(EXISTING_USERNAME);

        //Assert
        Assertions.assertNotNull(adminDetails);
        Assertions.assertEquals(EXISTING_USERNAME, adminDetails.getUsername());
        Assertions.assertEquals(EXISTING_USERNAME, adminDetails.getUsername());
        Assertions.assertEquals(testUser.getPassword(), adminDetails.getPassword());

        Assertions.assertEquals(1,
                adminDetails.getAuthorities().size(),
                "The authorities are supposed to be just one - ADMIN.");
        assertRole(adminDetails.getAuthorities());

    }

    private void assertRole(Collection<? extends GrantedAuthority> authorities) {
        authorities.
                stream().
                filter(a -> "ROLE_ADMIN".equals(a.getAuthority())).
                findAny().
                orElseThrow(() -> new AssertionFailedError("Role " + "ROLE_ADMIN" + " not found!"));
    }

    @Test
    void testUserNotFound() {
        assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername(NOT_EXISTING_USERNAME)
        );
    }

}
