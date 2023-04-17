package com.example.mobitech.model.dtos;

import com.example.mobitech.model.entity.Role;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {
    private Long id;
    private String username;
    private String email;
    private List<Role> roles;
}
