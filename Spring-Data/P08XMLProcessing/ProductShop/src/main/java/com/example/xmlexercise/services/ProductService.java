package com.example.xmlexercise.services;

import com.example.xmlexercise.domain.dtos.products.ExportProductsInRangeDTO;

public interface ProductService {
    ExportProductsInRangeDTO getInRange(float from, float to);
}
