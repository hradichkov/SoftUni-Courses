package com.example.mobitech.web;

import com.example.mobitech.model.dtos.ProductAddDTO;
import com.example.mobitech.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("addProductDTO")
    public ProductAddDTO initAddProductDTO() {
        return new ProductAddDTO();
    }

    @GetMapping("/products/add")
    public String productsAdd() {
        return "add-product";
    }

    @PostMapping("/products/add")
    public String productsAdd(@Valid ProductAddDTO productAddDTO,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddDTO", productAddDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.productAddDTO", bindingResult);

            return "redirect:/products/add";
        }
        this.productService.addProduct(productAddDTO);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        this.productService.deleteProductById(productId);
        return "redirect:/user/admin";
    }

    @GetMapping("/product")
    public String allProductsPage(Model model) {
        model.addAttribute("allProducts", this.productService.getAllProducts());
        return "product";
    }

    @GetMapping("/product/info/{id}")
    public String productInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("productInfo", this.productService.getProductInfoById(id));
        return "product-info";
    }
}
