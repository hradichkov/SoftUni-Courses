package com.example.mobitech.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

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

    public String getName() {
        return name;
    }

    public ProductAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImg() {
        return img;
    }

    public ProductAddDTO setImg(String img) {
        this.img = img;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductAddDTO setCategory(String category) {
        this.category = category;
        return this;
    }
}
