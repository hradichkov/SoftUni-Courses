package com.example.mobitech.repository;

import com.example.mobitech.model.entity.SelectedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectedProductRepository extends JpaRepository<SelectedProduct, Long> {
}
