package com.example.jsonexercise;

import com.example.jsonexercise.services.CategoryService;
import com.example.jsonexercise.services.ProductService;
import com.example.jsonexercise.services.SeedService;
import com.example.jsonexercise.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
public class CommandRunner implements CommandLineRunner {

    private SeedService seedService;
    private ProductService productService;
    private UserService userService;
    private CategoryService categoryService;

    public CommandRunner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        this.seedService.seedAll();
        this.productService.findAllByPriceBetweenAndBuyerNullOrderByPrice(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        this.userService.findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName();
        this.categoryService.getCategorySummary();
        this.userService.usersAndProducts();
    }
}
