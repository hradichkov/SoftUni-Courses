package com.example.mobitech.model.entity;

import com.example.mobitech.model.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public Role setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }
}
