package com.example.mobitech.service;

import com.example.mobitech.model.dtos.MakeOrderDTO;
import com.example.mobitech.model.dtos.OrderInfoDTO;
import com.example.mobitech.model.dtos.ProductInfoInCartDTO;
import com.example.mobitech.model.dtos.UserInfoDTO;
import com.example.mobitech.model.entity.*;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.OrderRepository;
import com.example.mobitech.repository.RoleRepository;
import com.example.mobitech.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final OrderRepository orderRepository;
    private final SelectedProductService selectedProductService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, OrderRepository orderRepository, SelectedProductService selectedProductService, ProductService productService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.orderRepository = orderRepository;
        this.selectedProductService = selectedProductService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public void addProductToSelectedProductsList(Long id, Principal principal) {
        User user = getUserByPrincipal(principal);
        Product product = this.productService.getProductById(id);
        SelectedProduct selectedProduct = mapProductToSelectedProduct(product);

        if (user.getSelectedProducts().stream().anyMatch(p -> p.getImg().equals(product.getImg()))) {
            selectedProduct = user.findSelectedProductByImg(product.getImg());
            selectedProduct.setQuantity(selectedProduct.getQuantity() + 1);
        } else {
            user.getSelectedProducts().add(selectedProduct);
            selectedProduct.setQuantity(1);
        }

        selectedProduct.setSum(selectedProduct.getPrice().multiply(BigDecimal.valueOf(selectedProduct.getQuantity())));
        this.selectedProductService.save(selectedProduct);
        this.userRepository.save(user);
    }

    public SelectedProduct mapProductToSelectedProduct(Product product) {
        SelectedProduct selectedProduct = new SelectedProduct();
        selectedProduct.setName(product.getName());
        selectedProduct.setPrice(product.getPrice());
        selectedProduct.setImg(product.getImg());
        return selectedProduct;
    }

    public User getUserByPrincipal(Principal principal) {
        return this.userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new Error("User not found!"));
    }

    public void changeUserRole(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new Error("User not found!"));
        UserRoleEnum role = user.getRoles().stream().findFirst().get().getUserRole();
        if (role.equals(UserRoleEnum.USER)) {
            user.getRoles().clear();
            user.setRoles(roleRepository.findByUserRole(UserRoleEnum.ADMIN));
        } else {
            user.getRoles().clear();
            user.setRoles(roleRepository.findByUserRole(UserRoleEnum.USER));
        }
        this.userRepository.save(user);
    }

    public List<UserInfoDTO> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserInfoDTO.class))
                .toList();
    }

    public Set<ProductInfoInCartDTO> getSelectedProductsByUser(Principal principal) {
        User user = getUserByPrincipal(principal);

        return user.getSelectedProducts().stream()
                .map(product -> modelMapper.map(product, ProductInfoInCartDTO.class))
                .collect(Collectors.toSet());
    }

    public Integer countOfProductsInCart(Principal principal) {
        return getSelectedProductsByUser(principal).stream()
                .mapToInt(ProductInfoInCartDTO::getQuantity).sum();
    }

    public BigDecimal sumForAllPurchaseProduct(Principal principal) {
        return getSelectedProductsByUser(principal).stream()
                .map(ProductInfoInCartDTO::getProductSum)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OrderInfoDTO getOrderDetailsById(Principal principal, Long orderId) {
        User user = getUserByPrincipal(principal);
        OrderInfoDTO order = this.modelMapper.map(user.findOrderById(orderId), OrderInfoDTO.class);
        order.setUser(user);
        return order;
    }

    public Long orderProducts(MakeOrderDTO makeOrderDTO, Principal principal) {
        User user = getUserByPrincipal(principal);
        Order order = new Order();

        List<PurchasedProduct> productsToAdd = user.getSelectedProducts().stream()
                .map(this::mapSelectedProductToPurchasedProduct).toList();

        order.getOrderedProducts().addAll(productsToAdd);
        order.setDateOfOrder(LocalDate.now());
        order.setClient(user);
        order.setOrderSum(sumForAllPurchaseProduct(principal));
        this.orderRepository.save(order);

        user.setAddress(makeOrderDTO.getAddress());

        for (PurchasedProduct product : productsToAdd) {
            user.addProductToPurchasedProductList(product);
        }

        user.getSelectedProducts().clear();
        user.getOrders().add(order);

        this.userRepository.save(user);
        this.selectedProductService.deleteAll();
        return order.getId();
    }

    public PurchasedProduct mapSelectedProductToPurchasedProduct(SelectedProduct selectedProduct) {
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        purchasedProduct.setName(selectedProduct.getName());
        purchasedProduct.setImg(selectedProduct.getImg());
        purchasedProduct.setQuantity(selectedProduct.getQuantity());
        purchasedProduct.setPrice(selectedProduct.getPrice());

        return purchasedProduct;
    }

    public void removeProductFromSelectedList(Long productId, Principal principal) {
        User user = getUserByPrincipal(principal);
        user.removeProductFromSelectedList(productId);
        this.selectedProductService.deleteById(productId);
        this.userRepository.save(user);
    }

    public List<OrderInfoDTO> getAllOrders(Principal principal) {
        User user = getUserByPrincipal(principal);

        return user.getOrders().stream().map(o -> modelMapper.map(o, OrderInfoDTO.class)).toList();
    }
}
