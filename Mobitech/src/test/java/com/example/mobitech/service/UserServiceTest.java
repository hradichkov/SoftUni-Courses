package com.example.mobitech.service;

import com.example.mobitech.model.dtos.OrderInfoDTO;
import com.example.mobitech.model.dtos.UserInfoDTO;
import com.example.mobitech.model.entity.*;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private final String NEW_USERNAME = "radoslav";
    private final String RAW_PASSWORD = "radoslav";
    private final Long VALID_ID = 1L;
    private final String FIRST_NAME = "Radoslav";
    private final String LAST_NAME = "Radichkov";
    private final String EMAIL = "radoslav@example.com";

    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private ModelMapper mockMapper;
    @Mock
    private PasswordEncoder mockPasswordEncoder;
    @Mock
    private User user;
    @Mock
    Principal principal;
    @Spy
    @InjectMocks
    private UserService toTest;
    private UserInfoDTO userInfoDTO;
    private Order order;
    private Product product;
    private SelectedProduct selectedProduct;
    private PurchasedProduct purchasedProduct;
    private OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
    private final List<SelectedProduct> selectedProducts = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Role testRole = new Role();
        testRole.setUserRole(UserRoleEnum.USER);

        selectedProducts.add(selectedProduct);


        user = User.builder()
                .username(NEW_USERNAME)
                .password(mockPasswordEncoder.encode(RAW_PASSWORD))
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .orders(orders)
                .selectedProducts(selectedProducts)
                .build();

        product = Product.builder()
                .name("test product")
                .price(BigDecimal.valueOf(35))
                .description("Test product description")
                .build();

        product.setId(VALID_ID);
        selectedProduct = SelectedProduct.builder()
                .name("test product")
                .price(BigDecimal.valueOf(35))
                .quantity(1)
                .sum(BigDecimal.valueOf(35))
                .build();
        selectedProduct.setId(VALID_ID);

        purchasedProduct = PurchasedProduct.builder()
                .name("test product")
                .price(BigDecimal.valueOf(35))
                .quantity(1)
                .sum(BigDecimal.valueOf(35))
                .build();

        order = Order.builder()
                .client(user)
                .orderSum(BigDecimal.valueOf(35))
                .dateOfOrder(LocalDate.now())
                .build();

        order.setId(VALID_ID);
        orders.add(order);

        orderInfoDTO = OrderInfoDTO.builder()
                .id(VALID_ID)
                .orderSum(BigDecimal.valueOf(35))
                .build();

        userInfoDTO = UserInfoDTO.builder()
                .id(VALID_ID)
                .username(NEW_USERNAME)
                .email(EMAIL)
                .roles(List.of(testRole))
                .build();

        lenient().when(mockUserRepository.findByUsername(NEW_USERNAME)).thenReturn(Optional.of(user));
        Mockito.when(mockUserRepository.findByUsername(NEW_USERNAME)).thenReturn(Optional.of(user));
        lenient().when(principal.getName()).thenReturn(NEW_USERNAME);
        lenient().when((toTest.getUserByPrincipal(principal))).thenReturn(user);
    }

    @Test
    void testGetAllUsersFromRepo() {
        lenient().when(mockUserRepository.findAll()).thenReturn(List.of(user));
        lenient().when(mockMapper.map(user, UserInfoDTO.class)).thenReturn(userInfoDTO);

        UserInfoDTO userInfoDTO1 = toTest.getAllUsers().get(0);

        Assertions.assertEquals(userInfoDTO1.getUsername(), (userInfoDTO.getUsername()));

        Assertions.assertEquals(user.getUsername(), userInfoDTO.getUsername());
    }

    @Test
    void testGetOrderDetailsById() {
        lenient().when(mockMapper.map(order, OrderInfoDTO.class)).thenReturn(orderInfoDTO);
        orderInfoDTO.setOrderSum(BigDecimal.valueOf(75));
    }

    //
    @Test
    void testMapProductToSelectedProduct() {
        lenient().when(toTest.mapProductToSelectedProduct(product)).thenReturn(selectedProduct);
        Assertions.assertEquals(product.getName(), selectedProduct.getName());
        Assertions.assertEquals(product.getImg(), selectedProduct.getImg());
    }

    @Test
    void testMapSelectedProductToPurchasedProduct() {
        lenient().when(toTest.mapSelectedProductToPurchasedProduct(selectedProduct)).thenReturn(purchasedProduct);
        Assertions.assertEquals(selectedProduct.getName(), purchasedProduct.getName());
        Assertions.assertEquals(selectedProduct.getImg(), purchasedProduct.getImg());
    }

    @Test
    void testOrderInfoDTO() {
        lenient().when(mockMapper.map(order, OrderInfoDTO.class)).thenReturn(orderInfoDTO);
        lenient().when(toTest.getOrderDetailsById(principal, VALID_ID)).thenReturn(orderInfoDTO);
        Assertions.assertEquals(order.getOrderSum(), orderInfoDTO.getOrderSum());
    }

}
