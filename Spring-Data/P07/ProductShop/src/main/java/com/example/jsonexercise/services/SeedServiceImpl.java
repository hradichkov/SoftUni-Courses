package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.categories.CategoryImportDto;
import com.example.jsonexercise.domain.dtos.products.ProductImportDto;
import com.example.jsonexercise.domain.dtos.users.UserImportDto;
import com.example.jsonexercise.domain.entities.Category;
import com.example.jsonexercise.domain.entities.Product;
import com.example.jsonexercise.domain.entities.User;
import com.example.jsonexercise.repositories.CategoryRepository;
import com.example.jsonexercise.repositories.ProductRepository;
import com.example.jsonexercise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static com.example.jsonexercise.constants.Paths.*;
import static com.example.jsonexercise.constants.Utils.GSON;
import static com.example.jsonexercise.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUsers() throws IOException {
        if (this.userRepository.count() == 0) {
            FileReader fileReader = new FileReader(USER_JSON_PATH.toFile());

            List<User> users = Arrays.stream(GSON.fromJson(fileReader, UserImportDto[].class))
                    .map(userImportDto -> MODEL_MAPPER.map(userImportDto, User.class))
                    .toList();

            this.userRepository.saveAllAndFlush(users);
            fileReader.close();
        }
    }

    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() == 0) {
            FileReader fileReader = new FileReader(CATEGORY_JSON_PATH.toFile());

            List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportDto[].class))
                    .map(categoryImportDto -> MODEL_MAPPER.map(categoryImportDto, Category.class))
                    .toList();

            this.categoryRepository.saveAllAndFlush(categories);
            fileReader.close();
        }
    }

    @Override
    public void seedProducts() throws IOException {
        if (this.productRepository.count() == 0) {
            FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

            List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportDto[].class))
                    .map(productImportDto -> MODEL_MAPPER.map(productImportDto, Product.class))
                    .map(this::setRandomSeller)
                    .map(this::setRandomBuyer)
                    .map(this::setRandomCategory)
                    .toList();

            this.productRepository.saveAllAndFlush(products);
            fileReader.close();
        }
    }

    private Product setRandomSeller(Product product) {
        User seller = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

        product.setSeller(seller);

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) > 0) {
            User buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);

            while (buyer.equals(product.getSeller())) {
                buyer = this.userRepository.getRandomEntity().orElseThrow(NoSuchElementException::new);
            }

            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomCategory(Product product) {
        Random random = new Random();

        int numberOfCategories = random.nextInt((int) this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, numberOfCategories)
                .forEach(number -> {
                    Category category = this.categoryRepository.getRandomEntity()
                            .orElseThrow(NoSuchElementException::new);
                    categories.add(category);
                });

        product.setCategories(categories);

        return product;
    }
}
