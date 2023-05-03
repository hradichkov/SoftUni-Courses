package com.example.mobitech.model.dtos;

import com.example.mobitech.model.entity.PurchasedProduct;
import com.example.mobitech.model.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoDTO {
    private Long id;
    private LocalDate dateOfOrder;
    private BigDecimal orderSum;
    private User user;
    private List<PurchasedProduct> orderedProducts;
}
