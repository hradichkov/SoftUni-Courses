package com.example.mobitech.repository;

import com.example.mobitech.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrderByDateOfOrderBefore(LocalDate oldDate);
}

