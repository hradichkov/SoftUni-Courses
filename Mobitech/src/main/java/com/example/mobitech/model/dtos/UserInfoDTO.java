package com.example.mobitech.model.dtos;

import com.example.mobitech.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {
    private Long id;
    private String username;
    private String email;
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public UserInfoDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserInfoDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfoDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public UserInfoDTO setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }
}
