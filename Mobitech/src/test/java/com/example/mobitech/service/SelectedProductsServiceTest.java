package com.example.mobitech.service;

import com.example.mobitech.model.entity.SelectedProduct;
import com.example.mobitech.repository.SelectedProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class SelectedProductsServiceTest {
    @Mock
    private SelectedProductRepository selectedProductRepository;
    private SelectedProductService toTest;
    private SelectedProduct selectedProduct;

    @Captor
    private ArgumentCaptor<SelectedProduct> selectedProductCaptor;

    @BeforeEach
    void setUp() {
        toTest = new SelectedProductService(selectedProductRepository);

        selectedProduct = new SelectedProduct();
        selectedProduct.setName("test product");
        selectedProduct.setPrice(BigDecimal.valueOf(35));
        selectedProduct.setQuantity(1);
    }

    @Test
    void testSave() {
        toTest.save(selectedProduct);

        verify(selectedProductRepository, times(1))
                .save(selectedProductCaptor.capture());
        SelectedProduct argument = selectedProductCaptor.getValue();
        Assertions.assertEquals(selectedProduct.getQuantity(), argument.getQuantity());
        Assertions.assertEquals(selectedProduct.getName(), argument.getName());
        Assertions.assertEquals(selectedProduct.getPrice(), argument.getPrice());
    }

    @Test
    void testDeleteById() {
        toTest.deleteById(1L);
        verify(selectedProductRepository, times(1))
                .deleteById(1L);
    }

    @Test
    void testDeleteAll() {
        toTest.deleteAll();
        verify(selectedProductRepository, times(1))
                .deleteAll();
    }
}
