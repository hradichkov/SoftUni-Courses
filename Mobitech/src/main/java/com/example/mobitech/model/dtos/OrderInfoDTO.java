package com.example.mobitech.model.dtos;

import com.example.mobitech.model.entity.PurchasedProduct;
import com.example.mobitech.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderInfoDTO {
    private Long id;
    private LocalDate dateOrdered;
    private BigDecimal orderSum;
    private User client;
    private List<PurchasedProduct> orderedProducts;
}
