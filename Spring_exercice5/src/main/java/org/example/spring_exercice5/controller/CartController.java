package org.example.spring_exercice5.controller;

import jakarta.validation.Valid;
import org.example.spring_exercice5.entity.CartItem;
import org.example.spring_exercice5.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("total", cartService.totalCart());
        return "cart/list";
    }


    @PostMapping("/add-to-cart")
    public String addFurnitureToCart(@ModelAttribute("cartItem") CartItem cartItem, @RequestParam("furnitureId") Long id) {
        cartService.addCartItem(id, cartItem.getQuantity());
        return "redirect:/furniture";
    }

    @GetMapping("/delete")
    public String deleteFurniture(@RequestParam("id") Long id) {
        cartService.removeCartItemById(id);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearFurniture() {
        cartService.clearCartItems();
        return "redirect:/cart";
    }

}
