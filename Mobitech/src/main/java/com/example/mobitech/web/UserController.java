package com.example.mobitech.web;

import com.example.mobitech.service.OrderService;
import com.example.mobitech.service.ProductService;
import com.example.mobitech.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public UserController(UserService userService,
                          ProductService productService,
                          OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/purchase/{id}")
    public String buyProduct(@PathVariable("id") Long productId, Principal username) {
        this.userService.addProductToSelectedProductsList(productId, username);
        return "redirect:/product";
    }

    @GetMapping("/user/admin")
    public String adminPanel(Model model) {
        model.addAttribute("allUsers", this.userService.getAllUsers());
        model.addAttribute("allProducts", this.productService.getAllProducts());
        model.addAttribute("allOrders", this.orderService.getAllOrders());
        return "admin";
    }

    @GetMapping("/user/change-role/{id}")
    public String changeRole(@PathVariable("id") Long userId) {
        this.userService.changeUserRole(userId);
        return "redirect:/user/admin";
    }

}
