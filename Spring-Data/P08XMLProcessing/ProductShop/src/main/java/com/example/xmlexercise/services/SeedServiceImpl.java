package com.example.xmlexercise.services;

import com.example.xmlexercise.domain.dtos.categories.CategoriesImportDTO;
import com.example.xmlexercise.domain.dtos.products.ProductsImportDTO;
import com.example.xmlexercise.domain.dtos.users.UsersImportDTO;
import com.example.xmlexercise.domain.entities.Category;
import com.example.xmlexercise.domain.entities.Product;
import com.example.xmlexercise.domain.entities.User;
import com.example.xmlexercise.repositories.CategoryRepository;
import com.example.xmlexercise.repositories.ProductRepository;
import com.example.xmlexercise.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.xmlexercise.constants.Paths.*;


@Service
public class SeedServiceImpl implements SeedService {


    private UserRepository userRepository;
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    private ModelMapper mapper;


    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public void seedUsers() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(UsersImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader xmlReader = Files.newBufferedReader(USER_XML_PATH);
        UsersImportDTO importDTO = (UsersImportDTO) unmarshaller.unmarshal(xmlReader);

        List<User> entities = importDTO.getUsers()
                .stream()
                .map(dto -> this.mapper.map(dto, User.class))
                .collect(Collectors.toList());

        this.userRepository.saveAll(entities);
    }

    @Override
    public void seedCategories() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(CategoriesImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        FileReader xmlReader = new FileReader(CATEGORY_XML_PATH.toAbsolutePath().toString());
        CategoriesImportDTO importDTO = (CategoriesImportDTO) unmarshaller.unmarshal(xmlReader);

        List<Category> entities = importDTO.getCategories()
                .stream()
                .map(cn -> new Category(cn.getName()))
                .collect(Collectors.toList());

        this.categoryRepository.saveAll(entities);
    }

    @Override
    public void seedProducts() throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(ProductsImportDTO.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BufferedReader xmlReader = Files.newBufferedReader(PRODUCTS_XML_PATH);
        ProductsImportDTO importDTO = (ProductsImportDTO) unmarshaller.unmarshal(xmlReader);

        List<Product> entities = importDTO.getProducts()
                .stream()
                .map(dto -> this.mapper.map(dto, Product.class))
                .map(this::setRandomCategory)
                .map(this::setRandomSeller)
                .map(this::setRandomBuyer)
                .collect(Collectors.toList());

        this.productRepository.saveAll(entities);
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

        List<Category> categories = new ArrayList<>();

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
