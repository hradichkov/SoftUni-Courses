package com.example.mobitech.service;

import com.example.mobitech.model.dtos.UserInfoDTO;
import com.example.mobitech.model.entity.Product;
import com.example.mobitech.model.entity.SelectedProduct;
import com.example.mobitech.model.entity.User;
import com.example.mobitech.model.enums.UserRoleEnum;
import com.example.mobitech.repository.RoleRepository;
import com.example.mobitech.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final SelectedProductService selectedProductService;
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, SelectedProductService selectedProductService, ProductService productService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.selectedProductService = selectedProductService;
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    public void addProductToSelectedProductsList(Long id, Principal principal) {
        User user = getUserByPrincipal(principal);
        Product product = this.productService.getProductById(id);
        SelectedProduct selectedProduct = mapProductToSelectedProduct(product);

        if (user.getSelectedProducts().stream().anyMatch(p -> p.getImg().equals(product.getImg()))) {
            selectedProduct = user.findByImg(product.getImg());
            selectedProduct.setQuantity(selectedProduct.getQuantity() + 1);
        } else {
            user.getSelectedProducts().add(selectedProduct);
            selectedProduct.setQuantity(1);
        }

        selectedProduct.setSum(selectedProduct.getPrice().multiply(BigDecimal.valueOf(selectedProduct.getQuantity())));
        this.selectedProductService.save(selectedProduct);
        this.userRepository.save(user);
    }

    private SelectedProduct mapProductToSelectedProduct(Product product) {
        SelectedProduct selectedProduct = new SelectedProduct();
        selectedProduct.setName(product.getName());
        selectedProduct.setPrice(product.getPrice());
        selectedProduct.setImg(product.getImg());
        return selectedProduct;
    }

    private User getUserByPrincipal(Principal principal) {
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
}
