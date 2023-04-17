package com.example.mobitech.web;

import com.example.mobitech.model.dtos.MakeOrderDTO;
import com.example.mobitech.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class OrderController {
    private final UserService userService;

    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("makeOrderDTO")
    public MakeOrderDTO initMakeOrderDTO() {
        return new MakeOrderDTO();
    }

    @GetMapping("/cart")
    public String cart(Principal username, Model model) {
        model.addAttribute("selectedProduct", this.userService.getSelectedProductsByUser(username));
        model.addAttribute("count", this.userService.countOfProductsInCart(username));
        model.addAttribute("sumForAllProducts", this.userService.sumForAllPurchaseProduct(username));
        return "cart";
    }

    @GetMapping("/order/details/{id}")
    public String placeOrder(@PathVariable("id") Long orderId,
                             Principal principal, Model model) {
        model.addAttribute("orderDetails", this.userService.getOrderDetailsById(principal, orderId));
        return "order-details";
    }

    @PatchMapping("/cart")
    public String cart(Principal username,
                       @Valid MakeOrderDTO makeOrderDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("makeOrderDTO", makeOrderDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.makeOrderDTO", bindingResult);

            return "redirect:/cart";
        }
        Long orderId = this.userService.orderProducts(makeOrderDTO, username);
        return "redirect:/order/details/" + orderId;
    }

    @GetMapping("/cart/remove-product-from-list/{id}")
    String removeProductFromSelectedList(@PathVariable("id") Long productId, Principal username) {
        this.userService.removeProductFromSelectedList(productId, username);
        return "redirect:/cart";
    }

    @GetMapping("/orders")
    public String orderByUserId(Principal principal, Model model) {
        model.addAttribute("userOrders", this.userService.getAllOrders(principal));
        return "orders";
    }
}
