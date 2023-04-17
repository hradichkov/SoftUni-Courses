package com.example.mobitech.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakeOrderDTO {
    @NotBlank
    @Size(min = 10)
    private String address;
}
