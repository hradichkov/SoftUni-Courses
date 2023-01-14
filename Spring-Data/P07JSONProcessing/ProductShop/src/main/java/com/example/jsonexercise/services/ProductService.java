package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.products.ProductInRangeWithNoBuyer;
import com.example.jsonexercise.domain.entities.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductInRangeWithNoBuyer> findAllByPriceBetweenAndBuyerNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException;
}
