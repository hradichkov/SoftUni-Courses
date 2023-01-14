package com.example.jsonexercise.services;

import com.example.jsonexercise.constants.Utils;
import com.example.jsonexercise.domain.dtos.products.ProductDto;
import com.example.jsonexercise.domain.dtos.products.ProductInRangeWithNoBuyer;
import com.example.jsonexercise.domain.entities.Product;
import com.example.jsonexercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.example.jsonexercise.constants.Paths.PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH;
import static com.example.jsonexercise.constants.Utils.MODEL_MAPPER;
import static com.example.jsonexercise.constants.Utils.writeJsonIntoFile;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductInRangeWithNoBuyer> findAllByPriceBetweenAndBuyerNullOrderByPrice(BigDecimal low, BigDecimal high) throws IOException {
        List<ProductInRangeWithNoBuyer> products = this.productRepository.findAllByPriceBetweenAndBuyerNullOrderByPrice(low, high)
                .orElseThrow(NoSuchElementException::new)
                .stream()
                .map(product -> MODEL_MAPPER.map(product, ProductDto.class))
                .map(ProductDto::toProductInRangeWithNoBuyer)
                .collect(Collectors.toList());

        writeJsonIntoFile(products, PRODUCTS_WITH_NO_BUYERS_IN_RANGE_JSON_PATH);
        return products;
    }
}
