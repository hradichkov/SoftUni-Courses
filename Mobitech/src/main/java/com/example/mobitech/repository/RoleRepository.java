package com.example.mobitech.repository;

import com.example.mobitech.model.entity.Role;
import com.example.mobitech.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByUserRole(UserRoleEnum user);
}
