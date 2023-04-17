package com.example.mobitech.model.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfoInCartDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String img;
    private int quantity;
    private BigDecimal productSum;
}
