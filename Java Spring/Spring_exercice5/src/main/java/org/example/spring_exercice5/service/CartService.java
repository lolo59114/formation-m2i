package org.example.spring_exercice5.service;

import org.example.spring_exercice5.entity.CartItem;
import org.example.spring_exercice5.entity.Furniture;
import org.example.spring_exercice5.repository.CartItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    public CartService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll(Sort.by(Sort.Direction.ASC, "Furniture.name"));
//        return cartItemRepository.findAllByOrderByFurniture_Name();
    }

    public CartItem getCartItemByFurnitureId(Long id) {
        return cartItemRepository.findCartItemByFurniture_Id(id);
    }

    public void addCartItem(Long furnitureId, Integer quantity) {
        Furniture furniture = furnitureService.getFurnitureById(furnitureId);
        furniture.setStock(furniture.getStock() - quantity);

        CartItem cartItem = getCartItemByFurnitureId(furnitureId);
        if(cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setFurniture(furniture);
            cartItem.setQuantity(quantity);
        }

        cartItemRepository.save(cartItem);
    }

    public void removeCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.getReferenceById(id);
        cartItem.getFurniture().setStock(cartItem.getFurniture().getStock() + cartItem.getQuantity());
        cartItemRepository.deleteById(id);
    }

    public void clearCartItems() {
        getAllCartItems().forEach(cartItem -> removeCartItemById(cartItem.getId()));
    }

    public double totalCart() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        double total = 0.0;
        for(CartItem cart : cartItems) {
            total += cart.getQuantity() * cart.getFurniture().getPrice();
        }
        return total;
    }
}