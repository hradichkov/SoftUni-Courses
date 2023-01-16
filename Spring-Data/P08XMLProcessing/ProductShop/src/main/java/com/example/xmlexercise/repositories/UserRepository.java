package com.example.xmlexercise.repositories;

import com.example.xmlexercise.domain.dtos.users.ExportSellersDTO;
import com.example.xmlexercise.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from `product_shop`.users order by RAND() limit 1",
            nativeQuery = true)
    Optional<User> getRandomEntity();

    @Query("SELECT u FROM User u " +
            "WHERE (SELECT COUNT(p) FROM Product p WHERE p.seller = u AND p.buyer IS NOT NULL) > 0 " +
            "ORDER BY u.lastName, u.firstName")
    List<User> findAllWithSoldProducts();
}

