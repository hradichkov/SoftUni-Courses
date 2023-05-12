package com.example.mobitech.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRegistration() throws Exception {
        mockMvc.perform(post("/register")
                        .param("username", "radoslav")
                        .param("firstName", "Radoslav")
                        .param("lastName", "Radichkov")
                        .param("email", "radoslav@examle.com")
                        .param("password", "radoslav")
                        .param("confirmPassword", "radoslav")
                        .with(csrf())
                ).andExpect(status().
                        is2xxSuccessful());
    }

    @Test
    void testRegistrationWithError() throws Exception {
        mockMvc.perform(post("/register")
                        .param("username", "test")
                        .param("firstName", "Test")
                        .param("lastName", "Testov")
                        .param("email", "test@examle.com")
                        .param("password", "test1")
                        .param("confirmPassword", "test")
                        .with(csrf())
                ).andExpect(status()
                        .is3xxRedirection())
                .andExpect(redirectedUrl("/register"));
    }

    @Test
    void testLogin() throws Exception {
        mockMvc.perform(get("/login")
                .param("username", "test")
                .param("password", "test")
                .with(csrf())
        ).andExpect(status()
                .is2xxSuccessful());
    }

    @Test
    void testLoginUnsuccessful() throws Exception {
        mockMvc.perform(post("/login-error")
                        .param("username", "test")
                        .param("password", "")
                        .with(csrf())
                ).andExpect(status()
                        .is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }
}
