package com.example.mobitech.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class ProductAddDTO {
    @NotBlank
    @Size(min = 5)
    private String name;
    @Positive
    private BigDecimal price;
    @NotBlank
    @Size(min = 10)
    private String description;
    @NotBlank
    private String img;
    @NotNull
    private String category;
}
