package com.example.xmlexercise.constants;

import java.nio.file.Path;

public enum Paths {
    ;

    public static final Path USER_XML_PATH = Path.of("src", "main", "resources", "productShop", "users.xml");

    public static final Path PRODUCTS_XML_PATH = Path.of("src", "main", "resources", "productShop", "products.xml");

    public static final Path CATEGORY_XML_PATH = Path.of("src", "main", "resources", "productShop", "categories.xml");

    public static final Path PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH =
            Path.of("src", "main", "resources", "outputs", "products-in-range.json");

    public static final Path USERS_WITH_SOLD_PRODUCTS_JSON_PATH =
            Path.of("src", "main", "resources", "outputs", "users-sold-products.json");

    public static final Path CATEGORIES_BY_PRODUCTS_JSON_PATH =
            Path.of("src", "main", "resources", "outputs", "categories-by-products.json");

    public static final Path USERS_AND_PRODUCTS_JSON_PATH =
            Path.of("src", "main", "resources", "outputs", "users-and-products.json");
}
