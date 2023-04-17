package com.example.mobitech.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private String img;
}
