package com.example.mobitech.repository;

import com.example.mobitech.model.entity.PurchasedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {
}
