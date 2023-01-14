package com.example.jsonexercise.services;

import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface SeedService {

    void seedUsers() throws IOException;
    void seedProducts() throws IOException;
    void seedCategories() throws IOException;

    default void seedAll() throws IOException {
        seedUsers();
        seedCategories();
        seedProducts();
    }
}
