package com.example.mobitech.service;

import com.example.mobitech.model.entity.SelectedProduct;
import com.example.mobitech.repository.SelectedProductRepository;
import org.springframework.stereotype.Service;

@Service
public class SelectedProductService {
    private final SelectedProductRepository selectedProductRepository;

    public SelectedProductService(SelectedProductRepository selectedProductRepository) {
        this.selectedProductRepository = selectedProductRepository;
    }

    public void save(SelectedProduct selectedProduct) {
        this.selectedProductRepository.save(selectedProduct);
    }

    public void deleteAll() {
        this.selectedProductRepository.deleteAll();
    }

    public void deleteById(Long productId) {
        this.selectedProductRepository.deleteById(productId);
    }
}
