package com.example.mobitech.config;

import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.UserRepository;
import com.example.mobitech.service.ApplicationUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
                authorizeHttpRequests().
                requestMatchers("/", "/css/**", "/images/**", "/js/**").permitAll().
                requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                requestMatchers("/", "/login", "/register", "/product",
                        "/login-error", "/product/info/{id}").permitAll().

                requestMatchers("/products/add", "/user/admin", "/product/delete/{id}", "/user/change-role/{id}")
                .hasRole(UserRoleEnum.ADMIN.name()).

                requestMatchers("/purchase/{id}", "/cart", "/orders",
                        "/cart/remove-product-from-list/{id}", "/order/details/{id}").hasRole(UserRoleEnum.USER.name()).
                anyRequest().authenticated().
                and().
                formLogin().
                loginPage("/login").
                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                defaultSuccessUrl("/", true).
                failureForwardUrl("/login-error").//в контролера в логин връща грешките
                and().
                logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/").
                invalidateHttpSession(true).
                deleteCookies("JSESSIONID");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }
}
