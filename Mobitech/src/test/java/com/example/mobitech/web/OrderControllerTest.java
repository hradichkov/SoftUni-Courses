package com.example.mobitech.web;

import com.example.mobitech.model.dtos.ProductInfoInCartDTO;
import com.example.mobitech.model.entity.*;
import com.example.mobitech.repository.UserRepository;
import com.example.mobitech.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    private final String NEW_USERNAME = "radoslav";

    @Mock
    Principal principal;
    @Mock
    private UserRepository userRepository;
    @Spy
    @InjectMocks
    private UserService toTest;
    @Autowired
    private MockMvc mockMvc;
    List<SelectedProduct> selectedProducts = new ArrayList<>();
    List<ProductInfoInCartDTO> productInfoInCartDTOS = new ArrayList<>();

    @BeforeEach
    void setUp() {
        User client = User.builder()
                .username(NEW_USERNAME)
                .password("radoslav")
                .email("radoslav@test.test")
                .firstName("Radoslav")
                .lastName("Radichkov")
                .selectedProducts(selectedProducts)
                .build();

        SelectedProduct selectedProduct = SelectedProduct.builder()
                .name("chose product name")
                .img("img")
                .quantity(1)
                .sum(BigDecimal.valueOf(35))
                .price(BigDecimal.valueOf(35))
                .build();
        selectedProducts.add(selectedProduct);

        ProductInfoInCartDTO productInfoInCartDTO = ProductInfoInCartDTO.builder()
                .name("chose product name")
                .img("img")
                .quantity(1)
                .productSum(BigDecimal.valueOf(35))
                .price(BigDecimal.valueOf(35))
                .build();
        productInfoInCartDTOS.add(productInfoInCartDTO);
        userRepository.save(client);

        lenient().when(userRepository.findByUsername(NEW_USERNAME)).thenReturn(Optional.of(client));
        Mockito.when(userRepository.findByUsername(NEW_USERNAME)).thenReturn(Optional.of(client));
        lenient().when(principal.getName()).thenReturn(NEW_USERNAME);
        lenient().when((toTest.getUserByPrincipal(principal))).thenReturn(client);
    }

    @Test
    @WithMockUser(username = "radoslav")
    void testCart() throws Exception {
        mockMvc.perform(get("/cart"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("selectedProduct"))
                .andExpect(model().attributeExists("count"))
                .andExpect(model().attributeExists("sumForAllProducts"))
                .andExpect(view().name("cart"));
    }

    @Test
    @WithMockUser(username = "radoslav")
    void testOrderByClientId() throws Exception {
        mockMvc.perform(get("/orders"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("userOrders"))
                .andExpect(view().name("orders"));
    }
}
