package com.example.mobitech.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Length(max = 5000)
    private String description;

    @Column(nullable = false, unique = true)
    private String img;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;
}

