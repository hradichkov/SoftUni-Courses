package com.example.mobitech.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "purchased_product")
public class PurchasedProduct extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Length(max = 5000)
    private String img;

    @Column
    private int quantity;

    @Column
    private BigDecimal sum;

    public String getName() {
        return name;
    }

    public PurchasedProduct setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public PurchasedProduct setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getImg() {
        return img;
    }

    public PurchasedProduct setImg(String img) {
        this.img = img;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public PurchasedProduct setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public PurchasedProduct setSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }
}
