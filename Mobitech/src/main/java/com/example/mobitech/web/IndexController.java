package com.example.mobitech.web;

import com.example.mobitech.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final ProductService productService;

    public IndexController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String loggedOutIndex(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "index";
    }
}
