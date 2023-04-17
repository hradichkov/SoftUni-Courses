package com.example.mobitech.model.dtos;

import com.example.mobitech.validation.ValidatePasswordMatch;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidatePasswordMatch(password = "password", confirmPassword = "confirmPassword")
public class UserRegistrationDTO {
    @NotNull
    @Size(min = 5, max = 20)
    private String username;

    @NotNull
    @Size(min = 5, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 20)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Size(min = 5, max = 20)
    private String password;

    @NotNull
    @Size(min = 5, max = 20)
    private String confirmPassword;
}
