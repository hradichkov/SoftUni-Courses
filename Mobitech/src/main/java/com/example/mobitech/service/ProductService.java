package com.example.mobitech.service;

import com.example.mobitech.model.dtos.ProductAddDTO;
import com.example.mobitech.model.dtos.ProductInfoDTO;
import com.example.mobitech.model.entity.Product;
import com.example.mobitech.repository.CategoryRepository;
import com.example.mobitech.repository.ProductRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductInfoDTO> getAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductInfoDTO.class))
                .toList();
    }

    public void addProduct(@Valid ProductAddDTO productAddDTO) {
        Product product = modelMapper.map(productAddDTO, Product.class);

        product.setName(productAddDTO.getName());
        product.setPrice(productAddDTO.getPrice());
        product.setDescription(productAddDTO.getDescription());
        product.setImg(productAddDTO.getImg());
        product.setCategory(categoryRepository.findById(Long.parseLong(productAddDTO.getCategory()))
                .orElseThrow(() -> new Error("Category not found!")));

        this.productRepository.save(product);
    }

    public void deleteProductById(Long productId) {
        this.productRepository.deleteById(productId);
    }

    public ProductInfoDTO getProductInfoById(Long id) {
        Product product = this.productRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
        return this.modelMapper.map(product, ProductInfoDTO.class);
    }

    public Product getProductById(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new Error("Product not found!"));
    }
}
