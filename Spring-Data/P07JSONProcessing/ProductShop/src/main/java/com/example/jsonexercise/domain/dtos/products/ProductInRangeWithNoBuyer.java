package com.example.jsonexercise.domain.dtos.products;

import com.example.jsonexercise.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInRangeWithNoBuyer {
    private String name;
    private BigDecimal price;
    private String seller;
}
