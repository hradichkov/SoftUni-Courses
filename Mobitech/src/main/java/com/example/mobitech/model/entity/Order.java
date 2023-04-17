package com.example.mobitech.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column(name = "order_sum")
    private BigDecimal orderSum;

    @Column(nullable = false, name = "date_of_order")
    private LocalDate dateOfOrder;

    @ManyToOne
    private User client;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PurchasedProduct> orderedProducts = new ArrayList<>();
}
