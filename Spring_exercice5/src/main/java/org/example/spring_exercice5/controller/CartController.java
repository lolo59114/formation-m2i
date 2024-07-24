package org.example.spring_exercice5.controller;

import org.example.spring_exercice5.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String cartList(Model model) {
        model.addAttribute("cartItems", cartService.getAllCartItems());
        return "cart/list";
    }


    @GetMapping("/add-to-cart")
    public String addFurnitureToCart(@RequestParam("id") Long id) {
        cartService.addCartItem(id);
        return "redirect:/furniture";
    }

}
